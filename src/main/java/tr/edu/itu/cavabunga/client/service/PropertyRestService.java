package tr.edu.itu.cavabunga.client.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import tr.edu.itu.cavabunga.client.configuration.CavabungaClientConfiguration;
import tr.edu.itu.cavabunga.lib.entity.Property;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.itu.cavabunga.lib.http.PropertyResponse;
import tr.edu.itu.cavabunga.lib.http.Response;

import java.util.List;

@Data
@Service
public class PropertyRestService {
    private CavabungaClientConfiguration cavabungaClientConfiguration;
    private RestTemplateBuilder restTemplateBuilder;
    private RestTemplate restTemplate;

    @Autowired
    public PropertyRestService(CavabungaClientConfiguration cavabungaClientConfiguration,
                               RestTemplateBuilder restTemplateBuilder){
        this.cavabungaClientConfiguration = cavabungaClientConfiguration;
        this.restTemplateBuilder = restTemplateBuilder;
        this.restTemplate = restTemplateBuilder.build();
    }

    public void postPropertyToServer(Property property, String apiUri, HttpHeaders httpHeaders){
        this.restTemplate.exchange(this.cavabungaClientConfiguration.getCavabungaServerUrl() + ":" + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,
                HttpMethod.POST,
                new HttpEntity<>(httpHeaders),
                Response.class,
                property);
    }

    public List<Property> getPropertyFromServer(String apiUri, HttpHeaders httpHeaders){
        return this.restTemplate.exchange(this.cavabungaClientConfiguration.getCavabungaServerUrl() + ":" + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                PropertyResponse.class).getBody().getData();
    }
}
