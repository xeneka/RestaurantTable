package es.elprincipe.restaurant.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.Comanda;

/**
 * Created by Antonio on 9/12/16.
 */

public class DetailPlateFragment extends Fragment {

    private static final String ARG_PLATE_SELECT = "ARG_PLATE_SELECT";
    private Comanda mComanda;
    private static OnAddPlateListener mOnAddPlateListener;

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
        if (getArguments() != null) {
            mComanda = (Comanda) getArguments().getSerializable(ARG_PLATE_SELECT);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_detail_plate,container,false);

        EditText editText = (EditText) root.findViewById(R.id.comment_comanda);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                boolean handled = false;

                if (actionId == EditorInfo.IME_ACTION_SEND || keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    Log.v(getClass().getName(), textView.getText().toString());
                    mComanda.setComment(textView.getText().toString());
                    mOnAddPlateListener.NewComandaCommentsAdd(textView.getText().toString());

                    handled = true;
                }
                return handled;
            }
        });




        return  root;
    }

    public interface OnAddPlateListener{
        public void NewComandaCommentsAdd(String comment);
    }


}
