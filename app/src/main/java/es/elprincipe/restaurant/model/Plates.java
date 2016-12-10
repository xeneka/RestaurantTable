package es.elprincipe.restaurant.model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Antonio on 6/12/16.
 */

public class Plates implements Serializable{


    private LinkedList<Comanda> mComandas;

    private static Plates mInstance = null;

    private Plates(){

        mComandas = null;

    }

    public static Plates getInstance(){
        if(mInstance == null)
        {
            mInstance = new Plates();
        }
        return mInstance;
    }


    public void setComandas(LinkedList<Comanda> comandas) {
        mComandas = comandas;
    }

    public LinkedList<Comanda> getComandas() {
        return mComandas;
    }

    public int getNumComandas(){
        return mComandas.size();
    }

    public Comanda getComandaId(int index){
        return mComandas.get(index);
    }
}
