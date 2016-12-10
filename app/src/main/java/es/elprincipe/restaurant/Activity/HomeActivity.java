package es.elprincipe.restaurant.Activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ViewSwitcher;

import java.net.URL;

import es.elprincipe.restaurant.Fragment.RestaurantTableListFragment;
import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.RestaurantTables;
import es.elprincipe.restaurant.util.DownloadJson;

public class HomeActivity extends AppCompatActivity {

    private static final int LOADING_VIEW_INDEX = 0;
    private static final int RESTAURANT_VIEW_INDEX = 1;

    private ViewSwitcher mViewSwitcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // Accedemos a la toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setLogo(R.mipmap.ic_launcher);
        // Le decimos a nuestra pantalla que esa es nuestra action bar
        setSupportActionBar(toolbar);




        RestaurantTables restaurant = RestaurantTables.initInstance(4);

        // Accedo a las vistas de mi interfaz



        mViewSwitcher = (ViewSwitcher) findViewById(R.id.activity_home);




        URL mulr = null;
        try {
           mulr = new URL("http://www.mocky.io/v2/58468c41110000bf2bf3cb99");
        }catch(Exception e){
            Log.v("HOME", e.getMessage());
        }
        new DownloadJson(mViewSwitcher).execute(mulr);



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
