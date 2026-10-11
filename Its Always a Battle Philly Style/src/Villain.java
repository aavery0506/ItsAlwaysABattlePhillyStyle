import java.util.Random;

public class Villain extends BasicPlayer implements IPlayer {
    public Villain() {
        Random rand = new Random();
        int randInt = rand.nextInt(4);
        switch (randInt) {
            case 0:
                this.name = "Cricket";
                this.hitPoints = 20;
                break;
            case 1:
                this.name = "Maureen";
                this.hitPoints = 15;
                break;
            case 2:
                this.name = "the McPoyle Brothers";
                this.hitPoints = 40;
                break;
            case 3:
                this.name = "the Night Man";
                this.hitPoints =50;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + randInt);
        }
    }
}
