package es.elprincipe.restaurant.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.elprincipe.restaurant.Activity.DetailPlateActivity;
import es.elprincipe.restaurant.Adapter.ListAllPlatesRecyclerViewAdapter;
import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.Comanda;
import es.elprincipe.restaurant.model.Plates;


public class ChoosePlateFragment extends Fragment implements ListAllPlatesRecyclerViewAdapter.OnListAllPlatesClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_MESAID = "ARG_MESAID";


    // TODO: Rename and change types of parameters
    private int mMesaid;


    private RecyclerView mlist;



    // TODO: Rename and change types and number of parameters
    public static ChoosePlateFragment newInstance(int mesaid) {
        ChoosePlateFragment fragment = new ChoosePlateFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_MESAID, mesaid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMesaid = getArguments().getInt(ARG_MESAID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_choose_plate, container, false);

        //Accedemos al ListView
        mlist = (RecyclerView) root.findViewById(R.id.list_all_plates);
        mlist.setLayoutManager(new LinearLayoutManager(getActivity()));
        mlist.setItemAnimator(new DefaultItemAnimator());


        // Adapter
        Plates mPlates = Plates.getInstance();

        mlist.setAdapter(new ListAllPlatesRecyclerViewAdapter(mPlates, getActivity(),this));

        return root;
    }




    @Override
    public void OnListAllPlates(int position, Comanda comanda, View view) {


        Intent intent = new Intent(getActivity(), DetailPlateActivity.class);
        intent.putExtra(DetailPlateActivity.EXTRA_MESAID, mMesaid);
        intent.putExtra(DetailPlateActivity.EXTRA_COMANDA, comanda);

        startActivity(intent);
    }
}
