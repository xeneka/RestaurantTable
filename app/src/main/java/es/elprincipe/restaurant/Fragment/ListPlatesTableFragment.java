package es.elprincipe.restaurant.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.elprincipe.restaurant.Activity.DetailPlateActivity;
import es.elprincipe.restaurant.Adapter.ListPlatesTableRecyclerViewAdapter;
import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.Comanda;
import es.elprincipe.restaurant.model.RestaurantTable;

/**
 * Created by Antonio on 6/12/16.
 */

public class ListPlatesTableFragment extends Fragment  implements  ListPlatesTableRecyclerViewAdapter.OnListPlatesTableClickListener{

    private RecyclerView mlist;
    private RestaurantTable mRestaurantTable;
    private static final String ARG_RESTAURANT_TABLE = "restaurant_table";


    public static ListPlatesTableFragment newInstance(RestaurantTable restaurantTable) {

        ListPlatesTableFragment listPlatesTableFragment = new ListPlatesTableFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(ARG_RESTAURANT_TABLE, restaurantTable);
        listPlatesTableFragment.setArguments(arguments);

        return listPlatesTableFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(getArguments() != null){

            mRestaurantTable = (RestaurantTable) getArguments().getSerializable(ARG_RESTAURANT_TABLE);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_list_plates_table, container, false);

        //Accedemos al ListView
        mlist = (RecyclerView) root.findViewById(R.id.list_plates_table);
        mlist.setLayoutManager(new LinearLayoutManager(getActivity()));
        mlist.setItemAnimator(new DefaultItemAnimator());


        // Adapter

        mlist.setAdapter(new ListPlatesTableRecyclerViewAdapter(mRestaurantTable, getActivity(),this));


        return root;
    }

    @Override
    public void OnListPlatesTableList(int position, Comanda comanda, View view) {

        Intent intent = new Intent(getActivity(), DetailPlateActivity.class);
        intent.putExtra(DetailPlateActivity.EXTRA_COMANDA,comanda);
        startActivity(intent);


    }
}
