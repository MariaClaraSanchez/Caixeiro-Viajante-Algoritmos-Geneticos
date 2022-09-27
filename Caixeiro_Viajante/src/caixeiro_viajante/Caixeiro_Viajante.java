package caixeiro_viajante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Maria Sanchez
 */
public class Caixeiro_Viajante {
    public static void main(String[] args) {
    	
        int kIndividuos = 10;
        int KGenes = 6;
        
        /*Criação da População*/
        Population controle = new Population();

        ArrayList<Individual> populacao = new ArrayList<>();
        
        for (int i = 0; i < kIndividuos; i++) {
            Individual individuo = new Individual(KGenes);
            controle.criarIndividuoAleatorio(individuo);
            populacao.add(individuo);
        }

        System.out.println("****** Populacao Inicial: *****");
        controle.printPopulation(populacao);

        /*Inicio das operações Cruzamento - Mutação e Seleção*/
        //Genetic genetic = new Genetic();
        
        
        /* Cruzamento */
        System.out.println("********* Cruzamento **********");
        Operations operations = new Operations();
        
        int qntC = 1;
        int ponto = 3;
        
        System.out.println("Populacao antes: " + populacao.size());
        operations.CallCrossover(qntC,ponto,KGenes,populacao);
        System.out.println("Populacao depois: " + populacao.size());
        /*
        
        
        
        int qntC = 1;
        int ponto = 3;
        
        Random random = new Random();
        int num;
        Individual filho = new Individual(KGenes);
        
        
        // De acordo com a quantidade de cruzamento escolhida
        for (int i = 0; i < qntC; i++) {

        	num = random.nextInt(kIndividuos);
        	if(num+1 < populacao.size()) {
        		int[] pai = populacao.get(num).getGenes();
            	//System.out.println("Pai:" + Arrays.toString(populacao.get(num).getGenes()));
            	int[] mae = populacao.get(num+1).getGenes();
            	//System.out.println("Mae:" + Arrays.toString(populacao.get(num+1).getGenes()));
            	
            	filho = genetic.crossover(pai, mae,filho,ponto);
            	populacao.add(filho);
            	kIndividuos = populacao.size();
        	}
        }
        
        //System.out.println("*******************************");
        System.out.println("****** Populacao depois: ******");
        for(int i=0; i<populacao.size();i++){
            System.out.println(Arrays.toString(populacao.get(i).getGenes()));
        }
        
        System.out.println("*******************************");
        System.out.println("********** Mutacao: **********");
        Individual mutacao = new Individual(KGenes);
        int KMutacao = 2;
        // De acordo com a quantidade de mutações escolhida
        for (int i = 0; i < qntC; i++) {
        	num = random.nextInt(kIndividuos);
        	if(num+1 < populacao.size()) {
            	int[] aux = populacao.get(num+1).getGenes();
            	mutacao = genetic.mutation(aux,KGenes,KMutacao);
            	populacao.add(num+1, mutacao);
        	}
        	
        }
        
        //System.out.println("*******************************");
        System.out.println("****** Populacao depois: ******");
        for(int i=0; i<populacao.size();i++){
            System.out.println(Arrays.toString(populacao.get(i).getGenes()));
        }
        */
    }

}


// 1º População ok
// 2º Cruzamento ok
// 3º Mutação
// 4º Seleção

