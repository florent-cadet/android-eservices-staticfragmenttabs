package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends FragmentActivity implements MyItf {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private int currentCounter;
    private TextView counterTextView;
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;

    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPagerAndTabs();
    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {
        viewPager = findViewById(R.id.tab_viewpager);
        counterTextView = findViewById(R.id.counter_textview);
        tabLayout = findViewById(R.id.tablayout);
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
        //TODO we want two fragments with layouts : fragment_one, fragment_two.

        fragmentOne = FragmentOne.newInstance();
        fragmentTwo = FragmentTwo.newInstance();

        //TODO set adapter to viewpager and handle tragment change inside
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if(position == 0) {
                    return fragmentOne;
                } else {
                    return fragmentTwo;
                }
            }

            @Override
            public int getItemCount() {
                return 2;
            }
        });

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(position == 0 ? FragmentOne.TAB_NAME : FragmentTwo.TAB_NAME);
            }
        });

        tabLayoutMediator.attach();
    }

    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)
    @Override
    public void incrementCounter() {
        currentCounter++;
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
    }

    @Override
    public void decrementCounter() {
        currentCounter--;
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
    }
}
