package fr.daubert.cleanarchitecture.injector.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import fr.daubert.cleanarchitecture.injector.scope.PerApplication;
import fr.daubert.cleanarchitecture.network.LoggingInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by daubert on 10/07/2017.
 */

@Module
public class NetworkModule {
    private final String baseUrl;

    public NetworkModule(String baseUrl){
        this.baseUrl = baseUrl;
    }

    @Provides
    @PerApplication
    public Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @PerApplication
    public Gson provideGson(){
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
    }

    @Provides
    @PerApplication
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();
    }
}
