package lunainc.com.mx.fastdelivery.UI.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.mx.lunainc.fastdelivery.R;

import lunainc.com.mx.fastdelivery.Model.Categoria;
import lunainc.com.mx.fastdelivery.Model.CategoriaHolder;

public class DescubreFragment extends Fragment {


    private View view;
    private RecyclerView recyclerView;
    private FirebaseFirestore firebaseFirestore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.descubre_fragment, container, false);

        initVars();
        initViews();
        loadData();

        return view;
    }


    public void initVars(){
        firebaseFirestore = FirebaseFirestore.getInstance();

    }

    public void initViews(){

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager( getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    public void loadData(){

        Query query = firebaseFirestore.collection("categoria");

        FirestoreRecyclerOptions<Categoria> recyclerOptions = new FirestoreRecyclerOptions.Builder<Categoria>().
                setQuery(query, Categoria.class)
                .build();


        FirestoreRecyclerAdapter adapter = new FirestoreRecyclerAdapter<Categoria, CategoriaHolder>(recyclerOptions) {
            @Override
            protected void onBindViewHolder(CategoriaHolder holder, int position, Categoria categoria) {

                holder.title.setText(categoria.getName());

                Glide.with(holder.itemView.getContext()).load(categoria.getPhoto()).into(holder.imageView);


            }

            @Override
            public CategoriaHolder onCreateViewHolder(ViewGroup group, int i) {
                View view = LayoutInflater.from(group.getContext())
                        .inflate(R.layout.item_descubre, group, false);

                return new CategoriaHolder(view);
            }
            @Override
            public void onError(FirebaseFirestoreException e) {
                Log.e("error", e.getMessage());
            }
        };

        adapter.startListening();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

}
