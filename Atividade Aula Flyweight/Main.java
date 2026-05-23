import java.util.ArrayList;
import java.util.List;

public class Main {
    // Para armazenar a nossa floresta, guardamos a posição (única) e a referência (Flyweight)
    record PlantedTree(int x, int y, Tree treeReference) {}

    public static void main(String[] args) {
        List<PlantedTree> forest = new ArrayList<>();
        String[] colors = {"Dark Green", "Light Green", "Amber Yellow"};
        float[] sizes = {5.0f, 6.5f, 7.0f};

        int treesToPlant = 10000; // Queremos 10 mil árvores

        System.out.println("Populating forest...\n");

        for (int i = 0; i < treesToPlant; i++) {
            // Gerando características aleatórias para a árvore
            String color = colors[(int) (Math.random() * colors.length)];
            float width = sizes[(int) (Math.random() * sizes.length)];
            float height = width * 3.0f; // Altura proporcional

            // Posições únicas para cada árvore (Estado Extrínseco)
            int x = (int) (Math.random() * 1000);
            int y = (int) (Math.random() * 1000);

            // A fábrica retorna uma instância existente ou cria uma nova
            Tree flyweightTree = TreeFactory.getTree(color, width, height);
            
            // Plantamos visualmente (vai imprimir muito no console, limite se quiser)
            // flyweightTree.plant(x, y); 

            // Guardamos a árvore na floresta
            forest.add(new PlantedTree(x, y, flyweightTree));
        }

        System.out.println("\n--- Summary ---");
        System.out.println("Total trees in the forest (visual/logic): " + forest.size());
        System.out.println("Total of REAL instances from ConcreteTree created in memory: " + TreeFactory.getCreatedTreesCount());
    }
}
