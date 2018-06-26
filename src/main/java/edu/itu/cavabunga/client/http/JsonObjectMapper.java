package edu.itu.cavabunga.client.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.itu.cavabunga.client.exception.ClientException;
import edu.itu.cavabunga.client.exception.JsonParseException;
import edu.itu.cavabunga.lib.entity.Parameter;
import edu.itu.cavabunga.lib.entity.Participant;
import edu.itu.cavabunga.lib.entity.Property;
import edu.itu.cavabunga.lib.http.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.PropertyResourceBundle;

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
            throw new JsonParseException("There is something wrong in toJson mapping: " + e.getMessage());
        }
    }

    public String mapComponentToJson(edu.itu.cavabunga.lib.entity.Component component){
        try {
            return mapper.writeValueAsString(component);
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toJson mapping: " + e.getMessage());
        }
    }


    public String mapPropertyToJson(Property property){
        try {
            return mapper.writeValueAsString(property);
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toJson mapping: " + e.getMessage());
        }
    }

    public String mapParameterToJson(Parameter parameter){
        try {
            return mapper.writeValueAsString(parameter);
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toJson mapping: " + e.getMessage());
        }
    }

    public Participant mapFromJsonToParticipant(String jsonInput){
        try {
            return mapper.readValue(jsonInput, Participant.class);
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toParticipant mapping: " + e.getMessage());
        }
    }

    public List<Participant> mapFromJsonToParticipantResponseList(String jsonInput){
        try{
            return mapper.readValue(jsonInput,ParticipantResponse.class).getData();
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toParticipantResponse mapping " + e.getMessage());
        }
    }

    public edu.itu.cavabunga.lib.entity.Component mapFromJsonToComponent(String jsonInput){
        try {
            return mapper.readValue(jsonInput, edu.itu.cavabunga.lib.entity.Component.class);
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toComponent mapping: " + e.getMessage());
        }
    }

    public List<edu.itu.cavabunga.lib.entity.Component> mapFromJsonToComponentResponseList(String jsonInput){
        try{
            return mapper.readValue(jsonInput,ComponentResponse.class).getData();
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toComponentResponse mapping " + e.getMessage());
        }
    }

    public Property mapFromJsonToProperty(String jsonInput){
        try {
            return mapper.readValue(jsonInput, Property.class);
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toProperty mapping: " + e.getMessage());
        }
    }

    public List<Property> mapFromJsonToPropertyResponseList(String jsonInput){
        try {
            return mapper.readValue(jsonInput, PropertyResponse.class).getData();
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toPropertyResponse mapping: " + e.getMessage());
        }
    }

    public Parameter mapFromJsonToParameter(String jsonInput){
        try {
            return mapper.readValue(jsonInput, Parameter.class);
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toParameter mapping: " + e.getMessage());
        }
    }

    public List<Parameter> mapFromJsonToParameterResponseList(String jsonInput){
        try {
            return mapper.readValue(jsonInput, ParameterResponse.class).getData();
        }catch (Exception e){
            throw new JsonParseException("There 's something wrong in toParameterResponse mapping: " + e.getMessage());
        }
    }

    public Response mapFromJsonToResponse(String jsonInput){
        try {
            return mapper.readValue(jsonInput, Response.class);
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toResponse mapping: " + e.getMessage());
        }
    }

    public ErrorResponse mapFromJsonToErrorResponse(String jsonInput){
        try {
            return mapper.readValue(jsonInput,ErrorResponse.class);
        }catch (Exception e){
            throw new JsonParseException("There is something wrong in toErrorResponse mapping: " + e.getMessage());
        }
    }
}
