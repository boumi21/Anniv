package ca.qc.cqmatane.informatique.gestionanniv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VueAnniv extends AppCompatActivity {

    protected List<HashMap<String, String>> listeAnniv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_anniv);
        ListView listeAnnivVue = (ListView)findViewById(R.id.vue_liste_anniv);
        listeAnniv = prepareListeAnniv();

        // Connecter la vue avec la structure de donnees
        SimpleAdapter adapteur = new SimpleAdapter(this,
                listeAnniv, // une liste d’objets formattés en HashMap
                android.R.layout.two_line_list_item, // un layout dédié à l’item de liste
                new String[] {"titre", "date", "heure", "description", "url"}, // sources des données dans chaque objet en format HashMap
                new int[] {android.R.id.text1,android.R.id.text2}); // cibles dans le layout nommé précédemment
        listeAnnivVue.setAdapter(adapteur);
    }

    public List<HashMap<String, String>> prepareListeAnniv() {
        List<HashMap<String,String>> listeAnniv = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> anniv;

        anniv = new HashMap<String, String>();
        anniv.put("titre","Premier anniv");
        anniv.put("date","20/01/2017");
        anniv.put("heure","8pm");
        anniv.put("description","Le premier de l'annee");
        anniv.put("url","http:www");
        listeAnniv.add(anniv);

        anniv = new HashMap<String, String>();
        anniv.put("titre","Le deuxieme");
        anniv.put("date","29/01/2017");
        anniv.put("heure","10pm");
        anniv.put("description","En route !");
        anniv.put("url","http:www");
        listeAnniv.add(anniv);


        anniv = new HashMap<String, String>();
        anniv.put("titre","Le dernier");
        anniv.put("date","04/02/2017");
        anniv.put("heure","9pm");
        anniv.put("description","Un dernier pour la route");
        anniv.put("url","http:www");
        listeAnniv.add(anniv);

        return  listeAnniv;
    }


}
