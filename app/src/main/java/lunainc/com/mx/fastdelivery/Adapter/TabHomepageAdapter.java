package lunainc.com.mx.fastdelivery.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import lunainc.com.mx.fastdelivery.UI.Fragment.CarritoFragment;
import lunainc.com.mx.fastdelivery.UI.Fragment.HistorialFragment;

public class TabHomepageAdapter extends FragmentStatePagerAdapter {
        private int numoftabs;

    public TabHomepageAdapter(FragmentManager fm, int  mnumoftabs ) {
            super(fm);
            this.numoftabs = mnumoftabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CarritoFragment();
                case 1:
                    return new HistorialFragment();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return numoftabs;
        }
}
