package Biblio;
import Livre.Livre;
import Utilisateur.Utilisateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Biblio {
    Scanner sc = new Scanner(System.in);
    private ArrayList<Livre> listeLivres;
    private HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateurs;

    public Biblio() {
        listeLivres = new ArrayList<>();
        empruntsUtilisateurs = new HashMap<>();
    }

    public HashMap<Utilisateur, ArrayList<Livre>> getEmpruntsUtilisateurs() {
        return empruntsUtilisateurs;
    }

    public ArrayList<Livre> getListeLivres() {
        return listeLivres;
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

    public void retournerLivre(Utilisateur utilisateur) {
        boolean isGood = false;
        if (!utilisateur.getListeEmpruntes().isEmpty()) {
            utilisateur.Afficherlivres();
            System.out.print(". Veuillez renseigner ses informations suivant :\nEntrez l'ISBN du livre que " + utilisateur.getNom() + " souhaite retourner parmi ses livres : ");
            String ISBN = sc.nextLine();
    
            Iterator<Livre> iterator = utilisateur.getListeEmpruntes().iterator();
            while (iterator.hasNext()) {
                Livre livre = iterator.next();
                if (livre.getISBN().equals(ISBN)) {
                    if (livre.getEstEmprunte()) {
                        isGood = true;
                        livre.setEstEmprunte(false);
                        empruntsUtilisateurs.get(utilisateur).remove(livre);
                        System.out.println("Retour réussi. Vous pouvez récupérer le livre " + livre.getTitre());
                        utilisateur.Afficherlivres();
                        listeLivre();
                        break; // Sortir de la boucle car le livre a été trouvé et retourné
                    }
                }
            }
            if (!isGood) {
                System.out.println(utilisateur.getNom() + " n'a pas emprunté ce livre.");
                retournerLivre(utilisateur);
            }
        } else {
            System.out.println(utilisateur.getNom() + " n'a pas emprunté de livre.");
        }
    }
    

    public void emprunterLivre(Utilisateur utilisateur) throws InterruptedException, IOException {
        boolean isGood=false;
        if(utilisateur.peutEmprunter()==true){
            do{

                System.out.print("\t[VERIFICATION DES LIVRES DISPONIBLES]\nEntrez le titre, l'auteur du livre que le client souhaite emprunter: ");
            }while(!rechercherLivreDispo(sc.nextLine()));
                // rechercherLivre(sc.nextLine());
                System.out.print("Entrez l'ISBN du livre à emprunter parmis ses livres disponibles: ");
                String ISBN=sc.nextLine();
                // empruntsUtilisateurs.put(utilisateur, utilisateur.getListeEmpruntes());
                for (Livre livre : listeLivres) {
                    if (livre.getISBN().equals(ISBN)) {
                        if(livre.getEstEmprunte()==false){
                            isGood=true;
                            livre.setEstEmprunte(true);
                            empruntsUtilisateurs.get(utilisateur).add(livre);
                            System.out.println("Emprunt reussie. Vous pouvez remettre a "+utilisateur.getNom()+" le livre "+livre.getTitre());}
                        // else{
                        //     System.out.println("Ce livre n'est pas disponible.");

                        // }
                    }
                }
                utilisateur.Afficherlivres();
            if (!isGood) {
                // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("Ce livre n'est pas disponible.");
                emprunterLivre(utilisateur);
            }
        }else
            System.out.println(utilisateur.getNom()+" n'est pas a jour par rapport au cotisation. Donc il ne peut pas emprunter pour l'instant.");
    }


    public Boolean ajouterLivre(String titre, String auteur, int anneePublication, String ISBN) {
        Boolean ISBNexist=false;
        for(Livre livre : listeLivres){
            if(livre.getISBN().equals(ISBN)){
                ISBNexist=true;
                break;
            }
        }
        if(ISBNexist==false){
            Livre livre = new Livre(titre, auteur, anneePublication, ISBN);
            listeLivres.add(livre);
            return true;
        }else{
            return false;
        }
    }

    public String supprimerLivre(String ISBN) {
    String ISBNconcerne = ISBN;
    // boolean auMoinsEmprunte=false;
    listeLivre();
    for (Livre livre : listeLivres) {
    if(livre.getEstEmprunte()==true){
        return "Le livre ne peut pas etre supprimer";
    }else if (livre.getISBN().equals(ISBNconcerne)) {
    listeLivres.remove(livre);
    return "Livre d'ISBN : "+ ISBN+ " a ete supprimee";
    }
    }
    return "Ce livre n'existe pas.";
    }

    // Recherche livre
    public void rechercherLivre(String critere) {
        Boolean trouve=false;
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("| TITRE                                    | AUTEUR                    | ANNEE      | ISBN            |");
        System.out.println("------------------------------------------------------------------------------------------------------");
    for (Livre livre : listeLivres) {
        if (livre.getISBN().equalsIgnoreCase(critere) || livre.getAuteur().equalsIgnoreCase(critere) || livre.getTitre().equalsIgnoreCase(critere)) {
            System.out.println(livre.toString());
            trouve=true;
        }
    }
    if(!trouve)
        System.out.println("| AUCUN LIVRE TROUVE");
        System.out.println("------------------------------------------------------------------------------------------------------");
    }

    // Recherche livre empruntable
    public Boolean rechercherLivreDispo(String critere) {
        Boolean trouve=false;
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| Liste des Livres disponible pour le motif :"+critere);
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| TITRE                                    | AUTEUR                    | ANNEE      | ISBN            | DISPONIBLE      |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    for (Livre livre : listeLivres) {
        if (livre.getISBN().equalsIgnoreCase(critere) || livre.getAuteur().equalsIgnoreCase(critere) || livre.getTitre().equalsIgnoreCase(critere)) {
            if(livre.getEstEmprunte()==false)
                System.out.println(livre.toString()+livre.estDisponible());
            trouve=true;
        }
    }
    if(!trouve)
        System.out.println("| AUCUN LIVRE TROUVE");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    return trouve;
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


    public void listeLivre(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| Liste des Livres de la Bibliotheque");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| TITRE                                    | AUTEUR                    | ANNEE      | ISBN            | DISPONIBLE      |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        
        for(Livre livre : listeLivres){
            System.out.println(livre.toString()+livre.estDisponible());
        }
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }
    
    public void menuClient(Utilisateur utilisateur) throws InterruptedException, IOException{
        int choix;
        do {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("Bienvenue dans le menu de "+ utilisateur.getNom());
            System.out.println("1. Emprunter un livre");
            System.out.println("2. Retourner un livre"); 
            System.out.println("3. Enregistrer cotisation");
            System.out.println("4. Liste de ses livres");
            System.out.println("5. Quitter");
            System.out.print("Choix: ");
            
            choix = sc.nextInt();
            sc.nextLine();

             switch (choix) {
                 case 1:
                 new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("Cette operation vous permet a "+utilisateur.getNom()+" d'emprunter un livre\n . Veuillez renseigner ses informations suivant :");
                    emprunterLivre(utilisateur);
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 2:
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("Cette operation permet a "+utilisateur.getNom()+" de retourner un livre\n");
                    retournerLivre(utilisateur);
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 3:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("Cette operation permet a " +utilisateur.getNom() + " de cotiser la somme de 1000 FCFA.");
                    System.out.print("Si vous avez recu la cotisation\n\t>>Taper [OUI] sinon Taper [NON] :");
                    if(sc.nextLine().equalsIgnoreCase("OUI")){
                        utilisateur.setCotisation(1000);
                        System.out.println(utilisateur.getNom()+" a cotisé "+utilisateur.getCotisation()+" FCFA .");
                    }else
                        System.out.println(utilisateur.getNom()+" n'a pas cotisé .");
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                break;
                case 4:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    utilisateur.Afficherlivres();
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                break;   
                case 5:
                    // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("BYE BYE ! Appuyez sur la touche (ENTRER) pour QUITTER");
                    sc.nextLine();
                break;   
                default:
                System.out.println("Choix invalide. Veuillez réessayer.");
                }
     } while (choix != 5);
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

