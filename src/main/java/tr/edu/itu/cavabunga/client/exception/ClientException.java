package tr.edu.itu.cavabunga.client.exception;

public class ClientException extends RuntimeException {
    public ClientException(){}
    public ClientException(String message){
        super(message);
    }
    public ClientException(Throwable cause){
        super(cause);
    }
}
