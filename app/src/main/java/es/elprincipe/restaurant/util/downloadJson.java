package es.elprincipe.restaurant.util;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ViewSwitcher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import es.elprincipe.restaurant.model.Comanda;
import es.elprincipe.restaurant.model.Plates;

/**
 * Created by Antonio on 6/12/16.
 */

public class DownloadJson extends AsyncTask<URL,Integer, LinkedList<Comanda> > {

    protected  ViewSwitcher mViewSwitcher;

    @Override
    protected LinkedList<Comanda> doInBackground(URL... urls) {

        LinkedList<Comanda> comandas= new LinkedList<Comanda>();
        InputStream input = null;
        Plates mplates = null;

        try{
            HttpURLConnection con = (HttpURLConnection) urls[0].openConnection();
            con.connect();
            int responseLength = con.getContentLength();
            byte data[] = new byte[1024];
            long currentBytes = 0;
            int downloadedBytes;
            input = con.getInputStream();
            StringBuilder sb = new StringBuilder();
            while ((downloadedBytes = input.read(data)) != -1 && !isCancelled()) {
                sb.append(new String(data, 0, downloadedBytes));

                publishProgress((int)(currentBytes * 100) / responseLength);
            }

            if (isCancelled()) {
                // Ya veré yo lo que hago si me han cancelado la petición
                return null;
            }

            // Analizamos los datos para convertirlos de JSON a algo que podamos manejar en código

            JSONObject jsonRoot = new JSONObject(sb.toString());


            for(Iterator iterator = jsonRoot.keys(); iterator.hasNext();) {

                Log.v(getClass().getName(),"Bucle");
                String key = (String) iterator.next();
                System.out.println(key);
                System.out.println(jsonRoot.get(key));
                String namePlate = key;
                JSONObject plateInfo = new JSONObject(jsonRoot.get(key).toString());
                Log.v(getClass().getName(), plateInfo.toString());
                Double pricePlate = plateInfo.getDouble("precio");
                JSONArray alergenos = new JSONArray();
                try {
                    alergenos = plateInfo.getJSONArray("alergenos");
                }catch (Exception e){
                    Log.v(getClass().getName(),"Warning Alergenos no informados");
                }
                ArrayList<String> allergenos = JSONArrayToArray(alergenos);


                Comanda comanda = new Comanda(namePlate,pricePlate,allergenos);
                comandas.add(comanda);
                Log.v(getClass().getName(), "download");




            }

            Thread.sleep(1000);
        }catch (Exception e){
            Log.v("Utils", e.getMessage());
        }



        Plates plate = Plates.getInstance();
        plate.setComandas(comandas);
        //mplates = new Plates(comandas);

        return comandas;
    }

    public DownloadJson() {
        super();
    }
    public DownloadJson(ViewSwitcher switcher) {
        super();
        if (switcher !=null){
            mViewSwitcher = switcher;


            switcher.setDisplayedChild(0);
        } else{
            Log.v("D","Nulo**************");
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.v("DOW","inicio");
        mViewSwitcher.setDisplayedChild(0);
    }

    @Override
    protected void onPostExecute(LinkedList<Comanda> plates) {
        super.onPostExecute(plates);

        /*try {
            Thread.sleep(14000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/




        mViewSwitcher.setDisplayedChild(1);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(LinkedList<Comanda> plates) {
        super.onCancelled(plates);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    private ArrayList<String> JSONArrayToArray(JSONArray jsonArray){

        ArrayList<String> list = new ArrayList<String>();

        if (jsonArray != null) {

            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    list.add(jsonArray.get(i).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }
        return  list;
    }

}
