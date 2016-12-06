package es.elprincipe.restaurant.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.elprincipe.restaurant.Adapter.RestaurantTablesListRecyclerViewAdapter;
import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.RestaurantTable;
import es.elprincipe.restaurant.model.RestaurantTables;


public class RestaurantTableListFragment extends Fragment implements RestaurantTablesListRecyclerViewAdapter.OnRestaurantTableListClickListener {

    private static final String ARG_PARAM1 = "mesaid";

    private RecyclerView mlist;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_restaurant_table_list, container, false);



        // Modelo
        final RestaurantTables restaurantTables = new RestaurantTables(8);

        //Accedemos al ListView
        mlist = (RecyclerView) root.findViewById(android.R.id.list);
        mlist.setLayoutManager(new LinearLayoutManager(getActivity()));
        mlist.setItemAnimator(new DefaultItemAnimator());


        // Adapter

        mlist.setAdapter(new RestaurantTablesListRecyclerViewAdapter(restaurantTables, getActivity(),this));



        return root;
    }

    @Override
    public void OnRestauranTableList(int position, RestaurantTable restaurantTable, View view) {
        Log.v("CLICK", restaurantTable.getNameTable());
    }
}
