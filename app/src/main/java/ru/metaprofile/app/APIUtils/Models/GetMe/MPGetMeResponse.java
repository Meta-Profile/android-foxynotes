package ru.metaprofile.app.APIUtils.Models.GetMe;

import ru.metaprofile.app.APIUtils.Models.MPControllerResponse;

public class MPGetMeResponse extends MPControllerResponse {
    private GetMeResponse response;

    public GetMeResponse getResponse() {
        return response;
    }

    public void setResponse(GetMeResponse response) {
        this.response = response;
    }
}
