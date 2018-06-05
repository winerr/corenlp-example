package org.nlp.classifier;

import org.nlp.classifier.train.Classifier;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        org.apache.log4j.BasicConfigurator.configure();
        Classifier c = new Classifier();
        c.train();

//        Properties props = new Properties();
//        props.put("annotators", "tokenize,ssplit,pos,lemma,ner,depparse,natlog,openie,parse,dcoref,");
//        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
//
//        // create an empty Annotation just with the given text
//        Annotation document = new Annotation();
//
//        // run all Annotators on this text
//        pipeline.annotate(document);
//
//        // these are all the sentences in this document
//        // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
//        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
//
//        for(CoreMap sentence: sentences) {
//            // traversing the words in the current sentence
//            // a CoreLabel is a CoreMap with additional token-specific methods
//            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
//                String word = token.get(CoreAnnotations.TextAnnotation.class);
//                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
//                System.out.println("word: " + word + " ne:" + ne);
//            }
//        }

        Scanner scanner = new Scanner(System.in);
        while (true){
            String q = scanner.nextLine();
            c.getClazz(q);


        }
    }

}
