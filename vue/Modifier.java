package vue ;

import controleur.Saisi ;
import controleur.Modification;

public class Modifier {
  public static void menuModifier ( char choix2 ) {

    String choixModifie = null ;

    while( true ) {

    	if ( choix2 != BREAK ) {
    		raccourciModifier ( choix2 ) ;
    		break ;
    	}

    	System.out.println("\n\n");
    	System.out.println("        ==================================================================") ;
      System.out.println("        =    ****              GESTION DE REPERTOIRE            ****     =") ;
      System.out.println("        =     ****                      KA75                   ****      =");
      System.out.println("        ==================================================================");
      System.out.println("        =    ****                MENU DE MODIFICATION           ****     =");
      System.out.println("        ==================================================================\n");
    	System.out.println("*************************************************************************************");
			System.out.println("   Remarque : La modification necessite la connaissance de l'identifiant du contact !");
			System.out.println("**************************************************************************************");
      System.out.println("       ||                                                                ||");
      System.out.println("       ||     [ 1-a ] -- MODIFIER LE NOM                                 ||");
      System.out.println("       ||     [ 2-b ] -- MODIFIER LE PRENOM                              ||");
      System.out.println("       ||     [ 3-c ] -- MODIFIER LE NUMERO TELEPHONE                    ||");
      System.out.println("       ||     [ 4-d ] -- MODIFIER L'EMAIL                                ||");
      System.out.println("       ||     [ 5-e ] -- MODIFIER LA CATEGORIE                           ||");
      System.out.println("       ||     [ 6-f ] -- MODIFIER PLUSIEURS ELEMENTS                     ||");
      System.out.println("       ||     [ 0-z ] -- RETOUR AU MENU PRINCIPAL                        ||");
      System.out.println("        ------------------------------------------------------------------\n") ;
      System.out.print("                                   Taper votre choix : "); choixModifie = Saisi.chaine();

      if ( choixModifie.length() == ZERO ) { choixModifie = CHOIX_SIX + ""; }

      if (choixModifie.charAt( ZERO ) == BREAK || choixModifie.charAt( ZERO ) == BREAK_ ) {
      	System.out.println("** Retour au menu principal **");
      	break ;
      }

      menuModifie : switch ( choixModifie.charAt( ZERO ) ){
        case CHOIX_UN :{
                    Modification.modifierNom ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        case CHOIX_DEUX :{
                    Modification.modifierPrenom ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        case CHOIX_TROIS :{
                    Modification.modifierTelephone ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        case CHOIX_QUATRE :{
                    Modification.modifierEmail ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        case CHOIX_CINQ :{
                    Modification.modifierCategorie ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        case CHOIX_SIX :{
                    Modification.modifierContact ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        case CHOIX_UN_ :{
                    Modification.modifierNom ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        case CHOIX_DEUX_ :{
                    Modification.modifierPrenom ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        case CHOIX_TROIS_ :{
                    Modification.modifierTelephone ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        case CHOIX_QUATRE_ :{
                    Modification.modifierEmail ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        case CHOIX_CINQ_ :{
                    Modification.modifierCategorie ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        case CHOIX_SIX_ :{
                    Modification.modifierContact ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
        default :{
                    System.out.println("\n   *****   choix incorrect   *****") ;
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menuModifie ;
      }
    }
  }

	static void raccourciModifier ( char choix2 ) {
		switch ( choix2 ){
      case CHOIX_UN :{
                  Modification.modifierNom ();
               } break  ;
      case CHOIX_DEUX :{
                  Modification.modifierPrenom ();
               } break  ;
      case CHOIX_TROIS :{
                  Modification.modifierTelephone ();
               } break  ;
      case CHOIX_QUATRE :{
                  Modification.modifierEmail ();
               } break  ;
      case CHOIX_CINQ :{
                  Modification.modifierCategorie ();
               } break  ;
      case CHOIX_SIX :{
                  Modification.modifierContact ();
               } break  ;
      case CHOIX_UN_ :{
                  Modification.modifierNom ();
               } break  ;
      case CHOIX_DEUX_ :{
                  Modification.modifierPrenom ();
               } break  ;
      case CHOIX_TROIS_ :{
                  Modification.modifierTelephone ();
               } break  ;
      case CHOIX_QUATRE_ :{
                  Modification.modifierEmail ();
               } break  ;
      case CHOIX_CINQ_ :{
                  Modification.modifierCategorie ();
               } break  ;
      case CHOIX_SIX_ :{
                  Modification.modifierContact ();
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
