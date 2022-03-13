package ru.metaprofile.app.APIUtils.Models.SignIn;

import ru.metaprofile.app.APIUtils.Models.MPControllerResponse;

public class MPSignInResponse extends MPControllerResponse {
    private SignInResponse response;

    public SignInResponse getResponse() {
        return response;
    }
}
