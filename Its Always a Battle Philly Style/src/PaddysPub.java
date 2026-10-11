public class PaddysPub extends BasicLocation{
    public PaddysPub(BasicPlayer player1, BasicPlayer player2,BasicWeapon weapon1, BasicWeapon weapon2){
        this.name = "Paddy's Pub";
       // playerBonus(player1);
       // playerBonus(player2);
       // weaponBonus(weapon1);
       // weaponBonus(weapon2);
    }

    @Override
    void playerBonus(BasicPlayer player) {
        String pName = player.getName();
        switch(pName){
            case "Charlie":
                player.health += 25;
                break;
            case "Mac":
                player.health += 10;
                break;
            case "Frank":
                player.health -=10;
                break;
            case"Dennis":
                player.health+= 10;
                break;
            case "Dee":
                player.health+=15;
                break;
            case "McPoyle Brothers":
                player.health -= 25;
                break;
            case "Cricket":
                player.health += 10;
                break;
            case "Maureen":
                player.health -=10;
                break;
            case"Nightman":
                player.health+= 10;
                break;
        }
    }

    @Override
    void weaponBonus(BasicWeapon weapon) {
        String wName = weapon.getName();
        switch(wName){
            case "Rat Stick":
                weapon.durability += 25;
            case "Rum Ham":
                weapon.durability += 10;
            case "Flamethrower":
                weapon.durability -=10;
            case"Generic Dagger":
                weapon.durability+= 10;
            case "Toe Knife":
                weapon.durability+=15;
            case "Trash Can":
                weapon.durability -= 25;
        }
    }
    @Override
    public String toString(){
        return "Welcome to Paddy's Irish Pub"+"\n"
                +"Home of Charlie Kelly's Sunblock drink."+"\n"
                +"Sponsored by Kelly and Associates specializing in Bird Law";
    }

}
