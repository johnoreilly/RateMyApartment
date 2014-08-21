package net.oreilly.john.ratemyapartment;

import java.util.UUID;

/**
 * Created by john on 28/07/14.
 */
public class Rating {


    public Rating(){
        mId = UUID.randomUUID();

    }

    private UUID mId;
    private String mTitle;

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
