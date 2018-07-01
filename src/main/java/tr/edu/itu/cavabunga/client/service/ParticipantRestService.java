package tr.edu.itu.cavabunga.client.service;

import tr.edu.itu.cavabunga.client.configuration.CavabungaClientConfiguration;
import tr.edu.itu.cavabunga.client.http.HttpAdapter;
import tr.edu.itu.cavabunga.client.http.JsonObjectMapper;
import tr.edu.itu.cavabunga.lib.entity.Participant;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Data
@Service
public class ParticipantRestService {

    private HttpAdapter httpAdapter;
    private JsonObjectMapper jsonObjectMapper;
    private CavabungaClientConfiguration cavabungaClientConfiguration;

    @Autowired
    public ParticipantRestService(HttpAdapter httpAdapter,
                                  JsonObjectMapper jsonObjectMapper,
                                  CavabungaClientConfiguration cavabungaClientConfiguration){
        this.cavabungaClientConfiguration = cavabungaClientConfiguration;
        this.jsonObjectMapper = jsonObjectMapper;
        this.cavabungaClientConfiguration = cavabungaClientConfiguration;
    }

    public String sendParticipantToServer(Participant participant,
                                        RequestMethod requestMethod,
                                        String apiUri){
        return this.httpAdapter.doRequest(this.cavabungaClientConfiguration.getCavabungaServerUrl() + ":" + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,
                requestMethod,
                this.jsonObjectMapper.mapParticipantToJson(participant));
    }

    public List<Participant> recieveParticipantFromServer(String apiUri, RequestMethod requestMethod){
        return this.jsonObjectMapper.mapFromJsonToParticipantResponseList( this.httpAdapter.doRequest(this.cavabungaClientConfiguration.getCavabungaServerUrl() + ":" + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,
                requestMethod, ""));
    }
}
