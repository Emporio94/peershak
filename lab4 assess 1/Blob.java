package ioop.lab4;

public class Blob extends Monster{
    public Blob(String name, Coordinates location, int maxHealth, World world, Damage attack, int speed) {
        super(name, location, maxHealth, world, attack, speed);
    }

    public void encounter(WorldEntity traveller)
    {
        if (traveller instanceof Blob){
            maxHealth+=traveller.getMaxHealth();
            currentHealth+=traveller.getCurrentHealth();
            this.gainXP((int)(Math.pow(2,((Monster)traveller).level)+((Monster)traveller).xp));
            traveller.conscious=false;
        }
        else {
            if (awake==true){
                world.battle(this,traveller);
            } 
            else {
                awake = true;
            }
        }

    }


}
