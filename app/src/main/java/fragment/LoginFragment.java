package fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.onlineclothingshoppingapp.DashboardActivity;
import com.example.onlineclothingshoppingapp.R;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Map<String, String > credentails;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        btnLogin = view.findViewById(R.id.btnLogin);

        credentails = new HashMap<>();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    login();
                }
            }
        });
        return view;
    }
    private void login(){
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("user",MODE_PRIVATE);
        String Username=sharedPreferences.getString("username","");
        String Password=sharedPreferences.getString("password","");
        if(Username.equals(etUsername.getText().toString()) && Password.equals(etPassword.getText().toString())){

            Toast.makeText(getActivity(),"Login successfull ",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getActivity(), DashboardActivity.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(getActivity(),"Either username or password is incorrect ",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate(){
        boolean validated=true;
        if(TextUtils.isEmpty(etUsername.getText().toString())){
            etUsername.setError("Username is required");
            etUsername.requestFocus();
            validated=false;
        }
        if(TextUtils.isEmpty(etPassword.getText().toString())){
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            validated=false;
        }
        return  validated;

    }

}