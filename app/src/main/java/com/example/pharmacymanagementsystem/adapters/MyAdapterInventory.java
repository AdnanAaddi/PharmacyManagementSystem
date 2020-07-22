package com.example.pharmacymanagementsystem.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacymanagementsystem.CustomFilterInventory;
import com.example.pharmacymanagementsystem.R;
import com.example.pharmacymanagementsystem.models.ModelCustomer;
import com.example.pharmacymanagementsystem.models.Modelinventory;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MyAdapterInventory extends RecyclerView.Adapter<MyViewHoderInventory> implements Filterable{
    public ArrayList<ModelCustomer> models;
    Context c;

    String uid;
    ArrayList<ModelCustomer>  filterList;
    DatabaseReference db;
    private FirebaseAuth mAuth;
    CustomFilterInventory filter;

    public MyAdapterInventory(Context c, ArrayList<ModelCustomer> models) {

        this.c = c;
        this.models = models;
        this.filterList = models;
    }

    @Override
    public MyViewHoderInventory onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(c).inflate(R.layout.customercard, parent, false);
        return new MyViewHoderInventory(v);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public void onBindViewHolder(final MyViewHoderInventory holder, final int position) {
//
//        holder.item.setText(models.get(position).getEiname());
//        holder.btc.setText(models.get(position).getEbatchNo());
//        holder.exp.setText(models.get(position).getEexpdate());
//        holder.mrp.setText(models.get(position).getEmrp());
//        holder.qty.setText(models.get(position).getEqty());
//        holder.sp.setText(models.get(position).getEsp());
//        holder.cName.setText(models.get(position).getEcName());
//        holder.code.setText(models.get(position).getEcode());
//        holder.cp.setText(models.get(position).getEcp());
//        holder.desc.setText(models.get(position).getEdesc());
//        holder.unit.setText(models.get(position).getEunit());
        holder.item.setText(models.get(position).getEiname());
        holder.exp.setText(models.get(position).getEdate());
        holder.unit.setText(models.get(position).getEmoney());
        holder.mrp.setText(models.get(position).getEaddr());
        holder.code.setText(models.get(position).getEphoneNo());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.gone.getVisibility() == View.VISIBLE) {
                    holder.gone.setVisibility(View.GONE);
                } else {
                    holder.gone.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent i = new Intent(c, UpdateItem.class);
//                i.putExtra("Keys", models.get(position).getItemId());
//                c.startActivity(i);
            }
        });

//        holder.delbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final String item = models.get(position).getEiname();
//                mAuth = FirebaseAuth.getInstance();
//                uid = mAuth.getCurrentUser().getUid();
//                db = FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("Inventory")
//                        .child("Items").child(models.get(position).getItemId());
//                db.keepSynced(true);
//                db.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(final DataSnapshot dataSnapshot) {
//
//                        AlertDialog.Builder alert = new AlertDialog.Builder(c);
//                        alert.setTitle("Alert!!");
//                        alert.setMessage("Are you sure to delete this item?");
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
//                                                                    + " Item Deleted\n" + l);
//                                                } else {
//                                                    db.getParent().getParent().getParent().child("Log").child("log")
//                                                            .setValue(format.format(calendar.getTime()) + "\n["
//                                                                    + fm.format(calendar.getTime()) + "] " + item
//                                                                    + " Item Deleted\n\n" + l);
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
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                    }
//                });
//            }
//
//        });
    }

    @Override
    public Filter getFilter() {

        if (filter == null) {
            filter = new CustomFilterInventory(filterList, this);
        }
        return filter;
    }
}
