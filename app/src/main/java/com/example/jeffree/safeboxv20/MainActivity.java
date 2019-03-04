package com.example.jeffree.safeboxv20;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setLogo(R.drawable.logosmaller);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        int[] imageResId = {
                R.drawable.logs,
                R.drawable.dropbox,
                R.drawable.help,
        };
        for (int i = 0; i < imageResId.length; i++) {
            tabLayout.getTabAt(i).setIcon(imageResId[i]);
        }


    }
    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
                default:
                    return new Fragment1();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0:
                    title = new String("Activity");
                    return title;
                case 1:
                    title = new String ("Dropbox");
                    return title;
                case 2:
                    title = new String ("Help");
                    return title;
            }
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_logout_btn:
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                logOut();
                return true;

            default:
                return false;

        }
    }

    private void logOut() {

       new AlertDialog.Builder(this)
                .setIcon(R.drawable.logosmall)
                .setMessage("Are you sure you want to sign out?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent logoutIntent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(logoutIntent);
                        finish();
                    }
                })
        .setNegativeButton("No",null)
        .show();
    }

}
