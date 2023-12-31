package ioop.lab4;

public class TravellingWorldEntity extends WorldEntity{

    public TravellingWorldEntity(String name, Coordinates location, int maxHealth, World world, Damage attack) {
        super(name, location, maxHealth, world, attack);
    }

    // Task 2.1
    public void takeTurn()
    {
        move(location.findSafeMove(world));
    }    

    // Task 2.1
    public void move(Coordinates vector)
    {
        location.x += vector.x;
        location.y += vector.y;
    }
    
}
