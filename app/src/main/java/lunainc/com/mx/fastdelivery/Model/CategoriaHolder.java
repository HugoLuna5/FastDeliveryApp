package lunainc.com.mx.fastdelivery.Model;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.mx.lunainc.fastdelivery.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import lunainc.com.mx.fastdelivery.customfonts.TextView_Helvetica_Neue_bold;

public class CategoriaHolder extends RecyclerView.ViewHolder {

    public @BindView(R.id.image)
    ImageView imageView;

    public @BindView(R.id.title)
    TextView_Helvetica_Neue_bold title;

    public CategoriaHolder(View itemView){
        super(itemView);
        ButterKnife.bind(this, itemView);

    }



}
