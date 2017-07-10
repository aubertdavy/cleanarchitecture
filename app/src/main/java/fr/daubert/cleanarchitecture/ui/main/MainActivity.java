package fr.daubert.cleanarchitecture.ui.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import fr.daubert.cleanarchitecture.CleanApplication;
import fr.daubert.cleanarchitecture.R;
import fr.daubert.cleanarchitecture.injector.component.ApplicationComponent;
import fr.daubert.cleanarchitecture.injector.component.CalendarsComponent;
import fr.daubert.cleanarchitecture.injector.component.DaggerCalendarsComponent;
import fr.daubert.cleanarchitecture.injector.module.ActivityModule;
import fr.daubert.cleanarchitecture.injector.module.CalendarsModule;
import fr.daubert.cleanarchitecture.mvp.model.Calendar;
import fr.daubert.cleanarchitecture.mvp.presenter.main.CalendarsPresenter;
import fr.daubert.cleanarchitecture.mvp.view.main.CalendarsView;
import fr.daubert.cleanarchitecture.ui.BaseActivity;
import retrofit2.Retrofit;

public class MainActivity extends BaseActivity implements CalendarsView {
    private static String TAG = MainActivity.class.getSimpleName();

    @Inject CalendarsPresenter calendarsPresenter;
    @Inject Retrofit retrofit;

    @BindView(R.id.ar_toolbar) Toolbar toolbar;
    @BindView(R.id.ar_loading) View loadingView;
    @BindView(R.id.ar_tabs) TabLayout tabLayout;
    @BindView(R.id.ar_pager) ViewPager viewPager;
    @BindView(R.id.ar_fab) FloatingActionButton fab;

    @Override
    public int getCurrentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ApplicationComponent applicationComponent = ((CleanApplication)getApplication()).getCleanApplication();

        CalendarsComponent calendarsComponent = DaggerCalendarsComponent.builder()
                .calendarsModule(new CalendarsModule())
                .activityModule(new ActivityModule(this))
                .applicationComponent(applicationComponent)
                .build();
        calendarsComponent.inject(this);

        calendarsPresenter.onAttachView(this);
        calendarsPresenter.load();
    }

    @Override
    public void showCalendars(List<Calendar> calendars) {
        // notifyDataSetChanged() on adapter
    }

    @Override
    public void showError(final Throwable t) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getBaseContext(), TAG + ": " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };
        runOnUiThread(runnable);
    }

    @Override
    public void swhoLoading() {

    }
}
