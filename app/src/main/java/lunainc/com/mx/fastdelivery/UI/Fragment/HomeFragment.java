package lunainc.com.mx.fastdelivery.UI.Fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.mx.lunainc.fastdelivery.R;
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import lunainc.com.mx.fastdelivery.Adapter.FoodPagerAdapter;
import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    private FoodPagerAdapter loginPagerAdapter;
    private ViewPager viewPager;
    private CircleIndicator indicator;
    private FirebaseFirestore firebaseFirestore;
    private int size = 0;

    @BindView(R.id.recyclerviewCombos)
    MultiSnapRecyclerView recyclerViewCombos;
    @BindView(R.id.recyclerviewPromos)
    MultiSnapRecyclerView recyclerViewPromos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View  view = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, view);

        firebaseFirestore = FirebaseFirestore.getInstance();


        initViews(view);

        return view;
    }



    public void initViews(View view){

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


        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(getActivity());
        LinearLayoutManager linearLayoutManager2 =  new LinearLayoutManager(getActivity());
        recyclerViewCombos.setLayoutManager(linearLayoutManager);
        recyclerViewPromos.setLayoutManager(linearLayoutManager2);



    }

}
