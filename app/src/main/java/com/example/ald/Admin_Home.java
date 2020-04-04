package com.example.ald;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_Home extends AppCompatActivity {

    static final int PICK_AUDIO_REQUEST = 1;
    static Uri audioFilePath;
    String saudioFilePath;
    DBHandler dbh;
    Attribute at;

    TextView yrj, dptj, subjj, tpj, audioj, hey, user;
    EditText etyrj, etdptj, etsubj, ettpj, etaudioj;
    Button bj, b2j, b3j, b4j;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__home);

        dbh = new DBHandler(this);

        yrj = findViewById(R.id.yr);
        dptj = findViewById(R.id.dpt);
        subjj = findViewById(R.id.subj);
        tpj = findViewById(R.id.tp);
        audioj = findViewById(R.id.taudio);
        etyrj = findViewById(R.id.etyr);
        etdptj = findViewById(R.id.etdpt);
        etsubj = findViewById(R.id.etsub);
        ettpj = findViewById(R.id.ettp);
        etaudioj = findViewById(R.id.etaudio);
        bj = findViewById(R.id.b);
        b2j = findViewById(R.id.b2);
        b3j = findViewById(R.id.b3);
        b4j = findViewById(R.id.b4);
        hey = findViewById(R.id.hey);
        user = findViewById(R.id.user);

        user.setText(getIntent().getStringExtra("user"));
        dbh = new DBHandler(this);

        etaudioj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("audio/*");
                startActivityForResult(i, PICK_AUDIO_REQUEST);
            }
        });

        //insData();
        delData();
        upData();
        vallData();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_AUDIO_REQUEST && resultCode==RESULT_OK && data != null && data.getData()!= null){

            audioFilePath = data.getData();
            saudioFilePath = getRealPathFromUri(audioFilePath);
            etaudioj.setText(saudioFilePath);

            bj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    at = new Attribute(etyrj.getText().toString(),
                            etdptj.getText().toString(),
                            etsubj.getText().toString(),
                            ettpj.getText().toString(),
                            etaudioj.getText().toString());


                    boolean isInserted = dbh.insertData(at.getYear(),
                            at.getDep(),
                            at.getSub(),
                            at.getTopic(),
                            at.getAudio_path());
                    if(isInserted){
                        Toast.makeText(Admin_Home.this, "Data Insertion Successful", Toast.LENGTH_LONG).show();
                        cleara();
                    }
                    else {
                        Toast.makeText(Admin_Home.this, "Data Insertion Unsuccessful", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void delData() {
        b2j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ettpj.getText().toString().length() == 0) {
                    Toast.makeText(Admin_Home.this, "Enter Topic Name", Toast.LENGTH_LONG).show();
                }
                else if(dbh.checkempty()){
                    Toast.makeText(Admin_Home.this, "Empty Database", Toast.LENGTH_LONG).show();
                }
                else if(dbh.checkexists(ettpj.getText().toString())){
                    Toast.makeText(Admin_Home.this, "Data Does Not Exists", Toast.LENGTH_LONG).show();
                }
                else {

                    boolean deletedRows = dbh.deleteData(ettpj.getText().toString());

                    if (deletedRows){
                        Toast.makeText(Admin_Home.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        cleara();
                    }
                    else {
                        Toast.makeText(Admin_Home.this, "Data Not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void upData() {
        b3j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valid()){

                    at = new Attribute(etyrj.getText().toString(),
                            etdptj.getText().toString(),
                            etsubj.getText().toString(),
                            ettpj.getText().toString(),
                            getRealPathFromUri(audioFilePath));

                    if(dbh.checkempty()){
                        Toast.makeText(Admin_Home.this, "Empty Database", Toast.LENGTH_LONG).show();
                    }
                    else if(dbh.checkexists(at.getTopic())){
                        Toast.makeText(Admin_Home.this, "Data Does Not Exists", Toast.LENGTH_LONG).show();
                    }
                    else {

                        boolean isUpdate = dbh.updateData(at.getYear(),
                                at.getDep(),
                                at.getSub(),
                                at.getTopic(),
                                at.getAudio_path());

                        if (isUpdate) {
                            Toast.makeText(Admin_Home.this, "Data Update", Toast.LENGTH_LONG).show();
                            cleara();
                        }
                        else {
                            Toast.makeText(Admin_Home.this, "Data Not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }

    private void vallData() {
        b4j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res = dbh.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing Found");
                    return;
                }

                StringBuilder buffer = new StringBuilder();

                while (res.moveToNext()) {
                    buffer.append("Year \t\t :" + res.getString(0) + "\n");
                    buffer.append("Deptartment \t :" + res.getString(1) + "\n");
                    buffer.append("Subject \t\t:" + res.getString(2) + "\n");
                    buffer.append("Topic \t\t\t :" + res.getString(3) + "\n");
                    buffer.append("Audio Path \t\t : "+res.getString(4)+"\n");
                    buffer.append("------------------------------------\n");
                }

                // Show all data
                showMessage("Data", buffer.toString());
            }
        });
    }

    private boolean valid () {
        boolean res = false;
        if (etyrj.getText().toString().length() == 0) {
            Toast.makeText(Admin_Home.this, "Enter Year", Toast.LENGTH_LONG).show();
        }
        else if (etdptj.getText().toString().length() == 0) {
            Toast.makeText(Admin_Home.this, "Enter Department Name", Toast.LENGTH_LONG).show();
        }
        else if (etsubj.getText().toString().length() == 0) {
            Toast.makeText(Admin_Home.this, "Enter Subject Name", Toast.LENGTH_LONG).show();
        }
        else if (ettpj.getText().toString().length() == 0) {
            Toast.makeText(Admin_Home.this, "Enter Topic Name", Toast.LENGTH_LONG).show();
        }
        else if(etaudioj.getText().toString().length() == 0){
            Toast.makeText(Admin_Home.this, "Select Audio Path", Toast.LENGTH_LONG).show();
        }
        else {
            res = true;
        }
        return res;
    }

    private void cleara () {
        etyrj.setText(null);
        etdptj.setText(null);
        etsubj.setText(null);
        ettpj.setText(null);
        etaudioj.setText(null);
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public String getRealPathFromUri(Uri contentUri){
        String[] proj = {MediaStore.Audio.Media.DATA};
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        if(cursor == null){
            return contentUri.getPath();
        }

        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        //cursor.close();
        return cursor.getString(column_index);
    }
}