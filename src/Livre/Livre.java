package Livre;

public class Livre {

    //declarons les attributs d'abord
    private String titre;
    private String auteur;
    private int anneePublication;
    private String ISBN;
    private boolean estEmprunte=false;

    // Constructeur pour initialiser les attributs
    public Livre(String titre, String auteur, int anneePublication, String ISBN){
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.ISBN = ISBN;
    }

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

    //Pour estEmprunte
    
    public boolean getEstEmprunte(){
        return estEmprunte;
    }

    public void setEstEmprunte(boolean estEmprunte) {
        this.estEmprunte = estEmprunte;
    }

    // VERIFIE LA DISPONIBILITE DU LIVRE
    public String estDisponible(){
        if(estEmprunte)
            return String.format(" %-15s |","NON");
        else
            return String.format(" %-15s |","OUI");
    }


    //Methode toString() pour afficher en details les infos du livre
    public String toString(){
        return String.format("| %-40s | %-25s | %-10d | %-15s |", titre, auteur, anneePublication, ISBN);
    }
    


}
