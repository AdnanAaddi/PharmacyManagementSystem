package com.example.pharmacymanagementsystem;

import android.widget.Filter;

import com.example.pharmacymanagementsystem.adapters.MyAdapterCustomer;
import com.example.pharmacymanagementsystem.models.ModelCustomer;

import java.util.ArrayList;

public class CustomFilterCustomer extends Filter {
    MyAdapterCustomer adapter;
    ArrayList<ModelCustomer> filterList;

    public CustomFilterCustomer(ArrayList<ModelCustomer> filterList, MyAdapterCustomer adapter) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected Filter.FilterResults performFiltering(CharSequence constraint) {
        Filter.FilterResults results = new Filter.FilterResults();
        // CHECK CONSTRAINT VALIDITY
        if (constraint != null && constraint.length() > 0) {
            // CHANGE TO UPPER
            constraint = constraint.toString().toUpperCase();
            // STORE OUR FILTERED PLAYERS
            ArrayList<ModelCustomer> filteredPlayers = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {
                // CHECK
                if (filterList.get(i).getEiname().toUpperCase().contains(constraint)) {
                    // ADD PLAYER TO FILTERED PLAYERS
                    filteredPlayers.add(filterList.get(i));
                }
            }
            results.count = filteredPlayers.size();
            results.values = filteredPlayers;
        } else {
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
        adapter.models = (ArrayList<ModelCustomer>) results.values;
        // REFRESH
        adapter.notifyDataSetChanged();
    }
}
