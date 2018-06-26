package edu.itu.cavabunga.client.service;

import edu.itu.cavabunga.client.configuration.CavabungaClientConfiguration;
import edu.itu.cavabunga.client.exception.ClientException;
import edu.itu.cavabunga.client.http.HttpAdapter;
import edu.itu.cavabunga.client.http.JsonObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Data
@Service
public class ComponentRestService {

    private HttpAdapter httpAdapter;
    private JsonObjectMapper jsonObjectMapper;
    private CavabungaClientConfiguration cavabungaClientConfiguration;

    @Autowired
    public ComponentRestService(HttpAdapter httpAdapter,
                                JsonObjectMapper jsonObjectMapper,
                                CavabungaClientConfiguration cavabungaClientConfiguration){
        this.cavabungaClientConfiguration = cavabungaClientConfiguration;
        this.httpAdapter = httpAdapter;
        this.jsonObjectMapper = jsonObjectMapper;
    }

    public String sendComponentToServer(edu.itu.cavabunga.lib.entity.Component component,
                                      RequestMethod requestMethod,
                                      String apiUri){
        return this.httpAdapter.doRequest(this.cavabungaClientConfiguration.getCavabungaServerUrl() + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,
                requestMethod,
                this.jsonObjectMapper.mapComponentToJson(component));
    }

    public List<edu.itu.cavabunga.lib.entity.Component> recieveComponentFromServer(String apiUri, RequestMethod requestMethod){
        return this.jsonObjectMapper.mapFromJsonToComponentResponseList( this.httpAdapter.doRequest(this.cavabungaClientConfiguration.getCavabungaServerUrl() + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,
                requestMethod, ""));
    }
}
