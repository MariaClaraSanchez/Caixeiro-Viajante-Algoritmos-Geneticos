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
		// Atribuição da quantidade de caminhos a serem utilizados
		int graphMax[][] = new int[19][19];
		int nVertex = graphMax.length;

		for (int i = 0; i < nVertex; i++) {
			for (int j = 0; j < nVertex; j++) {
				graphMax[i][j] = graphInicial[i][j];
			}
		}

		
		/* ************ Declaracao das variaveis ************ */

		int kIndividuos = 15000;
		int KGenes = nVertex;
		int KVezes = (int) (0.4 * kIndividuos);
		int qntCruzamento = (int) (0.3 * kIndividuos);
		int KMutacao = (int) (0.1 * kIndividuos);
		int kSelecao = (int) (0.1 * kIndividuos);
		int ponto = (int) (0.5 * KGenes);

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
		System.out.println("\n************ Saidas ************");
		System.out.printf("\nTempo de Execucao: %.3f s %n", (end - start) / 1000d);
		System.out.printf("Tempo de Execucao: %.3f m %n", ((end - start) / 1000)/60d);
		System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / dataSize + "MB");
		Operations.printShowPath(populacao);
	}

}

