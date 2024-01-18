import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * drill bullet used by the Frog
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{   
    
    
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int bulletspeed = 5;
    public void act()
    {
        // Add your action code here.
        GreenfootImage bulletImage = new GreenfootImage("drill.png");
        setImage(bulletImage);
        move(bulletspeed);
        boundary();
    }
    public void boundary()
    {   
        if (isAtEdge()) 
        {   
            //remove bullet when it hits the ledge
            World world = getWorld();
            if (world != null) 
            {
                world.removeObject(this);
                
            }
        }
    }
}
