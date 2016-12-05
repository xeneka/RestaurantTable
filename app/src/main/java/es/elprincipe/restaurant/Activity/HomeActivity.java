package es.elprincipe.restaurant.Activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.elprincipe.restaurant.Fragment.RestaurantTableListFragment;
import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.RestaurantTables;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RestaurantTables restaurant = new RestaurantTables(8);

        // Cargamos el Fragment

        FragmentManager fm = getFragmentManager();

        // Checking si en la interfaz va el fragment

        if (findViewById(R.id.fragment_restaurant_table_list) != null) {

            if (fm.findFragmentById(R.id.fragment_restaurant_table_list) == null) {
                fm.beginTransaction()
                        .add(R.id.fragment_restaurant_table_list, new RestaurantTableListFragment())
                        .commit();
            }


        }
    }
}
