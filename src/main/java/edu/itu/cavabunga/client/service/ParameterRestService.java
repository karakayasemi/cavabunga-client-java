package edu.itu.cavabunga.client.service;

import edu.itu.cavabunga.client.configuration.ClientConfiguration;
import edu.itu.cavabunga.lib.entity.Parameter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class ParameterRestService {

    private ClientConfiguration configuration;
    private String apiUri;
    private Parameter bodyObject;
    private String requestResult;

    @Autowired
    public ParameterRestService(ClientConfiguration configuration){
        this.configuration = configuration;
    }
}
