import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Vyprava {

    private static final int HMOTNOST_OPICKY = 15;
    private static final int HMOTNOST_BANANU = 1;

    private final JSONObject koren;
    private final JSONArray opicky;
    private final List<Koberec> koberce = new ArrayList<>();

    private int banany;
    private int hmotnost;

    public Vyprava(JSONObject koren) {
        this.koren = koren;
        opicky = koren.getJSONArray("opicky");
        JSONArray pole = koren.getJSONArray("koberce");
        for(int i = 0; i < pole.length(); i++) {
            koberce.add(new Koberec(pole.getJSONObject(i)));
        }
    }

    public JSONObject getKoren() { return koren; }
    public List<Koberec> getKoberce() { return koberce; }
    public int getBanany() { return banany; }
    public int getHmotnost() { return hmotnost; }
    public int getPocetOpicek()  { return opicky.length(); }

    public String getJmenaOpicek() throws JSONException {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < opicky.length(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(opicky.getString(i));
        }
        return sb.toString();
    }

    public int spocitejHmotnost(int PocetBananu) {
        this.banany = PocetBananu;
        this.hmotnost =  getPocetOpicek() * HMOTNOST_OPICKY + PocetBananu * HMOTNOST_BANANU;
        return hmotnost;
    }

    public void zaznamenejLet(Koberec vybrany) throws JSONException {
        vybrany.deaktivuj();

        JSONObject let = new JSONObject();
        let.put("koberecId", vybrany.getId());
        let.put("pocetOpicek",  getPocetOpicek());
        let.put("banany",  getBanany());
        let.put("hmotnost",  getHmotnost());
        koren.put("osudovyLet", let);

    }






}
