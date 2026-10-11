import java.util.Scanner;

/**
 * Generates a basic menu-driven command line structure for battle game
 */
public class View {
    public int playerChoice;
    public int weaponChoice;
    public BasicLocation location;

    public void startUp(BasicLocation location) {
        this.location=location;
        System.out.println(location.toString());
        //this program is not actually sponsored or endorsed by any affiliates of Kelly and Associates or by It's Always Sunny in Philadelphia
        Scanner input = new Scanner(System.in);
        System.out.println("First you must select your character:");
        System.out.println("Make your selection 1-5\n\t" +
                "1.Frank\n\t" +
                "2.Dennis\n\t" +
                "3.Dee\n\t" +
                "4.Mac\n\t" +
                "5.Charlie\n\t" +
                "6.Random choice");
        this.playerChoice = input.nextInt();
        System.out.println("Every great fighter needs a weapon, choose wisely:\n" +
                "Make your selection 1-5\n\t" +
                "1.Rat Stick\n\t" +
                "2.Nunchaku\n\t" +
                "3.Rum Ham\n\t" +
                "4.Flamethrower\n\t" +
                "5.Toe Knife\n\t" +
                "6.Surprise me!");
        this.weaponChoice = input.nextInt();
        System.out.println("Get ready to rrruuummmbbbblllleee!!!!");
        String player = "";
        String weapon = "";
        String wepPhrase ="";
        switch (playerChoice) {
            case 1:
                player = "Frank";
                break;
            case 2:
                player = "Dennis";
                break;
            case 3:
                player = "Dee";
                break;
            case 4:
                player = "Mac";
                break;
            case 5:
                player = "Charlie";
                break;
            case 6:
                player = "a Random Character";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + playerChoice);
        }
        switch (weaponChoice) {
            case 1:
                weapon = "Rat Stick";
                wepPhrase ="I will SMASH your face into a- into a jelly!";
                break;
            case 2:
                weapon = "Nunchaku";
                wepPhrase ="All my skills and training tell me to use this as a weapon";
                break;
            case 3:
                weapon = "Rum Ham";
                wepPhrase = "This is ham, soaked in rum.";
                break;
            case 4:
                weapon = "Flamethrower";
                wepPhrase = "That thing's badass, man. It's like a flamethrower.";
                break;
            case 5:
                weapon = "Toe Knife";
                wepPhrase = "Jesus Christ, "+player+". Are you cutting your toenails with a steak knife?";
                break;
            case 6:
                weapon = "Surprise weapon";
                wepPhrase ="Wildcard, bitches! Yee-haw!";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + weaponChoice);
        }
        System.out.println("You have decided to try your luck with "
                + player + " hopefully the "
                + weapon + " will help you succeed!");
        System.out.println(wepPhrase);
        System.out.println("\n");
    }


    public String losingMess(IPlayer player) {
        return "Whomp Whomp...Hey " + player.getName() + " Can I offer you a nice egg in this trying time?";
    }

    public String winMess(IPlayer player) {
        String str = switch (playerChoice) {
            case 1 ->
                    "If you’re dealt a bunch of lemons, you got to take those lemons, and stuff them down somebody’s throat until they see yellow. - Frank";
            case 2 ->
                    "Let me tell you something. I haven’t even begun to peak. And when I do peak, you’ll know. Because I’m gonna peak so hard that everybody in Philadelphia’s gonna feel it.- Dennis";
            case 3 -> "It’s like when I’m doing good in the game I’m doing good in life. - Dee";
            case 4 -> "Throughout history, the ass kickers have always known carpentry – Jesus Christ, Harrison Ford. - Mac";
            case 5 -> "I’m not an executioner. I’m the best goddamn bird lawyer in the world. - Charlie";
            case 6 -> "We used to be losers, like all of you people.";
            default -> throw new IllegalStateException("Unexpected value: " + playerChoice);
        };
        return "And the winner is: "+ player.getName()+" \n"+str;
    }

    public String getLocation() {
        return location.toString();
    }



}
