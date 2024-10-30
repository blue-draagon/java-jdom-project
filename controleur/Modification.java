package controleur ;

import org.jdom2.Document;
import org.jdom2.Element;

import controleur.Saisi;

import modele.java.GestionRepertoire;

public class Modification {

	static final int     ZERO   = 0;

	public static void modifierNom () {

		System.out.println("\n***  --  ***  Modifier le nom  ***  --  ***");

		System.out.print("\n***  Numero du contact : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n***  Nouveau Nom       : ");
		String leNom = Saisi.nom();

		Element contact = GestionRepertoire.getContactById(identifiant);
		Element nom  = GestionRepertoire.getNom(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (nom != null ) {
			GestionRepertoire.changeNom(identifiant, leNom);
		} else {
			System.out.println("\n***  --  ***  Erreur ce contact n'a pas de nom ***  --  ***\n");
		}
	}

	public static void modifierPrenom () {

		System.out.println("\n***  --  ***  Modifier le prenom  ***  --  ***");

		System.out.print("\n***  Numero du contact : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n***  Nouveau Prenom    : ");
		String lePrenom = Saisi.prenom();

		Element contact = GestionRepertoire.getContactById(identifiant);
		Element prenom  = GestionRepertoire.getPrenom(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (prenom != null ) {
			GestionRepertoire.changePrenom(identifiant, lePrenom);
		} else {
			System.out.println("\n***  --  ***  Erreur ce contact n'a pas de prenom ***  --  ***\n");
		}
	}

	public static void modifierTelephone () {

		System.out.println("\n***  --  ***  Modifier le telephone  ***  --  ***");

		System.out.print("\n***  Numero du contact           : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n***  Nouveau Numero de Telephone : ");
		String numeroTelephone = Saisi.telephone();

		Element contact = GestionRepertoire.getContactById(identifiant);
		Element telephone  = GestionRepertoire.getTelephone(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (telephone != null ) {
			GestionRepertoire.changeTelephone(identifiant, numeroTelephone);
		} else {
			System.out.println("\n***  --  ***  Erreur ce contact n'a pas de nom ***  --  ***\n");
		}
	}

	public static void modifierEmail () {

		System.out.println("\n***  --  ***  Modifier l'email  ***  --  ***");

		System.out.print("\n***  Numero du contact      : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n***  Nouvelle Adresse Email : ");
		String adresseEmail = Saisi.email();

		Element contact = GestionRepertoire.getContactById(identifiant);
		Element email  = GestionRepertoire.getEmail(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (email != null ) {
			GestionRepertoire.changeEmail(identifiant, adresseEmail);
		} else {
			System.out.println("\n***  --  ***  Erreur ce contact n'a pas d'email ***  --  ***\n");
		}
	}

	public static void modifierCategorie () {

		System.out.println("\n***  --  ***  Modifier Categorie  ***  --  ***");

		System.out.print("\n***  Numero du contact      : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n***  Nouvelle Categorie     : ");
		String laCategorie = Saisi.categorie();

		Element contact   = GestionRepertoire.getContactById(identifiant);
		Element categorie = GestionRepertoire.getCategorie(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (categorie != null ) {
			GestionRepertoire.changeCategorie(identifiant, laCategorie);
		} else {
			System.out.println("\n***  --  ***  Erreur ce contact n'est dans aucune categorie ***  --  ***\n");
		}
	}

	public static void modifierContact () {

		System.out.println("\n***  --  ***  Modifier plusieurs elements  ***  --  ***");

		System.out.println("\n*****************************************************************************************");
		System.out.println("                       Tapez Entrer pour ignorer un element !!!");
		System.out.println("*****************************************************************************************\n");


		boolean modifierTout = true;

		System.out.print("\n***  Numero du contact  : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n***  Nouveau Prenom     : ");
		String lePrenom = Saisi.prenom();

		if (lePrenom.length() == ZERO ) { modifierTout = false; }

		System.out.print("\n***  Nouveau Nom        : ");
		String leNom = Saisi.nom();

		if (leNom.length() == ZERO ) { modifierTout = false; }

		System.out.print("\n***  Nouveau Telephone  : ");
		String numeroTelephone = Saisi.telephone();

		if (numeroTelephone.length() == ZERO ) { modifierTout = false; }

		System.out.print("\n***  Nouveau Email      : ");
		String adresseEmail = Saisi.email();

		if (adresseEmail.length() == ZERO ) { modifierTout = false; }

		System.out.print("\n***  Nouvelle Categorie : ");
		String newCategorie = Saisi.categorie();

		if (newCategorie.length() == ZERO ) { modifierTout = false; }

		Element contact = GestionRepertoire.getContactById(identifiant);

		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (modifierTout ) {
			GestionRepertoire.changeContact(identifiant, lePrenom, leNom, newCategorie, numeroTelephone, adresseEmail);
		} else {
			if (leNom.length()           != ZERO ) { GestionRepertoire.changeNom(identifiant, leNom); }
		  	if (lePrenom.length()        != ZERO ) { GestionRepertoire.changePrenom(identifiant, lePrenom); }
		  	if (newCategorie.length()    != ZERO ) { GestionRepertoire.changeCategorie(identifiant, newCategorie); }
		  	if (numeroTelephone.length() != ZERO ) { GestionRepertoire.changeTelephone(identifiant, numeroTelephone); }
		  	if (adresseEmail.length()    != ZERO ) { GestionRepertoire.changeEmail(identifiant, adresseEmail); }
			if ( leNom.length()==ZERO && lePrenom.length()==ZERO && numeroTelephone.length()==ZERO && adresseEmail.length()==ZERO )
				System.out.println("\n***  --  ***  Erreur lors de la modification du contact ***  --  ***\n");
		}
	}
}
