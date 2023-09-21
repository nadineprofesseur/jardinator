package vue;
import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurJardinator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import modele.Legume;

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

		Button choisirCarotte = (Button)lookup("#action-choisir-carotte");
		choisirCarotte.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				System.out.println("Clic choisir carotte !");
				controleur.notifierChoixSemis(Legume.LEGUME.CAROTTE);
				
			}});
				
		// POC = Proof Of Concept => que on peut faire apparaitre une image sur le jardin
		
		// Position du clic est détectée par le Rectangle (#jardin-terre)
		// L'image est ajoutée sur le AnchorPane (#jardin-cloture)
		Rectangle jardin = (Rectangle)lookup("#jardin-terre");
		jardin.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent clic) {
				
				System.out.println("Clic pour planter un semis");
				double x = clic.getX();
				double y = clic.getY();
				System.out.println("Clic a ("+x+","+y+")");
				
				
				ImageView carottePlantee = new ImageView();
				carottePlantee.setImage(new Image("vue/decoration/semis/carotte.png"));
				carottePlantee.setPreserveRatio(true);
				carottePlantee.setFitHeight(100);
				carottePlantee.setX(x - 15);
				carottePlantee.setY(y - 50); 
				
				AnchorPane cloture = (AnchorPane)lookup("#jardin-cloture");
				cloture.getChildren().add(carottePlantee);				

			}});
	}
}
