package Livre;

public class Livre {

    //declarons les attributs d'abord
    private String titre;
    private String auteur;
    private int anneePublication;
    private String ISBN;

    // Constructeur pour initialiser les attributs
    public Livre(String titre, String auteur, int anneePublication, String ISBN){
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.ISBN = ISBN;
    }
    //---------------------------------------
    //Parties des getters er setters        |
    //---------------------------------------

    //Pour le titre
    public String getTitre(){
        return titre;
    }
    public void setTitre(String titre){
        this.titre=titre;
    }
    
}
