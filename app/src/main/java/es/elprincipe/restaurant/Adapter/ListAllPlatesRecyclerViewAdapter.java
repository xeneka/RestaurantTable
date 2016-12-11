package es.elprincipe.restaurant.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.Comanda;
import es.elprincipe.restaurant.model.Plates;
import es.elprincipe.restaurant.util.AsignImage;

/**
 * Created by Antonio on 8/12/16.
 */

public class ListAllPlatesRecyclerViewAdapter extends RecyclerView.Adapter<ListAllPlatesRecyclerViewAdapter.ListAllTablesViewHolder> {


    private Plates mPlates;
    private Context mContext;
    private OnListAllPlatesClickListener mOnListAllPlatesClickListener;
    private ImageView mImageView;

    public ListAllPlatesRecyclerViewAdapter(Plates plates, Context context ,OnListAllPlatesClickListener onListAllPlatesClickListener ) {
        super();
        mPlates = plates;
        mContext = context;
        mOnListAllPlatesClickListener = onListAllPlatesClickListener;

    }

    @Override
    public ListAllTablesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_plates_table,parent,false);

        return new ListAllTablesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAllTablesViewHolder holder, final int position) {

        holder.bindListAllTablesViewHolder(mPlates.getComandaId(position), mContext);
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mOnListAllPlatesClickListener != null){
                    mOnListAllPlatesClickListener.OnListAllPlates(position,mPlates.getComandaId(position),view);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mPlates.getNumComandas();
    }

    protected class ListAllTablesViewHolder extends RecyclerView.ViewHolder {

        private TextView mnamePlate;
        private TextView mprecioPlate;
        private TextView alergenos;
        private View mView;

        public ListAllTablesViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mnamePlate = (TextView) itemView.findViewById(R.id.name_plate);
            mprecioPlate = (TextView) itemView.findViewById(R.id.precio_plate);
            alergenos = (TextView) itemView.findViewById(R.id.alergenos_plate);
            mImageView = (ImageView) itemView.findViewById(R.id.table_image);


        }

        public void bindListAllTablesViewHolder(Comanda comanda, Context context){

            mnamePlate.setText(comanda.getPlate());
            mprecioPlate.setText(comanda.getPrice().toString());
            alergenos.setText(comanda.getAllergens().toString());
            mImageView.setImageResource(AsignImage.plateImage(comanda.getPlate()));

        }

        public View getView() {
            return mView;
        }


    }

    public interface OnListAllPlatesClickListener{
        public void OnListAllPlates(int position, Comanda comanda, View view);
    }


}
