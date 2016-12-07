package es.elprincipe.restaurant.model;

import java.util.LinkedList;

/**
 * Created by Antonio on 6/12/16.
 */

public class Plates {

    private LinkedList<Comanda> mComandas;

    public Plates(LinkedList<Comanda> comandas) {
        mComandas = comandas;
    }
}
