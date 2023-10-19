
import java.util.ArrayList;
import java.util.List;

import architecture.Controleur;
import architecture.Fenetre;
import donnee.Exportable;
import donnee.Exporteur;
import modele.Legume;
import vue.VueJardinator;

public class App {

	public static void main(String[] parametres) {
		Controleur.choisirVuePrincipale(VueJardinator.class);
		Fenetre.launch(Fenetre.class, parametres);	
		/*
		Legume legumeA = new Legume(Legume.LEGUME.CAROTTE, 4, 7);
		Legume legumeB = new Legume(Legume.LEGUME.CHOU, 10, 10);
		Legume legumeC = new Legume(Legume.LEGUME.CHAMPIGNONS, 200, 200);
		List<Exportable> legumesDuJardin = new ArrayList<Exportable>();
		legumesDuJardin.add(legumeA);
		legumesDuJardin.add(legumeB);
		legumesDuJardin.add(legumeC);
		
		Exporteur exporteur = new Exporteur();
		exporteur.sauvegarder(legumesDuJardin);
		*/
	}

}
