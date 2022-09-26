package caixeiro_viajante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Maria Sanchez
 */


public class Operations {


    public Individual crossover(int []pai, int[]mae,Individual filho, int cutSize) {

    	for (int i = 0; i < cutSize; i++) {
    			filho.setGene(i, pai[i]);
        }
        for (int i = cutSize; i < filho.getSize(); i++) {
        	filho.setGene(i, mae[i]);
        }
        
        filho.printIndividuo();
        return filho;
    }
    
    public Individual mutation(int []individuo, int KGenes, int KMutacao) {
    	
        Random rn = new Random();
        Individual aux = new Individual(KGenes);
        
        int size = individuo.length;
        int mutacao;
        int[] vetor = new int[KMutacao];
        int[] pos = new int[KMutacao];
        int cont=0;
        
        //System.out.println("Antes da Mutacao:");
        /*for(int i=0; i<size;i++) {
        	aux.setGene(i, individuo[i]);
        }*/
        //aux.printIndividuo();
        
        for (int i = 0; i < KMutacao; i++) {
        	mutacao = rn.nextInt(size);
        	//System.out.println(pos);
        	System.out.println(mutacao);
        	
        	do {
        		for(int j=0;j<size;j++) {
        			if(mutacao != individuo[j]) {
            			if(mutacao != size){
            				vetor[i] = mutacao; 
            		        pos[i] = i; 
                    	}
            			else {
            				vetor[i] = mutacao+1; 
            		        pos[i] = i; 
            			}
            		}
        		}
        		mutacao = rn.nextInt(size);
        	}while(cont!=KMutacao);
        	
        	for(int k=0; k<KMutacao;k++){
        		individuo[pos[i]] = vetor[i];
        		System.out.print(individuo[i]);
        	}
        }
        
        for(int i=0; i<size;i++) {
        	aux.setGene(i, individuo[i]);
        }
        
        //System.out.println("Depois da Mutacao:");
        //aux.printIndividuo();
        return aux;
    }

}
