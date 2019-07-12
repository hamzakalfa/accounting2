package ibm.teal.services.banque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibm.teal.services.banque.beans.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

	public Client findByIDNumber(String iDNumber);

	/*@Query("select c from Client c where c.compte=?1")
	public Client findByAccount(String id);*/
}
