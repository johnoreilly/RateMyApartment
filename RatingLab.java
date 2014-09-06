package net.oreilly.john.ratemyapartment;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by john on 27/08/14.
 */
public class RatingLab {
    private ArrayList<Rating> mRatings;
    private static RatingLab sRatingLab;
    private Context mAppContext;

    private RatingLab(Context appContext){
        mAppContext = appContext;
        mRatings = new ArrayList<Rating>();
        for (int i=0;i<100;i++){
            Rating r = new Rating();
            r.setTitle("Rating is:" + i);
            r.setSolved(i%2==0);
            mRatings.add(r);
        }
    }

    public static RatingLab get(Context c){
        if(sRatingLab==null){
          sRatingLab=new RatingLab((c.getApplicationContext()));
        }
        return sRatingLab;
    }

    public ArrayList<Rating> getRatings(){
        return mRatings;
    }

    public Rating getRating(UUID id){
        for (Rating r : mRatings){
            if(r.getId().equals(id)) return r;
        }
        return null;
    }
}
