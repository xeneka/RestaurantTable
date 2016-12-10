package es.elprincipe.restaurant.Activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import es.elprincipe.restaurant.Fragment.ListPlatesTableFragment;
import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.RestaurantTable;

/**
 * Created by Antonio on 6/12/16.
 */

public class ListPlatesTableActivity extends AppCompatActivity {



    private RestaurantTable mRestaurantTable;
    public static final String EXTRA_LIST_PLATES = "EXTRA_LIST_PLATES";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_plates_table);


        mRestaurantTable = (RestaurantTable) getIntent().getSerializableExtra(EXTRA_LIST_PLATES);





    // Cargo el Fragment

    FragmentManager fm = getFragmentManager();


    if (findViewById(R.id.fragment_list_plates_table) != null) {


        if(fm.findFragmentById(R.id.fragment_list_plates_table) == null){


            fm.beginTransaction()
                    .add(R.id.fragment_list_plates_table, ListPlatesTableFragment.newInstance(mRestaurantTable))
                    .commit();
        }
    }

    }

}
