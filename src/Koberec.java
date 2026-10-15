import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

public class Koberec {
    private static final String K_ID = "id";
    private static final String K_NAZEV = "nazev";
    private static final String K_NOSNOST = "nosnost";
    private static final String K_AKTIVNI = "aktivni";
    private static final String K_VYBAVA = "výbava";

    private final JSONObject json;


    public Koberec(JSONObject json) {
        this.json = json;
    }

    public int getId() throws JSONException {return json.getInt(K_ID);}
    public String getNazev() throws JSONException {return json.getString(K_NAZEV);}
    public int getNosnost() throws JSONException {return json.getInt(K_NOSNOST);}
    public Boolean isAktivni () throws JSONException {return json.getBoolean(K_AKTIVNI);}

    public void deaktivuj()  throws JSONException {
     json.put(K_AKTIVNI,false);
    }


    public boolean maVybavu(String polozka) throws JSONException {
        JSONArray vibavy = json.getJSONArray("vybava");
        for(int i = 0; i < vibavy.length(); i++) {
            if(vibavy.getString(i).equals(polozka)) return true;
        }
        return false;
    }

    public boolean jeVhodny(int hmotnost)  throws JSONException {
    return isAktivni() && maVybavu("kompas") && getNosnost() >= hmotnost;
    }

    @Override
    public String toString() {
        try {
            return "ID: " + getId() + ", název: " + getNazev() + ", nosnost: " + getNosnost() + ", dostupný: " +(isAktivni() ? "ano" : "ne");
        }  catch (JSONException e) {
            return "Nepltany koberec" + e.getMessage();
        }
    }



}
