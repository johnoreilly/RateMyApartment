package net.oreilly.john.ratemyapartment;

import android.app.Fragment;

/**
 * Created by john on 31/08/14.
 */
public class RatingListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new RatingListFragment();
    }
}
