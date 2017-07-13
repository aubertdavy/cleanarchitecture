package fr.daubert.cleanarchitecture.data.local;

/**
 * Created by daubert on 13/07/2017.
 */

final class DataBase {
    public static final String DATABASE_NAME = "ribots.db";
    public static final int DATABASE_VERSION = 2;

    public static final String TABLE_NAME = "ribot_profile";

    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_HEX_COLOR = "hex_color";
    public static final String COLUMN_DATE_OF_BIRTH = "date_of_birth";
    public static final String COLUMN_AVATAR = "avatar";
    public static final String COLUMN_BIO = "bio";

    public static final String CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_EMAIL + " TEXT PRIMARY KEY, " +
                    COLUMN_FIRST_NAME + " TEXT NOT NULL, " +
                    COLUMN_LAST_NAME + " TEXT NOT NULL, " +
                    COLUMN_HEX_COLOR + " TEXT NOT NULL, " +
                    COLUMN_DATE_OF_BIRTH + " INTEGER NOT NULL, " +
                    COLUMN_AVATAR + " TEXT, " +
                    COLUMN_BIO + " TEXT" +
                    " ); ";
}
