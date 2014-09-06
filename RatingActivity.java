package net.oreilly.john.ratemyapartment;

import android.app.Fragment;

public class RatingActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new RatingFragment();
    }
}
