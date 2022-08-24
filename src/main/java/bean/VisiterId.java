package bean;

import java.io.Serializable;

public class VisiterId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String codemed;
	private String codepat;
	
	public VisiterId() {}

	public VisiterId(String codemed, String codepat) {
		super();
		this.codemed = codemed;
		this.codepat = codepat;
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

	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result + ((codemed == null) ? 0 : codemed.hashCode());
        result = prime * result + ((codepat == null) ? 0 : codepat.hashCode());
        return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VisiterId other = (VisiterId) obj;
        if (codemed == null) {
            if (other.codemed != null)
                return false;
        } else if (!codemed.equals(other.codemed))
            return false;
        if (codepat == null) {
            if (other.codepat != null)
                return false;
        } else if (!codepat.equals(other.codepat))
            return false;
        return true;
	}
	
}
