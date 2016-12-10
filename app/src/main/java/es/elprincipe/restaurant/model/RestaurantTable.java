package es.elprincipe.restaurant.model;

import android.util.Log;

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
        mComandas = new LinkedList<Comanda>();
        mIdTable = idTable;

    }

    public String getNameTable() {
        return mNameTable;
    }

    public void addComanda(Comanda newComanda){
        if(newComanda != null) {
            mComandas.add(newComanda);
        }
    }

    public int getIdTable(){
        return mIdTable;
    }

    public float totalPrice(){

        float totalPriceComanda =0;
        for(int i=0; i< mComandas.size(); i++){

            totalPriceComanda += mComandas.get(i).getPrice();

        }

        return  totalPriceComanda;

    }

    public int getNumComandas(){


        if (mComandas == null){
            Log.v(getClass().getName(), "NULO");
            return 0;
        }

            return mComandas.size();

    }

    public Comanda getComandaId(int position){
        return mComandas.get(position);
    }

    @Override
    public String toString() {
        return getNameTable();
    }
}
