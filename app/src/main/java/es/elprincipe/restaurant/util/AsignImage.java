package es.elprincipe.restaurant.util;

import es.elprincipe.restaurant.R;

/**
 * Created by Antonio on 10/12/16.
 */

public final class AsignImage {

    public static int plateImage(String image){

        int resourceImage;
        switch (image){

            case "Chuleton":
                resourceImage = R.drawable.chuleton;
                break;
            case "Ensalada":
                resourceImage = R.drawable.ensalada;
                break;
            default:
                resourceImage = R.drawable.restaurant;
                break;

        }

        return resourceImage;

    }

}
