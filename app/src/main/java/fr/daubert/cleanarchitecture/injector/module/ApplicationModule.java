package fr.daubert.cleanarchitecture.injector.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import fr.daubert.cleanarchitecture.CleanApplication;
import fr.daubert.cleanarchitecture.injector.scope.PerApplication;

/**
 * Created by daubert on 07/07/2017.
 */

@Module
public class ApplicationModule {
    private final CleanApplication cleanApplication;

    public ApplicationModule(CleanApplication cleanApplication) {
        this.cleanApplication = cleanApplication;
    }

    @Provides
    @PerApplication
    public CleanApplication getCleanApplication() {
        return cleanApplication;
    }

    @Provides
    @PerApplication
    public Application getApplication() {
        return cleanApplication;
    }
}
