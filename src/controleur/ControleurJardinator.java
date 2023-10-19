package controleur;

import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.Legume;
import modele.Legume.LEGUME;
import vue.VueJardinator;

public class ControleurJardinator extends Controleur{

	private Legume.LEGUME legumeChoisi;
	private List<Legume> legumesDuJardin = null; // DECLARATION du nom du pointeur
	
	public ControleurJardinator()
	{
		Logger.logMsg(Logger.INFO, "new ControleurJardinator()");
		this.legumesDuJardin = new ArrayList<Legume>(); // INSTANTIATION
	}
	
	public void initialiser()
	{
		
	}

	public void notifierChoixSemis(LEGUME legume) {
		
		this.legumeChoisi = legume;
	}

	public void notifierClicJardin(double x, double y) {
		VueJardinator.getInstance().planterSemis(this.legumeChoisi, x,y);
		Legume legume = new Legume(this.legumeChoisi, x, y);
		this.legumesDuJardin.add(legume);
	}

	public void notifierChoixTerrain(int numeroTerrain) {
		VueJardinator.getInstance().afficherTerrain(numeroTerrain);
	}
	
	

}
