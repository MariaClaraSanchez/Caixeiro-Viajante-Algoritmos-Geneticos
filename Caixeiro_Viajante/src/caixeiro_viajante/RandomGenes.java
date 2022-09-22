/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caixeiro_viajante;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Maria Sanchez
 */
public class RandomGenes {
    
    private final Random random;
    public RandomGenes() {
        this.random = new Random();
    }
    
    public ArrayList GenesAleatorios(ArrayList genes, int k){
        ArrayList<String> genesSort = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            genesSort.add((String) genes.get(random.nextInt(genes.size())));
            //System.out.println("Gene Sorteado:" + genes.get(random.nextInt(genes.size())));
        }
        
        return genesSort;
    }
}
