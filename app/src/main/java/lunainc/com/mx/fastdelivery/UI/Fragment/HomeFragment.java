package lunainc.com.mx.fastdelivery.UI.Fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.mx.lunainc.fastdelivery.R;

import java.util.ArrayList;
import java.util.List;


import lunainc.com.mx.fastdelivery.Adapter.FoodPagerAdapter;
import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    private View view;

    private FoodPagerAdapter loginPagerAdapter;
    private ViewPager viewPager;
    private CircleIndicator indicator;
    private FirebaseFirestore firebaseFirestore;

    private int size = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);


        firebaseFirestore = FirebaseFirestore.getInstance();



        initViews();
        return view;
    }



    public void initViews(){

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        indicator = (CircleIndicator) view.findViewById(R.id.indicator);


        firebaseFirestore.collection("promosApp").whereEqualTo("state","active").get().
                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        size = task.getResult().size();
                        if (task.isSuccessful()){
                            loginPagerAdapter = new FoodPagerAdapter(getActivity().getSupportFragmentManager(), size);
                            for (QueryDocumentSnapshot dc : task.getResult()) {

                                String uid = dc.get("uid").toString();
                                loginPagerAdapter.add(uid);


                            }
                        }

                        viewPager.setAdapter(loginPagerAdapter);
                        indicator.setViewPager(viewPager);
                        loginPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());


                    }
                });




    }

}
