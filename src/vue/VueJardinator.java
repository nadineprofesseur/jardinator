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
import modele.Legume.LEGUME;

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
		Button choisirChou = (Button)lookup("#action-choisir-chou");
		choisirChou.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				System.out.println("Clic choisir chou !");
				controleur.notifierChoixSemis(Legume.LEGUME.CHOU);
				
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
				
				controleur.notifierClicJardin(x,y);

			}
			
		
		});
		
		Button actionChoisirTerrainTerre = (Button)lookup("#action-choisir-terrain-terre");
		Button actionChoisirTerrainEnclos = (Button)lookup("#action-choisir-terrain-enclos");
		Button actionChoisirTerrainRang = (Button)lookup("#action-choisir-terrain-rang");
		Button actionChoisirTerrainBacs = (Button)lookup("#action-choisir-terrain-bacs");
		
		actionChoisirTerrainTerre.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Choisir le terrain TERRE");		
				afficherTerrain(1);
			}});
		actionChoisirTerrainEnclos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Choisir le terrain ENCLOS");				
				afficherTerrain(2);
			}});
		actionChoisirTerrainRang.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Choisir le terrain RANG");				
				afficherTerrain(3);
			}});
		actionChoisirTerrainBacs.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Choisir le terrain BACS");				
				afficherTerrain(4);
			}});

	}
	
	public void afficherTerrain(int numeroTerrain)
	{
		AnchorPane cloture = (AnchorPane)lookup("#jardin-cloture");
		System.out.println(cloture);
		switch(numeroTerrain)
		{
		case 1:// TERRE
			cloture.setStyle("-fx-background-image:url('vue/decoration/terrain/terrain-terre.png');");
			break;
		case 2: // ENCLOS
			cloture.setStyle("-fx-background-image:url('vue/decoration/terrain/terrain-enclos.png');");
			break;
		case 3: // RANGS
			cloture.setStyle("-fx-background-image:url('vue/decoration/terrain/terrain-rangs.png');");
			break;
		case 4: // BACS
			cloture.setStyle("-fx-background-image:url('vue/decoration/terrain/terrain-bacs.png');");
			break;
		default:
			cloture.setStyle("-fx-background-image:url('vue/decoration/terrain/terrain.png');");
		break;
			
		}
	}
	
	public void planterSemis(LEGUME legumeChoisi, double x, double y)
	{
		ImageView legumePlante = new ImageView();
		if(legumeChoisi == LEGUME.CAROTTE)
			legumePlante.setImage(new Image("vue/decoration/semis/carotte.png"));
		if(legumeChoisi == LEGUME.CHOU)
			legumePlante.setImage(new Image("vue/decoration/semis/chou.png"));
			
		legumePlante.setPreserveRatio(true);
		legumePlante.setFitHeight(100);
		legumePlante.setX(x - 15);
		legumePlante.setY(y - 50); 
		
		AnchorPane cloture = (AnchorPane)lookup("#jardin-cloture");
		cloture.getChildren().add(legumePlante);				
	}
}
