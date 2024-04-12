package com.allogica.ChallengeConversorMoedas.JsonManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JsonFileReader <T> {
    JsonWorkerPersonalized jsonWorkerPersonalized;

    public JsonFileReader() {
        this.jsonWorkerPersonalized = new JsonWorkerPersonalized<T>();
    }

    public List<T> readContentsFromFile(String filename, Class<T> clazz) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                return jsonWorkerPersonalized.convertToList(reader, clazz);

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado, inciando do zero");
            return null;
        } catch (IOException e) {
            System.out.println("Necessita permissão para alterar o arquivo, inciando do zero");
            return null;
        }
    }

    public T getStringFromFile(String fileName, Class<T> clazz){
        try {
            return (T) jsonWorkerPersonalized.convertToObject(Files.readString(Path.of(fileName)), clazz);


        } catch (FileNotFoundException e) {
            System.out.println("Arquivo com chave de API não encontrado");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
