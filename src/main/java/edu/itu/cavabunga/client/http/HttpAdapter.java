package edu.itu.cavabunga.client.http;

import edu.itu.cavabunga.client.exception.ClientException;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Data
@Component
public class HttpAdapter {
    public static String doRequest(String requestUrl, RequestMethod requestMethod, String bodyParameters){
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod.toString());

            if(bodyParameters != null  && !bodyParameters.isEmpty()){
                connection.setDoOutput(true);
                DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                out.writeBytes(bodyParameters);
                out.flush();
                out.close();
            }

            connection.setRequestProperty("Content-Type", "application/json");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer result = new StringBuffer();
            while((inputLine = in.readLine()) != null){
                result.append(inputLine);
            }
            in.close();
            connection.disconnect();
            if(connection.getResponseCode() != 200){
                throw new ClientException("Cavabunga server return with http code: " + connection.getResponseCode());
            }
            return result.toString();
        }catch (Exception e){
            throw new ClientException("There is a problem about http connection: " + e.getMessage());
        }
    }
}
