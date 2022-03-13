package ru.metaprofile.app.APIUtils.Exceptions;

public class MPAPIBadResponseException extends RuntimeException{
    public MPAPIBadResponseException(){
        super("Ответ не может быть декодирован");
    }
}
