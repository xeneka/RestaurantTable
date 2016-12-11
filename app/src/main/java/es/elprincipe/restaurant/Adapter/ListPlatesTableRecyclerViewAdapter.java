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
import es.elprincipe.restaurant.model.RestaurantTable;
import es.elprincipe.restaurant.util.AsignImage;

/**
 * Created by Antonio on 6/12/16.
 */

public class ListPlatesTableRecyclerViewAdapter extends RecyclerView.Adapter<ListPlatesTableRecyclerViewAdapter.ListPlatesTablesViewHolder> {


    private RestaurantTable mRestaurantTable;
    private Context mContext;
    private OnListPlatesTableClickListener mOnListPlatesTableClickListener;



    public ListPlatesTableRecyclerViewAdapter(RestaurantTable restaurantTable, Context context, OnListPlatesTableClickListener onListPlatesTableClickListener) {
        super();
        mRestaurantTable = restaurantTable;
        mContext = context;
        mOnListPlatesTableClickListener  = onListPlatesTableClickListener;


    }

    @Override
    public ListPlatesTablesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_list_plates_table,parent,false);

        return new ListPlatesTablesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListPlatesTablesViewHolder holder, final int position) {

        holder.bindListPlatesTablesViewHolder(mRestaurantTable.getComandaId(position), mContext);
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnListPlatesTableClickListener != null){
                    mOnListPlatesTableClickListener.OnListPlatesTableList(position,mRestaurantTable.getComandaId(position),view);
                }
            }
        });


    }



    @Override
    public int getItemCount() {
        return mRestaurantTable.getNumComandas();
    }

    protected class ListPlatesTablesViewHolder extends RecyclerView.ViewHolder {

        private TextView mnamePlate;
        private TextView mprecioPlate;
        private TextView alergenos;
        private TextView mCommentPlate;
        private View mView;
        private ImageView mImageView;


        public ListPlatesTablesViewHolder(View itemView) {

            super(itemView);
            mView = itemView;
            mnamePlate = (TextView) itemView.findViewById(R.id.name_plate);
            mprecioPlate = (TextView) itemView.findViewById(R.id.precio_plate);
            alergenos = (TextView) itemView.findViewById(R.id.alergenos_plate);
            mCommentPlate = (TextView) itemView.findViewById(R.id.comment_plate);
            mImageView = (ImageView) itemView.findViewById(R.id.table_image);



        }

        public void bindListPlatesTablesViewHolder(Comanda comanda, Context context){


            mnamePlate.setText(comanda.getPlate());
            mprecioPlate.setText(comanda.getPrice().toString());
            alergenos.setText(comanda.getAllergens().toString());
            mCommentPlate.setText(comanda.getComment());
            mImageView.setImageResource(AsignImage.plateImage(comanda.getPlate()));

        }

        public View getView() {
            return mView;
        }
    }


    public interface OnListPlatesTableClickListener{
        public void OnListPlatesTableList(int position, Comanda comanda, View view);
    }
}