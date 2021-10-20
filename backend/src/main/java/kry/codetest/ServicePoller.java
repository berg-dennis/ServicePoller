package kry.codetest;

import kry.codetest.Entities.ServiceEntity;
import kry.codetest.Repository.ServiceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ServicePoller {
    private static Logger logger = LoggerFactory.getLogger(ServicePoller.class);
    private final ServiceRepo serviceRepo;
    private final RestTemplate restTemplate;
    private static String OK = "OK";
    private static String FAIL = "FAIL";

    public ServicePoller(ServiceRepo serviceRepo, RestTemplate restTemplate) {
        this.serviceRepo = serviceRepo;
        this.restTemplate = restTemplate;
    }

    @Async("asyncExecutor")
    @Scheduled(fixedRate = 10000)
    @Transactional
    public void scheduledTask() throws InterruptedException{
        List<ServiceEntity> serviceList = serviceRepo.findAllServiceEntity().collect(Collectors.toList());

        for (int i = 0; i < serviceList.size(); i++) {
            String url = serviceList.get(i).getServiceUrl().toString();
            try{
                ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
                HttpStatus statusCode = response.getStatusCode();
                serviceList.get(i).setHttpStatus(OK);
                logger.info(serviceList.get(i).getServiceName() + " " + serviceList.get(i).getServiceUrl().toString() + " " + serviceList.get(i).getHttpStatus().toString());
            } catch (Exception e) {
                serviceList.get(i).setHttpStatus(FAIL);
                logger.info(serviceList.get(i).getServiceName() + " " + serviceList.get(i).getServiceUrl().toString() + " " + serviceList.get(i).getHttpStatus().toString());
            }
        }

    }




}
