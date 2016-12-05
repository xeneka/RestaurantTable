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
    private TextView mNameTable;

    public RestaurantTablesListRecyclerViewAdapter(RestaurantTables restaurantTables, Context context){
        super();
        mRestaurantTables = restaurantTables;
        mContext = context;

    }

    @Override
    public RestaurantTablesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_restaurant_tables,parent,false);
        return new RestaurantTablesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantTablesViewHolder holder, int position) {

        holder.binRestaurantTables(mRestaurantTables.getTable(position), mContext);
    }

    @Override
    public int getItemCount() {
        return mRestaurantTables.getCount();
    }

    protected class RestaurantTablesViewHolder extends RecyclerView.ViewHolder {

        public RestaurantTablesViewHolder(View itemView) {
            super(itemView);
            mNameTable = (TextView) itemView.findViewById(R.id.name_table);

        }

        public void binRestaurantTables(RestaurantTable restaurantTable, Context context) {
            //Log.v("*****", restaurantTable.getNameTable());
            mNameTable.setText(restaurantTable.getNameTable());

        }
    }


}
