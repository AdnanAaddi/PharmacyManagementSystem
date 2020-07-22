package com.example.pharmacymanagementsystem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Register extends AppCompatActivity {
    private GoogleApiClient mGoogleApiClient;
    EditText ename, estorename, etin, eaddr, eph1, eph2, emore, egst;
    private DatabaseReference du;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        setTitle("Register");

        ename = (EditText) findViewById(R.id.input_name);
        estorename = (EditText) findViewById(R.id.input_store_name);
        etin = (EditText) findViewById(R.id.input_tin);
        eaddr = (EditText) findViewById(R.id.input_addr);
        eph1 = (EditText) findViewById(R.id.input_ph1);
        eph2 = (EditText) findViewById(R.id.input_ph2);
        emore = (EditText) findViewById(R.id.input_more);
        egst = (EditText) findViewById(R.id.input_gst);

        mAuth = FirebaseAuth.getInstance();
        du = FirebaseDatabase.getInstance().getReference().child("Users");
        du.keepSynced(true);
    }
    public boolean validate(){
        int flag = 0;
        if (ename.getText().toString().trim().isEmpty()) {
            flag = 1;
        }

        if (etin.getText().toString().trim().isEmpty()) {
            flag = 1;
        }

        if (eaddr.getText().toString().trim().isEmpty()) {
            flag = 1;
        }
        if (eph1.getText().toString().trim().isEmpty()) {
            flag = 1;
        }
        if (eph2.getText().toString().trim().isEmpty()) {
            flag = 1;
        }
        if (emore.getText().toString().trim().isEmpty()) {
            flag = 1;
        }
        if (egst.getText().toString().trim().isEmpty()) {
            flag = 1;
        }

        if (flag == 1){
            return false;
        }else {
            return true;
        }
    }

    public void startsetup(View view) {
        String uid = mAuth.getCurrentUser().getUid();
        String sname = ename.getText().toString();
        String sstorename = estorename.getText().toString();
        String stin = etin.getText().toString();
        String saddr = eaddr.getText().toString();
        String sph1 = eph1.getText().toString();
        String sph2 = eph2.getText().toString();
        String smore = emore.getText().toString();
        String sgst = egst.getText().toString();
        if (validate()) {
            du.child(uid).child("info").child("name").setValue(sname);
            du.child(uid).child("info").child("storename").setValue(sstorename);
            du.child(uid).child("info").child("tin").setValue(stin);
            du.child(uid).child("info").child("addr").setValue(saddr);
            du.child(uid).child("info").child("ph1").setValue(sph1);
            du.child(uid).child("info").child("ph2").setValue(sph2);
            du.child(uid).child("info").child("more").setValue(smore);
            du.child(uid).child("info").child("gst").setValue(sgst);

            Calendar calendar = Calendar.getInstance();
             SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat fm = new SimpleDateFormat("HH:mm");
            du.child(uid).child("Log").child("log").setValue(
                    format.format(calendar.getTime()) + "\n[" + fm.format(calendar.getTime()) + "] Account Created");

            Intent i = new Intent(this, HomeActivity.class);
            finish();
            startActivity(i);
        }
        else {
                Toast.makeText(this, "Please Fill all the fields", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        super.onBackPressed();
    }

    public void logoutreg(View view) {
        signOut();
    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(Status status) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(Register.this, Login.class);
                finish();
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();
        mGoogleApiClient.connect();
        super.onStart();
    }
}
