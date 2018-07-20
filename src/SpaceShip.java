
public class SpaceShip extends BaseObject{

    private int dx = 0;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }

    public void moveLeft() {
        dx = -1;
    }

    public void moveRight() {
        dx = 1;
    }

    @Override
    public void move() {
        setX(getX() + dx);
        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() + 1);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public void fire() {
        Space.game.getRockets().add(new Rocket(x - 2, y));
        Space.game.getRockets().add(new Rocket(x + 2, y));
    }
}
