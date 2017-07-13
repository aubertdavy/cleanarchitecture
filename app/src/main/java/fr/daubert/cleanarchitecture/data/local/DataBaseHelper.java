package fr.daubert.cleanarchitecture.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import fr.daubert.cleanarchitecture.injector.scope.PerApplication;

/**
 * Created by daubert on 13/07/2017.
 */

@PerApplication
public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String TAG = DataBaseHelper.class.getSimpleName();

    public DataBaseHelper(Context context) {
        super(context, DataBase.DATABASE_NAME, null, DataBase.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(DataBase.CREATE);
            db.setTransactionSuccessful();
        }catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
}
