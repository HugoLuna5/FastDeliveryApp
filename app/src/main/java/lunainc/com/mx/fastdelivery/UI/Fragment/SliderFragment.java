package lunainc.com.mx.fastdelivery.UI.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mx.lunainc.fastdelivery.R;

import lunainc.com.mx.fastdelivery.customfonts.TextView_Helvetica_Neue_bold;

public class SliderFragment extends Fragment {


    private View view;
    private ImageView imageView;
    private TextView_Helvetica_Neue_bold name;
    private TextView_Helvetica_Neue_bold desc;

    private FirebaseFirestore firebaseFirestore;


    public static SliderFragment newInstance(String parameter) {

        Bundle args = new Bundle();
        args.putString("parameter", parameter);
        SliderFragment fragment = new SliderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.slider_fragment, container, false);

        initVars();
       initViews();

        return view;
    }



    public void initVars(){

        firebaseFirestore = FirebaseFirestore.getInstance();

    }

    public void initViews(){

        imageView = (ImageView) view.findViewById(R.id.image);
        name = (TextView_Helvetica_Neue_bold) view.findViewById(R.id.namePromo);
        desc = (TextView_Helvetica_Neue_bold) view.findViewById(R.id.descPromo);



        String data = getArguments().getString("parameter");

        firebaseFirestore.collection("promosApp").document(data).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){

                    name.setText(task.getResult().get("name").toString());
                    desc.setText(task.getResult().get("desc").toString());
                    Glide.with(getActivity()).load(task.getResult().get("photo").toString()).into(imageView);


                }
            }
        });



    }

}
