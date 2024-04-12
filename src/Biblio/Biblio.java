package Biblio;
import Livre.Livre;
import Utilisateur.Utilisateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Biblio {
    Scanner sc = new Scanner(System.in);
    ArrayList<Livre> listeLivres;
    HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs;

    public Biblio() {
        listeLivres = new ArrayList<>();
        empruntsUtilisateurs = new HashMap<>();
    }

    public Boolean ajouterLivre(String titre, String auteur, int anneePublication, String ISBN) {
        Livre livre = new Livre(titre, auteur, anneePublication, ISBN);
        listeLivres.add(livre);
        return true;
    }

    public String supprimerLivre(String ISBN) {
    String ISBNconcerne = ISBN;
    for (Livre livre : listeLivres) {
    if (livre.getISBN().equals(ISBNconcerne)) {
    listeLivres.remove(livre);
    return "Livre d'ISBN : "+ ISBN+ " a ete supprimee";
    }
    }
    return "Ce livre n'existe pas.";
    }

    public void rechercherLivre(String critere) {
        Boolean trouve=false;
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("| Titre                                    | Auteur                    | Année      | ISBN            |");
        System.out.println("------------------------------------------------------------------------------------------------------");
    for (Livre livre : listeLivres) {
        if (livre.getISBN().equals(critere) || livre.getAuteur().equals(critere) || livre.getTitre().equals(critere)) {
            System.out.println(livre.toString());
            trouve=true;
        }
    }
    if(!trouve)
        System.out.println("| AUCUN LIVRE TROUVE.");
    System.out.println("------------------------------------------------------------------------------------------------------");
    }

    public String enregistrerLivre(Utilisateur utilisateur, Livre livre) {
    String ISBNconcerne = livre.getISBN();
    for (Livre livreExistant : listeLivres) {
    if (livreExistant.getISBN().equals(ISBNconcerne)) {
    ArrayList<Livre> emprunts = empruntsUtilisateurs.get(utilisateur);
    if (emprunts == null) {
    emprunts = new ArrayList<>();
    empruntsUtilisateurs.put(utilisateur, emprunts);
                }
    emprunts.add(livreExistant);
    return "Livre enregistré";
    }
        }
        return "Ce livre est déjà emprunté";
    }

    public String retournerLivre(Utilisateur utilisateur, Livre livre) {
        if (empruntsUtilisateurs.containsKey(utilisateur)) {
        ArrayList<Livre> emprunts = empruntsUtilisateurs.get(utilisateur);
      if (emprunts.contains(livre)) {
        emprunts.remove(livre);
    return "Livre retourné avec succès.";
            } else {
    return "Cet utilisateur n'a pas emprunté ce livre.";
            }
        } else {
    return "Cet utilisateur n'a aucun emprunt enregistré.";
        }
    }

    public void listeLivre(){
        System.out.println("Liste des Livres");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("| Titre                                    | Auteur                    | Année      | ISBN            |");
        System.out.println("------------------------------------------------------------------------------------------------------");
        
        for(Livre livre : listeLivres){
            System.out.println(livre.toString());
        }
        
        System.out.println("------------------------------------------------------------------------------------------------------");
    }
    
    

    // public void afficherStatistiquesBibliotheque() {
    //     int nombreTotalLivres = listeLivres.size();
    //     int nombreTotalExemplaires = 0;
    //     for (Livre livre : listeLivres) {
    //         nombreTotalExemplaires += livre.getNombreExemplaires();
    //     }
    //     System.out.println("Statistiques de la bibliothèque :");
    //     System.out.println("- Nombre total de livres : " + nombreTotalLivres);
    //     System.out.println("- Nombre total d'exemplaires empruntés : " + nombreTotalExemplaires);
    // }

}

