public class Charlie extends BasicPlayer implements IPlayer{
    public Charlie(){
        super();
        this.hitPoints = 30;
        this.name = "Charlie";
        this.strength = 44;
    }
    @Override
    public void attack(IPlayer opponent) {
        opponent.takeDamage(this.hitPoints);
        this.strength+=5;//rage power
    }
}
