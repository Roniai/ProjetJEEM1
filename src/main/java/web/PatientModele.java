package web;

import java.util.ArrayList;
import java.util.List;

import bean.Patient;

public class PatientModele {
	private String motCle;
	List<Patient> patients = new ArrayList<>();
	
	public String getMotCle(){
		return motCle;
	}
	public void setMotCle(String motCle){
		this.motCle = motCle;
	}
	public List<Patient> getPatients(){
		return patients;
	}
	public void setPatients(List<Patient> patients){
		this.patients = patients;
	}
}
