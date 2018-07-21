import java.util.ArrayList;
import java.util.List;

public class Space {

    public static Space game;
    private int width;
    private int height;
    private SpaceShip ship;
    private ArrayList<Ufo> ufos = new ArrayList<>();
    private ArrayList<Rocket> rockets = new ArrayList<>();
    private ArrayList<Bomb> bombs = new ArrayList<>();


    public static void main(String[] args) {

    }

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void moveAllItems() {
        for (BaseObject object : getAllItems()) {
            object.move();
        }
    }

    public List<BaseObject> getAllItems() {
        ArrayList<BaseObject> list = new ArrayList<BaseObject>(ufos);
        list.add(ship);
        list.addAll(bombs);
        list.addAll(rockets);
        return list;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public ArrayList<Ufo> getUfos() {
        return ufos;
    }

    public ArrayList<Rocket> getRockets() {
        return rockets;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public void sleep(int ms) {

    }

    public void run() {

    }

    public void draw() {

    }
}
