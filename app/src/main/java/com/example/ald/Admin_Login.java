package com.example.ald;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_Login extends AppCompatActivity {

    EditText editTextLoginID, editTextPass;
    TextView textViewLoginID, textViewPass;
    Button sing_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__login);

        editTextLoginID = findViewById(R.id.etloginid);
        editTextPass = findViewById(R.id.etpass);
        textViewLoginID = findViewById(R.id.tvid);
        textViewPass = findViewById(R.id.tvpass);
        sing_in = findViewById(R.id.signin);

        sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_admin = new Intent(Admin_Login.this, Admin_Home.class);
                if(editTextLoginID.getText().toString().length() == 0){
                    Toast.makeText(Admin_Login.this, "Enter Login ID", Toast.LENGTH_LONG).show();
                }
                else if(editTextPass.getText().toString().length() == 0){
                    Toast.makeText(Admin_Login.this, "Enter Password", Toast.LENGTH_LONG).show();
                }
                else if(editTextLoginID.getText().toString().equals("shubhammulherkar23@gmail.com") && editTextPass.getText().toString().equals("shubham23")){
                    String str = "Prasad";
                    i_admin.putExtra("user", str);
                    editTextLoginID.setText(null);
                    editTextPass.setText(null);
                    startActivity(i_admin);
                }
                else if(editTextLoginID.getText().toString().equals("mankuskarabhi@gmail.com") && editTextPass.getText().toString().equals("abhimanku17")){
                    String str = "Abhishek";
                    i_admin.putExtra("user", str);
                    editTextLoginID.setText(null);
                    editTextPass.setText(null);
                    startActivity(i_admin);
                }
                else if(editTextLoginID.getText().toString().equals("shivanidsatav@gmail.com") && editTextPass.getText().toString().equals("satav1999")){
                    String str = "Shivani";
                    i_admin.putExtra("user", str);
                    editTextLoginID.setText(null);
                    editTextPass.setText(null);
                    startActivity(i_admin);
                }
                else if(editTextLoginID.getText().toString().equals("phirke_mayuri06@gmail.com") && editTextPass.getText().toString().equals("mayuri06")){
                    String str = "Mayuri";
                    i_admin.putExtra("user", str);
                    editTextLoginID.setText(null);
                    editTextPass.setText(null);
                    startActivity(i_admin);
                }
                else {
                    Toast.makeText(Admin_Login.this, "Incorrect Credentials ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
