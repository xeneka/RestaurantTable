package es.elprincipe.restaurant.Fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import es.elprincipe.restaurant.Activity.ChoosePlateActivity;
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

        setHasOptionsMenu(true);

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

        FloatingActionButton addButton = (FloatingActionButton) root.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ChoosePlateActivity.class);
                intent.putExtra(ChoosePlateActivity.EXTRA_MESAID,mRestaurantTable.getIdTable());
                startActivity(intent);

            }
        });

        return root;
    }

    @Override
    public void OnListPlatesTableList(int position, Comanda comanda, View view) {

        //Intent intent = new Intent(getActivity(), ChoosePlateActivity.class);
        //intent.putExtra(ChoosePlateActivity.EXTRA_COMANDA,comanda);
        //startActivity(intent);


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_table_list,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean supermenu = super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.calcule){
            Log.v(getClass().getName(), String.valueOf(mRestaurantTable.totalPrice()));

            // Ha habido algún error, se lo notificamos al usuario
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
            alertDialog.setTitle("Total");
            alertDialog.setMessage(String.valueOf(mRestaurantTable.totalPrice()));
            

            alertDialog.show();


        }

        return supermenu;
    }
}
