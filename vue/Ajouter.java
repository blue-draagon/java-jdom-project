package vue ;

import controleur.Saisi ;
import controleur.Ajout;

public class Ajouter {
  public static void menuAjouter ( char choix2 ) {

    String choixAjoute = null ;

    while( true ) {

    	if ( choix2 != BREAK ) {
    		raccourciAjouter ( choix2 ) ;
    		break ;
    }

			System.out.println("\n\n");
    	System.out.println("        ==================================================================") ;
      System.out.println("        =    ****              GESTION DE REPERTOIRE            ****     =") ;
      System.out.println("        =     ****                      KA75                   ****      =");
      System.out.println("        ==================================================================") ;
      System.out.println("        =    ****                    MENU AJOUTER               ****     =");
      System.out.println("        ==================================================================") ;
      System.out.println("       ||                                                                ||");
    	System.out.println("       ||     [ 1-a ] -- AJOUTER UN CONTACT                              ||");
      System.out.println("       ||     [ 2-b ] -- AJOUTER UN NUMERO DE TELEPHONE                  ||");
      System.out.println("       ||     [ 3-c ] -- AJOUTER UNE ADRESSE EMAIL                       ||");
      System.out.println("       ||     [ 4-d ] -- AJOUTER A LA CATEGORIE                          ||");
      System.out.println("       ||     [ 0-z ] -- RETOUR AU MENU PRINCIPAL                        ||");
      System.out.println("        ------------------------------------------------------------------\n") ;
      System.out.print("                                    Taper votre choix : "); choixAjoute = Saisi.chaine();

      if ( choixAjoute.length() == ZERO ) { choixAjoute = CHOIX_UN + ""; }

      if (choixAjoute.charAt( ZERO ) == BREAK || choixAjoute.charAt( ZERO ) == BREAK_ ) {
      	System.out.println("** Retour au menu principal **");
      	break ;
      }

      menuAjoute : switch ( choixAjoute.charAt( ZERO ) ){
        case CHOIX_UN :{
                    Ajout.ajouterContact ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAjoute ;
        case CHOIX_DEUX :{
                    Ajout.ajouterTelephone ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAjoute ;
        case CHOIX_TROIS :{
                    Ajout.ajouterEmail  ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAjoute ;
        case CHOIX_QUATRE :{
                    Ajout.ajouterCategorie ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAjoute ;
        case CHOIX_UN_ :{
                    Ajout.ajouterContact ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAjoute ;
        case CHOIX_DEUX_ :{
                    Ajout.ajouterTelephone ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAjoute ;
        case CHOIX_TROIS_ :{
                    Ajout.ajouterEmail  ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAjoute ;
        case CHOIX_QUATRE_ :{
                    Ajout.ajouterCategorie ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAjoute ;
        default :{
                    System.out.println("\n   *****   choix incorrect   *****") ;
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuAjoute ;
      }
    }
  }

  static void raccourciAjouter ( char choix2 ) {
		switch ( choix2 ){
	    case CHOIX_UN :{
	                Ajout.ajouterContact ();
	             } break  ;
	    case CHOIX_DEUX :{
	                Ajout.ajouterTelephone ();
	             } break  ;
	    case CHOIX_TROIS :{
	                Ajout.ajouterEmail  ();
	             } break  ;
	    case CHOIX_QUATRE :{
	                Ajout.ajouterCategorie ();
	             } break  ;
	    case CHOIX_UN_ :{
	                Ajout.ajouterContact ();
	             } break  ;
	    case CHOIX_DEUX_ :{
	                Ajout.ajouterTelephone ();
	             } break  ;
	    case CHOIX_TROIS_ :{
	                Ajout.ajouterEmail  ();
	             } break  ;
	    case CHOIX_QUATRE_ :{
	                Ajout.ajouterCategorie ();
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
	static final char BREAK        = '0' ;

	static final char CHOIX_UN_     = 'a' ;
	static final char CHOIX_DEUX_   = 'b' ;
	static final char CHOIX_TROIS_  = 'c' ;
	static final char CHOIX_QUATRE_ = 'd' ;
	static final char BREAK_        = 'z' ;

	static final int ZERO = 0 ;
}
