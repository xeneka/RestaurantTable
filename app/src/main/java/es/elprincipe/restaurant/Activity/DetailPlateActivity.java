package es.elprincipe.restaurant.Activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import es.elprincipe.restaurant.Fragment.DetailPlateFragment;
import es.elprincipe.restaurant.R;

public class DetailPlateActivity extends AppCompatActivity {

    public static final String EXTRA_COMANDA = "EXTRA_COMANDA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_plate);


        FragmentManager fm = getFragmentManager();

        if (findViewById(R.id.fragment_detail_plate) != null){

            if (fm.findFragmentById(R.id.fragment_detail_plate) == null){

                fm.beginTransaction()
                        .add(R.id.fragment_detail_plate , DetailPlateFragment.newInstance("p1","p2"))
                        .commit();
            }

        }

    }
}
