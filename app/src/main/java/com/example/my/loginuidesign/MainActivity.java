package com.example.my.loginuidesign;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private TextInputLayout texinputUserName;
    private TextInputLayout textInputPassword;
  private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texinputUserName = findViewById(R.id.usernameLayoutId);
        textInputPassword = findViewById(R.id.passwordLayoutId);
        submitButton = findViewById(R.id.submitId);

    }
    private boolean validateUserName(){
      String usernameInput = texinputUserName.getEditText().getText().toString().trim();
      if (usernameInput.isEmpty()){
        texinputUserName.setError("Feild Can't be empty");
        return  false;
      }
      else if(usernameInput.length()>7){
          texinputUserName.setError("Length Must Be under 7");
          return  false;
      }
      else{
          texinputUserName.setError(null);
          // or texinputUserName.setErrorEnabled(false);
          return  true;
      }
    }

    private boolean validatePassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();
        if (passwordInput.isEmpty()){
            textInputPassword.setError("Feild Can't be empty");
            return  false;
        }
        else if(passwordInput.length()>7){
            textInputPassword.setError("Length Must Be under 7");
            return  false;
        }
        else{
            textInputPassword.setError(null);
            // or texinputUserName.setErrorEnabled(false);
            return  true;
        }
    }
    public void confirmInput(View view) {
      if (!validateUserName() | !validatePassword()){
return;
      }
        Toast.makeText(this,"SuccessFully Done",Toast.LENGTH_LONG).show();
      textInputPassword.getEditText().setText("");
        texinputUserName.getEditText().setText("");
        texinputUserName.getEditText().requestFocus();
    }
}
