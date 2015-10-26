package com.example.naveen.navigationtrial;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private final String TAG = "com.example.naveen.navigationtrial";
    public DrawerLayout drawer;
    public ActionBarDrawerToggle toggle;
    public NavigationView navigationView;
    public Toolbar toolbar;


    protected void onCreateDrawer() {
        Log.i(TAG, "onCreateDrawer");
        setContentView(R.layout.activity_navigation_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i(TAG, "Toolbar");

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.i(TAG, "FloatingActionButton");
*/

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Log.i(TAG, "DrawerLayout");

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, 0, 0) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(R.string.navigation_drawer_close);
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(R.string.navigation_drawer_open);
            }
        };
        Log.i(TAG, "ActionBarDrawerToggle");
        drawer.setDrawerListener(toggle);
        Log.i(TAG, "ActionBarDrawerToggle");
        toggle.syncState();
        Log.i(TAG, "ActionBarDrawerToggle");


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Log.i(TAG, "NavigationView");

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            Intent intent = new Intent(this, Camera.class);
            intent.putExtra("Actionbarname", "Camera3");
            startActivity(intent);

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(this, Gallery.class);
            intent.putExtra("Actionbarname", "Camera3");
            startActivity(intent);


        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_home) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Actionbarname", "Camera3");
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
