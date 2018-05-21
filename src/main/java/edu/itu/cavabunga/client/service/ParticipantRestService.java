package edu.itu.cavabunga.client.service;

import edu.itu.cavabunga.client.configuration.ClientConfiguration;
import edu.itu.cavabunga.lib.entity.Participant;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ParticipantRestService {

    private ClientConfiguration configuration;
    private String apiUri;
    private Participant bodyObject;
    private String requestResult;

    @Autowired
    public ParticipantRestService(ClientConfiguration configuration){
        this.configuration = configuration;
    }
}
