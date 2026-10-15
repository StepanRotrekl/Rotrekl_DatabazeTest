import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {

            Vyprava vyprava = new Vyprava(SouborovyManazer.nactiJSON("vyprava.json"));
            System.out.println("Pocet opicek: " + vyprava.getPocetOpicek());


            System.out.println("\nVsechny koberce: ");
            for (Koberec k : vyprava.getKoberce()) {
                System.out.println(k);
            }

            Scanner sc = new Scanner(System.in);
            System.out.print("\nZadej pocet bananu(0 - 10000): ");
            int hmotnost = vyprava.spocitejHmotnost(sc.nextInt());
            System.out.println("Celkova hmotnost vypravy: " + hmotnost + " kg");

            List<Koberec> vhodne = VyberKoberec.najdiVhodne(vyprava.getKoberce(), hmotnost);
            System.out.println("\nVhodne koberce: ");
            for (Koberec k : vhodne) {
                System.out.println(k.getNazev() + " (nosnost " + k.getNosnost() + ")");
            }


            Koberec vybrany = VyberKoberec.vyberNejmensi(vhodne);
            if (vybrany == null) {
                System.out.println("Zadny vhodny koberec");
                return;
            }
            System.out.println("\nVybrany koberec: " + vybrany.getNazev());


            vyprava.zaznamenejLet(vybrany);

            SouborovyManazer.ulozJSON("vyprava_po_letu.json", vyprava.getKoren());

            SouborovyManazer.ulozZpravu("zprava.txt", vyprava, vybrany);
            System.out.println("Soubory vyprava_po_letu a zprava.txt byly vytvoreny");

        } catch (IOException e) {
            System.out.println("Chyba pri cteny zapisu souboru: " + e.getMessage());
        } catch (JSONException e) {
            System.out.println("Chyba pri zpracovani JSONu: " + e.getMessage());
        }

















    }
}
