import java.util.Scanner;

import Biblio.Biblio;
// import Biblio.Bibliotheque;
import Livre.Livre;
import Utilisateur.Utilisateur;

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

        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("Bienvenue dans la bibliothèque!");
            System.out.println("Menu:");
            System.out.println("1. Rechercher un livre");
            System.out.println("2. Gerer client");
            System.out.println("3. Enregistrer un nouveau client");
            System.out.println("4. Ajouter un livre");
            System.out.println("5. Supprimer un livre");
            System.out.println("6. Liste des livres");
            System.out.println("7. Liste des clients");
            System.out.println("8. Afficher les statistiques de la bibliothèque");
            System.out.println("9. Quitter");
            System.out.print("Choix: ");
            
            choix = sc.nextInt();
            sc.nextLine();

             switch (choix) {
                case 1:
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre à rechercher: ");
                    Bibliotheque.rechercherLivre(sc.nextLine());
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 2:
                Boolean idFind=false;
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("Cette operation vous permet de gerer un client\n . Veuillez renseigner ses informations suivant :");
                    do{
                        System.out.print("Donnez le numero d'identification du client :");
                        int id=sc.nextInt();
                        sc.nextLine();
                        for(Utilisateur utilisateur : Bibliotheque.getEmpruntsUtilisateurs().keySet()){
                            if(utilisateur.getNumeroIdentification()==id){
                                idFind=true;
                                Bibliotheque.menuClient(utilisateur);
                            }
                        }
                        if(idFind==false)
                            System.out.println("IDENTIFIANT INCORRECT.");
                    }while (!idFind);
                    break;
                case 3:
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("Cette operation vous permet d'inscrire un nouveau client\n . Veuillez renseigner ses informations suivant :");
                    System.out.print("Nom :");
                    String nom=sc.nextLine();
                    System.out.print("ID identification :");
                    Bibliotheque.ajouterUtilisateur(nom, sc.nextInt());
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 4:
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
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
                    }else
                        System.out.println("Livre d'ISBN : "+ISBN+" existe deja");
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 5:
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("Cette operation vous permet de supprimer un livre.\nVeuillez renseigner ses informations suivant :");
                    System.out.print("ISBN :");
                    System.out.println(Bibliotheque.supprimerLivre(sc.nextLine()));
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 6:
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    Bibliotheque.listeLivre();
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 7:
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    Bibliotheque.listeUtilisateur();
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 8:
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    Bibliotheque.listeUtilisateur();
                    System.out.println("Appuyez sur la touche (ENTRER) pour CONTINUER");
                    sc.nextLine();
                    break;
                case 9:
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("BYE BYE ! Appuyez sur la touche (ENTRER) pour QUITTER");
                    sc.nextLine();
                    break;   
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    
            }
     } while (choix != 9);

        sc.close();
  }
}

