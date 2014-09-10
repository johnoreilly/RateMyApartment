package net.oreilly.john.ratemyapartment;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by john on 30/08/14.
 */
public class RatingListFragment extends ListFragment {
    private ArrayList<Rating> mRatings;
    private static final String TAG = "RatingListFragment";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.ratings_title);
        mRatings=RatingLab.get(getActivity()).getRatings();
        RatingAdapter adapter = new RatingAdapter(mRatings);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l,View v,int position,long id){
        Rating r = ((RatingAdapter)getListAdapter()).getItem(position);
        Intent i = new Intent(getActivity(),RatingActivity.class);
        i.putExtra(RatingFragment.EXTRA_RATING_ID,r.getId());
        startActivity(i);
    }

    private class RatingAdapter extends ArrayAdapter<Rating> {
        public RatingAdapter(ArrayList<Rating> ratings) {
            super(getActivity(), 0, ratings);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_rating, null);
            }
            Rating r = getItem(position);
            TextView titleTextView = (TextView) convertView.findViewById(R.id.rating_list_item_titleTextView);
            titleTextView.setText(r.getTitle());
            TextView dateTextView = (TextView) convertView.findViewById(R.id.rating_list_item_dateTextView);
            dateTextView.setText(r.getDate().toString());
            CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.rating_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(r.isSolved());
            return convertView;
        }
    }

}
