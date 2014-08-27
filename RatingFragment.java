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


public class RatingFragment extends Fragment {

    private Rating mRating;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mRating = new Rating();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_rating, parent, false);
        mTitleField = (EditText)v.findViewById(R.id.rating_title);
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
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mRating.setSolved(isChecked);
            }
        });
        return v;
    }

}
