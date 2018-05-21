package edu.itu.cavabunga.client.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.itu.cavabunga.client.exception.ClientException;
import edu.itu.cavabunga.lib.entity.Parameter;
import edu.itu.cavabunga.lib.entity.Participant;
import edu.itu.cavabunga.lib.entity.Property;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class JsonObjectMapper {
    private ObjectMapper mapper;

    @Autowired
    public JsonObjectMapper(ObjectMapper objectMapper){
        this.mapper = objectMapper;
    }

    public String mapParticipantToJson(Participant participant){
        try {
            return mapper.writeValueAsString(participant);
        }catch (Exception e){
            throw new ClientException("There is something wrong in toJson mapping: " + e.getMessage());
        }
    }

    public String mapComponentToJson(edu.itu.cavabunga.lib.entity.Component component){
        try {
            return mapper.writeValueAsString(component);
        }catch (Exception e){
            throw new ClientException("There is something wrong in toJson mapping: " + e.getMessage());
        }
    }

    public String mapPropertyToJson(Property property){
        try {
            return mapper.writeValueAsString(property);
        }catch (Exception e){
            throw new ClientException("There is something wrong in toJson mapping: " + e.getMessage());
        }
    }

    public String mapParameterToJson(Parameter parameter){
        try {
            return mapper.writeValueAsString(parameter);
        }catch (Exception e){
            throw new ClientException("There is something wrong in toJson mapping: " + e.getMessage());
        }
    }

    public Participant mapFromJsonToParticipant(String jsonInput){
        try {
            return mapper.readValue(jsonInput, Participant.class);
        }catch (Exception e){
            throw new ClientException("There is something wrong in toParticipant mapping: " + e.getMessage());
        }
    }

    public edu.itu.cavabunga.lib.entity.Component mapFromJsonToComponent(String jsonInput){
        try {
            return mapper.readValue(jsonInput, edu.itu.cavabunga.lib.entity.Component.class);
        }catch (Exception e){
            throw new ClientException("There is something wrong in toComponent mapping: " + e.getMessage());
        }
    }

    public Property mapFromJsonToProperty(String jsonInput){
        try {
            return mapper.readValue(jsonInput, Property.class);
        }catch (Exception e){
            throw new ClientException("There is something wrong in toProperty mapping: " + e.getMessage());
        }
    }

    public Parameter mapFromJsonToParameter(String jsonInput){
        try {
            return mapper.readValue(jsonInput, Parameter.class);
        }catch (Exception e){
            throw new ClientException("There is something wrong in toParameter mapping: " + e.getMessage());
        }
    }
}
