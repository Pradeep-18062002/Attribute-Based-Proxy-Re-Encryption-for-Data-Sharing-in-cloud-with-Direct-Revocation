package algo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.List;


import java.util.Arrays;
import java.util.List;

public class TFIDFCalculator {
    /**
     * @param doc  list of strings
     * @param term String represents a term
     * @return term frequency of term in document
     */
    public double tf(List<String> doc, String term) {
       int a3=0;
        double result = 0;
        for (String word : doc) 
        {
            if (term.equalsIgnoreCase(word))
                result++;
        }    
        float du=(float)Math.log(result)+1;
        a3+=Math.pow(du,2);
        //double xyz=(double)1/Math.sqrt(du);
        return a3;
        
    }

    /**
     * @param docs list of list of strings represents the dataset
     * @param term String represents a term
     * @return the inverse term frequency of term in documents
     */
    public double idf(List<List<String>> docs, String term) {
        double n = 0;
        int a3=0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        double du=Math.log((1+(docs.size()/n)));
        a3+=Math.pow(du,2);
       // double xyz=(double)1/Math.sqrt(du);
        return a3;        
    }

    /**
     * @param doc  a text document
     * @param docs all documents
     * @param term term
     * @return the TF-IDF of term
     */
    public double tfIdf(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);
    }

    public static void main(String[] args) {

        List<String> doc1 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
        List<String> doc2 = Arrays.asList("Vituperata", "incorrupte", "at", "ipsum", "pro", "quo");
        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "simul");
        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3);

        TFIDFCalculator calculator = new TFIDFCalculator();
        System.out.println(calculator.tf(doc3, "dolor"));
        double tfidf = calculator.tfIdf(doc1, documents, "ipsum");
       // System.out.println("TF-IDF (ipsum) = " + tfidf);


    }


}