package lunainc.com.mx.fastdelivery.UI.Activity.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.mx.lunainc.fastdelivery.R;

import lunainc.com.mx.fastdelivery.UI.Activity.HomeActivity;
import lunainc.com.mx.fastdelivery.customfonts.EditText_Roboto_Regular;
import lunainc.com.mx.fastdelivery.customfonts.MyTextView_Roboto_Regular;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * Variables globales
     */
    public EditText_Roboto_Regular editNumber;
    public MyTextView_Roboto_Regular btnLogin;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void initVars() {
        mAuth = FirebaseAuth.getInstance();
    }

    public void initViews(){

        editNumber = (EditText_Roboto_Regular) findViewById(R.id.phoneNumber);
        btnLogin = (MyTextView_Roboto_Regular) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:

                String number = editNumber.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editNumber.setError("Se requiere un numero valido");
                    editNumber.requestFocus();
                    return;
                }

                String phoneNumber = number;

                /**
                 * Verificar numero de telefono
                 */

                Intent intent = new Intent(LoginActivity.this, VerifyPhoneActivity.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);
                finish();


                break;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {

            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
            finish();

        }
    }

}
