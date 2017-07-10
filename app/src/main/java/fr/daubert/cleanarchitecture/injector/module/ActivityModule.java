package fr.daubert.cleanarchitecture.injector.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import fr.daubert.cleanarchitecture.injector.scope.PerActivity;

/**
 * Created by daubert on 07/07/2017.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public Context getContext() {
        return activity;
    }
}
