package web;

import java.util.ArrayList;
import java.util.List;

import bean.Medecin;

public class MedecinModele {
	List<Medecin> medecins = new ArrayList<>();

	public List<Medecin> getMedecins() {
		return medecins;
	}

	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}
}
