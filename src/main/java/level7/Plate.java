package level7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        food -= n;
    }

    public boolean enoughFoodInThePlate(int n) {
        return (food - n) >= 0;
    }

    public void increaseFood(int n) {
        food += n;
        System.out.println("Увеличили еды в тарелке вот на столько " + n);
    }

    public int getFoodCount() {
        return food;
    }

    public void info() {
        if (food == 0) {
            System.out.println("Еды в тарелке больше не осталось.");
        }
        else {
            System.out.println("Вот столько еды осталось в тарелке: " + food);
        }
    }

}
