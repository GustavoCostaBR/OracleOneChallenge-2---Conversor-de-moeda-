package com.allogica.ChallengeConversorMoedas.JsonManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class JsonFileWriter <T> {
    private FileWriter fileWriter;
    private JsonWorkerPersonalized jsonWorkerPersonalized;

    public JsonFileWriter(String fileName, Boolean value) {

        try {
            if (value) {
                this.fileWriter = new FileWriter(fileName, true);
            }
            else {
                this.fileWriter = new FileWriter(fileName);
            }
            jsonWorkerPersonalized = new JsonWorkerPersonalized<T>();
        }
        catch (IOException e) {
            System.out.println("Não pode escrever para o arquivo de nome " + fileName + ". Por favor cheque suas permissões.");
        }
    }

    public void writeToJson(T objectToWrite){
        try {
            fileWriter.write(jsonWorkerPersonalized.convertToJson(objectToWrite));
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Impossível escrever no arquivo!");
        }
    }

    public void writeListToJson(List<T> list) {
        try {
            fileWriter.write(jsonWorkerPersonalized.convertToJson(list));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeSetToJson(Set<T> set) {
        try {
            fileWriter.write(jsonWorkerPersonalized.convertToJson(set));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
