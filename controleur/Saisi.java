package controleur ;

import java.util.Scanner ;
import java.util.regex.*;

public class Saisi
{
	static Scanner  clavier = new Scanner (System.in);

	public static int entier ()
	{
		int var = clavier.nextInt() ;
		  clavier.nextLine();
		return var;
	}
	public static long lgentier ()
	{
		long var = clavier.nextLong() ;
		  clavier.nextLine();
		return var;
	}
	public static short ptentier ()
	{
		short var = clavier.nextShort() ;
		  clavier.nextLine();
		return var;
	}
	public static String chaine ()
	{
		String var = clavier.nextLine() ;
		return var;
	}
	public static float reel ()
	{
		float var  = clavier.nextFloat() ;
		  clavier.nextLine();
		return var;
	}
	public static double lgreel ()
	{
		double var = clavier.nextDouble() ;
		  clavier.nextLine();
		return var;
	}
	public static double controle ( int mini , int maxi )
	{
	    int i=0 ;   double n ;
	    do {
	         if (i>0) System.out.print("comprix entre "+mini+" et "+maxi+" SVP : " );
	          n = clavier.nextDouble() ;
	            clavier.nextLine();
	         i++ ;
	       }
	    while (n < mini || n > maxi) ;
	return n ;
	}

	public static String controle ()
	{
	    int i=0 ;   String chaine = null ;
	    do {
	         if (i > 0) {
	         	System.out.println("\n **** Cette informations est obligatoire ****\n" );
	         	System.out.print("        **** Veillez le renseignez SVP : " );
				}
	          chaine = clavier.nextLine() ;
	         i++ ;
	       }
	    while ( chaine.length() == 0 ) ;
	return chaine ;
	}

	public static String prenomControle ()
	{
	    int i=0 ;   String chaine = "" ; boolean correct = false ;
	    do {
	         if (i > 0 && chaine.length() < 40 ) {
	         	System.out.println("\n **** Cette informations est obligatoire ****\n" );
	         	System.out.print("       **** Veillez le renseignez SVP : " );
				} else if (chaine.length() > 40) {
	         	System.out.println("\n **** Ce prenom est trop long ****\n" );
	         	System.out.print("       **** Veillez changer SVP       : " );
				}
	          chaine = clavier.nextLine() ;

	          if (chaine.length() < 40 && chaine.length() > 0 ) correct = true;
	         i++ ;
	       }
	    while ( !correct ) ;
	return chaine ;
	}

	public static String nomControle ()
	{
	    int i=0 ;   String chaine = "" ; boolean correct = false ;
	    do {
	         if (i > 0 && chaine.length() < 20 ) {
	         	System.out.println("\n **** Cette informations est obligatoire ****\n" );
	         	System.out.print("       **** Veillez le renseignez SVP : " );
				} else if (chaine.length() > 20) {
	         	System.out.println("\n **** Ce nom est trop long ****\n" );
	         	System.out.print("       **** Veillez changer SVP       : " );
				}
	          chaine = clavier.nextLine() ;

	          if (chaine.length() < 20 && chaine.length() > 0 ) correct = true;
	         i++ ;
	       }
	    while ( !correct ) ;
	return chaine ;
	}

	public static String prenom ()
	{
	    int i=0 ;   String chaine = null ; boolean correct = false ;
	    do {
	         if (i > 0 && chaine.length() > 40 ) {
	         	System.out.println("\n **** Ce prenom est trop long ****\n" );
	         	System.out.print("       **** Veillez changer SVP       : " );
				}
	          chaine = clavier.nextLine() ;

	          if (chaine.length() < 40 ) correct = true;
	         i++ ;
	       }
	    while ( !correct ) ;
	return chaine ;
	}

	public static String nom ()
	{
	    int i=0 ;   String chaine = null ; boolean correct = false ;
	    do {
	         if (i > 0 && chaine.length() > 20 ) {
	         	System.out.println("\n **** Ce nom est trop long ****\n" );
	         	System.out.print("       **** Veillez changer SVP       : " );
				}
	          chaine = clavier.nextLine() ;

	          if (chaine.length() < 20 ) correct = true;
	         i++ ;
	       }
	    while ( !correct ) ;
	return chaine ;
	}

	public static String telephone ()
	{
	   int i=0 ;   String chaine = null ; boolean correct = false ;
		do {
			if (i > 0) {
				System.out.println("\n**** Ce numero n'est pas correct ****\n" );
				System.out.print("  **** Veillez rentrez un bon numero SVP : " );
			}
			chaine = clavier.nextLine() ;
			Pattern telephonePattern = Pattern
				.compile("^(((00)|\\+)?[- ]?(221)?[- ]?(77|76|78|70)[- ]?[0-9]{3}[- ]?[0-9]{2}[- ]?[0-9]{2})?$");
			Matcher telephone = telephonePattern.matcher(chaine) ;
			correct = telephone.matches();
			i++ ;
		} while ( !correct ) ;
	return chaine ;
	}

	public static String email ()
	{
	   int i=0 ;   String chaine = null ; boolean correct = false ;
		do {
			if (i > 0) {
				System.out.println("\n **** Cet email n'est pas correct ****\n" );
				System.out.print(" **** Veillez rentrez une bonne adresse email SVP : " );
			}
			chaine = clavier.nextLine() ;
			Pattern emailPattern = Pattern.compile("^([0-9a-zA-Z_]+@[a-z]+\\.[a-z]+)?$");
			Matcher email = emailPattern.matcher(chaine) ;
			correct = email.matches();
			i++ ;
		} while ( !correct ) ;
	return chaine ;
	}

	public static String categorie ()
	{
	   int i=0 ;   String chaine = null ; boolean correct = false ;
		do {
			if (i > 0) {
				System.out.println("\n **** Categorie incorrect ****\n" );
				System.out.print("      **** Veillez reessayez SVP : " );
			}
			chaine = clavier.nextLine() ;
			Pattern categoriesPattern = Pattern
				.compile("^(favori|ami|famille|professionnel)?$");
			Matcher categorie = categoriesPattern.matcher(chaine) ;
			correct = categorie.matches();
			i++ ;
		} while ( !correct ) ;
	return chaine ;
	}

	public static String searchCategorie ()
	{
	   int i=0 ;   String chaine = null ; boolean correct = false ;
		do {
			if (i > 0) {
				System.out.println("\n **** formalisme incorrect ****\n" );
				System.out.print("        **** Veillez reessayez SVP : " );
			}
			chaine = clavier.nextLine() ;
			Pattern categoriesPattern = Pattern
				.compile("^((-?(favori|ami|famille|professionnel)){1,4})?$");
			Matcher categories = categoriesPattern.matcher(chaine) ;
			correct = categories.matches();
			i++ ;
		} while ( !correct ) ;
	return chaine ;
	}


}

