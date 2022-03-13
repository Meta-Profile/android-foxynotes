package ru.metaprofile.app.APIUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import ru.metaprofile.app.APIUtils.Models.GetMe.GetMeResponse;
import ru.metaprofile.app.APIUtils.Models.GetMe.MPGetMeResponse;
import ru.metaprofile.app.APIUtils.Models.SignIn.MPSignInResponse;
import ru.metaprofile.app.APIUtils.Models.SignIn.SignInResponse;

public class APIUtils {
    APIUrls ApiUrls = new APIUrls();

    String EndpointUrl = ApiUrls.getEndpoint(APIEndpontsEnum.FOXYNOTES);

    public SignInResponse signIn(String username, String password) throws IOException {
        URL Url = new URL(EndpointUrl + ApiUrls.getAuthMethods(APIAuthEnum.SIGN_IN));
        HttpsURLConnection myConnection =
                (HttpsURLConnection) Url.openConnection();
        myConnection.setConnectTimeout(10000);
        myConnection.setRequestMethod("POST");
        myConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        myConnection.setRequestProperty("Accept", "application/json");
        myConnection.setDoOutput(true);

        String jsonInputString = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";

        try (OutputStream os = myConnection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try (BufferedReader responseBodyReader = new BufferedReader(
                new InputStreamReader(myConnection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = responseBodyReader.readLine()) != null) {
                response.append(responseLine.trim());
            }

            MPSignInResponse resFromModel = JSONUtils.convertToObject(MPSignInResponse.class, response.toString());

            return resFromModel.getResponse();

        }

    }

    public GetMeResponse getUserMe(String token) throws IOException {

        String EndpointUrl = ApiUrls.getEndpoint(APIEndpontsEnum.FOXYNOTES);

        URL Url = new URL(EndpointUrl + ApiUrls.getUserMethods(APIUsersEnum.USER_ME));
        HttpsURLConnection myConnection =
                (HttpsURLConnection) Url.openConnection();
        myConnection.setConnectTimeout(10000);
        myConnection.setRequestMethod("GET");
        myConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        myConnection.setRequestProperty("Accept", "application/json");
        myConnection.setRequestProperty("Authorization", "Bearer " + token);

        try (BufferedReader responseBodyReader = new BufferedReader(
                new InputStreamReader(myConnection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = responseBodyReader.readLine()) != null) {
                response.append(responseLine.trim());
            }

            MPGetMeResponse resFromModel = JSONUtils.convertToObject(MPGetMeResponse.class, response.toString());

            return resFromModel.getResponse();

        }
    }
}
