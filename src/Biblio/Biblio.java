package Biblio;
import Livre.Livre;
import Utilisateur.Utilisateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Biblio {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Livre> listeLivres;
    private HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs;

    public Biblio() {
        listeLivres = new ArrayList<>();
        empruntsUtilisateurs = new HashMap<>();
    }

    public void ajouterUtilisateur(String nom,int numeroIdentification) {
        Utilisateur utilisateur=new Utilisateur(nom, numeroIdentification);
        if (!empruntsUtilisateurs.containsKey(utilisateur)) {
            empruntsUtilisateurs.put(utilisateur, utilisateur.getListeEmpruntes());
            System.out.println("Utilisateur ajouté : " + utilisateur.getNom());
        } else {
            System.out.println("L'utilisateur existe déjà.");
        }
    }

    public void listeUtilisateur(){
        System.out.println("Liste des utilisateurs :");
        for (Utilisateur utilisateur : empruntsUtilisateurs.keySet()) {
            System.out.println(utilisateur.getNom());
        }
    }

    public void emprunterLivre(int id, String ISBN) {

        for (Utilisateur utilisateur : empruntsUtilisateurs.keySet()) {
            if (utilisateur.getNumeroIdentification()==id) {
                utilisateur.Afficherlivres();
                // empruntsUtilisateurs.put(utilisateur, utilisateur.getListeEmpruntes());
                for (Livre livre : listeLivres) {
                    if (livre.getISBN().equals(ISBN)) {
                    empruntsUtilisateurs.get(utilisateur).add(livre);
                    }
                }
                utilisateur.Afficherlivres();
            }
        }
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
        System.out.println("| AUCUN LIVRE TROUVE");
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
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("| Liste des Livres de la Bibliotheque");
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

