package caixeiro_viajante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Maria Sanchez
 */
public class Population {

    private final Random random;
    public Population() {
        this.random = new Random(System.nanoTime());
    }

    public void criarIndividuoAleatorio(Individual individuo) {
        for (int i = 0; i < individuo.getSize(); i++) {
            int posicao = 0;
            do {
                posicao = random.nextInt(individuo.getSize());
            } while (individuo.getGenes()[posicao] != -1);
            individuo.setGene(posicao, i);
        }
    } 
    
}
