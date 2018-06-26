package edu.itu.cavabunga.client.exception;

public class JsonParseException extends RuntimeException {
    public JsonParseException(){}
    public JsonParseException(String message){super(message);}
    public JsonParseException(Throwable cause){super(cause);}
}
