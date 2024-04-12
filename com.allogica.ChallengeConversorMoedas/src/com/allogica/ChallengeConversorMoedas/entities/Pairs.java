package com.allogica.ChallengeConversorMoedas.entities;

public enum Pairs {
    USD_ARS("USD/ARS"),
    ARS_USD("ARS/USD"),
    USD_BRL("USD/BRL"),
    BRL_USD("BRL/USD"),
    USD_COP("USD/COP"),
    COP_USD("COP/USD");

    private final String pair;

    Pairs(String pair) {
        this.pair = pair;
    }

    public String getPair() {
        return pair;
    }
}
