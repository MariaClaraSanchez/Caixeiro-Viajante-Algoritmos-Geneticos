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

		filho.printIndividuo();
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
		// aux.printIndividuo();

		for (int i = 0; i < KMutacao; i++) {
			mutacao = random.nextInt(size);
			pos = random.nextInt(size);
			aux.setGene(pos, mutacao);
		}

		// System.out.println("Depois da Mutacao:");
		// aux.printIndividuo();
		return aux;
	}

	public ArrayList<Individual> selecao(ArrayList<Individual> populacao, int KSelecao, int Kgenes) {
		ArrayList<Individual> popSelecionada = new ArrayList<Individual>();
		Individual indAux = new Individual(Kgenes);
		//ArrayList<Individual> popAux = new ArrayList<>();

		int melhorEsforco;
		int esforco, pos;
		int tamPop = populacao.size();
		int cont = 0;

		/* Encontrando os melhores esforcos */
		while(cont!=KSelecao) {
			pos = 0;
			melhorEsforco = 10000;
			tamPop = populacao.size();
			
			for (int i = 0; i < tamPop; i++) {
				esforco = populacao.get(i).getEsforco();
				if (esforco == -1) {
					melhorEsforco = 10000;
					continue;
				}
				else {
					if (esforco <= melhorEsforco) {
						melhorEsforco = esforco;
						pos = i;
					}
				}

			}
			
			indAux = populacao.get(pos);
			popSelecionada.add(indAux);
			populacao.remove(pos);
			indAux = null;
			cont++;

		}

		return popSelecionada;

	}

}
