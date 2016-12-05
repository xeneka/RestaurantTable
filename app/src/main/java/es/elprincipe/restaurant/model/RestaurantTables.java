package es.elprincipe.restaurant.model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Antonio on 4/12/16.
 */

public class RestaurantTables implements Serializable {

    private LinkedList<RestaurantTable> mRestaurantTables;

    public RestaurantTables(int Tables){

        mRestaurantTables = new LinkedList<>();

        for(int i=0; i< Tables; i++){

            String nameMesa = "Mesa numero: ".concat(Integer.toString(i));
            RestaurantTable restTable = new RestaurantTable(nameMesa, i);
            mRestaurantTables.add(restTable);

        }

    }

    public RestaurantTable getTable(int position){
        return mRestaurantTables.get(position);
    }

    public LinkedList<RestaurantTable> getRestaurantTables() {
        return mRestaurantTables;
    }

    public int getCount(){
        return mRestaurantTables.size();
    }
}
