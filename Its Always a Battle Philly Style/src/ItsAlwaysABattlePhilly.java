import java.util.LinkedList;
import java.util.Random;

/**
 * Controller for It's always a battle game
 */
public class ItsAlwaysABattlePhilly implements IGame{

    BasicPlayer player1;
    BasicPlayer player2;
    BasicWeapon weapon1;
    BasicWeapon weapon2;
    BasicLocation l;
    View v;
    LinkedListImpl<Villain> villains = new LinkedListImpl<>();
    LinkedListImpl<BasicLocation> locations = new LinkedListImpl<>();
    LinkedListImpl<BasicWeapon> weapons = new LinkedListImpl<>();


    public ItsAlwaysABattlePhilly() {
        this.v = new View();
        this.l=setLocation();//utilizes setLocation method to determine battleground
        v.startUp(this.l);
        //create player 1 based on selection from view
        switch(v.playerChoice){
            case 1: this.player1 = new Frank();
                break;
            case 2: this.player1= new Dennis();
                break;
            case 3: this.player1=new Dee();
                break;
            case 4: this.player1=new Mac();
                break;
            case 5: this.player1=new Charlie();
                break;
            case 6: this.player1= new BasicPlayer();
                break;
        }
        l.playerBonus(this.player1); //gives player any bonus or malus

        //create weapon 1 based on selection from view
        switch(v.weaponChoice){
            case 1: this.weapon1 = new RatStick();
                break;
            case 2: this.weapon1= new Nunchaku();
                break;
            case 3: this.weapon1= new RumHam();
                break;
            case 4: this.weapon1 =new Flamethrower();
                break;
            case 5: this.weapon1= new ToeKnife();
                break;
            case 6: this.weapon1= new BasicWeapon();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.weaponChoice);
        }
        l.weaponBonus(this.weapon1);//gives any bonus or malus for Players weapon

        //add random villains to list for player 2
        Random rand = new Random(); //new random generator
        villains.addBack(new Villain());
        villains.addBack(new Villain());
        villains.addBack(new Villain());
        villains.addBack(new Villain());
        int randInt= rand.nextInt(villains.getSize()-1); //get a random int between 0-3 for index value
        this.player2= (BasicPlayer) villains.get(randInt); //select the Villain at the random index
       // String villain = villains.map(IPlayer::getName).toString();// These two lines were used for testing purposes
       // System.out.println(villain);
        l.playerBonus(this.player2);//gives any bonus or malus to villain

        //add random weapons to list for weapon 2
        weapons.addBack(new RatStick());
        weapons.addBack(new RumHam());
        randInt=rand.nextInt(weapons.getSize()-1); //gets a new random int between 0-1 for index value
        this.weapon2 = (BasicWeapon) weapons.get(randInt);

    }

    @Override
    public void battle() {
        //v.startUp();
        int p1health= this.player1.getHealth();
        int p2health= this.player2.getHealth();
        singleRound();
        if (p1health>0&&p2health>0){
            //recursively battle until one of the players dies
            battle();
            player1.isAlive(); //updates status of player 1
            player2.isAlive(); //updates status of player 2
        }
        if(p1health<=0){
            System.out.println(v.winMess(player2));
            System.out.println(v.losingMess(player1)); //if p1 dies print their losing message
        }
        if(p2health<=0){
            System.out.println(v.winMess(player1));//if p2 does print the winning message
            System.out.println(v.losingMess(player2));
        }
    }

    public void singleRound(){
            player1.attack(player2);
            player2.attack(player1);
    }

    private BasicLocation setLocation(){
        locations.addBack(new PaddysPub(player1,player2,weapon1,weapon2));
        locations.addBack(new FrankAndCharliesApt(player1,player2,weapon1,weapon2));
        Random picker=new Random();
        int randInt= picker.nextInt(2);
        this.l= (BasicLocation) locations.get(randInt);
        return this.l;
    }


}


