package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import modele.Legume;
import modele.Legume.LEGUME;
import vue.VueJardinator;

public class ControleurJardinator extends Controleur{

	private Legume.LEGUME legumeChoisi;
	
	public ControleurJardinator()
	{
		Logger.logMsg(Logger.INFO, "new ControleurJardinator()");
	}
	
	public void initialiser()
	{
		
	}

	public void notifierChoixSemis(LEGUME legume) {
		
		this.legumeChoisi = legume;
	}

	public void notifierClicJardin(double x, double y) {
		VueJardinator.getInstance().planterSemis(this.legumeChoisi, x,y);		
	}

	public void notifierChoixTerrain(int numeroTerrain) {
		VueJardinator.getInstance().afficherTerrain(numeroTerrain);
	}
	
	

}
