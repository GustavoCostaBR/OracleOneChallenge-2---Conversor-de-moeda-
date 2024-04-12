package com.allogica.ChallengeConversorMoedas.main;

import com.allogica.ChallengeConversorMoedas.entities.ConversionPair;
import com.allogica.ChallengeConversorMoedas.entities.ConversionPairRequisition;
import com.allogica.ChallengeConversorMoedas.entities.Pairs;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static List<ConversionPair> menu(Pairs pair, List<ConversionPair> conversionPairList){
        ConversionPairRequisition conversionPairRequisition1 = new ConversionPairRequisition();
        conversionPairRequisition1.conversionMenu(pair);
        if (conversionPairRequisition1.getAllright()) {
            conversionPairList.add(conversionPairRequisition1.getConversionPairToBeSaved());
            System.out.println("Tudo certo com a conversão!");
        }
        return conversionPairList;
    }

    public static void main(String[] args) {
        String opcao = "abacate";
        Scanner teclado = new Scanner(System.in);
        String fileName = "abacate";
        while (!(fileName.matches(".+\\.json$"))) {
            System.out.println("Informe o nome do arquivo no qual a conversão foi salva com a extensão .json. Exemplo: enderecos.json. Se nenhum arquivo foi salvo, ou quer informar um nome novo, informe um novo nome para começar");
            fileName = teclado.nextLine();
        }
        List<ConversionPair> conversionPairList;
        ConversionPairRequisition conversionPairRequisition = new ConversionPairRequisition();
        conversionPairList = conversionPairRequisition.getConversionBackFromJsonFile(fileName);
        if (conversionPairList == null) {
            conversionPairList = new ArrayList<>();
        }


        while (!(opcao.equals("7"))) {
            System.out.println("""
                    Por favor informe a opção desejada (digite apenas o número):
                    1) Dólar =>> Peso argentino;
                    2) Peso argentino=>> Dólar;
                    3) Dólar =>> Real brasileiro;
                    4) Real brasileiro =>> Dólar;
                    5) Dólar =>> Peso colombiano;
                    6) Peso colombiano =>> Dólar;
                    7) Sair;
                    """);

            opcao = teclado.nextLine();
            Pairs pair;
            switch (opcao) {
                case "1": {
                    pair = Pairs.USD_ARS;
                    menu(pair, conversionPairList);
                    break;
                }
                case "2": {
                    pair = Pairs.ARS_USD;
                    menu(pair, conversionPairList);
                    break;
                }
                case "3": {
                    pair = Pairs.USD_BRL;
                    menu(pair, conversionPairList);
                    break;
                }
                case "4": {
                    pair = Pairs.BRL_USD;
                    menu(pair, conversionPairList);
                    break;
                }
                case "5": {
                    pair = Pairs.USD_COP;
                    menu(pair, conversionPairList);
                    break;
                }
                case "6": {
                    pair = Pairs.COP_USD;
                    menu(pair, conversionPairList);
                    break;
                }
                case "7": {
                    break;
                }
                default:
                    System.out.println("Informe uma opcao válida!");

            }
//        Set<Address> addressSet = new TreeSet<>(Comparator.comparing(Address::cep));
//        addressSet.addAll(conversionPairList);
            Set<ConversionPair> conversionPairSet = new TreeSet<>(conversionPairList);
            conversionPairRequisition.saveConversionToJson(fileName, conversionPairSet);

        }
    }
}