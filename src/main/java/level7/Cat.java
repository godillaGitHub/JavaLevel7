package level7;

public class Cat {

    private String name;
    private int appetite;
    private boolean welFed;

    public Cat(String name, int appetite, boolean welFed) {
        this.name     = name;
        this.appetite = appetite;
        this.welFed   = welFed;
    }
    public void eat(Plate p) {
        p.decreaseFood(appetite);
    }

    public boolean enoughFood(Plate p) {
        welFed  = p.enoughFoodInThePlate(appetite);
        return welFed;
    }

    public void info() {
        System.out.println("Вот такая кошка: " + name + " вот с таким аппетитом " + appetite + (welFed ? " сыта" : " голодная"));
    }

}
