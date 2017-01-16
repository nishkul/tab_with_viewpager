package com.android.test.acitivity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.test.R;
import com.android.test.adaptor.ViewPagerAdaptor;
import com.android.test.model.Video;
import com.android.test.utils.MyConstants;
import com.android.test.widget.CirclePageIndicator;

import java.util.ArrayList;
/**
 * Created by Manish on 16/1/17.
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPagerAdaptor mAdapter;
    private ViewPager pager;
    private CirclePageIndicator mIndicator;
    private TabLayout tabLayout;
    private ArrayList<Video> videoArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        videoArrayList.add(new Video("First Video", "nature beauty"));
        videoArrayList.add(new Video("Second Video", "nature beauty"));
        videoArrayList.add(new Video("Third Video", "Seven wonder of world"));
        videoArrayList.add(new Video("Fourth Video", "nature beauty"));

        initLayout();
        initView();
        setData();
    }


    private void initLayout() {
        setContentView(R.layout.activity_main);

    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabs);


        pager = (ViewPager) findViewById(R.id.viewpager);
        mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setData() {


        tabLayout.addTab(tabLayout.newTab().setText("Video").setIcon(R.drawable.ic_tab_videos));
        tabLayout.addTab(tabLayout.newTab().setText("Images").setIcon(R.drawable.ic_tab_image));
        tabLayout.addTab(tabLayout.newTab().setText("Milestone").setIcon(R.drawable.ic_tab_milstone));
        mAdapter = new ViewPagerAdaptor(this, MyConstants.HOME_PAGE_SLIDER, videoArrayList);
        pager.setAdapter(mAdapter);

        final float density = getResources().getDisplayMetrics().density;
        mIndicator.setFillColor(0xFFFFFFFF);
        mIndicator.setStrokeColor(0xFFFFFFFF);
        mIndicator.setStrokeWidth(1);
        mIndicator.setRadius(3 * density);
        mIndicator.setViewPager(pager);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_images) {
            Toast.makeText(this, "Images selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_video) {
            Toast.makeText(this, "Video selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_milestone) {
            Toast.makeText(this, "Milestone selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_about_us) {
            Toast.makeText(this, "About us selected", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
