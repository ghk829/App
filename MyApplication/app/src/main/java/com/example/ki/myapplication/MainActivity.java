package com.example.ki.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {
    ListView lv;
    ArrayAdapter<String> myAdapter;

    String[] items = {"서현석","개구리","사무엘 잭슨"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.App.myapplication.R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(com.example.App.myapplication.R.id.toolbar);
        setSupportActionBar(toolbar);

/*        ListView에 관한 코드*/
        myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        lv = (ListView)findViewById(com.example.App.myapplication.R.id.lv);
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(com.example.App.myapplication.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "친구 추가", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent naverIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                                startActivity(naverIntent);
                            }
                        });
            }});

        DrawerLayout drawer = (DrawerLayout) findViewById(com.example.App.myapplication.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, com.example.App.myapplication.R.string.navigation_drawer_open, com.example.App.myapplication.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(com.example.App.myapplication.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(com.example.App.myapplication.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.App.myapplication.R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.example.App.myapplication.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == com.example.App.myapplication.R.id.nav_camera) {
            // Handle the camera action
        } else if (id == com.example.App.myapplication.R.id.nav_gallery) {

        } else if (id == com.example.App.myapplication.R.id.nav_slideshow) {

        } else if (id == com.example.App.myapplication.R.id.nav_manage) {

        } else if (id == com.example.App.myapplication.R.id.nav_share) {

        } else if (id == com.example.App.myapplication.R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(com.example.App.myapplication.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,items[i]+"는 개객기입니다.",Toast.LENGTH_SHORT).show();
    }
}

