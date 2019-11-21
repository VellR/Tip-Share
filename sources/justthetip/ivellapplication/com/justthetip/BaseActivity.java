package justthetip.ivellapplication.com.justthetip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.firebase.auth.FirebaseAuth;

public abstract class BaseActivity extends AppCompatActivity {
    DrawerLayout Drawer;
    ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        this.Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        this.mDrawerToggle = new ActionBarDrawerToggle(this, this.Drawer, this.toolbar, R.string.openDrawer, R.string.closeDrawer) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        this.Drawer.addDrawerListener(this.mDrawerToggle);
        this.mDrawerToggle.syncState();
        findViewById(R.id.navDrawer_weekPeek).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BaseActivity.this.startActivity(new Intent(BaseActivity.this, WeekPeekActivity.class));
                BaseActivity.this.finish();
            }
        });
        findViewById(R.id.navDrawer_motivated).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BaseActivity.this.startActivity(new Intent(BaseActivity.this, MotivatedActivity.class));
                BaseActivity.this.finish();
            }
        });
        findViewById(R.id.navDrawer_fly).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BaseActivity.this.startActivity(new Intent(BaseActivity.this, OnTheFlyActivity.class));
                BaseActivity.this.finish();
            }
        });
        findViewById(R.id.navDrawer_stats).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BaseActivity.this.startActivity(new Intent(BaseActivity.this, StatsActivity.class));
                BaseActivity.this.finish();
            }
        });
        findViewById(R.id.navDrawer_logout).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                BaseActivity.this.startActivity(new Intent(BaseActivity.this, LoginActivity.class));
                BaseActivity.this.finish();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
