package tr.edu.itu.cavabunga.client.controller;

import tr.edu.itu.cavabunga.client.service.CavabungaClientService;
import tr.edu.itu.cavabunga.lib.entity.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {
    @Autowired
    private CavabungaClientService cavabungaClientService;

    @GetMapping
    public List<Component> test(){
        return this.cavabungaClientService.retrieveCalendarsByOwner("testuser");
    }

}
