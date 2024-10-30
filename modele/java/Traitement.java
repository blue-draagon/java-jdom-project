package modele.java;

public class Traitement {
//--------------------------------------------------
	/* Variables et constante utilitaite */
//--------------------------------------------------
	final static String SPACE   = " ";
	final static String TIRET   = "-";
  final static String VIDE    = "";
  final static String T221    = "+221";

  final static int NEUF   = 9 ;
  final static int ZERO   = 0 ;
	static final int DEUX   = 2 ;
	static final int CINQ   = 5 ;
	static final int SEPT   = 7 ;

//###########################################################################################
	//					                  	FONCTIONS UTILITAIRES
//###########################################################################################

//--------------------------------------------------
	/* Enregistrer le telephone selon un bon format */
//--------------------------------------------------
	public static String formatTelephone (String telephone) {
		String temp = telephone.replaceAll( SPACE+"|"+TIRET, VIDE );

		String formatedTelephone = VIDE ;

		if (temp.length() == NEUF ) {
			String telephonePartieDeux   = temp.substring ( ZERO, DEUX);
			String telephonePartieTrois  = temp.substring ( DEUX, CINQ);
			String telephonePartieQuatre = temp.substring ( CINQ, SEPT);
			String telephonePartieCinq   = temp.substring ( SEPT );

			formatedTelephone =
				T221 +
				TIRET +
				telephonePartieDeux +
				TIRET +
				telephonePartieTrois +
				TIRET +
				telephonePartieQuatre +
				TIRET +
				telephonePartieCinq ;
		} else {
			temp = temp.substring(temp.length() - NEUF );
			String telephonePartieDeux   = temp.substring ( ZERO, DEUX);
			String telephonePartieTrois  = temp.substring ( DEUX, CINQ);
			String telephonePartieQuatre = temp.substring ( CINQ, SEPT);
			String telephonePartieCinq   = temp.substring ( SEPT );

			formatedTelephone =
				T221 +
				TIRET +
				telephonePartieDeux +
				TIRET +
				telephonePartieTrois +
				TIRET +
				telephonePartieQuatre +
				TIRET +
				telephonePartieCinq ;
		}

		return formatedTelephone ;
	}

}
