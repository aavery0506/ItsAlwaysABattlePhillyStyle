/**
 * sets up generic weapon for a player in the Its Always a Battle game.
 */
public class BasicWeapon implements IWeapon{
    String name;
    int damage;
    int durability;
    Status status;
public BasicWeapon(){
    this.status=Status.ALIVE;
    this.durability=100;
    this.damage = 10;
    this.name= "Generic Dagger";
}

    @Override
    public String getName() {
        return this.name;
    }

    public int useWeapon(){
    if(this.durability<=0){
        this.damage = 0;
    }
    else{
        this.durability-=1;
    }
    return this.damage;
}

}
