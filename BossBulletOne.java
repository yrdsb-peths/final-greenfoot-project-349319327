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
    }
    public void boundary()
    {   
        MyWorld world = (MyWorld) getWorld();
        if(getX() >= world.getWidth())
        {
            
            world.removeObject(this);
        }
    }
}
