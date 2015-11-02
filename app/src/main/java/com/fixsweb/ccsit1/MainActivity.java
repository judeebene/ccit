package com.fixsweb.ccsit1 ;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.fixsweb.ccsit1.fragment.Animation_fragment;
import com.fixsweb.ccsit1.fragment.Main_fragment;

import java.io.IOException;



public class MainActivity extends AppCompatActivity  {

    String LOG_TAG = MainActivity.class.getSimpleName() ;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer ;
    ActionBarDrawerToggle drawerToggle ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

       if(savedInstanceState == null){
           Main_fragment main_fragment =  new Main_fragment() ;
           getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, main_fragment)
                   .commit();
       }






        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Set the menu icon instead of the launcher icon.
        final ActionBar ab = getSupportActionBar();

        ab.setHomeAsUpIndicator(R.drawable.ic_drawer);
        ab.setDisplayHomeAsUpEnabled(true);

        //navigation menu

        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);

        // Tie DrawerLayout events to the ActionBarToggle
        drawerToggle = setupDrawerToggle() ;
        mDrawer.setDrawerListener(drawerToggle);



          // this is the main activity fragment, if you want to design the main Screen, go to
        //  fragment_main.xml to design
        //




    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open,  R.string.navigation_drawer_close);
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        //  use this function  selectDrawerItem(menuItem) to
                         selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }



   // This is where you will change or add things

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the planet to show based on
        // position
        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();


        switch (menuItem.getItemId()) {
            case R.id.animation:



                fragment = new  Animation_fragment();



                fragmentManager.beginTransaction().replace(R.id.main_fragment, fragment).commit();
                break;

            default:

               fragment =  new Main_fragment();

                fragmentManager.beginTransaction().replace(R.id.main_fragment, fragment).commit();
        }






        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();

    }







}
