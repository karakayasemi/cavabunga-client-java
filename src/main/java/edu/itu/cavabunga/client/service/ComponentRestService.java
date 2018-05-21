package edu.itu.cavabunga.client.service;

import edu.itu.cavabunga.client.configuration.ClientConfiguration;
import edu.itu.cavabunga.client.http.HttpAdapter;
import edu.itu.cavabunga.client.http.JsonObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ComponentRestService {

    private HttpAdapter httpAdapter;
    private JsonObjectMapper jsonObjectMapper;
    private ClientConfiguration configuration;
    private String apiUri;
    private edu.itu.cavabunga.lib.entity.Component bodyObject;
    private String requestResult;

    @Autowired
    public ComponentRestService(ClientConfiguration configuration, HttpAdapter httpAdapter, JsonObjectMapper jsonObjectMapper){
        this.configuration = configuration;
        this.httpAdapter = httpAdapter;
        this.jsonObjectMapper = jsonObjectMapper;
    }
}
