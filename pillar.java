import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pillar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pillar extends Actor
{
    /**
     * Act - do whatever the pillar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int durationTime = 2;
    public void act()
    {
        // Add your action code here.
        duration();
    }
    
    public void duration()
    {
        while(durationTime > 0)
        {
            durationTime -= 1;
            
        }
        if(durationTime <= 0)
        {
            World world = getWorld();
            if (world != null) 
            {
                world.removeObject(this);
                
            }
        }
    }
}
