package modele;

public class Legume {
	
	public enum LEGUME {CAROTTE, RADIS, CHOU, OIGNON, CHOU_FLEUR, PANAIS, CHAMPIGNONS, LAITUE};
	protected LEGUME legume;
	
	public Legume()
	{
		
	}
	public Legume(LEGUME legume)
	{
		this.legume = legume;
	}
	
	public LEGUME getLegume() {
		return legume;
	}
	public void setLegume(LEGUME legume) {
		this.legume = legume;
	}

	
}
