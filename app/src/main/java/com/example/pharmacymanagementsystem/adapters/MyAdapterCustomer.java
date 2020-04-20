package com.example.pharmacymanagementsystem.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacymanagementsystem.CustomerLog;
import com.example.pharmacymanagementsystem.DecimalDigitsInputFilter;
import com.example.pharmacymanagementsystem.R;
import com.example.pharmacymanagementsystem.UpdateCustomers;
import com.example.pharmacymanagementsystem.models.ModelCustomer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class MyAdapterCustomer extends RecyclerView.Adapter<MyViewHolderCustomer> {
    Context c;

    String uid;
    ArrayList<ModelCustomer> models, filterList;
    DatabaseReference db;
    private FirebaseAuth mAuth;
   // CustomFilterCustomer filter;

    public MyAdapterCustomer(Context c, ArrayList<ModelCustomer> models) {

        this.c = c;
        this.models = models;
        this.filterList = models;
    }


    @NonNull
    @Override
    public MyViewHolderCustomer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.customercard, parent, false);
        return new MyViewHolderCustomer(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolderCustomer holder, final int position) {
        holder.item.setText(models.get(position).getEiname());
        holder.date.setText(models.get(position).getEdate());
        holder.money.setText(models.get(position).getEmoney());
        holder.addr.setText(models.get(position).getEaddr());
        holder.phone.setText(models.get(position).getEphoneNo());

//        holder.cv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (holder.gone.getVisibility() == View.VISIBLE) {
//                    holder.gone.setVisibility(View.GONE);
//                } else {
//                    holder.gone.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//
//        holder.editBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(c, UpdateCustomers.class);
//                i.putExtra("Keys", models.get(position).getKey());
//                c.startActivity(i);
//            }
//        });
//        holder.log.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(c, CustomerLog.class);
//                i.putExtra("k", models.get(position).getKey());
//                c.startActivity(i);
//
//            }
//        });
//        holder.delbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final String item = models.get(position).getEiname();
//                mAuth = FirebaseAuth.getInstance();
//                uid = mAuth.getCurrentUser().getUid();
//                db = FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("Customer")
//                        .child("Person").child(models.get(position).getKey());
//                db.keepSynced(true);
//                db.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(final DataSnapshot dataSnapshot) {
//
//                        AlertDialog.Builder alert = new AlertDialog.Builder(c);
//                        alert.setTitle("Alert!!");
//                        alert.setMessage("Are you sure to delete this customer?");
//                        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                                dataSnapshot.getRef().removeValue();
//                                dialog.dismiss();
//                                models.remove(position);
//                                notifyItemRemoved(position);
//                                notifyItemRangeChanged(position, models.size());
//
//                                // log
//                                db.getParent().getParent().getParent().child("Log").child("log")
//                                        .addListenerForSingleValueEvent(new ValueEventListener() {
//                                            @Override
//                                            public void onDataChange(DataSnapshot dataSnapshot) {
//                                                String l = (String) dataSnapshot.getValue();
//                                                String date = l.substring(0, 10);
//                                                Calendar calendar = Calendar.getInstance();
//                                                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//                                                SimpleDateFormat fm = new SimpleDateFormat("HH:mm");
//                                                if (format.format(calendar.getTime()).equals(date)) {
//                                                    l = l.substring(11);
//                                                    db.getParent().getParent().getParent().child("Log").child("log")
//                                                            .setValue(format.format(calendar.getTime()) + "\n["
//                                                                    + fm.format(calendar.getTime()) + "] " + item
//                                                                    + " Customer Deleted\n" + l);
//                                                } else {
//                                                    db.getParent().getParent().getParent().child("Log").child("log")
//                                                            .setValue(format.format(calendar.getTime()) + "\n["
//                                                                    + fm.format(calendar.getTime()) + "] " + item
//                                                                    + " Customer Deleted\n\n" + l);
//                                                }
//
//                                            }
//
//                                            @Override
//                                            public void onCancelled(DatabaseError error) {
//                                            }
//                                        });
//
//                                Toast.makeText(c, item + " has been removed succesfully.", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//
//                        alert.show();
////
    }
    @Override
    public int getItemCount() {
        return 0;
    }
}