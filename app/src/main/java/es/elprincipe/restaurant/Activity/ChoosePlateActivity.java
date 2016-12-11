package es.elprincipe.restaurant.Activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import es.elprincipe.restaurant.Fragment.ChoosePlateFragment;
import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.Plates;

public class ChoosePlateActivity extends AppCompatActivity {

    public static final String EXTRA_MESAID = "EXTRA_MESAID";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_plate);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Plates plates = Plates.getInstance();

        int mesaid = getIntent().getIntExtra(EXTRA_MESAID,0);

        
        FragmentManager fm = getFragmentManager();

        if (findViewById(R.id.fragment_choose_plate) != null){

            if (fm.findFragmentById(R.id.fragment_choose_plate) == null){

                fm.beginTransaction()
                        .add(R.id.fragment_choose_plate , ChoosePlateFragment.newInstance(mesaid))
                        .commit();
            }

        }





    }

    
}
