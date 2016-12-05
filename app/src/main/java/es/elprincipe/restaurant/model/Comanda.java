package es.elprincipe.restaurant.model;

import java.io.Serializable;

/**
 * Created by Antonio on 4/12/16.
 */

public class Comanda implements Serializable {

    private String mPlate;
    private float mPrice;
    private String mAllergens[];

    public Comanda(String plate, float price, String[] allergens) {
        mPlate = plate;
        mPrice = price;
        mAllergens = allergens;
    }

    public float getPrice() {
        return mPrice;
    }
}
