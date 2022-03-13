package ru.metaprofile.app.APIUtils.Api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import ru.metaprofile.app.APIUtils.Methods.APIEndpontsEnum;

public class API {
    APIUrls ApiUrls = new APIUrls();
    String EndpointUrl = ApiUrls.getEndpoint(APIEndpontsEnum.FOXYNOTES);

    public String Post(String jsonInputString, String method) throws IOException {
        URL Url = new URL(EndpointUrl + method);
        HttpsURLConnection myConnection =
                (HttpsURLConnection) Url.openConnection();
        myConnection.setConnectTimeout(10000);
        myConnection.setRequestMethod("POST");
        myConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        myConnection.setRequestProperty("Accept", "application/json");
        myConnection.setDoOutput(true);

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

            return response.toString();
        }
    }

    public String Get(String method, String token) throws IOException {
        URL Url = new URL(EndpointUrl + method);
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

            return response.toString();

        }
    }
}
