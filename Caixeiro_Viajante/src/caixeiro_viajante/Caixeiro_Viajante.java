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

    	
        /* ************ Geração da População ************ */
        int kIndividuos = 100;
        int KGenes = graph.length;
        int KVezes = 2;
        int qntC = 1;
        int ponto = 3;
        int KMutacao = 2;
        int kSelecao = (int)(0.3*kIndividuos);

    	/*Criação da População pela primeira vez*/
        
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
            
            /* Mutacão */
            operations.CallMutation(qntC, KGenes, KMutacao, populacao);
            
            /* Seleção */
            ArrayList<Individual> novaPopulacao = new ArrayList<>();
     
            populacao = operations.CalculaEsforco(populacao, graph, KGenes);
            System.out.println("****** Esforço *****");
            controle.printEsforco(populacao);
            
            System.out.println("\n****** Seleção ******");
            operations.CallSelection(populacao, kSelecao, KGenes);
            
            System.out.println("****** Populacao Após a Seleção: *****");
            controle.printPopulation(populacao); 
            
            /* Criando novas populações*/
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
        
       

        System.out.printf("Tempo de Execução: %.3f ms%n", (end - start) / 1000d);
        
        operations.printShowPath(populacao);
    }

}


// 1º População ok
// 2º Cruzamento ok
// 3º Mutação  ok
// 4º Seleção	

