package org.nlp.classifier.train;

import edu.stanford.nlp.classify.ColumnDataClassifier;
import edu.stanford.nlp.ling.Datum;
import edu.stanford.nlp.objectbank.ObjectBank;

import java.io.IOException;

public class Classifier {
    public static String where = "";
    private ColumnDataClassifier cdc;
    public void train() throws IOException {
        System.out.println("Training ColumnDataClassifier");
        cdc = new ColumnDataClassifier(where + "src/main/resources/train/weather.prop");
        cdc.trainClassifier(where + "src/main/resources/train/weather.train");

        System.out.println();
        System.out.println("Testing predictions of ColumnDataClassifier");
        for (String line : ObjectBank.getLineIterator(where + "src/main/resources/train/weather.test", "utf-8")) {
            // instead of the method in the line below, if you have the individual elements
            // already you can use cdc.makeDatumFromStrings(String[])
            Datum<String,String> d = cdc.makeDatumFromLine(line);
            System.out.printf("%s  ==>  %s (%.4f)%n", line, cdc.classOf(d), cdc.scoresOf(d).getCount(cdc.classOf(d)));
        }
        System.out.println("---------------------------------------");
        String line = "0\tWhat the weather in Lviv on Friday";
        Datum<String,String> d = cdc.makeDatumFromLine(line);
        System.out.printf("%s  ==>  %s (%.4f)%n", line, cdc.classOf(d), cdc.scoresOf(d).getCount(cdc.classOf(d)));
    }

    public String getClazz(String q){
        Datum<String,String> d = cdc.makeDatumFromLine("0\t"+q);
        System.out.printf("%s  ==>  %s (%.4f)%n", ("0\t"+q), cdc.classOf(d), cdc.scoresOf(d).getCount(cdc.classOf(d)));
        return cdc.classOf(d);
    }
}
