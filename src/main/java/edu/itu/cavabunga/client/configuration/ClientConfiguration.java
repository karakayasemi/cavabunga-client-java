package edu.itu.cavabunga.client.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Data
@Component
public class ClientConfiguration {
    private Environment env;

    private String cavabungaServerUrl;
    private String cavabungaServerPort;
    private String cavabungaServerAccessToken;
    private String cavabungaServerVersion;

    @Autowired
    public ClientConfiguration(Environment env){
        this.env = env;
        cavabungaServerUrl = this.env.getProperty("cavabunga.server.url");
        cavabungaServerPort = this.env.getProperty("cavabunga.server.port");
        cavabungaServerAccessToken = this.env.getProperty("cavabunga.server.access.token");
        cavabungaServerVersion = this.env.getProperty("cavabunga.server.version");
    }
}
