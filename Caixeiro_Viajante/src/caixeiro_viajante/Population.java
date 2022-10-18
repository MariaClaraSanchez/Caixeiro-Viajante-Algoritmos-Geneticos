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
    
    public void printPopulation(ArrayList<Individual> populacao) {
    	 for(int i=0; i<populacao.size();i++){
             System.out.println(Arrays.toString(populacao.get(i).getGenes()));
         }
    }
    public void printEsforco(ArrayList<Individual> populacao) {
     System.out.print("Esforcos: ");
   	 for(int i=0; i<populacao.size()-1;i++){
            System.out.print(populacao.get(i).getEsforco() + "\t");
        }
   }
    

}
