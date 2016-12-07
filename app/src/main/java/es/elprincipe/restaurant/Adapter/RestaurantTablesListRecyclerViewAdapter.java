package es.elprincipe.restaurant.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import es.elprincipe.restaurant.R;
import es.elprincipe.restaurant.model.RestaurantTable;
import es.elprincipe.restaurant.model.RestaurantTables;

/**
 * Created by Antonio on 5/12/16.
 */

public class RestaurantTablesListRecyclerViewAdapter extends  RecyclerView.Adapter<RestaurantTablesListRecyclerViewAdapter.RestaurantTablesViewHolder>{


    private RestaurantTables mRestaurantTables;
    private Context mContext;
    private OnRestaurantTableListClickListener mOnRestaurantTableListClickListener;


    public RestaurantTablesListRecyclerViewAdapter(RestaurantTables restaurantTables, Context context, OnRestaurantTableListClickListener onRestaurantTableListClickListener){
        super();
        mRestaurantTables = restaurantTables;
        mContext = context;
        mOnRestaurantTableListClickListener = onRestaurantTableListClickListener;

    }

    @Override
    public RestaurantTablesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_restaurant_tables,parent,false);
        return new RestaurantTablesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantTablesViewHolder holder, final int position) {

        holder.binRestaurantTables(mRestaurantTables.getTable(position), mContext);
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnRestaurantTableListClickListener != null) {
                    mOnRestaurantTableListClickListener.OnRestauranTableList(position,mRestaurantTables.getTable(position),view);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRestaurantTables.getCount();
    }




    protected class RestaurantTablesViewHolder extends RecyclerView.ViewHolder {

        private TextView mNameTable;
        private View mView;

        public RestaurantTablesViewHolder(View itemView) {
            super(itemView);
            mNameTable = (TextView) itemView.findViewById(R.id.name_table);
            mView = itemView;

        }

        public void binRestaurantTables(RestaurantTable restaurantTable, Context context) {

            mNameTable.setText(restaurantTable.getNameTable());


        }

        public View getView() {
            return mView;
        }

    }

    public interface OnRestaurantTableListClickListener{
        public void OnRestauranTableList(int position, RestaurantTable restaurantTable, View view);
    }

}
