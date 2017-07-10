package fr.daubert.cleanarchitecture.mvp.model;

/**
 * Created by daubert on 07/07/2017.
 */

public class Calendar {
    public static final String JSON_ARRAY_NAME = "calendars";

    public int id;
    public String summary;
    public String description;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getSummary() {
        return summary;
    }
}
