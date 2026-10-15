import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class SouborovyManazer {


    public static JSONObject nactiJSON(String soubor) throws JSONException, IOException {
        String obsah = Files.readString(Path.of(soubor), StandardCharsets.UTF_8);
        return new JSONObject(obsah);
    }

    public static void ulozJSON(String soubor, JSONObject json) throws JSONException, IOException, JSONException {
        Files.writeString(Path.of(soubor), json.toString(2), StandardCharsets.UTF_8);
    }

    public static void  ulozZpravu(String soubor, Vyprava v, Koberec k) throws JSONException, IOException {
        String nl = System.lineSeparator();
        String text = v.getJmenaOpicek() + nl + v.getBanany() + nl + v.getHmotnost() + nl + k.getNazev() + nl + k.getId() + nl + k.getNosnost() + nl;
        Files.writeString(Path.of(soubor), text, StandardCharsets.UTF_8);
    }





}
