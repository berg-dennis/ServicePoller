package kry.codetest.Service;

import kry.codetest.Entities.ServiceEntity;
import kry.codetest.Repository.ServiceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class ServiceService {

    private final ServiceRepo serviceRepo;
    private static Logger logger = LoggerFactory.getLogger(ServiceService.class);

    public ServiceService(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }


    public ResponseEntity<String> addService(Map <String, Object> requestBody) throws MalformedURLException {
        String serviceName = requestBody.get("serviceName").toString().toLowerCase();
        String serviceURL = requestBody.get("serviceUrl").toString().toLowerCase();
        ServiceEntity newService = new ServiceEntity();
        newService.setServiceName(serviceName);
        newService.setServiceUrl(new URL(serviceURL));
        newService.setCreationTime(LocalDateTime.now());
        serviceRepo.save(newService);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    public List<ServiceEntity> getServices(){
        return serviceRepo.findAll();
    }

    public ServiceEntity updateService(ServiceEntity service){
        return serviceRepo.save(service);
    }

    public void deleteService(String id){
        serviceRepo.deleteById(id);
    }

}
