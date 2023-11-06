package ioop.lab4;

public class Adventurer extends WorldEntity{

    private Damage[] attacks = new Damage[3];


    // Task 3.1
    public Adventurer(String name, Coordinates location, int maxHealth, World world, Damage attack) {
        super(name, location, maxHealth, world, attack);
        attacks[0]=attack;
    }

    // Task 3.1
    public void addAttack(Damage attack)
    {
        for (int i=0;i<3;i++){
            if (attacks[i]==null){
                attacks[i]=attack;
                break;
            }
        }
    }

    // Task 3.1
    public void attack(WorldEntity target)
    {
        for (int i=0;i<3;i++){
            if (attacks[i]!=null) {
                target.takeDamage(attacks[i]);
            }
        }
    }

    public Damage[] getAttacks()
    {
        return attacks;
    }
    


}