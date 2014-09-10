package net.oreilly.john.ratemyapartment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;


public class RatingFragment extends Fragment {
    public static final String EXTRA_RATING_ID = "net.oreilly.john.ratemyapartment";
    private Rating mRating;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    public static RatingFragment newInstance(UUID ratingId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_RATING_ID, ratingId);
        RatingFragment fragment = new RatingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID ratingId = (UUID)getArguments().getSerializable(EXTRA_RATING_ID);
        mRating = RatingLab.get(getActivity()).getRating(ratingId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_rating, parent, false);
        mTitleField = (EditText)v.findViewById(R.id.rating_title);
        mTitleField.setText(mRating.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                //toDo
            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
               mRating.setTitle(c.toString());
            }

            @Override
            public void afterTextChanged(Editable c) {
                //toDo
            }
        });
        mDateButton = (Button)v.findViewById(R.id.rating_date);
        mDateButton.setText(mRating.getDate().toString());
        mDateButton.setEnabled(false);
        mSolvedCheckBox=(CheckBox)v.findViewById(R.id.rating_solved);
        mSolvedCheckBox.setChecked(mRating.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mRating.setSolved(isChecked);
            }
        });
        return v;
    }

}
