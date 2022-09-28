package caixeiro_viajante;

import java.util.ArrayList;

/**
 *
 * @author Maria Sanchez
 */
public class Caixeiro_Viajante {
    public static void main(String[] args) {
    	
    	
    	/* Leitura do arquivo */
        CreationGraph cGr = new CreationGraph();
        ArrayList<String> text = cGr.ler("C:\\my_projects\\git\\CV\\Caixeiro-Viajante-Algoritmos-Geneticos\\Caixeiro_Viajante\\data\\Teste.txt");

        int graph[][] = cGr.graph(text);

        for (int[] graph1 : graph) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(" " + graph1[j] + " ");
            }
            System.out.println();
        }
    	
    	
        
        /* ************ Gera��o da Popula��o ************ */
        int kIndividuos = graph.length;
        int KGenes = graph.length;
        
        /*Cria��o da Popula��o*/
        Population controle = new Population();

        ArrayList<Individual> populacao = new ArrayList<>();
        
        for (int i = 0; i < kIndividuos; i++) {
            Individual individuo = new Individual(KGenes);
            controle.criarIndividuoAleatorio(individuo);
            populacao.add(individuo);
        }

        System.out.println("****** Populacao Inicial: *****");
        controle.printPopulation(populacao);

        /* Cruzamento */
        System.out.println("********* Cruzamento **********");
        Operations operations = new Operations();
        
        int qntC = 1;
        int ponto = 3;
        
        System.out.println("Populacao antes: " + populacao.size());
        operations.CallCrossover(qntC,ponto,KGenes,populacao);
        System.out.println("Populacao depois: " + populacao.size());
        
        int KMutacao = 2;
   
        System.out.println("Populacao antes: " + populacao.size());
        operations.CallMutation(qntC, KGenes, KMutacao, populacao);
        System.out.println("Populacao depois: " + populacao.size());
        
        
        System.out.println("****** Populacao Final: *****");
        controle.printPopulation(populacao);
    }

}


// 1� Popula��o ok
// 2� Cruzamento ok
// 3� Muta��o  ok
// 4� Sele��o	

