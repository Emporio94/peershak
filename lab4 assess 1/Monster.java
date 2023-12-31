package ioop.lab4;

public class Monster extends TravellingWorldEntity{
    
    private int speed;
    private int stepTimer=0;
    protected int xp=0;
    protected int level=1;
    protected int nextLevel=2;
    protected boolean awake=false;

    //Task2.2
    public Monster(String name, Coordinates location, int maxHealth, World world, Damage attack, int speed) {
        super(name, location, maxHealth, world, attack);
        this.speed=speed;
    }

    // Task 2.2
    public void takeTurn()
    {
        if (awake==true){
            if (stepTimer<=speed){
                stepTimer++;
            }
            else {
                stepTimer=0;
                move(location.getNextStepTo(world.getAdventurer().location));
            }
        }
    }
    
    //Task 2.2
    public void gainXP(int amount)
    {
        while(amount>=nextLevel){
            level++;
            amount=amount+xp-nextLevel;
            xp=0;
            nextLevel=nextLevel*2;
            maxHealth=maxHealth+10;
            currentHealth=maxHealth;
        }
        xp = amount;

    }
    
    //Task 2.2 - this code is incomplete but note how the monster instance passes itself as a parameter to the battle method!
    public void encounter(WorldEntity traveller)
    {
        if (awake==true){
            world.battle(this,traveller);
        } 
        else {
            awake = true;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public int getStepTimer() {
        return stepTimer;
    }

    public boolean isAwake() {
        return awake;
    }

    public int getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    public void setAwake(boolean awake)
    {
        this.awake=awake;
    }

    
}
