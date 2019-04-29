package lunainc.com.mx.fastdelivery.UI;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.mx.lunainc.fastdelivery.R;

import lunainc.com.mx.fastdelivery.UI.Fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            /*

             */
            switch (item.getItemId()) {
                case R.id.home:
                    HomeFragment fragment = new HomeFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left);
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.explore:
                    return true;
                case R.id.cart:
                    return true;
                case R.id.favorite:
                    return true;
                case R.id.profile:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.bottomBar);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
