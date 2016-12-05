package es.elprincipe.restaurant.model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Antonio on 4/12/16.
 */

public class RestaurantTable implements Serializable{

    private LinkedList<Comanda> mComandas;
    private String mNameTable;
    private int mIdTable;

    public RestaurantTable(String nombre, int idTable){

        mNameTable = nombre;
        mComandas = null;
        mIdTable = idTable;

    }

    public String getNameTable() {
        return mNameTable;
    }

    public void addComanda(Comanda newComanda){
        mComandas.add(newComanda);
    }

    public float totalPrice(){

        float totalPriceComanda =0;
        for(int i=0; i< mComandas.size(); i++){

            totalPriceComanda += mComandas.get(i).getPrice();

        }

        return  totalPriceComanda;

    }

    @Override
    public String toString() {
        return getNameTable();
    }
}
