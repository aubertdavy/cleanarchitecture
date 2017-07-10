package fr.daubert.cleanarchitecture.mvp.model;

import java.util.List;

/**
 * Created by daubert on 07/07/2017.
 */

public class User {
    public static final String JSON_ARRAY_NAME = "users";

    public String name;
    public List<String> emails;

    public String getName() {
        return name;
    }

    public List<String> getEmails() {
        return emails;
    }
}
