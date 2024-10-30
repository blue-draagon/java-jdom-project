package controleur ;

import org.jdom2.Document;
import org.jdom2.Element;

import controleur.Saisi;

import modele.java.GestionRepertoire;
import modele.java.Traitement;

public class Ajout {

	static final int     ZERO   = 0;
	static final double DZERO   = 0.0;

	public static void ajouterContact () {

		System.out.println("\n***  --  ***  Ajouter un nouveau contact  ***  --  ***");

		System.out.println("\n*****************************************************************************************");
		System.out.println("   Les elements avec *** sont obligatoire ; faites entrez pour ignorer un element !!!");
		System.out.println("***************************************************************************************** \n");

		System.out.print("\n***  Prenom    : ");
		String prenom = Saisi.prenomControle();

		System.out.print("\n***  Nom       : ");
		String nom = Saisi.nomControle();

		System.out.println("\n   favori - famille - ami - professionnel") ;
		System.out.print("\n    Categorie  : ");
		String categorie = Saisi.categorie();

		System.out.print("\n     Telephone : ");
		String telephone = Saisi.telephone();
		if (telephone.length() != ZERO) {
			telephone = Traitement.formatTelephone(telephone);
		}

		System.out.print("\n     Email     : ");
		String email = Saisi.email();

		Element test_telephone = GestionRepertoire.getContactByCorrectTelephone ( telephone );
		Element test_email     = GestionRepertoire.getContactByCorrectEmail ( email );

		if ( test_telephone != null || test_email != null ) {
			System.out.println("\n *** Echec d'enregistrement du contact ***") ;
			System.out.println("\n *** Ce telephone ou cette adresse email existe deja !!! ") ;
		} else if (telephone.length() == ZERO && email.length() == ZERO && categorie.length() == ZERO ) {

			GestionRepertoire.addContact( prenom, nom );

		} else if (telephone.length() == ZERO && categorie.length() == ZERO ) {

			GestionRepertoire.addContact( prenom, nom, DZERO , email );

		} else if (email.length() == ZERO  && categorie.length() == ZERO ) {

			GestionRepertoire.addContact( prenom, nom, ZERO, telephone );

		} else if (email.length() == ZERO  && telephone.length() == ZERO ) {

			GestionRepertoire.addContact( prenom, nom, categorie );

		} else if (email.length() == ZERO ) {

			GestionRepertoire.addContact( prenom, nom, categorie, telephone );

		} else if (telephone.length() == ZERO ) {

			GestionRepertoire.addContact( prenom, nom, categorie, ZERO, email );

		} else if (categorie.length() == ZERO ) {

			GestionRepertoire.addContact( prenom, nom, ZERO, telephone,  email );

		} else {

			GestionRepertoire.addContact( prenom, nom, categorie, telephone, email );

		}
	}

	public static void ajouterTelephone () {

		System.out.println("\n***  --  ***  Ajouter un numero de telephone  ***  --  ***");

		System.out.print("\n     Numero Contact   : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n     Numero Telephone : ");
		String numeroTelephone = Saisi.telephone();

		Element contact = GestionRepertoire.getContactById(identifiant);
		Element telephone = GestionRepertoire.getTelephone(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (telephone == null ) {
			GestionRepertoire.addTelephone(identifiant, numeroTelephone);
		} else {
			System.out.println("\n***  --  ***  Ce contact a déjà un numero de telephone ***  --  ***\n");
		}
	}

	public static void ajouterEmail () {

		System.out.println("\n***  --  ***  Ajouter une adresse email  ***  --  ***");

		System.out.print("\n     Numero Contact : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n     Adresse Email  : ");
		String adresseEmail = Saisi.email();

		Element contact = GestionRepertoire.getContactById(identifiant);
		Element email = GestionRepertoire.getEmail(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (email == null ) {
			GestionRepertoire.addEmail(identifiant, adresseEmail);
		} else {
			System.out.println("\n***  --  ***  Ce contact a déjà une adresse email ***  --  ***\n");
		}
	}


	public static void ajouterCategorie () {

		System.out.println("\n***  --  ***  Ajouter un contact dans une categorie  ***  --  ***");

		System.out.print("\n     Numero Contact : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n     Categorie      : ");
		String laCategorie = Saisi.categorie();

		Element contact   = GestionRepertoire.getContactById(identifiant);
		Element categorie = GestionRepertoire.getCategorie(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (categorie == null ) {
			GestionRepertoire.addCategorie(identifiant, laCategorie );
		} else {
			System.out.println("\n***  --  ***  Ce contact est déjà dans "+ categorie.getText() +" ***  --  ***\n");
		}
	}

}
