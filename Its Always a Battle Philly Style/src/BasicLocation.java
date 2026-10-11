/**
 * Abstract class sets up a basic battle location for the Its Always
 */
public abstract class BasicLocation {
String name;
BasicPlayer player1;
BasicPlayer player2;
BasicWeapon weapon1;
BasicWeapon weapon2;


    /**
     * bonus method adds bonus "power" to certain players or weapons based on location
     */
    abstract void playerBonus(BasicPlayer player);
    /**
     * malus method adds penalties to certain players or weapons based on location
     */
    abstract void weaponBonus(BasicWeapon weapon);

    /**
     * Simulates a battle between two players
      * @param player1
     * @param player2
     */

}
