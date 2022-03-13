package ru.metaprofile.app.APIUtils;

public class APIUrls {
    public String getAuthMethods(APIAuthEnum url){
        switch (url){
            case SIGN_IN:
                return "/v1/auth/signin";
            case SIGN_UP:
                return "/v1/auth/signup";
            default:
                return null;
        }
    }
    public String getUserMethods(APIUsersEnum url){
        if (url == APIUsersEnum.USER_ME) {
            return "/v1/user/me";
        }
        return null;
    }
    public String getEndpoint(APIEndpontsEnum url){
        if (url == APIEndpontsEnum.FOXYNOTES) {
            return "https://api.foxynotes.ru";
        }
        return null;
    }
}
