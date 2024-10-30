package modele.java;

import controleur.Saisi;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Attribute;
import org.jdom2.JDOMException;

import org.jdom2.input.SAXBuilder;
import org.jdom2.input.JDOMParseException;

import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream ;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

public class GestionRepertoire {
	final static String DOCUMENT_XML   = "modele/xml/repertoire.xml";
	final static String RACINE         = "repertoire";
	final static String CONTACT        = "contact";
	final static String NUMERO_CONTACT = "numeroContact";
	final static String PRENOM         = "prenom";
	final static String NOM            = "nom";
	final static String TELEPHONE      = "telephone";
	final static String EMAIL          = "email";
	final static String CATEGORIE      = "categorie";

//###########################################################################################
//					                  	FONCTIONS UTILITAIRES
//###########################################################################################

//--------------------------------------------------
	/* Enregistrer dans le document XML */
//--------------------------------------------------

	static Document enregistre( Document document ) {
		try {
			XMLOutputter sortie = new XMLOutputter (Format.getPrettyFormat());
			sortie.output(document, new FileOutputStream( DOCUMENT_XML ));
		}	catch (java.io.IOException e){
			System.out.println("*********        Erreur   ****************") ;
		}

		return document;
	}

//--------------------------------------------------
	/* Crée le document XML */
//--------------------------------------------------
	static void createXmlFile () {
		Element racine = new Element (RACINE) ;
		Document new_document = new Document(racine) ;

		enregistre(new_document) ;
	}

//###########################################################################################
//					                  	FONCTIONS DE RECUPERATION
//###########################################################################################


//--------------------------------------------------
	/* Récupération du document  */
//--------------------------------------------------
	public static Document getTheDocument () {
		Document document = new Document();
		try{
			SAXBuilder builder = new SAXBuilder();
			document = builder.build( new File( DOCUMENT_XML ));
		}catch(JDOMParseException exception ){
			System.out.println( "Le document XML n'est pas bien formé !!!" );
		}catch(JDOMException exception ){
			System.out.println( "Erreur lors de la contruction du fichier JDOM : " + exception );
		}catch(FileNotFoundException exception ){
			System.out.println( "Le fichier "+ DOCUMENT_XML +" est introuvable." ) ;
			//System.out.println( "Vouler vous creez le fichier : " );
		} catch(IOException exception ){
			System.out.println( "Erreur lors de la lecture du fichier : " + exception );
		}

		return document ;
	}

//--------------------------------------------------
	/* Récupération de l'élément racine  */
//--------------------------------------------------
	public static Element getRacine () {
		Element repertoire = getTheDocument().getRootElement();

		return repertoire;
	}



//--------------------------------------------------
	/* Récupération du premier contact  */
//--------------------------------------------------
	public static Element getFirstContact () {
		Element repertoire = getRacine();
		Element premierContact = null;

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant  : resultats ) {
			premierContact = resultatCourant;

			break ;
		}


		return premierContact;
	}

//--------------------------------------------------
	/* Récupération du dernier contact  */
//--------------------------------------------------
	public static Element getLastContact () {
		Element repertoire = getRacine();
		Element dernierContact = null;

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant  : resultats ) {
			dernierContact = resultatCourant;
		}

		return dernierContact;
	}

//--------------------------------------------------
	/* Récupération d'un contact par numero  */
//--------------------------------------------------
	public static Element getContactById ( String numero ) {
		Element repertoire = getRacine();
		Element contact = null;

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant  : resultats ) {
			String identifiant = resultatCourant.getAttributeValue( NUMERO_CONTACT );
			if ( identifiant.equals( numero ) ) {
				contact = resultatCourant ;
				break ;
			}
		}

		return contact;
	}

//--------------------------------------------------
	/* Récupération d'un contact par nom  */
//--------------------------------------------------
	public static List<Element> getContactByNom ( String nom ) {
		Element repertoire = getRacine();
		List<Element> contacts = new ArrayList<Element>();

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant : resultats ) {
			String nomCourant = resultatCourant.getChildText( NOM );
			if ( nomCourant != null && nomCourant.toUpperCase().contains( nom.toUpperCase() ) ) {
				contacts.add ( resultatCourant );
			}
		}

		return contacts;
	}

//--------------------------------------------------
	/* Récupération d'un contact par prenom  */
//--------------------------------------------------
	public static List<Element> getContactByPrenom ( String prenom ) {
		Element repertoire = getRacine();
		List<Element> contacts = new ArrayList<Element>();

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant : resultats ) {
			String prenomCourant = resultatCourant.getChildText( PRENOM );
			if ( prenomCourant != null && prenomCourant.toUpperCase().contains( prenom.toUpperCase() ) ) {
				contacts.add ( resultatCourant );
			}
		}

		return contacts;
	}

//--------------------------------------------------
	/* Récupération d'un contact par telephone  */
//--------------------------------------------------
	public static List<Element> getContactByTelephone ( String telephone ) {
		Element repertoire = getRacine();
		List<Element> contacts = new ArrayList<Element>();

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant : resultats ) {
			String telephoneCourant = resultatCourant.getChildText( TELEPHONE );
			if ( telephoneCourant != null && telephoneCourant.toUpperCase().contains( telephone.toUpperCase() ) ) {
				contacts.add ( resultatCourant );
			}
		}

		return contacts;
	}

//--------------------------------------------------
	/* Récupération d'un contact par telephone donnée  */
//--------------------------------------------------
	public static Element getContactByCorrectTelephone ( String telephone ) {
		Element repertoire = getRacine();
		Element contact = null ;

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant : resultats ) {
			String telephoneCourant = resultatCourant.getChildText( TELEPHONE );
			if ( telephoneCourant != null && telephoneCourant.equals( telephone ) ) {
				contact = resultatCourant ;
			}
		}

		return contact ;
	}

//--------------------------------------------------
	/* Récupération d'un contact par email  */
//--------------------------------------------------
	public static List<Element> getContactByEmail ( String email ) {
		Element repertoire = getRacine();
		List<Element> contacts = new ArrayList<Element>();

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant : resultats ) {
			String emailCourant = resultatCourant.getChildText( EMAIL );
			if ( emailCourant != null && emailCourant.toUpperCase().contains( email.toUpperCase() ) ) {
				contacts.add ( resultatCourant );
			}
		}

		return contacts;
	}

//--------------------------------------------------
	/* Récupération d'un contact par email donnée  */
//--------------------------------------------------
	public static Element getContactByCorrectEmail ( String email ) {
		Element repertoire = getRacine();
		Element contact = null ;

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant : resultats ) {
			String emailCourant = resultatCourant.getChildText( EMAIL );
			if ( emailCourant != null && emailCourant.equals( email ) ) {
				contact = resultatCourant ;
			}
		}

		return contact ;
	}

//--------------------------------------------------
	/* Récupération des contacts sans categorie  */
//--------------------------------------------------
	public static List<Element> getContactWithoutCategorie () {
		Element repertoire = getRacine();
		List<Element> contacts = new ArrayList<Element>();

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant : resultats ) {
			String categorieCourant = resultatCourant.getChildText( CATEGORIE );
			if ( categorieCourant == null ) {
				contacts.add ( resultatCourant );
			}
		}

		return contacts;
	}

//--------------------------------------------------
	/* Récupération d'un contact par categorie  */
//--------------------------------------------------
	public static List<Element> getContactByCategorie ( String categorie ) {
		Element repertoire = getRacine();
		List<Element> contacts = new ArrayList<Element>();

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant : resultats ) {
			String categorieCourant = resultatCourant.getChildText( CATEGORIE );
			if ( categorieCourant != null && categorieCourant.toUpperCase().equals( categorie.toUpperCase() ) ) {
				contacts.add ( resultatCourant );
			}
		}

		return contacts;
	}

//-------------------------------------------------------------------------
	/* Récupération d'un contact par categorie avec deux categories */
//--------------------------------------------------------------------------
	public static List<Element> getContactByCategorie ( String categorie1,  String categorie2 ) {
		Element repertoire = getRacine();
		List<Element> contacts = new ArrayList<Element>();

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant : resultats ) {
			String categorieCourant = resultatCourant.getChildText( CATEGORIE );
			if ( categorieCourant != null && ( categorieCourant.toUpperCase().equals( categorie1.toUpperCase())
													||	categorieCourant.toUpperCase().equals( categorie2.toUpperCase() ) )  ) {
				contacts.add ( resultatCourant );
			}
		}

		return contacts;
	}

//-------------------------------------------------------------------------
	/* Récupération d'un contact par categorie avec trois categories */
//--------------------------------------------------------------------------
	public static List<Element> getContactByCategorie ( String categorie1,  String categorie2 , String categorie3 ) {
		Element repertoire = getRacine();
		List<Element> contacts = new ArrayList<Element>();

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant : resultats ) {
			String categorieCourant = resultatCourant.getChildText( CATEGORIE );
			if ( categorieCourant != null && ( categorieCourant.toUpperCase().equals( categorie1.toUpperCase() )
													||	categorieCourant.toUpperCase().equals( categorie2.toUpperCase() )
													||	categorieCourant.toUpperCase().equals( categorie3.toUpperCase() ) ) ) {
				contacts.add ( resultatCourant );
			}
		}

		return contacts;
	}

//-------------------------------------------------------------------------
	/* Récupération d'un contact par categorie avec quatre categories */
//--------------------------------------------------------------------------
	public static List<Element> getContactByCategorie ( String categorie1,  String categorie2 , String categorie3 , String categorie4 ) {
		Element repertoire = getRacine();
		List<Element> contacts = new ArrayList<Element>();

		List<Element> resultats = repertoire.getChildren( CONTACT );
		for ( Element resultatCourant : resultats ) {
			String categorieCourant = resultatCourant.getChildText( CATEGORIE );
			if ( categorieCourant != null && ( categorieCourant.toUpperCase().equals( categorie1.toUpperCase() )
													||	categorieCourant.toUpperCase().equals( categorie2.toUpperCase() )
													||	categorieCourant.toUpperCase().equals( categorie3.toUpperCase() )
													||	categorieCourant.toUpperCase().equals( categorie4.toUpperCase() ) ) ) {
				contacts.add ( resultatCourant );
			}
		}

		return contacts;
	}


//--------------------------------------------------
	/* Récupérer l'identifiant du dernier contact  */
//--------------------------------------------------
	public static int getLastNumeroContact () {
		Element repertoire = getRacine();
		Element contact = getLastContact();
		String identifiant = null;
		if (contact != null ) {
			 identifiant = contact.getAttributeValue( NUMERO_CONTACT ) ;
		}

		if (identifiant != null ) {
			int numero ;
			numero = Integer.parseInt(identifiant);

			return numero  ;
		} else {
			return 0;
		}
	}

//--------------------------------------------------
	/* Récupérer le nom d'un contact  */
//--------------------------------------------------
	public static Element getNom ( String identifiant ) {
		Element repertoire = getRacine();
		Element contact = getContactById( identifiant );
		Element nom = null;
		if (contact != null ) {
			 nom = contact.getChild( NOM ) ;
		}

		if (nom != null ) {
			 return nom ;
		} else {
			return null;
		}
	}

//--------------------------------------------------
	/* Récupérer le prenom d'un contact  */
//--------------------------------------------------
	public static Element getPrenom ( String identifiant ) {
		Element repertoire = getRacine();
		Element contact = getContactById( identifiant );
		Element prenom = null;
		if (contact != null ) {
			 prenom = contact.getChild( PRENOM ) ;
		}

		if (prenom != null ) {
			 return prenom ;
		} else {
			return null;
		}
	}

//--------------------------------------------------
	/* Récupérer le telephone d'un contact  */
//--------------------------------------------------
	public static Element getTelephone ( String identifiant ) {
		Element repertoire = getRacine();
		Element contact = getContactById( identifiant );
		Element telephone = null;
		if (contact != null ) {
			 telephone = contact.getChild( TELEPHONE ) ;
		}

		if (telephone != null ) {
			 return telephone ;
		} else {
			return null;
		}
	}

//--------------------------------------------------
	/* Récupérer l'email d'un contact  */
//--------------------------------------------------
	public static Element getEmail ( String identifiant ) {
		Element repertoire = getRacine();
		Element contact = getContactById( identifiant );
		Element email = null;
		if (contact != null ) {
			 email = contact.getChild( EMAIL ) ;
		}

		if (email != null ) {
			 return email ;
		} else {
			return null;
		}
	}

//--------------------------------------------------
	/* Récupérer la categorie d'un contact  */
//--------------------------------------------------
	public static Element getCategorie ( String identifiant ) {
		Element repertoire = getRacine();
		Element contact = getContactById( identifiant );
		Element categorie = null;
		if (contact != null ) {
			 categorie = contact.getChild( CATEGORIE ) ;
		}

		if (categorie != null ) {
			 return categorie ;
		} else {
			return null;
		}
	}
//------------------------------FIN FONCTIONS DE RECUPERATION--------------------------------

//###########################################################################################
//					                  	FONCTIONS D'AFFICHAGE
//###########################################################################################

//--------------------------------------------------
	/* Afficher un document XML  */
//--------------------------------------------------
	public static Document affiche( Document document )	{
		try {
			XMLOutputter sortie = new XMLOutputter (Format.getPrettyFormat());
			sortie.output( document , System.out);
		}	catch ( IOException e){
			System.out.println("\n*********  Echec d'affichage du document   ****************\n") ;
			e.printStackTrace();
		}

		return document;
	}

//--------------------------------------------------
	/* Afficher une liste de contacts */
//--------------------------------------------------
	public static void afficherListContacts (List<Element> contacts) {
		String choix = "1by1";
		int size = contacts.size();
		int current = 0;
		for ( Element contactCourant : contacts ) {

			System.out.println("##########  contact : " + contactCourant.getAttributeValue(NUMERO_CONTACT ) + "  ##############");

			String categorie = contactCourant.getChildText(CATEGORIE) ;
			if (categorie != null ) {
				System.out.println("	Categorie   : " + categorie.toUpperCase() );
			}

			String prenom = contactCourant.getChildText( PRENOM ) ;
			if (prenom != null ) {
				System.out.println("	Prenom      : " + prenom );
			}

			String nom = contactCourant.getChildText( NOM ) ;
			if (nom != null ) {
				System.out.println("	Nom         : " + nom );
			}

			String telephone     = contactCourant.getChildText(TELEPHONE) ;
			if (telephone != null ) {
				System.out.println("	Telephone   : " + telephone );
			}

			String email     = contactCourant.getChildText(EMAIL);
			if (email != null ) {
				System.out.println("	Email       : " + email );
			}

			current++;

			if (choix.equals("1by1") && size > current) {
				System.out.print("Taper Entrer pour voir le contact suivant...");
				choix = Saisi.chaine();
				if (choix.length() == 0) choix = "1by1";
			}

		}

		System.out.println("-----------------------------------------------");
	}

//--------------------------------------------------
	/* Afficher un contact  */
//--------------------------------------------------
	public static Element afficherContact (Element contact) {

		System.out.println("##########  contact : " + contact.getAttributeValue( NUMERO_CONTACT ) + "  ##############");

		String categorie  = contact.getChildText(CATEGORIE) ;
		if (categorie != null ) {
			System.out.println("	Categorie   : " + categorie.toUpperCase() );
		}

		String prenom     = contact.getChildText( PRENOM ) ;
		if (prenom != null ) {
			System.out.println("	Prenom      : " + prenom );
		}

		String nom        = contact.getChildText( NOM ) ;
		if (nom != null ) {
			System.out.println("	Nom         : " + nom );
		}

		String telephone  = contact.getChildText(TELEPHONE) ;
		if (telephone != null ) {
			System.out.println("	Telephone   : " + telephone );
		}

		String email      = contact.getChildText(EMAIL);
		if (email != null ) {
			System.out.println("	Email       : " + email );
		}

		return contact;
	}
//------------------------------FIN FONCTIONS D'AFFICHAGE------------------------------------

//###########################################################################################
//					                  	FONCTIONS D'AJOUT
//###########################################################################################

//--------------------------------------------------
	/* Ajouter un contact sans telephone sans email */
//--------------------------------------------------
	public static Element addContact ( String prenom , String nom ) {
		Element repertoire = getRacine();

		Element contact = new Element ( CONTACT );
		String numeroContact = (getLastNumeroContact() + 1 ) + "" ;
		contact
			.setAttribute(new Attribute (NUMERO_CONTACT , numeroContact))
			.addContent(new Element( PRENOM ).setText(prenom))
			.addContent(new Element( NOM ).setText(nom)) ;
		repertoire.addContent(contact);

		enregistre (repertoire.getDocument());

		System.out.println("\n   *-*-*-*--*    Contact ajouter avec succès     *-*-*-*--*\n");

		return repertoire;
	}

//--------------------------------------------------
	/* Ajouter un contact avec categorie */
//--------------------------------------------------
	public static Element addContact ( String prenom , String nom , String categorie ) {
		Element repertoire = getRacine();

		Element contact = new Element ( CONTACT );
		String numeroContact = (getLastNumeroContact() + 1 ) + "" ;
		contact
			.setAttribute(new Attribute (NUMERO_CONTACT , numeroContact))
			.addContent(new Element( CATEGORIE ).setText(categorie))
			.addContent(new Element( PRENOM ).setText(prenom))
			.addContent(new Element( NOM ).setText(nom)) ;
		repertoire.addContent(contact);

		enregistre (repertoire.getDocument());

		System.out.println("\n   *-*-*-*--*    Contact ajouter avec succès     *-*-*-*--*\n");

		return repertoire;
	}

//--------------------------------------------------
	/* Ajouter un contact avec telephone */
//--------------------------------------------------
	public static Element addContact ( String prenom , String nom , int nbr , String telephone) {
		Element repertoire = getRacine();

		Element contact = new Element ( CONTACT );
		String numeroContact = (getLastNumeroContact() + 1 ) + "" ;
		contact
			.setAttribute(new Attribute (NUMERO_CONTACT , numeroContact))
			.addContent(new Element( PRENOM ).setText(prenom))
			.addContent(new Element( NOM ).setText(nom))
			.addContent(new Element( TELEPHONE ).setText(telephone)) ;
		repertoire.addContent(contact);

		enregistre (repertoire.getDocument());

		System.out.println("\n   *-*-*-*--*    Contact ajouter avec succès     *-*-*-*--*\n");

		return repertoire;
	}

//--------------------------------------------------
	/* Ajouter un contact avec email */
//--------------------------------------------------
	public static Element addContact ( String prenom , String nom , double nbr , String email) {
		Element repertoire = getRacine();

		Element contact = new Element ( CONTACT );
		String numeroContact = (getLastNumeroContact() + 1 ) + "" ;
		contact
			.setAttribute(new Attribute (NUMERO_CONTACT , numeroContact))
			.addContent(new Element( PRENOM ).setText(prenom))
			.addContent(new Element( NOM ).setText(nom))
			.addContent(new Element( EMAIL ).setText(email)) ;
		repertoire.addContent(contact);

		enregistre (repertoire.getDocument());

		System.out.println("\n   *-*-*-*--*    Contact ajouter avec succès     *-*-*-*--*\n");

		return repertoire;
	}

//--------------------------------------------------
	/* Ajouter un contact avec categorie et telephone */
//--------------------------------------------------
	public static Element addContact ( String prenom , String nom , String categorie , String telephone) {
		Element repertoire = getRacine();

		Element contact = new Element ( CONTACT );
		String numeroContact = (getLastNumeroContact() + 1 ) + "" ;
		contact
			.setAttribute(new Attribute (NUMERO_CONTACT , numeroContact))
			.addContent(new Element( CATEGORIE ).setText(categorie))
			.addContent(new Element( PRENOM ).setText(prenom))
			.addContent(new Element( NOM ).setText(nom))
			.addContent(new Element( TELEPHONE ).setText(telephone)) ;
		repertoire.addContent(contact);

		enregistre (repertoire.getDocument());

		System.out.println("\n   *-*-*-*--*    Contact ajouter avec succès     *-*-*-*--*\n");

		return repertoire;
	}

//--------------------------------------------------
	/* Ajouter un contact avec categorie et email */
//--------------------------------------------------
	public static Element addContact ( String prenom , String nom , String categorie , int nbr , String email) {
		Element repertoire = getRacine();

		Element contact = new Element ( CONTACT );
		String numeroContact = (getLastNumeroContact() + 1 ) + "" ;
		contact
			.setAttribute(new Attribute (NUMERO_CONTACT , numeroContact))
			.addContent(new Element( CATEGORIE ).setText(categorie))
			.addContent(new Element( PRENOM ).setText(prenom))
			.addContent(new Element( NOM ).setText(nom))
			.addContent(new Element( EMAIL ).setText(email)) ;
		repertoire.addContent(contact);

		enregistre (repertoire.getDocument());

		System.out.println("\n   *-*-*-*--*    Contact ajouter avec succès     *-*-*-*--*\n");

		return repertoire;
	}

//----------------------------------------------------------------
	/* Ajouter un contact avec telephone et email */
//----------------------------------------------------------------
	public static Element addContact ( String prenom , String nom , int nbr , String telephone , String email) {
		Element repertoire = getRacine();

		Element contact = new Element ( CONTACT );
		String numeroContact = (getLastNumeroContact() + 1 ) + "" ;
		contact
			.setAttribute(new Attribute (NUMERO_CONTACT , numeroContact))
			.addContent(new Element( PRENOM ).setText(prenom))
			.addContent(new Element( NOM ).setText(nom))
			.addContent(new Element( TELEPHONE ).setText(telephone))
			.addContent(new Element( EMAIL ).setText(email)) ;
		repertoire.addContent(contact);

		enregistre (repertoire.getDocument());

		System.out.println("\n   *-*-*-*--*    Contact ajouter avec succès     *-*-*-*--*\n");

		return repertoire;
	}

//----------------------------------------------------------------
	/* Ajouter un contact complet */
//----------------------------------------------------------------
	public static Element addContact ( String prenom , String nom , String categorie , String telephone , String email) {
		Element repertoire = getRacine();

		Element contact = new Element ( CONTACT );
		String numeroContact = (getLastNumeroContact() + 1 ) + "" ;
		contact
			.setAttribute(new Attribute (NUMERO_CONTACT , numeroContact))
			.addContent(new Element( CATEGORIE ).setText(categorie))
			.addContent(new Element( PRENOM ).setText(prenom))
			.addContent(new Element( NOM ).setText(nom))
			.addContent(new Element( TELEPHONE ).setText(telephone))
			.addContent(new Element( EMAIL ).setText(email)) ;
		repertoire.addContent(contact);

		enregistre (repertoire.getDocument());

		System.out.println("\n   *-*-*-*--*    Contact ajouter avec succès     *-*-*-*--*\n");

		return repertoire;
	}

//----------------------------------------------------------------
	/* Ajouter un telephone à un contact */
//----------------------------------------------------------------
	public static Element addTelephone ( String identifiant , String telephone ) {
		Element contact = getContactById ( identifiant );
		contact.addContent(new Element( TELEPHONE ).setText(telephone));
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Telephone ajouter avec succès     *-*-*-*--*\n");

		return contact;
	}

//----------------------------------------------------------------
	/* Ajouter une email à un contact */
//----------------------------------------------------------------
	public static Element addEmail ( String identifiant , String email ) {
		Element contact = getContactById ( identifiant );
		contact.addContent(new Element( EMAIL ).setText(email));
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Email ajouter avec succès     *-*-*-*--*\n");

		return contact;
	}

//----------------------------------------------------------------
	/* Ajouter un contact à une categorie */
//----------------------------------------------------------------
	public static Element addCategorie ( String identifiant , String categorie ) {
		Element contact = getContactById ( identifiant );
		contact.addContent(new Element( CATEGORIE ).setText(categorie));
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Contact ajouté a la categorie "+ categorie + "     *-*-*-*--*\n");

		return contact;
	}
//------------------------------FIN FONCTIONS D'AJOUT---------------------------------------

//###########################################################################################
//					                  	FONCTIONS DE MODIFICATION
//###########################################################################################

//----------------------------------------------------------------
	/* Modifier le prenom */
//----------------------------------------------------------------
	public static Element changeNom ( String identifiant , String nom ) {
		Element contact    = getContactById ( identifiant );
		contact.getChild( NOM ).setText(nom);
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Nom modifier avec succès     *-*-*-*--*\n");

		return contact;
	}

//----------------------------------------------------------------
	/* Modifier le prenom */
//----------------------------------------------------------------
	public static Element changePrenom ( String identifiant , String prenom ) {
		Element contact    = getContactById ( identifiant );
		contact.getChild( PRENOM ).setText(prenom);
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Prenom modifier avec succès     *-*-*-*--*\n");

		return contact;
	}

//----------------------------------------------------------------
	/* Modifier le telephone */
//----------------------------------------------------------------
	public static Element changeTelephone ( String identifiant , String telephone ) {
		Element contact    = getContactById ( identifiant );
		contact.getChild( TELEPHONE ).setText(telephone);
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Telephone modifier avec succès     *-*-*-*--*\n");

		return contact;
	}

//----------------------------------------------------------------
	/* Modifier l'email */
//----------------------------------------------------------------
	public static Element changeEmail ( String identifiant , String email ) {
		Element contact    = getContactById ( identifiant );
		contact.getChild( EMAIL ).setText(email);
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Email modifier avec succès     *-*-*-*--*\n");

		return contact;
	}

//----------------------------------------------------------------
	/* Modifier la categorie  */
//----------------------------------------------------------------
	public static Element changeCategorie ( String identifiant , String categorie ) {
		Element contact    = getContactById ( identifiant );
		contact.getChild( CATEGORIE ).setText(categorie);
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Categorie modifier avec succès     *-*-*-*--*\n");

		return contact;
	}

//----------------------------------------------------------------
	/* Modifier tout le Contact */
//----------------------------------------------------------------
	public static Element changeContact (String identifiant, String prenom, String nom, String categorie, String telephone, String email) {
		Element contact    = getContactById ( identifiant );
		if ( getNom(identifiant)       != null ) contact.getChild( NOM ).setText(nom);
		if ( getPrenom(identifiant)    != null ) contact.getChild( PRENOM ).setText(prenom);
		if ( getCategorie(identifiant) != null ) contact.getChild( CATEGORIE ).setText(categorie);
		if ( getTelephone(identifiant) != null ) contact.getChild( TELEPHONE ).setText(telephone);
		if ( getEmail(identifiant)     != null ) contact.getChild( EMAIL ).setText(email);
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Contact modifier avec succès     *-*-*-*--*\n");

		return contact;
	}
//------------------------------FIN FONCTIONS DE MODIFICATION---------------------------------------

//###########################################################################################
//					                  	FONCTIONS DE SUPPRESSION
//###########################################################################################

//--------------------------------------------------
	/* Supprimer un contact  */
//--------------------------------------------------
	public static void deleteContact ( String numero ) {
		Element repertoire = getRacine();

		List<Element> contactsRestant = new ArrayList<Element> ();

		List<Element> resultats = repertoire.getChildren( CONTACT );

		for ( Element resultatCourant : resultats ) {
			String identifiant = resultatCourant.getAttributeValue( NUMERO_CONTACT );
			if ( identifiant != null && ! identifiant.equals( numero ) ) {
				contactsRestant.add(resultatCourant);
			}
		}

		repertoire.removeChildren( CONTACT );

		for ( Element contact : contactsRestant ) {
			repertoire.addContent(contact);
		}

		enregistre(repertoire.getDocument());

		System.out.println("\n   *-*-*-*--*    Le contact est supprimés avec succès     *-*-*-*--*\n");
	}

//----------------------------------------------------------------
	/* Supprimer le telephone d'un contact */
//----------------------------------------------------------------
	public static Element deleteTelephone ( String identifiant ) {
		Element contact = getContactById ( identifiant );
		contact.removeChild(TELEPHONE);
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Telephone supprimer avec succès     *-*-*-*--*\n");

		return contact;
	}

//----------------------------------------------------------------
	/* Supprimer l'email d'un contact */
//----------------------------------------------------------------
	public static Element deleteEmail ( String identifiant ) {
		Element contact = getContactById ( identifiant );
		contact.removeChild(EMAIL);
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Email supprimer avec succès     *-*-*-*--*\n");

		return contact;
	}

//----------------------------------------------------------------
	/* Supprimer un contact d'une categorie */
//----------------------------------------------------------------
	public static Element deleteCategorie ( String identifiant ) {
		Element contact = getContactById ( identifiant );
		contact.removeChild(CATEGORIE);
		enregistre (contact.getDocument());

		System.out.println("\n   *-*-*-*--*    Categorie supprimer avec succès     *-*-*-*--*\n");

		return contact;
	}

//--------------------------------------------------
	/* Supprimer tous les contacts */
//--------------------------------------------------
	public static void deleteContacts () {

		Element repertoire = getRacine();

		repertoire.removeChildren( CONTACT );

		enregistre(repertoire.getDocument());

		System.out.println("\n   *-*-*-*--*    Tous les contacts sont supprimés avec succès     *-*-*-*--*\n");
	}
//------------------------------FIN FONCTIONS DE MODIFICATION---------------------------------------


//###########################################################################################
//					        FIN DE LA CLASSE GESTION DE REPERTOIRE
//###########################################################################################
}
