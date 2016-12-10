package es.elprincipe.restaurant.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Antonio on 4/12/16.
 */

public class Comanda implements Serializable {

    private String mPlate;
    private Double mPrice;
    private ArrayList<String> mAllergens;
    private String mComment;

    public Comanda(String plate, Double price, ArrayList<String> allergens) {
        mPlate = plate;
        mPrice = price;
        mAllergens = allergens;
        mComment = "";
    }

    public Double getPrice() {
        return mPrice;
    }

    public String getPlate() {
        return mPlate;
    }

    public void setComment(String comment) {
        mComment = comment;
    }

    public ArrayList<String> getAllergens() {

        return mAllergens;
    }
}
