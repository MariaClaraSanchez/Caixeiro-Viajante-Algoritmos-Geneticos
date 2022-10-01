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
        int kIndividuos = 100;
        int KGenes = graph.length;
        int KVezes = 2;
        int qntC = 1;
        int ponto = 3;
        int KMutacao = 2;
        int kSelecao = (int)(0.3*kIndividuos);

    	/*Cria��o da Popula��o pela primeira vez*/
        
        // Inicio da contagem do tempo
        
        long start = System.currentTimeMillis();
        
        Population controle = new Population();

        ArrayList<Individual> populacao = new ArrayList<>();
        
        for (int i = 0; i < kIndividuos; i++) {
            Individual individuo = new Individual(KGenes);
            controle.criarIndividuoAleatorio(individuo); 
            populacao.add(individuo);
        }
        
        System.out.println("****** Populacao Inicial: *****");
        controle.printPopulation(populacao);
        
        Operations operations = new Operations();
        
        for(int i=0; i<KVezes; i++) {

            /* Cruzamento */
            System.out.println("********* Cruzamento **********");
            
            operations.CallCrossover(qntC,ponto,KGenes,populacao);
            
            /* Mutac�o */
            operations.CallMutation(qntC, KGenes, KMutacao, populacao);
            
            /* Sele��o */
            ArrayList<Individual> novaPopulacao = new ArrayList<>();
     
            populacao = operations.CalculaEsforco(populacao, graph, KGenes);
            System.out.println("****** Esfor�o *****");
            controle.printEsforco(populacao);
            
            System.out.println("\n****** Sele��o ******");
            operations.CallSelection(populacao, kSelecao, KGenes);
            
            System.out.println("****** Populacao Ap�s a Sele��o: *****");
            controle.printPopulation(populacao); 
            
            /* Criando novas popula��es*/
            for (int j = kSelecao; j < kIndividuos; j++) {
                Individual individuo = new Individual(KGenes);
                controle.criarIndividuoAleatorio(individuo); 
                populacao.add(individuo);
            }
            
            System.out.println("****** Populacao Final: *****");
            controle.printPopulation(populacao);        
        }
        
        long end = System.currentTimeMillis();
     // Fim da contagem do tempo
        
       

        System.out.printf("Tempo de Execu��o: %.3f ms%n", (end - start) / 1000d);
        
        operations.printShowPath(populacao);
    }

}


// 1� Popula��o ok
// 2� Cruzamento ok
// 3� Muta��o  ok
// 4� Sele��o	

