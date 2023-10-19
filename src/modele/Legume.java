package modele;

public class Legume {
	
	public enum LEGUME {CAROTTE, RADIS, CHOU, OIGNON, CHOU_FLEUR, PANAIS, CHAMPIGNONS, LAITUE};
	protected LEGUME legume;
	protected double x;
	protected double y;

	public Legume() {
		super();
	}	
	public Legume(LEGUME legume) {
		super();
		this.legume = legume;
		this.x = 0;
		this.y = 0;
	}
	
	public Legume(LEGUME legume, double x, double y) {
		super();
		this.legume = legume;
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public LEGUME getLegume() {
		return legume;
	}
	public void setLegume(LEGUME legume) {
		this.legume = legume;
	}

	
}
