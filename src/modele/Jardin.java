package modele;

import java.util.ArrayList;
import java.util.List;

import donnee.Exportable;

public class Jardin implements Exportable {

	protected List<Legume> legumesDuJardin;
	
	public Jardin() {
		this.legumesDuJardin = new ArrayList<Legume>();
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
		for(Legume legume:this.legumesDuJardin)
		{
			xml+=legume.exporterXML();
		}
		return "<jardin>" + xml + "</jardin>";
	}

	@Override
	public String exporterJSON() {
		return "";
	}

}
