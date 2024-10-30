
package controleur ;

import org.jdom2.Document;
import org.jdom2.Element;

import java.util.List;
import java.util.ArrayList;

import controleur.Saisi;

import modele.java.GestionRepertoire;

public class Affichage {

	static final int ZERO   = 0;
	static final int UN     = 1;
	static final int DEUX   = 2;
	static final int TROIS  = 3;
	static final int QUATRE = 4;

	static final String FAVORI       = "favori" ;
	static final String FAMILLE      = "famille" ;
	static final String AMI          = "ami" ;
	static final String PROFESSIONEL = "professionnel" ;

	public static void afficherContacts () {
		List<Element> resultat = GestionRepertoire.getContactByNom( "" );

		if (resultat.size() == ZERO ) {
			System.out.println("\n***  --  ***  lE REPERTOIRE EST VIDE  ***  --  ***");
		} else {
			System.out.println("\n***  --  ***  LISTE DES CONTACTS  ***  --  ***\n");
			GestionRepertoire.afficherListContacts( resultat );
		}
	}

	public static void rechercheParNumero () {

		System.out.println("\n***  --  ***  Recherche par identifiant  ***  --  ***");
		System.out.print("\n***  Numero du contact : ");
		String numero = Saisi.chaine();

		Element resultat = GestionRepertoire.getContactById( numero );

		if (resultat == null ) {
			System.out.println("\n***  --  ***  AUCUN CONTACT AVEC CETTE IDENTIFIANT  ***  --  ***");
		} else {
			GestionRepertoire.afficherContact( resultat );
		}
	}

	public static void rechercheParNom () {

		System.out.println("\n***  --  ***  Recherche par nom  ***  --  ***");
		System.out.print("\n***  Nom du contact : ");
		String nom = Saisi.nom();

		List<Element> resultat = GestionRepertoire.getContactByNom( nom );

		if (resultat.size() == ZERO ) {
			System.out.println("\n***  --  ***  AUCUN CONTACT DE CE NOM  ***  --  ***");
		} else {
			System.out.println("");
			GestionRepertoire.afficherListContacts( resultat );
		}
	}

	public static void rechercheParPrenom () {

		System.out.println("\n***  --  ***  Recherche par prenom  ***  --  ***");
		System.out.print("\n***  Prenom du contact : ");
		String prenom = Saisi.prenom();

		List<Element> resultat = GestionRepertoire.getContactByPrenom( prenom );

		if (resultat.size() == ZERO ) {
			System.out.println("\n***  --  ***  AUCUN CONTACT DE CE PRENOM  ***  --  ***");
		} else {
			System.out.println("");
			GestionRepertoire.afficherListContacts( resultat );
		}
	}

	public static void rechercheParTelephone () {

		System.out.println("\n***  --  ***  Recherche par telephone  ***  --  ***");
		System.out.print("\n***  Numero de Telephone : ");
		String telephone = Saisi.chaine();

		List<Element> resultat = GestionRepertoire.getContactByTelephone( telephone );

		if (resultat.size() == ZERO ) {
			System.out.println("\n***  --  ***  AUCUN CONTACT AVEC CE TELEPHONE  ***  --  ***");
		} else {
			System.out.println("");
			GestionRepertoire.afficherListContacts( resultat );
		}
	}

	public static void rechercheParEmail () {

		System.out.println("\n***  --  ***  Recherche par email  ***  --  ***");
		System.out.print("\n***  Adresse Email : ");
		String email = Saisi.chaine();

		List<Element> resultat = GestionRepertoire.getContactByEmail( email );

		if (resultat.size() == ZERO ) {
			System.out.println("\n***  --  ***  AUCUN CONTACT AVEC CETTE EMAIL  ***  --  ***");
		} else {
			System.out.println("");
			GestionRepertoire.afficherListContacts( resultat );
		}
	}

	public static void rechercheParCategorie () {

		System.out.println("\n***  --  ***  Recherche par categorie  ***  --  ***");
    	System.out.println("\n************************************************");
		System.out.println("   favori - famille - ami - professionnel !") ;
		System.out.println(" Vous pouvez mettre plusieurs categorie separe par -") ;
		System.out.println("************************************************** \n");
		System.out.print("\n***   Categorie : ");
		String categorie = Saisi.searchCategorie();

		String[] categories = categorie.split("-");

		List<Element> resultat = new ArrayList<Element>();

		if (categories.length == ZERO || categories.length == QUATRE ) {
			resultat = GestionRepertoire.getContactByCategorie( FAVORI , FAMILLE , AMI , PROFESSIONEL );
		} else if (categories.length == UN ) {
			resultat = GestionRepertoire.getContactByCategorie( categories[ZERO]);
		} else if (categories.length == DEUX ) {
			resultat = GestionRepertoire.getContactByCategorie( categories[ZERO] , categories[UN]);
		} else if (categories.length == TROIS ) {
			resultat = GestionRepertoire.getContactByCategorie( categories[ZERO] , categories[UN] , categories[TROIS] );
		}

		if (resultat.size() == ZERO ) {
			System.out.println("\n***  --  ***  AUCUN CONTACT DANS CE(S) CATEGORIE(S)  ***  --  ***");
		} else {
			System.out.println("");
			GestionRepertoire.afficherListContacts( resultat );
		}
	}

//--------------------------------------------------
	/* Afficher les contacts favoris  */
//--------------------------------------------------
	public static void contactsFavori () {
		List<Element> contacts = GestionRepertoire.getContactByCategorie(FAVORI);

		if (contacts.size() == ZERO ) {
			System.out.println("\n***  --  ***  AUCUN CONSTACT DANS FAVORIS  ***  --  ***");
		} else {
			System.out.println("\n*** Liste des contact favoris ***\n");
			GestionRepertoire.afficherListContacts( contacts );
		}
	}

//--------------------------------------------------
	/* Afficher les contacts familles  */
//--------------------------------------------------
	public static void contactsFamille () {
		List<Element> contacts = GestionRepertoire.getContactByCategorie(FAMILLE);

		if (contacts.size() == ZERO ) {
			System.out.println("\n***  --  ***  AUCUN CONSTACT DANS FAMILLES  ***  --  ***");
		} else {
			System.out.println("\n*** Liste des contacts famillials ***\n");
			GestionRepertoire.afficherListContacts( contacts );
		}
	}

//--------------------------------------------------
	/* Afficher les contacts amis  */
//--------------------------------------------------
	public static void contactsAmi () {
		List<Element> contacts = GestionRepertoire.getContactByCategorie(AMI);

		if (contacts.size() == ZERO ) {
			System.out.println("\n***  --  ***  AUCUN CONSTACT DANS AMIS  ***  --  ***");
		} else {
			System.out.println("\n*** Liste des contact ami ***\n");
			GestionRepertoire.afficherListContacts( contacts );
		}
	}

//--------------------------------------------------
	/* Afficher les contacts professionnels  */
//--------------------------------------------------
	public static void contactsProfessionnel () {
		List<Element> contacts = GestionRepertoire.getContactByCategorie(PROFESSIONEL);

		if (contacts.size() == ZERO ) {
			System.out.println("\n***  --  ***  AUCUN CONSTACTS DANS PROFESSIONELS  ***  --  ***");
		} else {
			System.out.println("\n*** Liste des contact professionnels ***\n");
			GestionRepertoire.afficherListContacts( contacts );
		}
	}

	public static void contactsSansCategorie () {
		List<Element> contacts = GestionRepertoire.getContactWithoutCategorie();

		if (contacts.size() == ZERO ) {
			System.out.println("\n***  --  *** PAS DE CONTACT SANS CATEGORIE  ***  --  ***");
		} else {
			System.out.println("\n*** Liste des contact sans categorie ***\n");
			GestionRepertoire.afficherListContacts( contacts );
		}
	}

}
