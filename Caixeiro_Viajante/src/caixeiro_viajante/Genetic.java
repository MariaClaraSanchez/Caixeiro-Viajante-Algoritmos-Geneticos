package caixeiro_viajante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Maria Sanchez
 */

public class Genetic {

	public Individual crossover(int[] pai, int[] mae, Individual filho, int cutSize) {

		for (int i = 0; i < cutSize; i++) {
			filho.setGene(i, pai[i]);
		}
		for (int i = cutSize; i < filho.getSize(); i++) {
			filho.setGene(i, mae[i]);
		}

		return filho;
	}

	public Individual mutation(int[] individuo, int KGenes, int KMutacao) {

		Random random = new Random();
		Individual aux = new Individual(KGenes);

		int size = individuo.length;
		int mutacao, pos;

		// System.out.println("Antes da Mutacao:");
		for (int i = 0; i < size; i++) {
			aux.setGene(i, individuo[i]);
		}

		for (int i = 0; i < KMutacao; i++) {
			mutacao = random.nextInt(size);
			pos = random.nextInt(size);
			aux.setGene(pos, mutacao);
		}

		// System.out.println("Depois da Mutacao:");
		// aux.printIndividuo();
		return aux;
	}

	public ArrayList<Individual> select(ArrayList<Individual> populacao, int KSelecao, int Kgenes) {
		Random random = new Random();
		ArrayList<Individual> popSelecionada = new ArrayList<Individual>();
		Individual indAux = new Individual(Kgenes);

		int melhorEsforco;
		int esforco, pos = 0;
		int tamPop = populacao.size();
		int cont = 0;

		/* Encontrando os melhores esforcos */
		while (cont != KSelecao) {
			pos = 0;
			melhorEsforco = 1000000000;
			tamPop = populacao.size();

			for (int i = 0; i < tamPop; i++) {
				esforco = populacao.get(i).getEsforco();
				if (esforco == -1) {
					continue;
				} else {
					if ((esforco <= melhorEsforco) && (esforco != 1)) {
						melhorEsforco = esforco;
						pos = i;
					}
				}

			}
			if (pos == 0) {
				do {
					pos = random.nextInt(tamPop);
					esforco = populacao.get(pos).getEsforco();
					if (esforco == -1) {
						indAux = populacao.get(pos);
						popSelecionada.add(indAux);
						populacao.remove(pos);
						indAux = null;
						cont++;
					}

				} while (esforco != -1);
			} else {
				indAux = populacao.get(pos);
				popSelecionada.add(indAux);
				populacao.remove(pos);
				indAux = null;
				cont++;
			}

		}

		System.out.println("\nQuantidade de Individuos Selecionados: " + popSelecionada.size());
		// System.out.println("Individuo Selecionado: " +
		// Arrays.toString(populacao.get(pos).getGenes()));

		return popSelecionada;

	}

}
