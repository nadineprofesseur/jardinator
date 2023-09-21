package vue;
import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurJardinator;

public class VueJardinator extends Vue {

	protected ControleurJardinator controleur;
	protected static VueJardinator instance = null; 
	public static VueJardinator getInstance() {if(null==instance)instance = new VueJardinator();return VueJardinator.instance;}; 
	
	private VueJardinator() 
	{
		super("jardinator.fxml", VueJardinator.class, 1294,743);
		super.controleur = this.controleur = new ControleurJardinator();
		Logger.logMsg(Logger.INFO, "new VueJardinator()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		
		/*
		Button actionCalculatrice = (Button) lookup("#action-calculatrice");
		actionCalculatrice.setOnAction(new EventHandler<ActionEvent>() 
		{
            @Override public void handle(ActionEvent e) 
            {
            	Logger.logMsg(Logger.INFO, "Bouton Calculatrice activé");
            	controleur.notifierEvenement(ActionNavigation.CALCULATRICE);
            }
        });
		*/

	}
}
