package bean;

public class Visiter {
	private int id;
	private String codemed;
	private String codepat;
	private String date;
	
	public Visiter() {}

	public Visiter(String codemed, String codepat, String date) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Visiter [id=" + id + ", codemed=" + codemed + ", codepat=" + codepat + ", date=" + date + "]";
	}
	
}
