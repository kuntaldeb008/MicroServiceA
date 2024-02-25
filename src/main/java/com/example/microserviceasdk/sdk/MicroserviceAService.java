package com.example.microserviceasdk.sdk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicroserviceAService {

	private final RestTemplate restTemplate;
	
	
    private List<String> data = List.of("Data1", "Data2", "Data3");
    
    /*
	 * to fix restTemplate null issue in Microservice B while running it create a RestTemplate bean in your MicroserviceBApplication class 
	 * and inject it into this MicroserviceAService using @Autowired
	 */
	@Autowired
    public MicroserviceAService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("unchecked")
	public List<String> getDataFromMicroServiceAApi() {
        String microserviceAUrl = "http://localhost:8081/get/data";
       return restTemplate.getForObject(microserviceAUrl, List.class);
        //return (List<String>) restTemplate.getForEntity(microserviceAUrl, List.class);
    }
    
    public List<String> returnDataFromServiceA(){
    	return data;
    }
}
