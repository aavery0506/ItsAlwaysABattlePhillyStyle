public class FrankAndCharliesApt extends BasicLocation{

    public FrankAndCharliesApt(BasicPlayer player1, BasicPlayer player2,BasicWeapon weapon1, BasicWeapon weapon2){
        this.name = "Paddy's Pub";
        //playerBonus(player1);
       // playerBonus(player2);
       // weaponBonus(weapon1);
       // weaponBonus(weapon2);
    }

    @Override
    void playerBonus(BasicPlayer player) {
        String pName = player.getName();
        switch(pName){
            case "Charlie":
                player.health += 50;
                break;
            case "Frank":
                player.health -=50;
                break;
            case"Dennis":
                player.health+= 15;
                break;
            case "McPoyle Brothers":
                player.health -= 15;
                break;
            case "Cricket":
                player.health -= 10;
                break;
            case "Maureen":
                player.health -=20;
                break;
            case"Nightman":
                player.health-= 10;
                break;
            case "Barbara":
                player.health +=20;
        }
    }


    @Override
    void weaponBonus(BasicWeapon weapon) {
        String wName = weapon.getName();
        switch(wName){
            case "Rat Stick":
                weapon.durability += 15;
            case "Rum Ham":
                weapon.durability += 20;
            case "Toe Knife":
                weapon.durability+=45;
        }
    }

    @Override
    public String toString(){
        return "Welcome to the home of the Gruesome Twosome"+"\n"
                +"You gotta pay the troll toll...";
    }

}

