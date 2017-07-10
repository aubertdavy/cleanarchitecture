package fr.daubert.cleanarchitecture.injector.component;

import android.content.Context;

import dagger.Component;
import fr.daubert.cleanarchitecture.injector.module.ActivityModule;
import fr.daubert.cleanarchitecture.injector.module.CalendarsModule;
import fr.daubert.cleanarchitecture.injector.scope.PerActivity;
import fr.daubert.cleanarchitecture.ui.main.MainActivity;

/**
 * Created by daubert on 07/07/2017.
 */

@PerActivity
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class, CalendarsModule.class})
public interface CalendarsComponent {
    void inject(MainActivity mainActivity);
    Context context();
}
