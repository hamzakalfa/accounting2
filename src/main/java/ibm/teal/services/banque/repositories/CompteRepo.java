package ibm.teal.services.banque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ibm.teal.services.banque.beans.Client;
import ibm.teal.services.banque.beans.Compte;

@Repository
public interface CompteRepo extends JpaRepository<Compte, Long>{

	
	public Compte findByNumerodecompte(Long numerodecompte);

	@Query("select c from Client c join c.compte a where a.numerodecompte=?1")
	public Client findClientByAccount(long numerodecompte);
}
