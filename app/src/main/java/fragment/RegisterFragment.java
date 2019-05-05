package fragment;



import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.onlineclothingshoppingapp.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    private EditText etUsername, etPhoneNumber, etPassword, etAddress;
    private RadioButton rbMale, rbFemale;
    private Button btnRegister;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etPhoneNumber = view.findViewById(R.id.etPhoneNumber);
        etPassword = view.findViewById(R.id.etPassword);
        etAddress = view.findViewById(R.id.etAddress);
        rbMale = view.findViewById(R.id.rbMale);
        rbFemale = view.findViewById(R.id.rbFemale);
        btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender = "";
                if (rbMale.isChecked()){
                    gender = "male";
                }else {
                    gender = "female";
                }
                if (validate()){
                    register(gender);
                }
            }
        });

        return view;
    }
    private void register(String gender){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString("username",etUsername.getText().toString());
        editor.putString("phoneNumber",etPhoneNumber.getText().toString());
        editor.putString("password",etPassword.getText().toString());
        editor.putString("address",etAddress.getText().toString());
        editor.putString("gender",gender);
        editor.commit();

        Toast.makeText(getActivity(),"Registered successfull ",Toast.LENGTH_SHORT).show();
    }

    private boolean validate(){
        boolean validator=true;
        if(TextUtils.isEmpty(etUsername.getText().toString())){
            etUsername.setError("Username is required");
            etUsername.requestFocus();
            validator=false;
        }
        if(TextUtils.isEmpty(etPhoneNumber.getText().toString())){
            etPhoneNumber.setError("Password is required");
            etPhoneNumber.requestFocus();
            validator=false;
        }
        if(TextUtils.isEmpty(etAddress.getText().toString())){
            etAddress.setError("Username is required");
            etAddress.requestFocus();
            validator=false;
        }

        return  validator;

    }




}