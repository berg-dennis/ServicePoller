package kry.codetest.Entities;


import org.springframework.http.HttpStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URL;
import java.time.LocalDateTime;

@Entity
public class ServiceEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false)
    private LocalDateTime creationTime;

    @Column(nullable = false)
    private URL serviceUrl;

    private String httpStatus;

    public ServiceEntity(Long id, String serviceName, LocalDateTime creationTime, URL serviceUrl, String httpStatus) {
        this.id = id;
        this.serviceName = serviceName;
        this.creationTime = creationTime;
        this.serviceUrl = serviceUrl;
        this.httpStatus = httpStatus;
    }

    public ServiceEntity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public URL getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(URL serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }
}
