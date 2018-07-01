package tr.edu.itu.cavabunga.client.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import tr.edu.itu.cavabunga.client.configuration.CavabungaClientConfiguration;
import tr.edu.itu.cavabunga.lib.entity.Parameter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.itu.cavabunga.lib.http.ParameterResponse;
import tr.edu.itu.cavabunga.lib.http.Response;

import java.util.List;

@Service
@Data
public class ParameterRestService {
    private CavabungaClientConfiguration cavabungaClientConfiguration;
    private RestTemplate restTemplate;
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public ParameterRestService(CavabungaClientConfiguration cavabungaClientConfiguration, RestTemplateBuilder restTemplateBuilder){
        this.cavabungaClientConfiguration = cavabungaClientConfiguration;
        this.restTemplateBuilder = restTemplateBuilder;
        this.restTemplate = restTemplateBuilder.build();
    }

    public void postParameterToServer(Parameter parameter, String apiUri){
        this.restTemplate.postForEntity(this.cavabungaClientConfiguration.getCavabungaServerUrl() + ":" + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri, parameter, Response.class);
    }

    public List<Parameter> getParameterFromServer(String apiUri){
        return this.restTemplate.getForEntity(this.cavabungaClientConfiguration.getCavabungaServerUrl() + ":" + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri, ParameterResponse.class).getBody().getData();
    }
}
