package fr.daubert.cleanarchitecture.mvp.presenter.main;

import java.util.List;

import fr.daubert.cleanarchitecture.mvp.model.Calendar;
import fr.daubert.cleanarchitecture.mvp.presenter.Presenter;
import fr.daubert.cleanarchitecture.mvp.view.main.CalendarsView;
import fr.daubert.cleanarchitecture.network.MainApi;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by daubert on 07/07/2017.
 */

public class CalendarsPresenter implements Presenter<CalendarsView> {
    private CalendarsView calendarsView;
    private Subscription subscription;
    private Retrofit retrofit;

    public CalendarsPresenter(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    public void load(){
        subscription = retrofit.create(MainApi.class).getCalendars()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<List<Calendar>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    calendarsView.showError(e);
                }

                @Override
                public void onNext(List<Calendar> calendars) {
                    calendarsView.showCalendars(calendars);
                }
                });
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {
        if (subscription != null)
            subscription.unsubscribe();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onAttachView(CalendarsView view) {
        this.calendarsView = view;
    }

    @Override
    public void onDetachView() {
        this.calendarsView = null;
    }
}
