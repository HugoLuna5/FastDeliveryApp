package lunainc.com.mx.fastdelivery.UI.Activity;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import com.mx.lunainc.fastdelivery.R;

import lunainc.com.mx.fastdelivery.UI.Fragment.ContainerCarritoFragment;
import lunainc.com.mx.fastdelivery.UI.Fragment.DescubreFragment;
import lunainc.com.mx.fastdelivery.UI.Fragment.FavoriteFragment;
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
            fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left);

            switch (item.getItemId()) {
                case R.id.home:
                    HomeFragment fragment = new HomeFragment();
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.explore:

                    DescubreFragment descubreFragment = new DescubreFragment();
                    fragmentTransaction.replace(R.id.container, descubreFragment);
                    fragmentTransaction.commit();


                    return true;
                case R.id.cart:
                    ContainerCarritoFragment containerCarritoFragment = new ContainerCarritoFragment();
                    fragmentTransaction.replace(R.id.container, containerCarritoFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.favorite:

                    FavoriteFragment favoriteFragment = new FavoriteFragment();
                    fragmentTransaction.replace(R.id.container,  favoriteFragment);
                    fragmentTransaction.commit();

                    return true;
                case R.id.profile:
                    return true;
                default:
                    HomeFragment defaultF = new HomeFragment();
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
