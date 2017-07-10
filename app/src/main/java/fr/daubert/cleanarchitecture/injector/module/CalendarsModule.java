package fr.daubert.cleanarchitecture.injector.module;

import dagger.Module;
import dagger.Provides;
import fr.daubert.cleanarchitecture.injector.scope.PerActivity;
import fr.daubert.cleanarchitecture.mvp.presenter.main.CalendarsPresenter;
import retrofit2.Retrofit;

/**
 * Created by daubert on 07/07/2017.
 */

@Module
public class CalendarsModule {
    @PerActivity
    @Provides
    public CalendarsPresenter provideCalendarsPresenter(Retrofit retrofit) {
        return new CalendarsPresenter(retrofit);
    }
}
