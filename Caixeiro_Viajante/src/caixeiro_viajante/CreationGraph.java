package caixeiro_viajante;

import java.util.ArrayList;

/**
 *
 * @author Maria Sanchez
 */
public class CreationGraph {

    String nome;

    public ArrayList ler(String nome) {
        this.nome = nome;
        FileManager fileManager = new FileManager();
        ArrayList<String> text = fileManager.stringReader(nome);
        return text;
    }
    

    public int[][] graph(ArrayList text) {
        
        int nVertex = 0;
        int graph[][] = null;

        for (int i = 0; i < text.size(); i++) {
            String line = (String) text.get(i);
            if (i == 0) {
                nVertex = Integer.parseInt(line.trim());
                graph = new int[nVertex][nVertex];
            } else {
                int oriVertex = Integer.parseInt(line.split(" ")[0]);
                String splits[] = line.substring(line.indexOf(" "), line.length()).split(";");
                for (String part : splits) {
                    String edgeData[] = part.split("-");
                    int targetVertex = Integer.parseInt(edgeData[0].trim());
                    int weight = Integer.parseInt(edgeData[1]);

                    graph[oriVertex][targetVertex] = weight;
                    graph[targetVertex][oriVertex] = weight;
                    /*
                        if (graph[oriVertex][targetVertex] == 0) { graph[targetVertex][oriVertex] = weight;}
                     */
                }
            }
        }
       
        return graph;
    }
}