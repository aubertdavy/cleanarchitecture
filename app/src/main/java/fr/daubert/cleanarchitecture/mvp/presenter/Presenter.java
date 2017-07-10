package fr.daubert.cleanarchitecture.mvp.presenter;

import fr.daubert.cleanarchitecture.mvp.view.View;

/**
 * Created by daubert on 07/07/2017.
 */

public interface Presenter<V extends View> {
    void onCreate();
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
    void onAttachView(V view);
    void onDetachView();
}
