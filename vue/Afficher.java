package vue ;

import controleur.Saisi ;
import controleur.Affichage;

public class Afficher {
  public static void menuAfficher ( char choix2 ) {

    String choixAffiche = null ;

    while( true ) {

    	if ( choix2 != BREAK ) {
    		raccourciAfficher ( choix2 ) ;
    		break ;
    	}

    	System.out.println("\n\n");
    	System.out.println("        ==================================================================") ;
      System.out.println("        =    ****              GESTION DE REPERTOIRE            ****     =") ;
      System.out.println("        =     ****                      KA75                   ****      =");
      System.out.println("        ==================================================================");
      System.out.println("        =    ****                MENU DE RECHERCHE              ****     =");
      System.out.println("        ==================================================================");
      System.out.println("       ||                                                                 ||");
      System.out.println("       ||     [ 1-a ] -- RECHERCHE PAR NOM                                ||");
      System.out.println("       ||     [ 2-b ] -- RECHERCHE PAR PRENOM                             ||");
      System.out.println("       ||     [ 3-c ] -- RECHERCHE PAR NUMERO TELEPHONE                   ||");
      System.out.println("       ||     [ 4-d ] -- RECHERCHE PAR EMAIL                              ||");
      System.out.println("       ||     [ 5-e ] -- RECHERCHE PAR CATEGORIE                          ||");
      System.out.println("       ||     [ 6-f ] -- RECHERCHE UN CONTACT (par identifiant)           ||");
      System.out.println("       ||     [ 0-z ] -- RETOUR AU MENU PRINCIPAL                         ||");
      System.out.println("        ------------------------------------------------------------------\n");
      System.out.print("                                   Taper votre choix: "); choixAffiche = Saisi.chaine();
		if ( choixAffiche.length() == ZERO ) { choixAffiche = CHOIX_UN + "" ; }
      if (choixAffiche.charAt( ZERO ) == BREAK || choixAffiche.charAt( ZERO ) == BREAK_ ) {
      	System.out.println("** Retour au menu principal **");
      	break ;
      }
      menuAffiche : switch ( choixAffiche.charAt( ZERO ) ){
        case CHOIX_UN :{
                    Affichage.rechercheParNom ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_DEUX :{
                    Affichage.rechercheParPrenom ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_TROIS :{
                    Affichage.rechercheParTelephone ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_QUATRE :{
                    Affichage.rechercheParEmail ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_CINQ :{
                    Affichage.rechercheParCategorie ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_SIX :{
                    Affichage.rechercheParNumero ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_UN_ :{
                    Affichage.rechercheParNom ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_DEUX_ :{
                    Affichage.rechercheParPrenom ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_TROIS_ :{
                    Affichage.rechercheParTelephone ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_QUATRE_ :{
                    Affichage.rechercheParEmail ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_CINQ_ :{
                    Affichage.rechercheParCategorie ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        case CHOIX_SIX_ :{
                    Affichage.rechercheParNumero ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
        default :{
                    System.out.println("\n   *****   choix incorrect   *****") ;
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAffiche ;
      }
    }
  }

	static void raccourciAfficher ( char choix2 ) {
		switch ( choix2 ){

			case CHOIX_UN :{
				    Affichage.rechercheParNom ();
				 } break  ;

			case CHOIX_DEUX :{
				    Affichage.rechercheParPrenom ();
				 } break  ;

			case CHOIX_TROIS :{
				    Affichage.rechercheParTelephone ();
				 } break  ;

			case CHOIX_QUATRE :{
				    Affichage.rechercheParEmail ();
				 } break  ;

			case CHOIX_CINQ :{
				    Affichage.rechercheParCategorie ();
				 } break  ;

			case CHOIX_SIX :{
				    Affichage.rechercheParNumero ();
				 } break  ;

      case CHOIX_UN_ :{
                  Affichage.rechercheParNom ();
               } break;

      case CHOIX_DEUX_ :{
                  Affichage.rechercheParPrenom ();
               } break;

      case CHOIX_TROIS_ :{
                  Affichage.rechercheParTelephone ();
               } break;

      case CHOIX_QUATRE_ :{
                  Affichage.rechercheParEmail ();
               } break;

      case CHOIX_CINQ_ :{
                  Affichage.rechercheParCategorie ();
               } break;

      case CHOIX_SIX_ :{
                  Affichage.rechercheParNumero ();
               } break;

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
	static final char CHOIX_SIX    = '6' ;
	static final char BREAK        = '0' ;

	static final char CHOIX_UN_     = 'a' ;
	static final char CHOIX_DEUX_   = 'b' ;
	static final char CHOIX_TROIS_  = 'c' ;
	static final char CHOIX_QUATRE_ = 'd' ;
	static final char CHOIX_CINQ_   = 'e' ;
	static final char CHOIX_SIX_    = 'f' ;
	static final char BREAK_        = 'z' ;

	static final int ZERO = 0 ;
}

