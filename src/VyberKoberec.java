import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class VyberKoberec {
    public static List<Koberec> najdiVhodne(List<Koberec> koberce, int hmotnost) throws JSONException {
        List<Koberec> vhodne = new ArrayList<>();
        for( Koberec k : koberce) {
            if(k.jeVhodny(hmotnost)) vhodne.add(k);
        }
        return vhodne;
    };

    public static Koberec vyberNejmensi(List<Koberec> vhodne) throws JSONException {
        Koberec nejlepsi = null;
        for( Koberec k : vhodne) {
            if (nejlepsi == null || k.getNosnost() < nejlepsi.getNosnost()) {
                nejlepsi = k;
            }
        }
        return nejlepsi;
    }



}
