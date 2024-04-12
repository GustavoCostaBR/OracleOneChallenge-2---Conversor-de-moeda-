package com.allogica.ChallengeConversorMoedas.entities;

import com.allogica.ChallengeConversorMoedas.HttpManager.HttpRequestPersonalized;
import com.allogica.ChallengeConversorMoedas.JsonManager.JsonFileReader;
import com.allogica.ChallengeConversorMoedas.JsonManager.JsonFileWriter;
import com.allogica.ChallengeConversorMoedas.JsonManager.JsonWorkerPersonalized;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ConversionPairRequisition {
    private JsonWorkerPersonalized jsonWorkerPersonalized;
    private HttpRequestPersonalized httpRequestPersonalized = new HttpRequestPersonalized();
    private JsonFileWriter jsonFileWriter;

    private JsonFileReader jsonFileReader;

    private ConversionPair conversionPairToBeSaved;

    public ConversionPair getConversionPairToBeSaved() {
        return conversionPairToBeSaved;
    }
    private Boolean allright = false;

    public Boolean getAllright() {
        return allright;
    }

    public ConversionPairRequisition() {
        this.jsonFileReader = new JsonFileReader<ConversionPair>();
        this.apiKey = (ApiKey) jsonFileReader.getStringFromFile("C:\\Users\\Gustavo\\Documents\\Planejamento\\ORACLE_ONE\\Cursos_Trilha_Java\\Curso_5-ChallengeConversorDeMoedas\\com.allogica.ChallengeConversorMoedas\\src\\com\\allogica\\ChallengeConversorMoedas\\mykey.json", ApiKey.class);
    }

    private ApiKey apiKey;

    private String apiURL;

    private double amount;

    private double value;

    public ConversionPairRequisition(double amount) {
        this.amount = amount;
    }

    public ConversionPairRequisition(Pairs currencyPair) {
        this.apiURL = "https://v6.exchangerate-api.com/v6/" + apiKey.apiKey() +"/pair/" + currencyPair.getPair();
        httpRequestPersonalized.requestNewConversion(apiURL);
        jsonWorkerPersonalized = new JsonWorkerPersonalized<ConversionPair>();
        String response = httpRequestPersonalized.getBodyBack();
        conversionPairToBeSaved = (ConversionPair) jsonWorkerPersonalized.convertToObject(response, ConversionPair.class);

        if (conversionPairToBeSaved != null)
        {
            if (conversionPairToBeSaved.result().equals("success")){
                System.out.println("A conversão foi feita como esperado!");
                allright = true;
            }
            else {
                System.out.println("Requisição retornou com erro!");
            }
        }
        else System.out.println("Erro inesperado de objeto nulo!");
    }

    public void convertNewRequisition(Pairs currencyPair){
        this.apiURL = "https://v6.exchangerate-api.com/v6/" + apiKey.apiKey() +"/pair/" + currencyPair.getPair();
        httpRequestPersonalized.requestNewConversion(apiURL);
        jsonWorkerPersonalized = new JsonWorkerPersonalized<ConversionPair>();
        String response = httpRequestPersonalized.getBodyBack();
        conversionPairToBeSaved = (ConversionPair) jsonWorkerPersonalized.convertToObject(response, ConversionPair.class);

        if (conversionPairToBeSaved != null)
        {
            if (conversionPairToBeSaved.result().equals("success")){
                System.out.println("A conversão foi feita como esperado!");
                allright = true;
            }
            else {
                System.out.println("Requisição retornou com erro!");
            }
        }
        else System.out.println("Erro inesperado de objeto nulo!");
    }

    public void conversionMenu(Pairs pair){
        String amountString = "nonok";
        Scanner teclado = new Scanner(System.in);
        String currency1 = pair.getPair().split("/")[0];
        String currency2 = pair.getPair().split("/")[1];
        while (!amountString.equals("ok")){
            System.out.println("Informe a quantidade de " + currency1 + " que deseja converter em " + currency2 + ". Use número com ponto: '1.22'");

            amountString = teclado.nextLine();
            double amount = 0.00;
            try {
                amount = Double.parseDouble(amountString);
                this.amount = amount;
                amountString = "ok";
            }
            catch (RuntimeException e){
                System.out.println("Informe um valor válido!");
                amountString = "nonok";
            }
        }
        convertNewRequisition(pair);
        if (getAllright()){
            this.value = getConversionPair().conversionRate()*amount;
            conversionPairToBeSaved = new ConversionPair(conversionPairToBeSaved.result(), conversionPairToBeSaved.baseCode(), conversionPairToBeSaved.targetCode(), conversionPairToBeSaved.conversionRate(), this.amount, this.value);
            printConversionPair();
        }
    }
    public ConversionPair getConversionPair() {
        return conversionPairToBeSaved;
    }

    public void printConversionPair() {
        if (conversionPairToBeSaved != null){
            if (!conversionPairToBeSaved.result().equals("erro")){
                System.out.println(conversionPairToBeSaved.amount() + " " + conversionPairToBeSaved.baseCode());
                System.out.println(conversionPairToBeSaved.value() + " " + conversionPairToBeSaved.targetCode());
                System.out.println("Taxa de conversão: " + conversionPairToBeSaved.conversionRate());
            }
            else {
                System.out.println("Erro na requisição!");
            }
        }
        else {
            System.out.println("Erro!");
        }
    }

    public void saveAddressToJson(String fileName, Set<ConversionPair> conversionPairSet){
        jsonFileWriter = new JsonFileWriter<ConversionPair>(fileName, false);

        jsonFileWriter.writeSetToJson(conversionPairSet);
        System.out.println("Endereço nulo!");
    }

    public List<ConversionPair> getConversionBackFromJsonFile(String fileName){
        jsonFileReader = new JsonFileReader<>();
        return jsonFileReader.readContentsFromFile(fileName, ConversionPair.class);
    }

}
