package vue ;

import controleur.Saisi ;
import controleur.Suppression;

public class Supprimer {
  public static void menuSupprimer ( char choix2 ) {

    String choixSupprime = null ;

    while( true ) {

    	if ( choix2 != BREAK ) {
    		raccourciSupprimer ( choix2 ) ;
    		break ;
    	}

    	System.out.println("\n\n");
    	System.out.println("        ==================================================================");
      System.out.println("        =    ****              GESTION DE REPERTOIRE            ****     =");
      System.out.println("        =     ****                      KA75                   ****      =");
      System.out.println("        ==================================================================");
      System.out.println("        =    ****                MENU DE SUPPRESSION            ****     =");
      System.out.println("        ==================================================================");
      System.out.println("       ||                                                                 ||");
    	System.out.println("       ||     [ 1 ] -- SUPPRIMER UN CONTACT                               ||");
      System.out.println("       ||     [ 2 ] -- SUPPRIMER LE NUMERO DE TELEPHONE                   ||");
      System.out.println("       ||     [ 3 ] -- SUPPRIMER L'ADRESSE EMAIL                          ||");
      System.out.println("       ||     [ 4 ] -- SUPPRIMER DE LA CATEGORIE                          ||");
      System.out.println("       ||     [ 5 ] -- SUPPRIMER TOUT LES CONTACTS                        ||");
      System.out.println("       ||     [ 0 ] -- RETOUR AU MENU PRINCIPAL                           ||");
      System.out.println("        ------------------------------------------------------------------\n") ;
      System.out.print("                                       Taper votre choix : "); choixSupprime = Saisi.chaine();

      if ( choixSupprime.length() == ZERO ) { choixSupprime = CHOIX_UN + ""; }

      if (choixSupprime.charAt( ZERO ) == BREAK || choixSupprime.charAt( ZERO ) == BREAK_ ) {
      	System.out.println("** Retour au menu principal **");
      	break ;
      }

      menuSupprime : switch ( choixSupprime.charAt( ZERO )  ){
        case CHOIX_UN     :{
                    controleur.Suppression.supprimerContact ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuSupprime ;
        case CHOIX_DEUX   :{
                    controleur.Suppression.supprimerTelephone ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuSupprime ;
        case CHOIX_TROIS  :{
                    controleur.Suppression.supprimerEmail ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuSupprime ;
        case CHOIX_QUATRE :{
                    controleur.Suppression.supprimerCategorie ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuSupprime ;
        case CHOIX_CINQ   :{
                    controleur.Suppression.supprimerContacts ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuSupprime ;
        case CHOIX_UN_     :{
                    controleur.Suppression.supprimerContact ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuSupprime ;
        case CHOIX_DEUX_   :{
                    controleur.Suppression.supprimerTelephone ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuSupprime ;
        case CHOIX_TROIS_  :{
                    controleur.Suppression.supprimerEmail ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuSupprime ;
        case CHOIX_QUATRE_ :{
                    controleur.Suppression.supprimerCategorie ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuSupprime ;
        case CHOIX_CINQ_   :{
                    controleur.Suppression.supprimerContacts ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuSupprime ;
        default :{
                    System.out.println("\n   *****   choix incorrect   *****\n") ;
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuSupprime ;
      }
    }
  }

  static void raccourciSupprimer ( char choix2 ) {
		switch ( choix2 ){
			case CHOIX_UN     :{
				          controleur.Suppression.supprimerContact ();
				       } break  ;
			case CHOIX_DEUX   :{
				          controleur.Suppression.supprimerTelephone ();
				       } break ;
			case CHOIX_TROIS  :{
				          controleur.Suppression.supprimerEmail ();
				       } break  ;
			case CHOIX_QUATRE :{
				          controleur.Suppression.supprimerCategorie ();
				          } break ;
			case CHOIX_CINQ   :{
				          controleur.Suppression.supprimerContacts ();
				       } break  ;
			case CHOIX_UN_     :{
				          controleur.Suppression.supprimerContact ();
				       } break  ;
			case CHOIX_DEUX_   :{
				          controleur.Suppression.supprimerTelephone ();
				       } break ;
			case CHOIX_TROIS_  :{
				          controleur.Suppression.supprimerEmail ();
				       } break  ;
			case CHOIX_QUATRE_ :{
				          controleur.Suppression.supprimerCategorie ();
				          } break ;
			case CHOIX_CINQ_   :{
				          controleur.Suppression.supprimerContacts ();
				       } break  ;
			default :{
				          System.out.println("\n   *****   Raccourci incorrect *****\n") ;
				       } break  ;
		}
  }

	static final char CHOIX_UN     = '1' ;
	static final char CHOIX_DEUX   = '2' ;
	static final char CHOIX_TROIS  = '3' ;
	static final char CHOIX_QUATRE = '4' ;
	static final char CHOIX_CINQ   = '5' ;
	static final char BREAK        = '0' ;

	static final char CHOIX_UN_     = 'a' ;
	static final char CHOIX_DEUX_   = 'b' ;
	static final char CHOIX_TROIS_  = 'c' ;
	static final char CHOIX_QUATRE_ = 'd' ;
	static final char CHOIX_CINQ_   = 'e' ;
	static final char BREAK_        = 'z' ;

	static final int ZERO = 0 ;
}
