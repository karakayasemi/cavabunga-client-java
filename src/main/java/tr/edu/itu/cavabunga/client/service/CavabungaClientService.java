package tr.edu.itu.cavabunga.client.service;

import tr.edu.itu.cavabunga.client.exception.ClientException;
import tr.edu.itu.cavabunga.lib.entity.Component;
import tr.edu.itu.cavabunga.lib.entity.Participant;
import tr.edu.itu.cavabunga.lib.entity.component.Calendar;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class CavabungaClientService {
    private ComponentRestService componentRestService;
    private ParameterRestService parameterRestService;
    private ParticipantRestService participantRestService;
    private PropertyRestService propertyRestService;

    @Autowired
    public CavabungaClientService(ComponentRestService componentRestService,
                                  ParameterRestService parameterRestService,
                                  ParticipantRestService participantRestService,
                                  PropertyRestService propertyRestService){
        this.componentRestService = componentRestService;
        this.parameterRestService = parameterRestService;
        this.participantRestService = participantRestService;
        this.propertyRestService = propertyRestService;
    }

    public List<Participant> retrieveParticipant(String userName){
        try {
            return participantRestService.getParticipantFromServer("participant/" + userName);
        }catch (Exception e){
            throw new ClientException("Couldnt recieve participant with username: " + userName + " ,message:" + e.getMessage());
        }
    }

    public List<Component> retrieveComponentById(Long id){
        try {
            return componentRestService.getComponentFromServer("component/" + id.toString());
        }catch (Exception e){
            throw new ClientException("Couldnt recieve component with id of " + id.toString() + " ,message:" + e.getMessage());
        }
    }

    public List<Component> retrieveComponentsByOwner(String userName){
        try {
            return componentRestService.getComponentFromServer("participant/" + userName + "/components");
        }catch (Exception e){
            throw new ClientException("Coulnd recieve participants components username: " + userName + " ,message:" + e.getMessage());
        }
    }

    public List<Component> retrieveCalendarsByOwner(String userName){
        List<Component> calendars = new ArrayList<>();
        try {
            for (Component c : componentRestService.getComponentFromServer("participant/" + userName + "/components")){
                if(c instanceof Calendar){
                    calendars.add(c);
                }
            }
            return calendars;
        }catch (Exception e){
            throw new ClientException("Coulnd recieve participants components username: " + userName + " ,message:" + e.getMessage());
        }
    }
}
