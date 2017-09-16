package ca.qc.cqmatane.informatique.gestionanniv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VueAnniv extends AppCompatActivity {



    protected List<HashMap<String, String>> listeAnniv;
    protected ListView vueListeAnniv;
    static final public int ACTIVITE_MODIFIER_ANNIV = 1;
    static final public int ACTIVITE_AJOUTER_ANNIV = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_anniv);
        vueListeAnniv = (ListView)findViewById(R.id.vue_liste_anniv);

        listeAnniv = prepareListeAnniv();

        // Connecter la vue avec la structure de donnees
        SimpleAdapter adapteur = new SimpleAdapter(this,
                listeAnniv, // une liste d’objets formattés en HashMap
                android.R.layout.two_line_list_item, // un layout dédié à l’item de liste
                new String[] {"titre", "date", "heure", "description", "url"}, // sources des données dans chaque objet en format HashMap
                new int[] {android.R.id.text1,android.R.id.text2}); // cibles dans le layout nommé précédemment
        vueListeAnniv.setAdapter(adapteur);

        vueListeAnniv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View vue, int positionDansAdaptateur, long positionItem) {
                        ListView vueListeAnniv = (ListView)vue.getParent();

                        @SuppressWarnings("unchecked")
                        HashMap<String, String> anniv = (HashMap<String, String>) vueListeAnniv.getItemAtPosition((int)positionItem);
                        /*Toast message = Toast.makeText(getApplicationContext(),
                                "Position " + positionItem + " titre" + anniv.get("titre") + " date" + anniv.get("date"),
                                Toast.LENGTH_SHORT);
                        message.show();*/


                        Intent intentionNaviguerModifierAnniv = new Intent(
                                VueAnniv.this, VueModifierAnniv.class
                        );
                        intentionNaviguerModifierAnniv.putExtra("id_anniv", anniv.get("id_anniv"));
                        intentionNaviguerModifierAnniv.putExtra("titre", anniv.get("titre"));
                        intentionNaviguerModifierAnniv.putExtra("date", anniv.get("date"));
                        intentionNaviguerModifierAnniv.putExtra("heure", anniv.get("heure"));
                        intentionNaviguerModifierAnniv.putExtra("description", anniv.get("description"));
                        intentionNaviguerModifierAnniv.putExtra("url", anniv.get("url"));

                         //startActivity(intentionNaviguerModifierAnniv);
                        startActivityForResult(intentionNaviguerModifierAnniv, ACTIVITE_MODIFIER_ANNIV);

                    }
                }
        );
        afficherTousLesAnniv();
    }

    protected void onActivityResult (int activite, int resultat, Intent donnees) {
        Bundle parametres = donnees.getExtras();
        switch(activite) {
            case ACTIVITE_MODIFIER_ANNIV:
                String parametre_id_anniv = (String)parametres.get("id_anniv");
                final int id_anniv = Integer.parseInt(parametre_id_anniv);

                String parametre_titre = (String)parametres.get("titre");
                String titre = parametre_titre;
                System.out.println(titre);

                String parametre_date = (String)parametres.get("date");
                String date = parametre_date;
                System.out.println(date);

                String parametre_heure = (String)parametres.get("heure");
                String heure = parametre_heure;

                String parametre_description = (String)parametres.get("description");
                String description = parametre_description;

                String parametre_url = (String)parametres.get("url");
                String url = parametre_url;

                for (HashMap<String,String> liste:listeAnniv) {
                    if (id_anniv == Integer.parseInt(liste.get("id_anniv"))) {

                        liste.put("titre", parametre_titre);
                        liste.put("date", parametre_date);
                        liste.put("heure", parametre_heure);
                        liste.put("description", parametre_description);
                        liste.put("url", parametre_url);
                    }
                }




                break;
            case ACTIVITE_AJOUTER_ANNIV:
                break;
        }
        afficherTousLesAnniv();
    }

    public void afficherTousLesAnniv() {


        SimpleAdapter adapteur = new SimpleAdapter(this,
                listeAnniv, // une liste d’objets formattés en HashMap
                android.R.layout.two_line_list_item, // un layout dédié à l’item de liste
                new String[] {"titre", "date", "heure", "description", "url"}, // sources des données dans chaque objet en format HashMap
                new int[] {android.R.id.text1,android.R.id.text2}); // cibles dans le layout nommé précédemment
        vueListeAnniv.setAdapter(adapteur);
    }

    public List<HashMap<String, String>> prepareListeAnniv() {
        List<HashMap<String,String>> listeAnniv = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> anniv;

        anniv = new HashMap<String, String>();
        anniv.put("id_anniv","1");
        anniv.put("titre","Premier anniv");
        anniv.put("date","20/01/2017");
        anniv.put("heure","8pm");
        anniv.put("description","Yolo");
        anniv.put("url","http:www");
        listeAnniv.add(anniv);

        anniv = new HashMap<String, String>();
        anniv.put("id_anniv","2");
        anniv.put("titre","Le deuxieme");
        anniv.put("date","29/01/2017");
        anniv.put("heure","10pm");
        anniv.put("description","En route !");
        anniv.put("url","http:www");
        listeAnniv.add(anniv);


        anniv = new HashMap<String, String>();
        anniv.put("id_anniv","3");
        anniv.put("titre","Le dernier");
        anniv.put("date","04/02/2017");
        anniv.put("heure","9pm");
        anniv.put("description","Un dernier pour la route");
        anniv.put("url","http:www");
        listeAnniv.add(anniv);

        return  listeAnniv;
    }


}
