import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicPlayerTest {
    BasicPlayer p1;
    BasicPlayer p2;

    @Before


    public void setUp() {
        this.p1=new BasicPlayer();
        this.p2= new BasicPlayer();
    }

    @Test
    public void setAliveTest(){
        p1.setAlive(Status.ALIVE);
        assertTrue(p1.alive==Status.ALIVE);
        p1.setAlive(Status.DEAD);
        assertTrue(p1.alive==Status.DEAD);
    }
    @Test
    public void isAliveTest(){
        p2.health=0;
        assertEquals(Status.DEAD,p2.isAlive());
        p2.health = 10;
        assertEquals(Status.ALIVE,p2.isAlive());
    }
    @Test
    public void takeDamageTest() {
        assertEquals(100,p1.health);
        p1.takeDamage(10);
        assertEquals(90,p1.health);
        p1.takeDamage(100);
        assertEquals(0,p1.health);
    }

    @Test
    public void attackTest() {
        assertEquals(10,p1.hitPoints);
        assertEquals(100,p2.health);
        p1.attack(p2);
        assertEquals(140,p2.health);
        p1.hitPoints=90;
        p1.attack(p2);
        assertEquals(90,p2.health);
    }
}