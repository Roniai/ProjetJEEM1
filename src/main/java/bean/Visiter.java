package bean;

//Indique la date au format SQL que le JDBC peut comprendre
import java.sql.Date;

public class Visiter {
	private int id;
	private String codemed;
	private String codepat;
	private Date date;
	
	public Visiter() {}

	public Visiter(String codemed, String codepat, Date date) {
		super();
		this.codemed = codemed;
		this.codepat = codepat;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodemed() {
		return codemed;
	}

	public void setCodemed(String codemed) {
		this.codemed = codemed;
	}

	public String getCodepat() {
		return codepat;
	}

	public void setCodepat(String codepat) {
		this.codepat = codepat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Visiter [id=" + id + ", codemed=" + codemed + ", codepat=" + codepat + ", date=" + date + "]";
	}
	
}
