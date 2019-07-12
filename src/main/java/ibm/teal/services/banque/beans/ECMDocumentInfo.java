package ibm.teal.services.banque.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ECMDocumentInfo {

	
	@Id @GeneratedValue
	private Long id_document;
	
	@OneToMany
	private List<Client> client;
	
	@Column(name = "contentURL", unique = false, nullable = false)
	private String contentURL;
	
	@Column(name = "objectId", unique = false, nullable = false)
	private String objectId ;
	
	@Column(name = "serverName", unique = false, nullable = false)
	private String serverName;

	@OneToMany(mappedBy="docAttached")
	private List<Application> application;
	

	public List<Client> getClient() {
		return client;
	}
	
	public void setClient(List<Client> client) {
		this.client = client;
	}
	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	

	public Long getId_document() {
		return id_document;
	}

	public void setId_document(Long id_document) {
		this.id_document = id_document;
	}

	public ECMDocumentInfo() {
		super();
	}

	public String getContentURL() {
		return contentURL;
	}

	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	
}
