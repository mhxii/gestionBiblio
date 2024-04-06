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
    //    Parties des getters er setters    |
    //---------------------------------------

    //Pour le titre
    public String getTitre(){
        return titre;
    }
    public void setTitre(String titre){
        this.titre=titre;
    }

    //Pour l'auteur
    public String getAuteur(){
        return auteur;
    }    
    public void setAuteur(String auteur){
        this.auteur=auteur;
    }

    //Pour annee publication
    public int getAnneePublication(){
        return anneePublication;
    }
    public void setAnneePublication(int anneePublication){
        this.anneePublication=anneePublication;
    }

    //Pour ISBN
    public String getISBN(){
        return ISBN;
    }
    public void setISBN(String ISBN){
        this.ISBN=ISBN;
    }

    //---------------------------------------
    // FIN des parties de getters et setters |
    //---------------------------------------

    //Methode toString() pour afficher en details les infos du livre
    public String toString(){
        return "Infos du livre: \n"+ "Titre: " +titre+ ", "+ "Auteur: "+auteur+", "+ "Annee de publication: "+anneePublication+", "+"ISBN: "+ISBN+".";

    }


}
