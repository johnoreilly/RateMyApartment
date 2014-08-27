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
