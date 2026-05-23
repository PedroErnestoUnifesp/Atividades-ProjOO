import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static final Map<TreeState, Tree> treeMap = new HashMap<>();

    public static Tree getTree(String color, float width, float height) {
        TreeState key = new TreeState(color, height, width);
        Tree tree = treeMap.get(key);
        
        if (tree == null) {
            tree = new ConcreteTree(color, width, height);
            treeMap.put(key, tree); // Faltava ponto e vírgula
            System.out.println(">> Creating NEW tree object: " + color + " with size " + width + "x" + height); // Corrigido a concatenação
        }
        return tree;
    }
    
    // Método extra apenas para checarmos quantas instâncias reais foram criadas
    public static int getCreatedTreesCount() {
        return treeMap.size();
    }
}
