package web;

import java.util.ArrayList;
import java.util.List;

import bean.Visiter;

public class VisiterModele {
	List<Visiter> visiters = new ArrayList<>();

	public List<Visiter> getVisiters() {
		return visiters;
	}

	public void setVisiters(List<Visiter> visiters) {
		this.visiters = visiters;
	}
}
