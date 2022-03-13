package ru.metaprofile.app.APIUtils.Exceptions;

public class MPAPIBadResponseException extends RuntimeException{
    public MPAPIBadResponseException(String jsonString){
        super("Ответ не может быть декодирован");
        System.out.println(jsonString);
    }

    public MPAPIBadResponseException(){
        super("Ответ не может быть декодирован");
    }
}
