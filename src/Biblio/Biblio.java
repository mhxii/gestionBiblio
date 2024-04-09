package Biblio;

import Utilisateur.Utilisateur;
import Livre.Livre;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Biblio {
    Scanner sc = new Scanner(System.in);
    ArrayList<Livre> listeLivres = new ArrayList<>();
    HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs = new HashMap<>();

    public void AjouterLivre(String titre, String auteur, int anneePublication, String ISBN) {
        Livre livre = new Livre(titre, auteur, anneePublication, ISBN);
        listeLivres.add(livre);
    }

    public String SupprimerLivre(String ISBN) {
    String ISBNconcerne = ISBN;
    for (Livre livre : listeLivres) {
    if (livre.getISBN().equals(ISBNconcerne)) {
    listeLivres.remove(livre);
    return "Ce livre a été supprimé";
    }
    }
    return "Ce livre n'est pas présent";
    }

    public String RechercherLivre(String ISBN) {
   String ISBNconcerne = ISBN;
    for (Livre livre : listeLivres) {
            if (livre.getISBN().equals(ISBNconcerne)) {
     return "Livre:" + livre.getTitre() + "\nAuteur:" + livre.getAuteur() + "\nAnnée de publication:"  + livre.getAnneePublication() + "\nISBN:" + livre.getISBN();
   }
    }
        return "Ce livre n'est pas présent";
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

    public void afficherStatistiquesBibliotheque() {
        int nombreTotalLivres = listeLivres.size();
        int nombreTotalExemplaires = 0;
        for (Livre livre : listeLivres) {
            nombreTotalExemplaires += livre.getNombreExemplaires();
        }
        System.out.println("Statistiques de la bibliothèque :");
        System.out.println("- Nombre total de livres : " + nombreTotalLivres);
        System.out.println("- Nombre total d'exemplaires empruntés : " + nombreTotalExemplaires);
    }

}
