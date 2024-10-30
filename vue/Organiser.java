package vue ;

import controleur.Saisi ;
import controleur.Affichage;

public class Organiser {
  public static void menuOrganiser ( char choix2 ) {

    String choixAffiche = null ;

    while( true ) {

    	if ( choix2 != BREAK ) {
    		raccourciOrganiser ( choix2 ) ;
    		break ;
    	}

    	System.out.println("\n\n");
    	System.out.println("        ==================================================================") ;
      System.out.println("        =    ****              GESTION DE REPERTOIRE            ****     =") ;
      System.out.println("        =     ****                      KA75                   ****      =");
      System.out.println("        ==================================================================") ;
      System.out.println("        =    ****                MENU CATEGORIE                ****      =");
      System.out.println("        ==================================================================") ;
      System.out.println("       ||                                                                ||");
      System.out.println("       ||     [ 1-a ] -- FAVORIS                                         ||");
      System.out.println("       ||     [ 2-b ] -- FAMILLES                                        ||");
      System.out.println("       ||     [ 3-c ] -- AMIS                                            ||");
      System.out.println("       ||     [ 4-d ] -- PROFESSIONEL                                    ||");
      System.out.println("       ||     [ 5-e ] -- SANS CATEGORIE                                  ||");
      System.out.println("       ||     [ 0-z ] -- RETOUR AU MENU PRINCIPAL                        ||");
      System.out.println("        ------------------------------------------------------------------\n");
      System.out.print("                                            Taper votre choix: "); choixAffiche = Saisi.chaine();
		if ( choixAffiche.length() == ZERO ) { choixAffiche = CHOIX_UN + ""; }
      if (choixAffiche.charAt( ZERO ) == BREAK || choixAffiche.charAt( ZERO ) == BREAK_ ) {
      	System.out.println("** Retour au menu principal **");
      	break ;
      }
      menuAffiche : switch ( choixAffiche.charAt( ZERO ) ){
        case CHOIX_UN :{
                    Affichage.contactsFavori ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_DEUX :{
                    Affichage.contactsFamille ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_TROIS  :{
                    Affichage.contactsAmi ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_QUATRE :{
                    Affichage.contactsProfessionnel ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_CINQ :{
                    Affichage.contactsSansCategorie ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_UN_ :{
                    Affichage.contactsFavori ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_DEUX_ :{
                    Affichage.contactsFamille ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_TROIS_  :{
                    Affichage.contactsAmi ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_QUATRE_ :{
                    Affichage.contactsProfessionnel ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_CINQ_ :{
                    Affichage.contactsSansCategorie ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        default :{
                    System.out.println("\n   *****   choix incorrect   *****") ;
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
      }
    }
  }

  static void raccourciOrganiser ( char choix2 ) {
		switch ( choix2 ){
        case CHOIX_UN :{
                    Affichage.contactsFavori ();
                 } break ;
        case CHOIX_DEUX :{
                    Affichage.contactsFamille ();
                 } break  ;
        case CHOIX_TROIS  :{
                    Affichage.contactsAmi ();
                 } break  ;
        case CHOIX_QUATRE :{
                    Affichage.contactsProfessionnel ();
                 } break  ;
        case CHOIX_CINQ :{
                    Affichage.contactsSansCategorie ();
                 } break  ;
        case CHOIX_UN_ :{
                    Affichage.contactsFavori ();
                 } break ;
        case CHOIX_DEUX_ :{
                    Affichage.contactsFamille ();
                 } break  ;
        case CHOIX_TROIS_  :{
                    Affichage.contactsAmi ();
                 } break  ;
        case CHOIX_QUATRE_ :{
                    Affichage.contactsProfessionnel ();
                 } break  ;
        case CHOIX_CINQ_ :{
                    Affichage.contactsSansCategorie ();
                 } break  ;
        default :{
                    System.out.println("\n   *****   raccourci incorrect   *****") ;
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
