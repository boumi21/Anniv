package ca.qc.cqmatane.informatique.gestionanniv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VueModifierAnniv extends AppCompatActivity {Anniv anniv;
    EditText champTitre;
    EditText champDate;
    EditText champHeure;
    EditText champDescription;
    EditText champURL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_modifier_anniv);

        Bundle parametres = this.getIntent().getExtras();

        final String parametre_id_anniv = (String)parametres.get("id_anniv");
        final int id_anniv = Integer.parseInt(parametre_id_anniv);

        String parametre_titre = (String)parametres.get("titre");
        String titre = parametre_titre;

        String parametre_date = (String)parametres.get("date");
        String date = parametre_date;
        System.out.println(date);

        String parametre_heure = (String)parametres.get("heure");
        String heure = parametre_heure;

        String parametre_description = (String)parametres.get("description");
        String description = parametre_description;

        String parametre_url = (String)parametres.get("url");
        String url = parametre_url;


        Toast test = Toast.makeText(getApplicationContext(),
                "Valeur recue " + id_anniv,
                Toast.LENGTH_LONG);
        test.show();


        champTitre = (EditText)findViewById(R.id.champ_titre_modifier_anniv);
         champDate = (EditText)findViewById(R.id.champ_date_modifier_anniv);
         champHeure = (EditText)findViewById(R.id.champ_heure_modifier_anniv);
         champDescription = (EditText)findViewById(R.id.champ_description_modifier_anniv);
         champURL = (EditText)findViewById(R.id.champ_url_modifier_anniv);
        Button bouton = (Button) findViewById(R.id.action_modifier_anniv);

        champTitre.setText(titre);
        champDate.setText(date);
        champHeure.setText(heure);
        champDescription.setText(description);
        champURL.setText(url);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titre = champTitre.getText().toString();
                String date = champDate.getText().toString();
                String heure = champHeure.getText().toString();
                String description = champDescription.getText().toString();
                String url = champURL.getText().toString();

                Intent intentionNaviguerVueAnniv = new Intent(
                        VueModifierAnniv.this, VueAnniv.class
                );
                intentionNaviguerVueAnniv.putExtra("id_anniv", parametre_id_anniv);
                intentionNaviguerVueAnniv.putExtra("titre", titre);
                intentionNaviguerVueAnniv.putExtra("date", date);
                intentionNaviguerVueAnniv.putExtra("heure", heure);
                intentionNaviguerVueAnniv.putExtra("description", description);
                intentionNaviguerVueAnniv.putExtra("url", url);

                setResult( 1, intentionNaviguerVueAnniv);
                naviguerRetourAnniv();


            }
        });




    }

    public void modifierAnniv(View vue) {
        anniv.setTitre(champTitre.getText().toString());
        anniv.setDate(champDate.getText().toString());
        anniv.setHeure(champHeure.getText().toString());
        anniv.setDescription(champDescription.getText().toString());
        anniv.setUrl(champURL.getText().toString());
        naviguerRetourAnniv();
    }

    public void naviguerRetourAnniv() {
        this.finish();
    }
}
