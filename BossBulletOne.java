import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossBulletOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossBulletOne extends Actor
{
    /**
     * Act - do whatever the BossBulletOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int bulletspeed = 5;
    public void act()
    {
        // Add your action code here.
        move(bulletspeed);
        boundary();
        checkHitFrog();
    }
    
    public void boundary()
    {   
        MyWorld world = (MyWorld) getWorld();
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
    
    private void checkHitFrog() 
    {
        Frog frog = (Frog) getOneIntersectingObject(Frog.class);
        if (frog != null) {
            // Add actions if the bullet hits the frog
            getWorld().removeObject(this);
            frog.takeDamage(); // Assuming Frog has a method to handle taking damage
        }
    }
}
