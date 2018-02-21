package constraint.constraintset.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;

import butterknife.BindView;
import butterknife.ButterKnife;
import constraint.constraintset.R;

import static constraint.constraintset.R.id.constraint;
import static constraint.constraintset.R.id.iv_item1;
import static constraint.constraintset.R.id.iv_item2;


public class ConstraintFragment1 extends Fragment {

    private static final String TAG = ConstraintFragment1.class.getName();

    @BindView(R.id.constraint)
    ConstraintLayout constraint;
    @BindView(R.id.iv_item1)
    ImageView ivItem1;
    @BindView(R.id.iv_item2)
    ImageView ivItem2;

    @BindView(R.id.tv_title1)
    TextView tvTitle1;
    @BindView(R.id.tv_title2)
    TextView tvTitle2;

    @BindView(R.id.tv_desc1)
    TextView tvDesc1;
    @BindView(R.id.tv_desc2)
    TextView tvDesc2;

    private boolean show;
    private ConstraintSet constraintSet;
    Transition transition;

    @AfterViews
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_constraint1, container, false);
        ButterKnife.bind(this, v);

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                constraintSet = new ConstraintSet();

                constraint.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        constraintSet.clear(R.id.iv_item1);
                        constraintSet.clear(R.id.iv_item2);
                        constraintSet.clear(R.id.tv_title1);
                        constraintSet.clear(R.id.tv_title2);
                        constraintSet.clear(R.id.tv_desc1);
                        constraintSet.clear(R.id.tv_desc2);
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
        if (show) {
            constraintSet.setHorizontalBias(iv_item1, 0.25f);
            constraintSet.constrainHeight(iv_item1, 300);
            constraintSet.constrainHeight(iv_item2, 100);
            constraintSet.setRotationY(iv_item2, 45);
            tvTitle1.setTextSize(30);
            tvTitle2.setTextSize(15);
            tvTitle1.setText(getString(R.string.description));

            constraintSet.connect(tvTitle1.getId(), ConstraintSet.TOP, tvTitle2.getId(), ConstraintSet.TOP, 18);
            constraintSet.connect(tvTitle1.getId(), ConstraintSet.BOTTOM, tvTitle2.getId(), ConstraintSet.BOTTOM, 18);
            constraintSet.setVerticalBias(constraint.getId(), (float)0.2);
        } else {
            constraintSet.constrainHeight(iv_item2, 300);
            constraintSet.constrainHeight(iv_item1, 100);
            constraintSet.setHorizontalBias(iv_item1, 0.5f);
            constraintSet.setRotationY(iv_item2, -45);
            tvTitle1.setTextSize(15);
            tvTitle2.setTextSize(30);
            tvTitle1.setText(getString(R.string.title));
        }
        transition = new ChangeBounds();
        //transition.setInterpolator(new AccelerateDecelerateInterpolator());
        //transition.setInterpolator(new OvershootInterpolator());
        //transition.setInterpolator(new BounceInterpolator());
        //transition.setInterpolator(new AnticipateInterpolator());
        //transition.setInterpolator(new CycleInterpolator());
        //transition.setInterpolator(new LinearInterpolator());
        transition.setInterpolator(new FastOutSlowInInterpolator());
        transition.setDuration(1200);

        TransitionManager.beginDelayedTransition(constraint, transition);
        constraintSet.applyTo(constraint);
    }

    private void showContent() {
        show = true;
        updateConstraints(R.layout.fragment_constraint1);
    }

    private void hideContent() {
        show = false;
        updateConstraints(R.layout.fragment_constraint1);
    }

}