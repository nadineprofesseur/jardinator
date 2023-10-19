package modele;

import java.util.ArrayList;
import java.util.List;

import donnee.Exportable;

public class Jardin implements Exportable {

	public enum TERRAIN {BACS, ENCLOS, TERRE, RANGS, AUCUN};
	protected TERRAIN terrain = TERRAIN.AUCUN;

	protected List<Legume> legumesDuJardin;
	
	public Jardin() {
		this.legumesDuJardin = new ArrayList<Legume>();
	}
	public TERRAIN getTerrain() {
		return terrain;
	}

	public void setTerrain(TERRAIN terrain) {
		this.terrain = terrain;
	}
	
	public List<Legume> getLegumesDuJardin() {
		return legumesDuJardin;
	}

	public void setLegumesDuJardin(List<Legume> legumesDuJardin) {
		this.legumesDuJardin = legumesDuJardin;
	}
	
	public void ajouterLegume(Legume legume)
	{
		this.legumesDuJardin.add(legume);
	}


	@Override
	public String exporterXML() {
		
		String xml = "";
		xml += "<terrain>" + this.terrain + "</terrain>";
		xml += "<legumes>";
		for(Legume legume:this.legumesDuJardin)
		{
			xml+=legume.exporterXML();
		}
		xml += "</legumes>";
		return "<jardin>" + xml + "</jardin>";
	}

	@Override
	public String exporterJSON() {
		return "";
	}

}
