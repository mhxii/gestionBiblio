package Utilisateur;

import java.util.ArrayList;

import Livre.Livre;

public class Utilisateur {

    //Déclaration des attributs de la classe utilisateur
    private String nom;
    private int numeroIdentification;
    private ArrayList<Livre> livresempruntes;

    //Declarationdes methodes 

    //Declarations des constructeur pour initialiser les attributs


     public Utilisateur(String nom, int numeroIdentification){


        this.nom= nom;
        this.numeroIdentification= numeroIdentification;
    }


    //Declaration des getters et setters  du fait que les attibuts de la classe sont  à private

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws IllegalArgumentException {
        // Vérification si le nom ne contient que des lettres 
        if (!nom.matches("[a-zA-Z]+")) {       // sur cette ligne  [a-zA-Z]+ signiifie que nom contient seulement des lesttres miniscules et maniscules
            throw new IllegalArgumentException("Le nom ne peut contenir que des lettres.");
        }
        this.nom = nom;
    }

    public int getNumeroIdentification() {

    return numeroIdentification;
    }
    
    //methode pour emprunté unn livre 


    public void EmprunterLivre(Livre livre ){

        this.livresempruntes.add(livre);

    }
    //methode pour retourner un livre

    public void SupprimerLivres(Livre livre) {
        this.livresempruntes.remove(args)
    }

    }








   



