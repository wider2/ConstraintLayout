package constraint.constraintset.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import constraint.constraintset.R;

public class FragmentMovie extends Fragment {

    //@AfterViews
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_movie, container, false);
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }
}