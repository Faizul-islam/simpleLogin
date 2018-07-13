package com.example.mdfaizulislam.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //[Faizul 1]
    //Create variable (User define)

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int Counter = 5;

    //[~Faizul 1]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //[Faizul 2]
        //find by id

        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPasswort);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining: 5");

        //to response to click on Login Button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());

            }
        });


        //[~Faizul 2]

    }

    //[Faizul 3]
    //Validation
    private void validate(String userName, String userPassword) {
        if (userName.equals("Admin") && userPassword.equals("1234")) {

            ///intent use to move one activity to another activity
            Intent intn = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intn);
        } else {
            Counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(Counter));

            if (Counter == 0) {
                Login.setEnabled(false);
            }
        }
    }
}
