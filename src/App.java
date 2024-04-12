import java.util.Scanner;

import Biblio.Biblio;
// import Biblio.Bibliotheque;
import Livre.Livre;

public class App {
    public static void main(String[] args) throws Exception {
        Biblio Bibliotheque = new Biblio();

        // INITIALISATION DE QUELQUES LIVRES
        Bibliotheque.ajouterLivre("Le Seigneur des Anneaux", "J.R.R. Tolkien", 1954, "9782070342985");
        Bibliotheque.ajouterLivre("Le Seigneur des Anneaux", "J.R.R. Tolkien", 1954, "9782070343498");
        Bibliotheque.ajouterLivre("Harry Potter à l'école des sorciers", "J.K. Rowling", 1997, "9782070643028");
        Bibliotheque.ajouterLivre("1984", "George Orwell", 1949, "9780451524935");

        // INITIALISATION DE QUELQUES UTILISATEURS
        Bibliotheque.ajouterUtilisateur("Mohamed SALL", 1);
        Bibliotheque.ajouterUtilisateur("Mohamed MBAYE", 2);
        Bibliotheque.ajouterUtilisateur("Babacar NDIAYE", 3);
        Bibliotheque.ajouterUtilisateur("Amine DIAGNE", 4);

        System.out.println("Bienvenue dans la bibliothèque!");
        int choix;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("Menu:");
            System.out.println("1. Rechercher un livre");
            System.out.println("2. Emprunter un livre");
            System.out.println("3. Retourner un livre"); 
            System.out.println("4. Enregistrer un nouveau client");
            System.out.println("5. Enregistrer cotisation client");
            System.out.println("6. Ajouter un livre");
            System.out.println("7. Supprimer un livre");
            System.out.println("8. Liste des livres");
            System.out.println("9. Afficher les statistiques de la bibliothèque");
            System.out.println("10. Quitter");
            System.out.print("Choix: ");
            
            choix = sc.nextInt();
            sc.nextLine();

             switch (choix) {
                case 1:
                    System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre à rechercher: ");
                    Bibliotheque.rechercherLivre(sc.nextLine());
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("Cette operation vous permet a un utilisateur d'emprunter un livre\n . Veuillez renseigner ses informations suivant :");
                    System.out.print("Donnez le numero d'identification du client :");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("VERIFIONS LE LIVRE.\nEntrez le titre, l'auteur ou l'ISBN du livre: ");
                    Bibliotheque.rechercherLivre(sc.nextLine());
                    System.out.print("Entrez l'ISBN du livre à emprunter: ");
                    Bibliotheque.emprunterLivre(id, sc.nextLine());
                    break;
                case 3:
                    // Demander à l'utilisateur ses informations et enregistrer le retour
                    break;
                case 4:
                    
                    break;
                case 5:
                    System.out.println("Merci d'avoir utilisé la bibliothèque. Au revoir!");
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("Cette operation vous permet d'ajouter un livre.\nVeuillez renseigner ses informations suivant :");
                    System.out.print("Titre :");
                    String titre=sc.nextLine();
                    System.out.print("Auteur :");
                    String auteur=sc.nextLine();
                    System.out.print("Annee Publication :");
                    int anneePublication=sc.nextInt();
                    sc.nextLine();
                    System.out.print("ISBN :");
                    String ISBN=sc.nextLine();
                    if(Bibliotheque.ajouterLivre(titre, auteur, anneePublication, ISBN)){
                        System.out.println("Livre d'ISBN : "+ISBN+" a ete ajoutee");
                    }
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("Cette operation vous permet de supprimer un livre.\nVeuillez renseigner ses informations suivant :");
                    System.out.print("ISBN :");
                    System.out.println(Bibliotheque.supprimerLivre(sc.nextLine()));
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 8:
                    Bibliotheque.listeLivre();
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 9:
                    Bibliotheque.listeUtilisateur();
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    
            }
     } while (choix != 10);

        sc.close();
  }
}

