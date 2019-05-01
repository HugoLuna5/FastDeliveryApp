package lunainc.com.mx.fastdelivery.Adapter;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import lunainc.com.mx.fastdelivery.UI.Fragment.SliderFragment;

public class FoodPagerAdapter extends FragmentPagerAdapter {
    public ArrayList<String> uids;
    public int size = 0;


    public void add(String dat){
        uids.add(dat);
    }

    public FoodPagerAdapter(FragmentManager fm, int size) {
        super(fm);
        this.size = size;
        uids = new ArrayList<>();

        this.notifyDataSetChanged();

    }


    @Override
    public Fragment getItem(int position) {
        return  SliderFragment.newInstance(uids.get(position));



    }

    @Override
    public int getCount() {
        return size;
    }
}
