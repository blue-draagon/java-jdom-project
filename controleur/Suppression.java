package controleur ;

import org.jdom2.Document;
import org.jdom2.Element;

import modele.java.GestionRepertoire;

public class Suppression {

	public static void supprimerContact () {

		System.out.println("\n***  --  ***  Suppression d'un contact  ***  --  ***");

		System.out.print("\n***  Numero du contact : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n***  Mot de Passe      : ");
		String motDePasse = Saisi.chaine();

		Element contact = GestionRepertoire.getContactById(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (motDePasse.equals("diallo-sene")||motDePasse.equals("sene-diallo")||motDePasse.equals("sene")||motDePasse.equals("diallo"))
		 {
			System.out.println("");
			GestionRepertoire.afficherContact( contact );

			System.out.print("\n *** Voulez vous vraiment supprimer ce contact (oui/non) : ");
			String confirme = Saisi.chaine();

			if (confirme.equals("oui")) {
				GestionRepertoire.deleteContact(identifiant);
			} else {
				System.out.println("\n****  Vous avez annule la suppression  ****\n");
			}
		} else {
			System.out.println("\n***  --  ***  Le mot de passe est incorrect  ***  --  ***\n");
		}
	}

	public static void supprimerTelephone () {

		System.out.println("\n***  --  ***  Supprimer un numero de telephone  ***  --  ***");

		System.out.print("\n***  Numero du contact : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n***  Mot de Passe      : ");
		String motDePasse = Saisi.chaine();

		Element contact = GestionRepertoire.getContactById(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (motDePasse.equals("diallo-sene")||motDePasse.equals("sene-diallo")||motDePasse.equals("sene")||motDePasse.equals("diallo"))
		 {
			System.out.println("");
			GestionRepertoire.afficherContact( contact );

			System.out.print("\n *** Voulez vous vraiment supprimer le telephone (oui/non) : ");
			String confirme = Saisi.chaine();

			if (confirme.equals("oui")) {
				GestionRepertoire.deleteTelephone(identifiant);
			} else {
				System.out.println("\n****  Vous avez annule la suppression  ****\n");
			}
		} else {
			System.out.println("\n***  --  ***  Le mot de passe est incorrect  ***  --  ***\n");
		}
	}

	public static void supprimerEmail () {

		System.out.println("\n***  --  ***  Supprimer une adresse email  ***  --  ***");

		System.out.print("\n***  Numero du contact : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n***  Mot de Passe      : ");
		String motDePasse = Saisi.chaine();

		Element contact = GestionRepertoire.getContactById(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (motDePasse.equals("diallo-sene")||motDePasse.equals("sene-diallo")||motDePasse.equals("sene")||motDePasse.equals("diallo"))
		 {
			System.out.println("");
			GestionRepertoire.afficherContact( contact );

			System.out.print("\n *** Voulez vous vraiment supprimer cet email (oui/non) : ");
			String confirme = Saisi.chaine();

			if (confirme.equals("oui")) {
				GestionRepertoire.deleteEmail(identifiant);
			} else {
				System.out.println("\n****  Vous avez annule la suppression  ****\n");
			}
		} else {
			System.out.println("\n***  --  ***  Le mot de passe est incorrect  ***  --  ***\n");
		}
	}

	public static void supprimerCategorie () {

		System.out.println("\n***  --  ***  Supprimer la categorie d'un contact  ***  --  ***");

		System.out.print("\n***  Numero du contact : ");
		String identifiant = Saisi.chaine();

		System.out.print("\n***  Mot de Passe      : ");
		String motDePasse = Saisi.chaine();

		Element contact = GestionRepertoire.getContactById(identifiant);
		if (contact == null ) {
			System.out.println("\n***  --  ***  Ce contact n'existe pas ***  --  ***\n");
		} else if (motDePasse.equals("diallo-sene")||motDePasse.equals("sene-diallo")||motDePasse.equals("sene")||motDePasse.equals("diallo"))
		 {
			System.out.println("");
			GestionRepertoire.afficherContact( contact );

			System.out.print("\n *** Voulez vous vraiment supprimer cet email (oui/non) : ");
			String confirme = Saisi.chaine();

			if (confirme.equals("oui")) {
				GestionRepertoire.deleteCategorie(identifiant);
			} else {
				System.out.println("\n****  Vous avez annule la suppression  ****\n");
			}
		} else {
			System.out.println("\n***  --  ***  Le mot de passe est incorrect  ***  --  ***\n");
		}
	}

	public static void supprimerContacts () {

		System.out.println("\n***  --  ***  Suppression de tous les contacts  ***  --  ***");

		System.out.print("\n***  Mot de Passe      : ");
		String motDePasse = Saisi.chaine();

		if (motDePasse.equals("diallo-sene")||motDePasse.equals("sene-diallo")||motDePasse.equals("sene")||motDePasse.equals("diallo")){

			System.out.print("\n *** Voulez vous vraiment supprimer tous les contact (oui/non) : ");
			String confirme = Saisi.chaine();

			if (confirme.equals("oui")) {
				GestionRepertoire.deleteContacts();
			} else {
				System.out.println("\n****  Vous avez annule la suppression  ****\n");
			}
		} else {
			System.out.println("\n***  --  ***  Le mot de passe est incorrect  ***  --  ***\n");
		}
	}
}