package ca.qc.cqmatane.informatique.gestionanniv;

import java.util.HashMap;

/**
 * Created by 1741262 on 2017-09-12.
 */

public class Anniv {
    protected int id;
    protected String titre;
    protected String date;
    protected String heure;
    protected String description;
    protected String url;

    //Constructeur
    public Anniv(int id, String titre, String date, String heure, String description, String url) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.heure = heure;
        this.description = description;
        this.url = url;
    }

    //Constructeur sans l'id
    public Anniv( String auteur, String date, String heure, String description, String url) {
        this.titre = auteur;
        this.date = date;
        this.heure = heure;
        this.description = description;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> exporterHashMap() {
        HashMap<String, String> anniv = new HashMap<String, String>();
        anniv.put("id_livre", String.valueOf(this.id)); // Attention
        anniv.put("titre", this.titre);
        anniv.put("date", this.date);
        anniv.put("heure", this.heure);
        anniv.put("description", this.description);
        anniv.put("url", this.url);

        return anniv;
    }

}
