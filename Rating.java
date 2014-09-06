package net.oreilly.john.ratemyapartment;

import java.util.Date;
import java.util.UUID;

/**
 * Created by john on 28/07/14.
 */
public class Rating {
    private UUID Id;
    private String Title;
    private Date mDate;

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    private boolean mSolved;

    public Rating(){
        Id = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    @Override
    public String toString(){
        return  Title;
    }
}
