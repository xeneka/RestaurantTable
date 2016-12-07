package es.elprincipe.restaurant.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.elprincipe.restaurant.Activity.ListPlatesTableActivity;
import es.elprincipe.restaurant.Adapter.RestaurantTablesListRecyclerViewAdapter;
import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.Comanda;
import es.elprincipe.restaurant.model.RestaurantTable;
import es.elprincipe.restaurant.model.RestaurantTables;


public class RestaurantTableListFragment extends Fragment implements RestaurantTablesListRecyclerViewAdapter.OnRestaurantTableListClickListener {

    private static final String ARG_PARAM1 = "mesaid";

    private RecyclerView mlist;


    private RestaurantTables mRestaurantTables;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_restaurant_table_list, container, false);



        // Modelo
        if (mRestaurantTables == null) {
            mRestaurantTables = new RestaurantTables(8);
        }



        //Accedemos al ListView
        mlist = (RecyclerView) root.findViewById(android.R.id.list);
        mlist.setLayoutManager(new LinearLayoutManager(getActivity()));
        mlist.setItemAnimator(new DefaultItemAnimator());


        // Adapter

        mlist.setAdapter(new RestaurantTablesListRecyclerViewAdapter(mRestaurantTables, getActivity(),this));



        return root;
    }



    @Override
    public void OnRestauranTableList(int position, RestaurantTable restaurantTable, View view) {


        // Datos ficticios de prueba


        ArrayList<String> ale = new ArrayList<String>();
        ale.add("lentejas");
        ale.add("sal");
        Comanda prcomanda1 = new Comanda("Lentejas", 10.0, ale);
        Comanda prcomanda2 = new Comanda("Carne", 15.75, ale);

        restaurantTable.addComanda(prcomanda1);
        restaurantTable.addComanda(prcomanda2);
        Log.v(getClass().getName(), String.valueOf(restaurantTable.getNumComandas()));


        Intent intent = new Intent(getActivity(), ListPlatesTableActivity.class);
        intent.putExtra(ListPlatesTableActivity.EXTRA_LIST_PLATES, restaurantTable);
        startActivity(intent);

    }
}
