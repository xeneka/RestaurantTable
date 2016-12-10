package es.elprincipe.restaurant.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.elprincipe.restaurant.R;

/**
 * Created by Antonio on 9/12/16.
 */

public class DetailPlateFragment extends Fragment {

    private static final String ARG_PLATE_SELECT = "ARG_PLATE_SELECT";
    private String mParam1;

    public static DetailPlateFragment newInstance(String param1) {
        DetailPlateFragment fragment = new DetailPlateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PLATE_SELECT, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PLATE_SELECT);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_detail_plate,container,false);




        return  root;
    }



}
