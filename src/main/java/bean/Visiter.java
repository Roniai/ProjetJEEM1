package bean;

//Indique la date au format SQL que le JDBC peut comprendre
import java.sql.Date;

public class Visiter{
	private VisiterId id;
	private Date date;
	
	public Visiter() {}

	public Visiter(VisiterId id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}

	public VisiterId getId() {
		return id;
	}

	public void setId(VisiterId id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Visiter [id=" + id + ", date=" + date + "]";
	}
}
