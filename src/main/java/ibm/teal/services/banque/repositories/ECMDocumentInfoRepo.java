package ibm.teal.services.banque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ibm.teal.services.banque.beans.ECMDocumentInfo;

@Repository
public interface ECMDocumentInfoRepo extends JpaRepository<ECMDocumentInfo, Long> {

}
