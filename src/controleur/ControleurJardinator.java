package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import donnee.Exportable;
import donnee.Exporteur;
import modele.Jardin;
import modele.Legume;
import modele.Legume.LEGUME;
import vue.VueJardinator;

public class ControleurJardinator extends Controleur{

	private Legume.LEGUME legumeChoisi;
	//private List<Exportable> legumesDuJardin = null; // DECLARATION du nom du pointeur
	private Jardin jardin = new Jardin();
	
	public ControleurJardinator()
	{
		Logger.logMsg(Logger.INFO, "new ControleurJardinator()");
		//this.legumesDuJardin = new ArrayList<Exportable>(); // INSTANTIATION
	}
	
	public void initialiser()
	{
		
	}

	public void notifierChoixSemis(LEGUME legume) {
		
		this.legumeChoisi = legume;
	}

	public void notifierClicJardin(double x, double y) {
		System.out.println("ControleurJardinator.notifierClicJardin()");
		VueJardinator.getInstance().planterSemis(this.legumeChoisi, x,y);
		Legume legume = new Legume(this.legumeChoisi, x, y);
		//this.legumesDuJardin.add(legume);
		//this.jardin.getLegumesDuJardin().add(legume); // bris d'encapsulation
		this.jardin.ajouterLegume(legume); // encapsulation respectee
	}

	public void notifierChoixTerrain(Jardin.TERRAIN terrain) {
		System.out.println("ControleurJardinator.notifierChoixTerrain()");
		VueJardinator.getInstance().afficherTerrain(terrain);
		this.jardin.setTerrain(terrain);
	}

	public void notifierSauvegarder() {
		System.out.println("ControleurJardinator.notifierSauvegarder()");		
		Exporteur exporteur = new Exporteur();
		//exporteur.sauvegarder(legumesDuJardin);
		exporteur.sauvegarder(jardin);
	}
	
	

}
