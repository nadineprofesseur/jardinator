package vue;
import com.sun.media.jfxmedia.logging.Logger;

import architecture.Vue;
import controleur.ControleurJardinator;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import modele.Jardin;
import modele.Jardin.TERRAIN;
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
		
		Button choisirRadis = (Button)lookup("#action-choisir-radis");
		choisirRadis.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				System.out.println("Clic choisir radis !");
				controleur.notifierChoixSemis(Legume.LEGUME.RADIS);
				
			}});
				
		Button choisirChou = (Button)lookup("#action-choisir-chou");
		choisirChou.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				System.out.println("Clic choisir radis !");
				controleur.notifierChoixSemis(Legume.LEGUME.CHOU);
				
			}});
		
		Button choisirOignon = (Button)lookup("#action-choisir-oignon");
		choisirOignon.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				System.out.println("Clic choisir oignon !");
				controleur.notifierChoixSemis(Legume.LEGUME.OIGNON);
				
			}});
		
		Button choisirChouFleur = (Button)lookup("#action-choisir-choufleur");
		choisirChouFleur.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				System.out.println("Clic choisir chou-fleur !");
				controleur.notifierChoixSemis(Legume.LEGUME.CHOU_FLEUR);
				
			}});
		
		Button choisirPanais = (Button)lookup("#action-choisir-panais");
		choisirPanais.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				System.out.println("Clic choisir panais !");
				controleur.notifierChoixSemis(Legume.LEGUME.PANAIS);
				
			}});
		
		Button choisirChampignon = (Button)lookup("#action-choisir-champignon");
		choisirChampignon.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				System.out.println("Clic choisir champignons !");
				controleur.notifierChoixSemis(Legume.LEGUME.CHAMPIGNONS);
				
			}});
		
		Button choisirLaitue = (Button)lookup("#action-choisir-laitue");
		choisirLaitue.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				System.out.println("Clic choisir champignons !");
				controleur.notifierChoixSemis(Legume.LEGUME.LAITUE);
				
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
				controleur.notifierChoixTerrain(Jardin.TERRAIN.TERRE);
			}});
		actionChoisirTerrainEnclos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Choisir le terrain ENCLOS");	
				controleur.notifierChoixTerrain(Jardin.TERRAIN.ENCLOS);
			}});
		actionChoisirTerrainRang.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Choisir le terrain RANG");				
				controleur.notifierChoixTerrain(Jardin.TERRAIN.RANGS);
			}});
		actionChoisirTerrainBacs.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Choisir le terrain BACS");				
				controleur.notifierChoixTerrain(Jardin.TERRAIN.BACS);
			}});
		
		Button actionSauvegarder = (Button)lookup("#action-sauvegarder");
		actionSauvegarder.setOnAction(new EventHandler() {

			@Override
			public void handle(Event e) {
				System.out.println("Action de sauvegarder");				
				controleur.notifierSauvegarder();
				
			}});

	}
	
	public void afficherTerrain(TERRAIN terrain)
	{
		AnchorPane cloture = (AnchorPane)lookup("#jardin-cloture");
		System.out.println(cloture);
		switch(terrain)
		{
		case TERRE:// TERRE
			cloture.setStyle("-fx-background-image:url('vue/decoration/terrain/terrain-terre.png');");
			break;
		case ENCLOS: // ENCLOS
			cloture.setStyle("-fx-background-image:url('vue/decoration/terrain/terrain-enclos.png');");
			break;
		case RANGS: // RANGS
			cloture.setStyle("-fx-background-image:url('vue/decoration/terrain/terrain-rangs.png');");
			break;
		case BACS: // BACS
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
		if(legumeChoisi == LEGUME.RADIS)
			legumePlante.setImage(new Image("vue/decoration/semis/radis.png"));
		if(legumeChoisi == LEGUME.CHOU)
			legumePlante.setImage(new Image("vue/decoration/semis/chou.png"));
		if(legumeChoisi == LEGUME.OIGNON)
			legumePlante.setImage(new Image("vue/decoration/semis/oignon.png"));
		if(legumeChoisi == LEGUME.CHOU_FLEUR)
			legumePlante.setImage(new Image("vue/decoration/semis/chou-fleur.png"));
		if(legumeChoisi == LEGUME.CHAMPIGNONS)
			legumePlante.setImage(new Image("vue/decoration/semis/champignon.png"));
		if(legumeChoisi == LEGUME.PANAIS)
			legumePlante.setImage(new Image("vue/decoration/semis/panais.png"));
		if(legumeChoisi == LEGUME.LAITUE)
			legumePlante.setImage(new Image("vue/decoration/semis/laitue.png"));
			
		legumePlante.setPreserveRatio(true);
		legumePlante.setFitHeight(100);
		legumePlante.setX(x - 15);
		legumePlante.setY(y - 50); 
		
		AnchorPane cloture = (AnchorPane)lookup("#jardin-cloture");
		cloture.getChildren().add(legumePlante);
	}
}
