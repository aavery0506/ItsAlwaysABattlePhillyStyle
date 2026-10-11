public class Mac extends BasicPlayer implements IPlayer{
    public Mac(){
        super();
        this.hitPoints = 35;
        this.name = "Mac";
        this.strength = 45;
    }
    @Override
    public void attack(IPlayer opponent) {
        opponent.takeDamage(this.hitPoints);
    }
}
