package constraint.constraintset;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import constraint.constraintset.fragments.ConstraintFragment1;
import constraint.constraintset.fragments.ConstraintFragment2;
import constraint.constraintset.fragments.ConstraintFragment3;
import constraint.constraintset.fragments.FragmentChains;
import constraint.constraintset.fragments.FragmentMovie;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.home_fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.bt_fragment1)
    Button btFragment1;
    @BindView(R.id.bt_fragment2)
    Button btFragment2;
    @BindView(R.id.bt_fragment3)
    Button btFragment3;
    @BindView(R.id.bt_fragment_chain)
    Button btFragmentChain;
    @BindView(R.id.bt_fragment_movie)
    Button btFragmentMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        btFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentContainer.removeAllViews();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .add(R.id.home_fragment_container, new ConstraintFragment1(), ConstraintFragment1.class.getName())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentContainer.removeAllViews();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .add(R.id.home_fragment_container, new ConstraintFragment2(), ConstraintFragment2.class.getName())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btFragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentContainer.removeAllViews();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .add(R.id.home_fragment_container, new ConstraintFragment3(), ConstraintFragment3.class.getName())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btFragmentChain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentContainer.removeAllViews();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .add(R.id.home_fragment_container, new FragmentChains(), FragmentChains.class.getName())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btFragmentMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentContainer.removeAllViews();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .add(R.id.home_fragment_container, new FragmentMovie(), FragmentMovie.class.getName())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

}
