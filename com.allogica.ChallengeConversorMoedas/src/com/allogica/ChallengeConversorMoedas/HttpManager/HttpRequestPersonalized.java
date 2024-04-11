package com.allogica.ChallengeConversorMoedas.HttpManager;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestPersonalized {
    private HttpClient httpClient;
    private HttpRequest httpRequest;
    private HttpResponse<String> response;



    public HttpRequestPersonalized(String cepRequisition) {
        this.httpClient = HttpClient.newHttpClient();
        this.httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(cepRequisition))
                .build();
        createResponse();
    }

    public HttpRequestPersonalized() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public void requestNewCep(String cepRequisition){
        this.httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(cepRequisition))
                .build();
        createResponse();
    }

    public String getAddressBack(){
        return this.response.body();
    }

    public void createResponse(){

        try {
            this.response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            System.out.println("Resposta não criada, problema com a requisição!");
            this.response = null;
        }


    }
}
