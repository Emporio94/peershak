package ioop.lab4;

public class Coordinates {
    public final static Coordinates NORTH_VECTOR = new Coordinates(1, 0);
    public final static Coordinates SOUTH_VECTOR = new Coordinates(-1, 0);
    public final static Coordinates EAST_VECTOR = new Coordinates(0, 1);
    public final static Coordinates WEST_VECTOR = new Coordinates(0, -1);
    public final static Coordinates STATIONARY = new Coordinates(0, 0);

    protected int x;
    protected int y;

    // Task 1.1
    public Coordinates(int x, int y) {
        this.x=x;
        this.y=y;
    }

    // Task 1.1
    public void addCoordinates(Coordinates vector) {
        this.x += vector.getX();
        this.y += vector.getY();
    }

    // Task 1.1
    public Coordinates findSafeMove(World world) {
        if (this.x+1<=world.getxDimension() && this.x+1>=0) {
            return NORTH_VECTOR;
        }
        else if (this.y+1<=world.getyDimension() && this.y+1>=0) {
            return EAST_VECTOR;
        }
        else if (this.x-1<=world.getyDimension() && this.x-1>=0) {
            return SOUTH_VECTOR;
        }
        else if (this.y-1<=world.getyDimension() && this.y-1>=0) {
            return WEST_VECTOR;
        }
        else {
            return STATIONARY;
        }
    }

    // Task 1.2
    public Coordinates getNextStepTo(Coordinates destination) {
        int currentX = this.x;
        int currentY = this.y;
        int desX = destination.getX();
        int desY = destination.getY();

        if (Math.abs(desX - currentX) > Math.abs(desY - currentY)) {
            if (desX > currentX){
                return NORTH_VECTOR;
            }
            else {
                return SOUTH_VECTOR;
            }
        }
        else if (Math.abs(desX - currentX) < Math.abs(desY - currentY)) {
            if (desY > currentY){
                return EAST_VECTOR;
            }
            else {
                return WEST_VECTOR;
            }
        }
        else {
            return STATIONARY;
        }
    }

    // Task 1.3
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Coordinates check = (Coordinates) obj;
        if (check.getX()==this.x && check.getY()==this.y){
            return true;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
