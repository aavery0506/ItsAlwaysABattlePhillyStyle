import java.util.Random;

public class BasicPlayer implements IPlayer{
    public String name;
    public Status alive;
    public int strength;
    public int hitPoints;
    protected int health;

    public BasicPlayer(){
        //generate a random int to select a random name for the BasicPlayer
        Random rand = new Random();
        int randInt= rand.nextInt(7);
        switch (randInt){
            case 0: this.name="The Waitress";
            break;
            case 1: this.name = "Artemis";
            break;
            case 2: this.name = "Barbara";
            break;
            case 3: this.name ="Mac's Mom";
            break;
            case 4: this.name="Charlie's Mom";
            break;
            case 5: this.name="Bill Ponderosa";
            break;
            case 6: this.name = "The Lawyer";
            break;
        }
        this.alive = Status.ALIVE;
        this.strength = 50;
        this.hitPoints = 10;
        this.health=100;
    }
    @Override
    public String getName(){
        return this.name;
}

    @Override
    public int getHealth() {return this.health;}
    @Override
    public void setAlive(Status newStat) {this.alive = newStat;}
    @Override
    public  Status isAlive(){
        if (this.health>0) {
            setAlive(Status.ALIVE);

        } else {
            setAlive(Status.DEAD);
        }
    return this.alive;
}

    @Override
    public void takeDamage(int damage) {
        if(this.health>damage){ //if health is greater than the damage reduce by damage amount
            this.health-=damage;//takes damage value away from health
            this.health+=strength;//adds strength value to health
            this.strength-=damage;//reduces total strength by damage amount
        }
        else{ // is the damage is greater than the players health return 0, player is dead.
            health=0;
        }
        this.isAlive();//update stats of player after damage is taken
    }

    @Override
    public void attack(IPlayer opponent) {
        opponent.takeDamage(this.hitPoints);
    }

    public String toString(){
        return "Name: "+ this.name + "\n"+
                "Health: " + this.health + "\n"+
                "Status: " + this.alive + "\n"+
                "Hit Points: " + this.hitPoints + "\n"+
                "Strength: "+ this.strength + "\n";
    }

}
