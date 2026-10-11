/**
 * Represents a Character for It's Always a Battle Philly Style
 */
public interface IPlayer {
    /**
     * getName method gets the name of the IPlayer
     * @return int representing the health
     */
    String getName();

    /**
     * getHealth returns the int value of the health of the IPlayer
     * @return int representing health value
     */
    int getHealth();

    /**
     * setAlive takes in a Status and sets the status of the IPlayer
     * @param newStat new Status of the IPlayer
     */
    void setAlive(Status newStat);
    /**
     * reduces health by the damage amount,
     * adds strength back to health
     * reduces strength by damage amount.
     * @param damage damage to be taken from the health and strength
     */
    void takeDamage(int damage);

    /**
     * inflicts hitPoints on opponent utilizing takeDamage method
     * @param opponent
     */
    void attack(IPlayer opponent);

    /**
     * isAlive sets the status of the player to {@Link Status} ALIVE of DEAD
     * depending on the health of the IPlayer
     */
    Status isAlive();
}
