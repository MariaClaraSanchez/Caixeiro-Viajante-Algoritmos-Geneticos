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
        for(int i=0; i<populacao.size();i++){
            System.out.println(Arrays.toString(populacao.get(i).getGenes()));
        }

        /*Inicio das operações Cruzamento - Mutação e Seleção*/
        Operations operations = new Operations();
        
        /*Cruzamento*/
        //System.out.println("*******************************");
        System.out.println("********* Cruzamento **********");
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
            	
            	filho = operations.crossover(pai, mae,filho,ponto);
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
        // De acordo com a quantidade de cruzamento escolhida
        for (int i = 0; i < qntC; i++) {
        	num = random.nextInt(kIndividuos);
        	System.out.println(num+1);
        	int[] aux = populacao.get(num+1).getGenes();
        	populacao.remove(num+1);
        	mutacao = operations.mutation(aux,KGenes,KMutacao);
        	populacao.add(mutacao);
        }
        
        //System.out.println("*******************************");
        System.out.println("****** Populacao depois: ******");
        for(int i=0; i<populacao.size();i++){
            System.out.println(Arrays.toString(populacao.get(i).getGenes()));
        }
    }

}


// 1º População ok
// 2º Cruzamento ok
// 3º Mutação
// 4º Seleção

