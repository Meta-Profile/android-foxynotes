package ru.metaprofile.app.APIUtils.Api;

import ru.metaprofile.app.APIUtils.Methods.APIAuthEnum;
import ru.metaprofile.app.APIUtils.Methods.APIEndpontsEnum;
import ru.metaprofile.app.APIUtils.Methods.APIMetaProfileEnum;
import ru.metaprofile.app.APIUtils.Methods.APIUsersEnum;

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

    public String getMetaProfileMethods(APIMetaProfileEnum url){
        switch (url) {
            case CREATE:
                return "/v1/mp/create/";
            case LIST:
                return "/v1/mp/list";
            case FIELDS:
                return "/v1/mp/fields";
            case CATEGORIES:
                return "/v1/mp/categories";
        }
        return null;
    }

    public String getMetaProfileMethods(APIMetaProfileEnum url, String metaId){
        switch (url) {
            case GET:
                return "/v1/mp/get/" + metaId;
            case REMOVE:
                return "/v1/mp/remove/" + metaId;
            case UPDATE:
                return "/v1/mp/update/" + metaId;
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
