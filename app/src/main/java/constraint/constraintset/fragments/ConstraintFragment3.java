package constraint.constraintset.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import org.androidannotations.annotations.AfterViews;

import butterknife.BindView;
import butterknife.ButterKnife;
import constraint.constraintset.R;

public class ConstraintFragment3 extends Fragment {

    private static final String TAG = ConstraintFragment3.class.getName();

    @BindView(R.id.constraint)
    ConstraintLayout constraint;

    private boolean show;
    private ConstraintSet constraintSet;
    Transition transition;

    @AfterViews
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shopping, container, false);
        ButterKnife.bind(this, v);

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                constraintSet = new ConstraintSet();

                constraint.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!show) {
                            showContent();
                        } else {
                            hideContent();
                        }
                    }
                });
            } else {
                Log.d(TAG, "Such API not supported.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return v;
    }


    private void updateConstraints(int layoutRes) {
        constraintSet.clone(getContext(), layoutRes);
        transition = new ChangeBounds();
        transition.setInterpolator(new AccelerateDecelerateInterpolator());
        transition.setDuration(1200);

        TransitionManager.beginDelayedTransition(constraint, transition);
        constraintSet.applyTo(constraint);
    }

    private void showContent() {
        show = true;
        updateConstraints(R.layout.fragment_shopping_alt);
    }

    private void hideContent() {
        show = false;
        updateConstraints(R.layout.fragment_shopping);
    }
}