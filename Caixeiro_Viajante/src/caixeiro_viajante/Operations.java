package caixeiro_viajante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Operations {

	Genetic genetic;

	public Operations() {
		this.genetic = new Genetic();
	}

	public void CallCrossover(int qntC, int ponto, int KGenes, ArrayList<Individual> populacao) {
		Random random = new Random();
		int num;
		Individual filho = new Individual(KGenes);
		int kIndividuos = populacao.size();

		for (int i = 0; i < qntC; i++) {

			num = random.nextInt(kIndividuos);
			if (num + 1 < populacao.size()) {
				int[] pai = populacao.get(num).getGenes();
				// System.out.println("Pai:" + Arrays.toString(populacao.get(num).getGenes()));
				int[] mae = populacao.get(num + 1).getGenes();
				// System.out.println("Mae:" +
				// Arrays.toString(populacao.get(num+1).getGenes()));

				filho = genetic.crossover(pai, mae, filho, ponto);

				populacao.add(filho);
				kIndividuos = populacao.size();
			}
		}
	}

	public void CallMutation(int qntC, int KGenes, int KMutacao, ArrayList<Individual> populacao) {
		Random random = new Random();
		int num;
		Individual mutacao = new Individual(KGenes);
		int kIndividuos = populacao.size();

		for (int i = 0; i < qntC; i++) {
			num = random.nextInt(kIndividuos);
			if (num + 1 < populacao.size()) {
				int[] aux = populacao.get(num + 1).getGenes();
				mutacao = genetic.mutation(aux, KGenes, KMutacao);
				populacao.add(num + 1, mutacao);
				populacao.remove(num + 2);
			}

		}
	}

	public ArrayList<Individual> CallSelection(ArrayList<Individual> populacao, int KSelecao, int Kgenes) {
		Genetic sel = new Genetic();

		return sel.select(populacao, KSelecao, Kgenes);
	}

	public static List<Integer> FindAdjacentVertex(int graph[][], int CurrentPosition) {

		List<Integer> vertices = new ArrayList<Integer>();

		for (int i = 0; i < graph.length; i++) {

			if (CurrentPosition != i && graph[CurrentPosition][i] != 0) {
				vertices.add(i);
			}
		}

		return vertices;
	}

	public static boolean AllVerticesTraversed(boolean[] vertices, int size) {
		int cont = 0;
		for (int i = 0; i < size; i++) {

			if (vertices[i] == true) {
				cont++;
			}
		}
		if (cont == size) {
			return true;
		} else {
			return false;
		}

	}

	public static ArrayList<Individual> CalculaEsforco(ArrayList<Individual> populacao, int graph[][], int Kgenes) {

		int Kpopulacao = populacao.size();
		List<Integer> verticesAdj = new ArrayList<Integer>();
		int valorGene, somador = 0, pos, pos2;

		/* Genes Repetidos - Atribuir -1 no esforco */

		for (int i = 0; i < Kpopulacao; i++) {
			for (int j = 0; j < Kgenes; j++) {

				if (j + 1 == Kgenes) {
					if (populacao.get(i).getGene(j) == populacao.get(i).getGene(0)) {
						populacao.get(i).setEsforco(-1);
						break;
					}
				} else {

					if (populacao.get(i).getGene(j) == populacao.get(i).getGene(j + 1)) {
						populacao.get(i).setEsforco(-1);
						break;
					}
				}
			}

		}

		/* Calcula o esforço */
		for (int i = 0; i < Kpopulacao; i++) {
			somador = 0;
			for (int j = 0; j < Kgenes; j++) {
				verticesAdj = FindAdjacentVertex(graph, populacao.get(i).getGene(j));
				// System.out.println("Vertices Adjacentes: " + verticesAdj);
				if (j + 1 == Kgenes) {
					pos = populacao.get(i).getGene(j);
				} else {
					pos = populacao.get(i).getGene(j + 1);
					if (verticesAdj.contains(pos)) {
						if (pos == Kgenes) {
							pos2 = populacao.get(i).getGene(0);
							somador += graph[populacao.get(i).getGene(j)][pos];
						}
						somador += graph[populacao.get(i).getGene(j)][pos];
					} else {
						populacao.get(i).setEsforco(-1);
						break;
					}
				}

			}
			if (populacao.get(i).getEsforco() != -1) {
				populacao.get(i).setEsforco(somador);
			}
		}

		return populacao;
	}

	public static void printShowPath(ArrayList<Individual> populacao) {
		int tam = populacao.size();
		int menor = -3;
		int valor=0;
		int pos = 0;

		/*for (int i = 0; i < tam; i++) {
			valor = populacao.get(i).getEsforco();
			if (valor == -1) {
				break;
			} else {
				if (valor >= menor) {
					menor = valor;
					pos = i;
				}
			}
		}*/
		
		if(valor == -1) {
			System.out.printf("Nenhum Caminho ótimo foi encontrado!!");
		}else {
			System.out.printf("Melhor Caminho é: " + Arrays.toString(populacao.get(pos).getGenes()));	
			System.out.printf("\nEsforço: " + populacao.get(pos).getEsforco());
		}
		

	}

}
