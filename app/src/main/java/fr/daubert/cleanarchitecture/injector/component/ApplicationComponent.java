package fr.daubert.cleanarchitecture.injector.component;

import android.app.Application;

import com.google.gson.Gson;

import dagger.Component;
import fr.daubert.cleanarchitecture.CleanApplication;
import fr.daubert.cleanarchitecture.injector.module.ApplicationModule;
import fr.daubert.cleanarchitecture.injector.module.NetworkModule;
import fr.daubert.cleanarchitecture.injector.scope.PerApplication;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by daubert on 07/07/2017.
 */

@PerApplication
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    Application application();
    CleanApplication cleanApplication();
    OkHttpClient okHttpClient();
    Retrofit retrofit();
    Gson gson();
}
