package tr.edu.itu.cavabunga.client.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import tr.edu.itu.cavabunga.client.configuration.CavabungaClientConfiguration;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.http.ComponentResponse;
import tr.edu.itu.cavabunga.lib.http.Response;

import java.util.List;

@Data
@Service
public class ComponentRestService {
    private CavabungaClientConfiguration cavabungaClientConfiguration;
    private RestTemplate restTemplate;
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public ComponentRestService(CavabungaClientConfiguration cavabungaClientConfiguration,
                                RestTemplateBuilder restTemplateBuilder){
        this.cavabungaClientConfiguration = cavabungaClientConfiguration;
        this.restTemplateBuilder = restTemplateBuilder;
        this.restTemplate = restTemplateBuilder.build();
    }

    public void postComponentToServer(tr.edu.itu.cavabunga.lib.entity.Component component, String apiUri){
        this.restTemplate.postForEntity(this.cavabungaClientConfiguration.getCavabungaServerUrl() + ":" + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,
                component, Response.class);
    }

    public List<Component> getComponentFromServer(String apiUri){
        return this.restTemplate.getForEntity(this.cavabungaClientConfiguration.getCavabungaServerUrl() + ":" + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,ComponentResponse.class).getBody().getData();
    }

}
