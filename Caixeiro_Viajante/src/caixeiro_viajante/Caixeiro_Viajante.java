package caixeiro_viajante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.w3c.dom.TypeInfo;

/**
 *
 * @author Maria Sanchez
 */
public class Caixeiro_Viajante {
    public static void main(String[] args) {
        int kIndividuos = 10;
        
        Population controle = new Population();

        ArrayList<Individual> populacao = new ArrayList<>();
        
        for (int i = 0; i < kIndividuos; i++) {
            Individual individuo = new Individual(6);
            controle.criarIndividuoAleatorio(individuo);
            populacao.add(individuo);
            //individuo.printIndividuo();
        }
        
        ArrayList<String> teste = new ArrayList<>();
        
        System.out.println("Geração da População:");
        for(int i=0; i<populacao.size();i++){
            //teste[i] = populacao.get(i).getGenes();
            teste.add(i, Arrays.toString(populacao.get(i).getGenes()));
            //crossover.cross(teste.get(i-1), teste.get(i));
            System.out.println(teste.get(i));
            //System.out.println(Arrays.toString(populacao.get(i).getGenes()));
        }

        //Sortear os Genes para o Cruzamento
        System.out.println("********************");
        System.out.println("Sorteio Genes");
        int qntK = 3;
        //Random random = new Random();
        RandomGenes random = new RandomGenes();
        ArrayList<Individual> genesSorteados = new ArrayList<>();
        genesSorteados = random.GenesAleatorios(teste, qntK);
        for(int i=0; i<qntK;i++){
            System.out.println(genesSorteados.get(i));
        }
        
        System.out.println("********************");
        
        Crossover crossover = new Crossover();
        crossover.cross(genesSorteados);
        
        //System.out.println(teste.get(random.nextInt(teste.size())));
        
        //System.out.println(teste.size());
        
        
        
        
        
        
        //crossover.cross(teste);
        
    }
    
}

// 1º População
// 2º Cruzamento
// 3º Mutação
// 4º Seleção

