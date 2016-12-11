package es.elprincipe.restaurant.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.Comanda;
import es.elprincipe.restaurant.util.AsignImage;

/**
 * Created by Antonio on 9/12/16.
 */

public class DetailPlateFragment extends Fragment {

    private static final String ARG_PLATE_SELECT = "ARG_PLATE_SELECT";
    private Comanda mComanda;
    private static OnAddPlateListener mOnAddPlateListener;

    private ImageView mImageView;
    private TextView mplate;
    private TextView mprice;
    private TextView malergenos;
    private TextView mcomment;
    private Button mButton;

    public static DetailPlateFragment newInstance(Comanda comanda, OnAddPlateListener onAddPlateListener) {
        DetailPlateFragment fragment = new DetailPlateFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PLATE_SELECT, comanda);
        mOnAddPlateListener = onAddPlateListener;

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        if (getArguments() != null) {
            mComanda = (Comanda) getArguments().getSerializable(ARG_PLATE_SELECT);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_detail_plate,container,false);

        mImageView = (ImageView) root.findViewById(R.id.table_image);
        malergenos = (TextView) root.findViewById(R.id.alergenos_plate);
        mplate = (TextView) root.findViewById(R.id.name_plate);
        malergenos = (TextView) root.findViewById(R.id.alergenos_plate);
        mprice = (TextView) root.findViewById(R.id.precio_plate);
        mButton = (Button) root.findViewById(R.id.add_coment);

        final EditText editText = (EditText) root.findViewById(R.id.comment_comanda);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnAddPlateListener.NewComandaCommentsAdd(editText.getText().toString());

                Snackbar.make(getView(),"Comentario Añadido",Snackbar.LENGTH_LONG).show();
            }
        });


        setDataPlate();


        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                boolean handled = false;

                if (actionId == EditorInfo.IME_ACTION_SEND || keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                    mComanda.setComment(textView.getText().toString());
                    mOnAddPlateListener.NewComandaCommentsAdd(textView.getText().toString());
                    Snackbar.make(getView(),"Comentario Añadido",Snackbar.LENGTH_LONG).show();

                    handled = true;
                }
                return handled;
            }
        });




        return  root;
    }

    private void setDataPlate(){
        mImageView.setImageResource(AsignImage.plateImage(mComanda.getPlate()));
        malergenos.setText(mComanda.getAllergens().toString());
        mprice.setText(String.valueOf(mComanda.getPrice()));
        mplate.setText(mComanda.getPlate());



    }

    public interface OnAddPlateListener{
        public void NewComandaCommentsAdd(String comment);
        public void NotSavePlate();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_detail_plate, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean supermenu = super.onOptionsItemSelected(item);

        if(item.getItemId() ==  R.id.listtable){
            mOnAddPlateListener.NotSavePlate();
        }

        return supermenu;
    }

}
