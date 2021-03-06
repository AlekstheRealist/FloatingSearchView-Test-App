package com.android.floatingsearchviewtest;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.android.floatingsearchviewtest.fragments.BaseExampleFragment;
import com.android.floatingsearchviewtest.fragments.ScrollingSearchExampleFragment;
import com.android.floatingsearchviewtest.fragments.SlidingSearchResultsExampleFragment;
import com.android.floatingsearchviewtest.fragments.SlidingSearchViewExampleFragment;
import com.arlib.floatingsearchview.FloatingSearchView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements BaseExampleFragment.BaseExampleFragmentCallbacks, NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = "MainActivity";

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        showFragment(new SlidingSearchResultsExampleFragment());
    }

    @Override
    public void onAttachSearchViewToDrawer(FloatingSearchView searchView) {
        searchView.attachNavigationDrawerToMenuButton(mDrawerLayout);
    }

    @Override
    public void onBackPressed() {
        List fragments = getSupportFragmentManager().getFragments();
        BaseExampleFragment currentFragment = (BaseExampleFragment) fragments.get(fragments.size() - 1);

        if (!currentFragment.onActivityBackPress()) {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        switch (menuItem.getItemId()) {
            case R.id.sliding_list_example:
                showFragment(new SlidingSearchResultsExampleFragment());
                return true;
            case R.id.sliding_search_bar_example:
                showFragment(new SlidingSearchViewExampleFragment());
                return true;
            case R.id.scrolling_search_bar_example:
                showFragment(new ScrollingSearchExampleFragment());
                return true;
            default:
                return true;
        }
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
    }
}