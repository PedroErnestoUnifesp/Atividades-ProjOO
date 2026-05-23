public class ConcreteTree implements Tree {
    private String color;
    private float height;
    private float width;

    public ConcreteTree(String color, float width, float height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    @Override
    public void plant(int x, int y) {
        System.out.println("Planting a " + this.color + " tree at (" + x + ", " + y + ")");
    }
}
