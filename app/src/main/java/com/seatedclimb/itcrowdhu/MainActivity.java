package com.seatedclimb.itcrowdhu;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import com.seatedclimb.main.webview;

/**
 * Applciation Main Class
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private WebView lWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inicialization view
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // inicialization the webview
        this.lWebView = (WebView)findViewById(R.id.webViewRoot);
        this.lWebView.getSettings().setJavaScriptEnabled(true);
        this.lWebView.setWebViewClient(new webview());
        this.lWebView.loadUrl( getResources().getString(R.string.app_url));
    }

    /**
     * Phone back button
     */
    @Override
    public void onBackPressed() {
        //check the webview back state
        if (this.lWebView.canGoBack()) {
            this.lWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Menu navigatoin action
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //switching the menu item
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_development:
                this.lWebView.loadUrl( getResources().getString(R.string.menu_development_url));
                break;
            case R.id.nav_game:
                this.lWebView.loadUrl( getResources().getString(R.string.menu_game_url));
                break;
            case R.id.nav_secure:
                this.lWebView.loadUrl( getResources().getString(R.string.menu_secure_url));
                break;
            case R.id.nav_mobil:
                this.lWebView.loadUrl( getResources().getString(R.string.menu_mobil_url));
                break;
            case R.id.nav_send:
                this.lWebView.loadUrl( getResources().getString(R.string.menu_send_url));
                break;

            case R.id.nav_about:
                this.lWebView.loadUrl( getResources().getString(R.string.menu_about_url));
                break;
            case R.id.nav_source:
                this.lWebView.loadUrl( getResources().getString(R.string.menu_github_url));
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
