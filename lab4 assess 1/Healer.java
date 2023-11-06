package ioop.lab4;

public class Healer extends Character {
    
    public Healer(String name, Coordinates location, int maxHealth, World world, Damage attack, Coordinates goal) {
        super(name, location, maxHealth, world, attack, goal);
    }

    // Task 3.2
    public void encounter(WorldEntity traveller) {
        if (traveller.location.equals(Adventurer.class)==true) {
            traveller.currentHealth=traveller.maxHealth;
        }
        else if (traveller.location.equals(Monster.class)==true) {
            world.battle(this,traveller);
        }
    }

}
