package es.elprincipe.restaurant.Activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import es.elprincipe.restaurant.Fragment.ChoosePlateFragment;
import es.elprincipe.restaurant.Fragment.DetailPlateFragment;
import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.Comanda;
import es.elprincipe.restaurant.model.RestaurantTables;

/**
 * Created by Antonio on 9/12/16.
 */

public class DetailPlateActivity extends AppCompatActivity implements DetailPlateFragment.OnAddPlateListener {

    public static String EXTRA_MESAID = "EXTRA_MESAID";
    public static String EXTRA_COMANDA = "EXTRA_COMANDA";
    private Comanda comanda;
    private int mesaid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_plate);

        mesaid = getIntent().getIntExtra(EXTRA_MESAID,0);
        comanda = (Comanda) getIntent().getSerializableExtra(EXTRA_COMANDA);



        FragmentManager fm = getFragmentManager();

        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestaurantTables restaurantTables = RestaurantTables.getInstance();
                restaurantTables.getTable(mesaid).addComanda(comanda);

                returnListPlateTables();


            }
        });


        if (findViewById(R.id.fragment_detail_plate) != null){
            Log.v(getClass().getName(),"DETAIL");

            if (fm.findFragmentById(R.id.fragment_detail_plate) == null){

                fm.beginTransaction()
                        .add(R.id.fragment_detail_plate , DetailPlateFragment.newInstance(comanda,this))
                        .commit();
            }

        }


        if (findViewById(R.id.fragment_choose_plate) != null){
            Log.v(getClass().getName(),"CHOSE");

            if (fm.findFragmentById(R.id.fragment_choose_plate) == null){

                fm.beginTransaction()
                        .add(R.id.fragment_choose_plate , ChoosePlateFragment.newInstance(mesaid))
                        .commit();
            }

        }




    }

    public void returnListPlateTables(){
        Intent intent = new Intent(this,ListPlatesTableActivity.class);
        intent.putExtra(ListPlatesTableActivity.EXTRA_LIST_PLATES, RestaurantTables.getInstance().getRestaurantTables().get(mesaid));
        startActivity(intent);
    }

    @Override
    public void NewComandaCommentsAdd(String comment) {
        comanda.setComment(comment);
    }
}
