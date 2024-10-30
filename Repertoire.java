import controleur.Affichage ;
import controleur.Saisi ;

import vue.* ;

public class Repertoire {
  public static void main(String[] args) {
    String choix = null ;
    char choix2 = BREAK ;
    while( true ) {
    	System.out.println("\n\n");
    	System.out.println("        ==================================================================") ;
      System.out.println("        =    ****              GESTION DE REPERTOIRE            ****     =") ;
      System.out.println("        =     ****                      KA75                   ****      =");
      System.out.println("        ------------------------------------------------------------------");
      System.out.println("        ==================================================================");
      System.out.println("       ||                                                                ||");
      System.out.println("       ||         [ 1-a ] -- MES CONTACTS                                ||");
      System.out.println("       ||         [ 2-b ] -- AJOUTER                                     ||");
      System.out.println("       ||         [ 3-c ] -- MODIFIER                                    ||");
      System.out.println("       ||         [ 4-d ] -- RECHERCHER                                  ||");
      System.out.println("       ||         [ 5-e ] -- SUPPRIMER                                   ||");
      System.out.println("       ||         [ 6-f ] -- CATEGORIES                                  ||");
      System.out.println("       ||         [ 0-z ] -- QUITTER                                     ||");
      System.out.println("        ------------------------------------------------------------------\n");
      System.out.print("                                          Taper votre choix : "); choix = Saisi.chaine();

      if ( choix.length() == ZERO ) { choix = CHOIX_UN + ""; }

      if ( choix.length() >= DEUX ) { choix2 = choix.charAt( UN ) ; } else choix2 = BREAK ;

      if ( choix.charAt( ZERO ) == BREAK || choix.charAt( ZERO ) == BREAK_ ) break ;

      menu : switch ( choix.charAt( ZERO ) ) {

        case CHOIX_UN     :{
                    Affichage.afficherContacts ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        case CHOIX_DEUX   :{
                    Ajouter.menuAjouter ( choix2 );
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        case CHOIX_TROIS  :{
                    Modifier.menuModifier ( choix2 );
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        case CHOIX_QUATRE :{
                    Afficher.menuAfficher ( choix2 );
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        case CHOIX_CINQ   :{
                    Supprimer.menuSupprimer ( choix2 );
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        case CHOIX_SIX    :{
                    Organiser.menuOrganiser ( choix2 );
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        case CHOIX_UN_     :{
                    Affichage.afficherContacts ();
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        case CHOIX_DEUX_   :{
                    Ajouter.menuAjouter ( choix2 );
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        case CHOIX_TROIS_  :{
                    Modifier.menuModifier ( choix2 );
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        case CHOIX_QUATRE_ :{
                    Afficher.menuAfficher ( choix2 );
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        case CHOIX_CINQ_   :{
                    Supprimer.menuSupprimer ( choix2 );
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        case CHOIX_SIX_    :{
                    Organiser.menuOrganiser ( choix2 );
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;

        default :{
                    System.out.println("\n   *****   choix incorrect   *****") ;
                    System.out.print("\n        Taper ** Entrer ** pour continuer "); Saisi.chaine();
                 } break menu ;
      }
    }
    System.out.println("\n-*-*-*-*****    AU REVOIR   *****-*-*-*-\n") ;
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
	static final int UN   = 1 ;
	static final int DEUX = 2 ;
}
