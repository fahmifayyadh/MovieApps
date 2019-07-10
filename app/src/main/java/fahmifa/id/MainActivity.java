package fahmifa.id;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {
    RelativeLayout fragment;
    android.support.v4.app.Fragment movie, tvShow, setting;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v4.app.Fragment fragment=null;
            switch (item.getItemId()) {
                case R.id.navigation_movie:
                    fragment = movie;
                    if (fragment == null) {
                        movie = new MovieFragment();
                        fragment = movie;
                    }
                    break;

                case R.id.navigation_tvshow:
                    fragment = tvShow;
                    if (fragment == null){
                        tvShow = new TvShowFragment();
                        fragment = tvShow;
                    }
                    break;

                case R.id.navigation_setting:
                    fragment = setting;
                    if (fragment == null){
                        setting = new SettingFragment();
                        fragment = setting;
                    }
                    break;
            }
            if (fragment != null)
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
            return fragment != null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment= findViewById(R.id.fragment);
        MovieFragment fragment=new MovieFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment,fragment);
        fragmentTransaction.commit();

        BottomNavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationHelper.disableShiftMode(navigationView);
    }

}
