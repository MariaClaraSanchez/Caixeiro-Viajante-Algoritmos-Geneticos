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
		ArrayList<String> text = cGr.ler(
				"C:\\my_projects\\git\\CV\\Caixeiro-Viajante-Algoritmos-Geneticos\\Caixeiro_Viajante\\data\\Teste.txt");

		int graph[][] = cGr.graph(text);

		for (int[] graph1 : graph) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(" " + graph1[j] + " ");
			}
			System.out.println();
		}

		/* ************ Geração da População ************ */

		// Declaração das variaveis
		int kIndividuos = 100;
		int KGenes = graph.length;
		int KVezes = (int) (0.8* kIndividuos);
		int qntCruzamento = (int) (0.1 * kIndividuos);
		int ponto = (int) (0.5 * KGenes);
		int KMutacao = (int) (0.1 * kIndividuos);
		int kSelecao = (int) (0.1 * kIndividuos);

		/* Criação da População pela primeira vez */

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

		for (int i = 0; i < KVezes; i++) {

			System.out.println("********* Geração: " + i + " **********");

			/* Cruzamento */
			// System.out.println("********* Cruzamento **********");

			operations.CallCrossover(qntCruzamento, ponto, KGenes, populacao);
			//System.out.println("****** Populacao Após a Cruzamento: *****");
			//controle.printPopulation(populacao);

			/* Mutacão */
			operations.CallMutation(qntCruzamento, KGenes, KMutacao, populacao);

			//System.out.println("****** Populacao Após a mutação: *****");
			//controle.printPopulation(populacao);

			/* Seleção */

			populacao = operations.CalculaEsforco(populacao, graph, KGenes);
			System.out.println("****** Esforço *****");
			controle.printEsforco(populacao);

			// System.out.println("\n****** Seleção ******");
			populacao = operations.CallSelection(populacao, kSelecao, KGenes);

			//System.out.println("****** Populacao Após a Seleção: *****");
			//controle.printPopulation(populacao);

			if (i != KVezes - 1) {
				/* Criando novas populações */
				for (int j = kSelecao; j < kIndividuos; j++) {
					Individual individuo = new Individual(KGenes);
					controle.criarIndividuoAleatorio(individuo);
					populacao.add(individuo);
				}
			}

			// populacao = operations.CalculaEsforco(populacao, graph, KGenes);
			//System.out.println("****** Esforço *****");
			//controle.printEsforco(populacao);

		}

		long end = System.currentTimeMillis();
		// Fim da contagem do tempo

		/* Contagem da memoria */
		int dataSize = 1024 * 1024;
		Runtime runtime = Runtime.getRuntime();
		
		populacao = operations.CalculaEsforco(populacao, graph, KGenes);
		/* Saídas */
		System.out.println("\n****** Populacao Final: *****");
		controle.printPopulation(populacao);
		controle.printEsforco(populacao);

		System.out.printf("\nTempo de Execução: %.3f ms%n", (end - start) / 1000d);
		System.out.println("\nMemoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / dataSize + "MB");
		operations.printShowPath(populacao);
	}

}

// 1º População ok
// 2º Cruzamento ok
// 3º Mutação  ok
// 4º Seleção ok
