package caixeiro_viajante;

import java.util.ArrayList;
import java.util.Random;

public class Operations {
	
	Genetic genetic;

	public Operations() {
		this.genetic = new Genetic();
	}
	
	public void CallCrossover(int qntC, int ponto,int KGenes, ArrayList<Individual> populacao){
		Random random = new Random();
        int num;
        Individual filho = new Individual(KGenes);
        int kIndividuos = populacao.size();
        
		for (int i = 0; i < qntC; i++) {

        	num = random.nextInt(kIndividuos);
        	if(num+1 < populacao.size()) {
        		int[] pai = populacao.get(num).getGenes();
            	//System.out.println("Pai:" + Arrays.toString(populacao.get(num).getGenes()));
            	int[] mae = populacao.get(num+1).getGenes();
            	//System.out.println("Mae:" + Arrays.toString(populacao.get(num+1).getGenes()));
            	
            	filho = genetic.crossover(pai, mae, filho, ponto);
            			
            	populacao.add(filho);
            	kIndividuos = populacao.size();
        	}
        }
	}
}
