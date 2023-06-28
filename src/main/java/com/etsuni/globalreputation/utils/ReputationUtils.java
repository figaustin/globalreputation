package com.etsuni.globalreputation.utils;


import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;


public class ReputationUtils {

    public static String getPlayersReputation(UUID playerUUID) throws IOException, InterruptedException, URISyntaxException {
        String url = "http://localhost:5000/api/players/find/" + playerUUID.toString();
        HttpClient client = HttpClient.newHttpClient();
        URI httpURI = new URI(url);
        HttpRequest request = HttpRequest.newBuilder(httpURI).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }


    public static String addPlayerToDatabase(UUID playerUUID) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI httpURI = new URI("http://localhost:5000/api/players/add");
        JsonObject json = new JsonObject();
        json.addProperty("uuid", playerUUID.toString());
        HttpRequest request = HttpRequest.newBuilder(httpURI)
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }


}

