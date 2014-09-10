package net.oreilly.john.ratemyapartment;

import android.app.Fragment;

import java.util.UUID;

public class RatingActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        UUID crimeId = (UUID)getIntent()
                .getSerializableExtra(RatingFragment.EXTRA_RATING_ID);
        return RatingFragment.newInstance(crimeId);
    }
}
