package androidsqlite.com.tabmyicons;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;

    private TabLayout tabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        viewPager=(ViewPager)findViewById(R.id.viewpager_xml);
        setupViewPager(viewPager);

        tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setUpIcons();

    }

    private void setUpIcons(){

          int[] tabicons={
                R.drawable.ic_action_phone,
                R.drawable.ic_action_sms,
                R.drawable.ic_action_eye,
        };

        tabLayout.getTabAt(0).setIcon(tabicons[0]);
        tabLayout.getTabAt(1).setIcon(tabicons[1]);
        tabLayout.getTabAt(2).setIcon(tabicons[2]);

    }



    private void setupViewPager(ViewPager viewPager){

        ViewpagerAdapter adapter=new ViewpagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new OneFragment(),"One");

        adapter.addFragment(new TwoFragment(),"Two");

        adapter.addFragment(new ThreeFragment(),"Three");


        viewPager.setAdapter(adapter);


    }


    class ViewpagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment>mFragment=new ArrayList<>();

        private final List<String>mFragmentTitle=new ArrayList<>();

        public ViewpagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }

        @Override
        public int getCount() {
            return mFragment.size();
        }


        public void addFragment(Fragment fragment,String title){

            mFragment.add(fragment);
            mFragmentTitle.add(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitle.get(position);
        }
    }
}
