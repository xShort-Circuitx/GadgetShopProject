package application;

public class MP3 extends Gadget {
    private int availableMemory;

    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    public int getAvailableMemory() {
        return availableMemory;
    }

    public void downloadMusic(int size) {
        if (size <= availableMemory) {
            availableMemory -= size;
            System.out.println("Music downloaded successfully.");
        } else {
            System.out.println("Not enough memory to download music.");
        }
    }

    public void deleteMusic(int size) {
        availableMemory += size;
        System.out.println("Music deleted successfully.");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Available Memory: " + availableMemory);
    }

	public void setMemory(int i) {
		// TODO Auto-generated method stub
		this.availableMemory=i;
		
	}
}

