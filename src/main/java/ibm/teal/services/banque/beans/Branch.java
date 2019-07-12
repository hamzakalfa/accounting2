package ibm.teal.services.banque.beans;

import javax.persistence.Column;

public class Branch {

	@Column(name = "Ghandi", unique = false, nullable = false)
	private String Ghandi;

	@Column(name = "Palmier", unique = false, nullable = false)
	private String Palmier;
	
	@Column(name = "Abdelmoumen", unique = false, nullable = false)
	private String Abdelmoumen;
	
	@Column(name = "Ghautier", unique = false, nullable = false)
	private String Ghautier;

	
	public Branch() {
		super();
	}

	public String getGhandi() {
		return Ghandi;
	}

	public void setGhandi(String ghandi) {
		Ghandi = ghandi;
	}

	public String getPalmier() {
		return Palmier;
	}

	public void setPalmier(String palmier) {
		Palmier = palmier;
	}

	public String getAbdelmoumen() {
		return Abdelmoumen;
	}

	public void setAbdelmoumen(String abdelmoumen) {
		Abdelmoumen = abdelmoumen;
	}

	public String getGhautier() {
		return Ghautier;
	}

	public void setGhautier(String ghautier) {
		Ghautier = ghautier;
	}
	
	
}
