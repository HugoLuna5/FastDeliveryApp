package lunainc.com.mx.fastdelivery.UI.Activity;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import com.mx.lunainc.fastdelivery.R;

import lunainc.com.mx.fastdelivery.UI.Fragment.DescubreFragment;
import lunainc.com.mx.fastdelivery.UI.Fragment.HomeFragment;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            /*

             */
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.home:
                    HomeFragment fragment = new HomeFragment();
                    fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left);
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.explore:

                    DescubreFragment descubreFragment = new DescubreFragment();
                    fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_from_left);
                    fragmentTransaction.replace(R.id.container, descubreFragment);
                    fragmentTransaction.commit();


                    return true;
                case R.id.cart:
                    return true;
                case R.id.favorite:
                    return true;
                case R.id.profile:
                    return true;
                default:
                    HomeFragment defaultF = new HomeFragment();
                    fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left);
                    fragmentTransaction.replace(R.id.container, defaultF);
                    fragmentTransaction.commit();
                    return true;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.bottomBar);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.home);

    }

}
