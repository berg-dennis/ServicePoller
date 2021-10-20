package kry.codetest.Controller;


import kry.codetest.Entities.ServiceEntity;
import kry.codetest.Service.ServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @Autowired
    private final ServiceService ss;

    public ServiceController(ServiceService ss) {
        this.ss = ss;
    }

    @GetMapping("/services")
    public ResponseEntity<List<ServiceEntity>> getServices(){
        return new ResponseEntity<List<ServiceEntity>>(ss.getServices(),HttpStatus.OK);
    }

    @PostMapping("/services/add")
    public ResponseEntity<String> addService (@RequestBody Map<String, Object> service) throws MalformedURLException {
        System.out.println("adding new service");
        return ss.addService(service);

    }

    @PutMapping("/services/update")
    public ResponseEntity<ServiceEntity> updateService(@RequestBody ServiceEntity service){
        ServiceEntity updateService = ss.updateService(service);
        return new ResponseEntity<ServiceEntity>(updateService, HttpStatus.OK);
    }

    @DeleteMapping("/services/delete/{id}")
    public ResponseEntity<String> deleteService(@PathVariable("id") String id){
        ss.deleteService(id);
        return new ResponseEntity<String>("Service with id: " + id +" has been deleted",
                HttpStatus.OK);
    }



}
