package fr.daubert.cleanarchitecture.main;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import fr.daubert.cleanarchitecture.BaseTest;
import fr.daubert.cleanarchitecture.BuildConfig;
import fr.daubert.cleanarchitecture.mvp.presenter.Presenter;
import fr.daubert.cleanarchitecture.mvp.presenter.main.CalendarsPresenter;
import fr.daubert.cleanarchitecture.mvp.view.main.CalendarsView;
import fr.daubert.cleanarchitecture.util.RxSchedulersOverrideRule;
import retrofit2.Retrofit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by daubert on 12/07/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest extends BaseTest {
    private static final String TAG = MainActivityTest.class.getSimpleName();

    @Mock Retrofit mRetrofit;
    @Mock CalendarsView mCalendarsView;
    CalendarsPresenter mPresenter;

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    @Override
    public void setUp() throws Exception {
        super.setUp();

        mPresenter = new CalendarsPresenter(mRetrofit);
        mPresenter.onAttachView(mCalendarsView);
    }

    @Test
    public void testNotNull() throws Exception {
        assertNotNull("mockRetrofit is null", mRetrofit);
        assertNotNull("mockCalendarsView is null", mCalendarsView);
    }

    @Test
    public void testAttachView() throws Exception {
        mPresenter.onAttachView(mCalendarsView);

     //   verify(mPresenter).onAttachView(mCalendarsView);
    }

    @Test
    public void testLoad() throws Exception {
        mPresenter.load();

        verify(mCalendarsView).showLoading();
        verify(mCalendarsView, never()).showError(new Throwable());
    }

    @After
    public void afterDetachView(){
        mPresenter.onDetachView();
    }
}
