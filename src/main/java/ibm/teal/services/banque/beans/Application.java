package ibm.teal.services.banque.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Application implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5272343140214280409L;

	@Id @GeneratedValue
	private Long id_application;
	
	@ManyToOne
	private Client client;
	
	@Column(name = "pack", unique = false, nullable = false)
	private String pack;
	
	@ManyToOne
	private ECMDocumentInfo docAttached;
	
	@Column(name = "decision", unique = false, nullable = false)
	private String decision;
	
	@Column(name = "Eligibility", unique = false, nullable = false)
	private String Eligibility;
	
	@Column(name = "Submit", unique = false, nullable = false)
	private String Submit;

	
	public Long getId_application() {
		return id_application;
	}

	public void setId_application(Long id_application) {
		this.id_application = id_application;
	}


	
	
	
	public Application() {
		super();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public ECMDocumentInfo getDocAttached() {
		return docAttached;
	}

	public void setDocAttached(ECMDocumentInfo docAttached) {
		this.docAttached = docAttached;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getEligibility() {
		return Eligibility;
	}

	public void setEligibility(String eligibility) {
		Eligibility = eligibility;
	}

	public String getSubmit() {
		return Submit;
	}

	public void setSubmit(String submit) {
		Submit = submit;
	}
	 	
	
}
