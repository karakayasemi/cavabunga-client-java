package tr.edu.itu.cavabunga.client.service;

import tr.edu.itu.cavabunga.client.configuration.CavabungaClientConfiguration;
import tr.edu.itu.cavabunga.client.http.HttpAdapter;
import tr.edu.itu.cavabunga.client.http.JsonObjectMapper;
import tr.edu.itu.cavabunga.lib.entity.Parameter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
@Data
public class ParameterRestService {

    private HttpAdapter httpAdapter;
    private JsonObjectMapper jsonObjectMapper;
    private CavabungaClientConfiguration cavabungaClientConfiguration;

    @Autowired
    public ParameterRestService(HttpAdapter httpAdapter,
                                JsonObjectMapper jsonObjectMapper,
                                CavabungaClientConfiguration cavabungaClientConfiguration){
        this.httpAdapter = httpAdapter;
        this.jsonObjectMapper = jsonObjectMapper;
        this.cavabungaClientConfiguration = cavabungaClientConfiguration;
    }

    public String sendParameterToServer(Parameter parameter,
                                        RequestMethod requestMethod,
                                        String apiUri){
        return this.httpAdapter.doRequest(this.cavabungaClientConfiguration.getCavabungaServerUrl() + ":" + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,
                requestMethod,
                this.jsonObjectMapper.mapParameterToJson(parameter));
    }

    public List<Parameter> recieveParameterFromServer(String apiUri,
                                                      RequestMethod requestMethod){
        return this.jsonObjectMapper.mapFromJsonToParameterResponseList( this.httpAdapter.doRequest(this.cavabungaClientConfiguration.getCavabungaServerUrl() + ":" + this.cavabungaClientConfiguration.getCavabungaServerPort() + "/" + apiUri,
                requestMethod, ""));
    }
}
