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

    /**
     * Создаем новый НЛО. 1 раз на 10 вызовов.
     */
    public void createUfo() {
        if (ufos.size() > 0) return;

        int random10 = (int) (Math.random() * 10);
        if (random10 == 0) {
            double x = Math.random() * width;
            double y = Math.random() * height / 2;
            ufos.add(new Ufo(x, y));
        }
    }

    public void checkBombs() {
        for (Bomb bomb : bombs) {
            if (ship.isIntersect(bomb)) {
                ship.die();
                bomb.die();
            }
            if (bomb.getY() >= height)
                bomb.die();
        }
    }

    public void checkRockets() {
        for (Rocket rocket : rockets) {
            for (Ufo ufo : ufos) {
                if (ufo.isIntersect(rocket)) {
                    ufo.die();
                    rocket.die();
                }
            }
            if (rocket.getY() <= 0)
                rocket.die();
        }
    }

    public void removeDead() {
        for (BaseObject object : new ArrayList<BaseObject>(bombs)) {
            if (!object.isAlive())
                bombs.remove(object);
        }
        for (BaseObject object : new ArrayList<BaseObject>(rockets)) {
            if (!object.isAlive())
                rockets.remove(object);
        }
        for (BaseObject object : new ArrayList<BaseObject>(ufos)) {
            if (!object.isAlive())
                ufos.remove(object);
        }
    }
}
