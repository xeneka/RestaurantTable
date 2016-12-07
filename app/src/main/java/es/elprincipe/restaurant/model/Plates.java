package es.elprincipe.restaurant.model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Antonio on 6/12/16.
 */

public class Plates implements Serializable{

    private LinkedList<Comanda> mComandas;

    public Plates(LinkedList<Comanda> comandas) {
        mComandas = comandas;
    }
}
