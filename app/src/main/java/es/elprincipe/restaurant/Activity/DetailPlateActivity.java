package es.elprincipe.restaurant.Activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import es.elprincipe.restaurant.Fragment.DetailPlateFragment;
import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.Comanda;
import es.elprincipe.restaurant.model.RestaurantTables;

/**
 * Created by Antonio on 9/12/16.
 */

public class DetailPlateActivity extends AppCompatActivity {

    public static String EXTRA_MESAID = "EXTRA_MESAID";
    public static String EXTRA_COMANDA = "EXTRA_COMANDA";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_plate);

        final int mesaid = getIntent().getIntExtra(EXTRA_MESAID,0);
        final Comanda comanda = (Comanda) getIntent().getSerializableExtra(EXTRA_COMANDA);



        FragmentManager fm = getFragmentManager();

        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RestaurantTables restaurantTables = RestaurantTables.getInstance();
                restaurantTables.getTable(mesaid).addComanda(comanda);
            }
        });


        if (findViewById(R.id.fragment_detail_plate) != null){

            if (fm.findFragmentById(R.id.fragment_detail_plate) == null){

                fm.beginTransaction()
                        .add(R.id.fragment_detail_plate , DetailPlateFragment.newInstance("p1"))
                        .commit();
            }

        }


        EditText editText = (EditText) findViewById(R.id.comment_comanda);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND || keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    Log.v(getClass().getName(), textView.getText().toString());
                    comanda.setComment(textView.getText().toString());
                    handled = true;
                }
                return handled;
            }
        });

    }
}