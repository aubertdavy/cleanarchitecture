package fr.daubert.cleanarchitecture.mvp.view.main;

import java.util.List;

import fr.daubert.cleanarchitecture.mvp.model.Calendar;
import fr.daubert.cleanarchitecture.mvp.view.View;

/**
 * Created by daubert on 07/07/2017.
 */

public interface CalendarsView extends View {
    void showCalendars(List<Calendar> calendars);
    void showError(Throwable throwable);
    void showLoading();
}
