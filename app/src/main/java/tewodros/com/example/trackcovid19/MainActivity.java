package tewodros.com.example.trackcovid19;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.widget.Toolbar;

import tewodros.com.example.trackcovid19.ui.AboutFragment;
import tewodros.com.example.trackcovid19.ui.CallFragment;
import tewodros.com.example.trackcovid19.ui.ChartFragment;
import tewodros.com.example.trackcovid19.ui.FaqFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setItemIconTintList(null);

        NavigationView navigationView = findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        drawer = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.nav_map:
                Intent intent0 = new Intent(this,InteractiveMapActivity.class);
                startActivity(intent0);
                break;
            case R.id.nav_news:
                Intent intent = new Intent(this,News.class);
                startActivity(intent);
                break;
            case R.id.nav_hospital:
                Intent intent1 = new Intent(this,nearest_hospitals.class);
                startActivity(intent1);
                break;
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new CallFragment()).commit();
                break;
            case R.id.nav_info:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new FaqFragment()).commit();
                break;
            case R.id.nav_chart:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new ChartFragment()).commit();
                break;
            case R.id.nav_about:


                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new AboutFragment()).commit();
                break;
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
