package com.example.pharmacymanagementsystem;

import android.widget.Filter;

import com.example.pharmacymanagementsystem.adapters.MyAdapterInventory;
import com.example.pharmacymanagementsystem.models.ModelCustomer;
import com.example.pharmacymanagementsystem.models.Modelinventory;

import java.util.ArrayList;

public class CustomFilterInventory extends Filter {
    MyAdapterInventory adapterInventory;
    ArrayList<ModelCustomer> filterList;
    public CustomFilterInventory(ArrayList<ModelCustomer> filterList, MyAdapterInventory adapter) {
        this.adapterInventory = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
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
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapterInventory.models = (ArrayList<ModelCustomer>) results.values;
        // REFRESH
        adapterInventory.notifyDataSetChanged();

    }

}
