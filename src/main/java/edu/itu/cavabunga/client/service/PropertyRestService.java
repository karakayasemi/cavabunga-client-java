package edu.itu.cavabunga.client.service;

import edu.itu.cavabunga.client.configuration.CavabungaClientConfiguration;
import edu.itu.cavabunga.client.http.HttpAdapter;
import edu.itu.cavabunga.client.http.JsonObjectMapper;
import edu.itu.cavabunga.lib.entity.Component;
import edu.itu.cavabunga.lib.entity.Property;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Data
@Service
public class PropertyRestService {

    private HttpAdapter httpAdapter;
    private JsonObjectMapper jsonObjectMapper;
    private CavabungaClientConfiguration cavabungaClientConfiguration;

    @Autowired
    public PropertyRestService(HttpAdapter httpAdapter,
                               JsonObjectMapper jsonObjectMapper,
                               CavabungaClientConfiguration cavabungaClientConfiguration){
        this.httpAdapter = httpAdapter;
        this.jsonObjectMapper = jsonObjectMapper;
        this.cavabungaClientConfiguration = cavabungaClientConfiguration;
    }

    public String sendPropertyToServer(Property property,
                                        RequestMethod requestMethod,
                                        String apiUri){
        return this.httpAdapter.doRequest(this.cavabungaClientConfiguration.getCavabungaServerUrl() + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,
                requestMethod,
                this.jsonObjectMapper.mapPropertyToJson(property));
    }

    public List<Property> recievePropertyFromServer(String apiUri, RequestMethod requestMethod){
        return this.jsonObjectMapper.mapFromJsonToPropertyResponseList( this.httpAdapter.doRequest(this.cavabungaClientConfiguration.getCavabungaServerUrl() + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,
                requestMethod, ""));
    }
}
