package fr.daubert.cleanarchitecture;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by daubert on 13/07/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public abstract class BaseTest {
    private static final String TAG = BaseTest.class.getSimpleName();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
