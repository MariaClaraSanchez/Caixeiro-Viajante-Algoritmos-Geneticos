package caixeiro_viajante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Maria Sanchez
 */
public class Individual {

    private int[] genes;
    private int size;
    private int esforco;

    public Individual(int size) {
        this.size = size;
        this.genes = new int[size];
        this.esforco = esforco;
        for (int i = 0; i < size; i++) {
            this.genes[i] = -1;
        }
    }
    
    public void printIndividuo() {
        for (Integer gene : this.genes) {
            System.out.print(gene + "\t");
        }
        System.out.println("");
    }
    
    
    public void setGene(int posicao, int gene) {
        this.genes[posicao] = gene;
    }
    
    public void setEsforco(int esforco) {
		this.esforco = esforco;
	}
    
    public int getEsforco() {
		return esforco;
	}
    

    public int[] getGenes() {
        return genes;
    }

    public int getSize() {
        return size;
    }
    
    public int getGene(int index) {
        return genes[index];
    }
}
