public class Frank extends BasicPlayer implements IPlayer{
    public Frank(){
        super();
        this.hitPoints = 30;
        this.name = "Frank";
        this.strength = 30;
    }
    @Override
    public void attack(IPlayer opponent) {
        opponent.takeDamage(this.hitPoints);
        this.hitPoints -=5; //old man gets weaker with each attack
    }
}
