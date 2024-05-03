package application;

public class Gadget {
    protected String model;
    protected double price;
    protected int weight;
    protected String size;

    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getSize() {
        return size;
    }

    public void display() {
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Weight: " + weight);
        System.out.println("Size: " + size);
    }
}

