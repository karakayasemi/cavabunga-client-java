package edu.itu.cavabunga.client.service;

import edu.itu.cavabunga.client.configuration.ClientConfiguration;
import edu.itu.cavabunga.lib.entity.Property;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class PropertyRestService {

    private ClientConfiguration configuration;
    private String apiUri;
    private Property bodyObject;
    private String requestResult;

    @Autowired
    public PropertyRestService(ClientConfiguration configuration){
        this.configuration = configuration;
    }
}
