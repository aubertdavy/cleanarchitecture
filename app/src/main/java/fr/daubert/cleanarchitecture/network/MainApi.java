package fr.daubert.cleanarchitecture.network;

import java.util.List;

import fr.daubert.cleanarchitecture.mvp.model.Calendar;
import fr.daubert.cleanarchitecture.mvp.model.Event;
import fr.daubert.cleanarchitecture.mvp.model.User;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by daubert on 07/07/2017.
 */

public interface MainApi {
    @GET("users")
    Observable<List<User>> getUsers();

    @GET("calendars")
    Observable<List<Calendar>> getCalendars();

    @GET("calendars/{calendar_id}/events")
    Observable<List<Calendar>> getEvents(@Path("calendar_id") int calendarId);

    @DELETE("calendars/{calendar_id}/events/{event_id}")
    Observable<Calendar> deleteEvent(@Path("calendar_id") int calendarId, @Path("event_id") int eventId);

    @POST("calendars/{calendar_id}/events")
    Observable<Event> postEvent(@Path("calendar_id") int calendarId, @Body Event event);
}
