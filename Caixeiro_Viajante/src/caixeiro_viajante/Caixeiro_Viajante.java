package caixeiro_viajante;

import java.util.ArrayList;

/**
 *
 * @author Maria Sanchez
 */
public class Caixeiro_Viajante {
	public static void main(String[] args) {

		/* ************ Leitura do arquivo ************ */
		CreationGraph cGr = new CreationGraph();
		ArrayList<String> text = cGr.ler("./Caixeiro_Viajante/data/Teste3.txt");

		int graphInicial[][] = cGr.graph(text);

		for (int[] graph1 : graphInicial) {
			for (int j = 0; j < graphInicial.length; j++) {
				System.out.print(" " + graph1[j] + " ");
			}
			System.out.println();
		}

		
		// Atribuição da quantidade de caminhos a serem utilizados
		int graphMax[][] = new int[11][11];
		int nVertex = graphMax.length;

		for (int i = 0; i < nVertex; i++) {
			for (int j = 0; j < nVertex; j++) {
				graphMax[i][j] = graphInicial[i][j];
			}
		}

		
		/* ************ Declaracao das variaveis ************ */

		int kIndividuos = 10;
		int KGenes = nVertex;
		int KVezes = (int) (0.6 * kIndividuos);
		int qntCruzamento = (int) (0.1 * kIndividuos);
		int ponto = (int) (0.5 * KGenes);
		int KMutacao = (int) (0.5 * kIndividuos);
		int kSelecao = (int) (0.5 * kIndividuos);

		Population controle = new Population();
		ArrayList<Individual> populacao = new ArrayList<>();
		Operations operations = new Operations();

		/* Inicio da contagem do tempo */
		long start = System.currentTimeMillis();
		
		populacao = operations.CallAll(controle, populacao, kIndividuos, KGenes,
									KVezes, qntCruzamento, ponto, KMutacao, kSelecao, graphMax);

		long end = System.currentTimeMillis();
		/* Fim da contagem do tempo */
		
		
		/* Contagem da memória */
		int dataSize = 1024 * 1024;
		Runtime runtime = Runtime.getRuntime();

		/* ************ Saídas ************ */
		System.out.println("\n****** Populacao Final: *****");
		controle.printPopulation(populacao);
		controle.printEsforco(populacao);
		System.out.printf("\nTempo de Execucao: %.3f ms%n", (end - start) / 1000d);
		System.out.println("\nMemoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / dataSize + "MB");
		Operations.printShowPath(populacao);
	}

}

