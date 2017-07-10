package fr.daubert.cleanarchitecture;

import android.app.Application;

import fr.daubert.cleanarchitecture.injector.component.ApplicationComponent;
import fr.daubert.cleanarchitecture.injector.component.DaggerApplicationComponent;
import fr.daubert.cleanarchitecture.injector.module.ApplicationModule;
import fr.daubert.cleanarchitecture.injector.module.NetworkModule;

/**
 * Created by daubert on 07/07/2017.
 */

public class CleanApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
    }

    private void initInjector(){
       applicationComponent = DaggerApplicationComponent.builder()
               .applicationModule(new ApplicationModule(this))
               .networkModule(new NetworkModule("http://dnl.rayonnance.fr/"))
               .build();
    }

    // Branch tes
    public ApplicationComponent getCleanApplication(){
        return applicationComponent;
    }
}
