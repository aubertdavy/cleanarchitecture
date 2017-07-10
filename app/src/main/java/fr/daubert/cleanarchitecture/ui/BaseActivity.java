package fr.daubert.cleanarchitecture.ui;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by daubert on 07/07/2017.
 */

public abstract class BaseActivity extends Activity {
    private static String TAG = BaseActivity.class.getSimpleName();

    public abstract int getCurrentLayoutId();

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getCurrentLayoutId());
        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
