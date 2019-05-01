package lunainc.com.mx.fastdelivery.UI.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.mx.lunainc.fastdelivery.R;

public class FavoriteFragment extends Fragment {


    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.favorite_fragment, container, false);


        return view;
    }

}
