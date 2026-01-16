package fr.insa.project.OrchestratorMS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="service_urls")

public class ServiceUrl {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="service_name")
	private String serviceName;
	
	private String url;
	
	public ServiceUrl() {}
	
	public ServiceUrl(String url, String name) {
		this.serviceName = name;
		this.url = url;
	}
	
	public void SetId(long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void SetserviceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getserviceName() {
		return serviceName; 
	}
	
	public void SetserviceUrl(String serviceUrl) {
		this.url = serviceUrl;
	}	
	public String getserviceUrl() {
		return url; 
	}
	



	
}
