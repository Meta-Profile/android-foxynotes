package ru.metaprofile.app.APIUtils.Api;

import java.io.IOException;

import ru.metaprofile.app.APIUtils.Methods.APIAuthEnum;
import ru.metaprofile.app.APIUtils.Methods.APIUsersEnum;
import ru.metaprofile.app.APIUtils.Models.GetMe.GetMeResponse;
import ru.metaprofile.app.APIUtils.Models.GetMe.MPGetMeResponse;
import ru.metaprofile.app.APIUtils.Models.SignIn.MPSignInResponse;
import ru.metaprofile.app.APIUtils.Models.SignIn.SignInResponse;

public class APIUtils {
    APIUrls ApiUrls = new APIUrls();
    API Api = new API();

    public SignInResponse signIn(String username, String password) throws IOException {

        String jsonInputString = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";

        String res = Api.Post(jsonInputString, ApiUrls.getAuthMethods(APIAuthEnum.SIGN_IN));

        MPSignInResponse resFromModel = JSONUtils.convertToObject(MPSignInResponse.class, res);
        return resFromModel.getResponse();

    }

    public GetMeResponse getUserMe(String token) throws IOException {

        String res = Api.Get(ApiUrls.getUserMethods(APIUsersEnum.USER_ME), token);

        MPGetMeResponse resFromModel = JSONUtils.convertToObject(MPGetMeResponse.class, res);
        return resFromModel.getResponse();
    }
}
