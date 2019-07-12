package ibm.teal.services.banque.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Compte implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6231884941890911114L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_compte;
	
	@Column(name = "solde", unique = false, nullable = false)	
	private String solde;
	
	@Column(name = "numerodecompte",unique = false, nullable = false)	
	private Long numerodecompte; 
	
	public Long getNumerodecompte() {
		return numerodecompte;
	}



	public void setNumerodecompte(Long numerodecompte) {
		this.numerodecompte = numerodecompte;
	}

	@ManyToOne
	private Client client;

	public Compte() {
		super();
		 Long numCompte = (long) (Math.random() *89999998) + 10000001; 
		this.setNumerodecompte(numCompte);
	}

	

	public Long getId_compte() {
		return id_compte;
	}

	public void setId_compte(Long id_compte) {
		this.id_compte = id_compte;
	}

	public String getSolde() {
		return solde;
	}

	public void setSolde(String solde) {
		this.solde = solde;
	}

	@JsonIgnore
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	

	

}
