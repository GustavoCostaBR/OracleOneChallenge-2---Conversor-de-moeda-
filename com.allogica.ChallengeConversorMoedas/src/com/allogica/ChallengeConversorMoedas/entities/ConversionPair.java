package com.allogica.ChallengeConversorMoedas.entities;

import com.google.gson.annotations.SerializedName;


public record ConversionPair(String result, @SerializedName("base_code") String baseCode, @SerializedName("target_code") String targetCode, @SerializedName("conversion_rate") double conversionRate, double amount, double value, String localDateTime) implements Comparable<ConversionPair> {


    @Override
    public int compareTo(ConversionPair o) {
        return this.localDateTime.compareTo(o.localDateTime);
    }
}
