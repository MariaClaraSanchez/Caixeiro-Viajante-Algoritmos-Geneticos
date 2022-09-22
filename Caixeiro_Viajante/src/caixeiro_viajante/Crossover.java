package caixeiro_viajante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Maria Sanchez
 */


public class Crossover {
    
    public Integer somenteDigitos(String str) {
        StringBuilder digitos = new StringBuilder();
        char[] letras  = str.toCharArray();
        for (char letra : letras) {
            if(Character.isDigit(letra)) {
                digitos.append( letra );
            }
        }

        return Integer.parseInt( digitos.toString() );
    }

    ArrayList<String> genes = new ArrayList<>();

    public Crossover() {
        this.genes = genes;
    }

    public void cross(ArrayList genesSorteados) {
        
        String mae = (String) genesSorteados.get(0);
        
        //somenteDigitos(m);
        for (int i = 0; i < mae.length(); i++) {
            System.err.println(mae.charAt(i));
        }
        //System.out.println(m);
        
        //Trocar valores entre os pais
        /*for (int i = 0; i < genesSorteados.size(); i++) {
            

        }*/
    }
}
