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
    
    private boolean removed = false;
    public void act()
    {
        GreenfootImage atkImage = new GreenfootImage("greenBall.png");
        int width = atkImage.getWidth() -10 ; 
        int height = atkImage.getHeight() -10; 
        atkImage.scale(width, height);
        setImage(atkImage);
        if (!removed) 
        {
            move(5);
            boundary();
            
        }
    }

    private void boundary() 
    {
        if (isAtEdge() && !removed) 
        {
            World world = getWorld();
            if (world != null) 
            {
                world.removeObject(this);
                removed = true;
            }
        }
    }

    private void checkHitFrog() 
    {
        if (!removed) 
        {
            Frog frog = (Frog) getOneIntersectingObject(Frog.class);
            if (frog != null) 
            {
                World world = getWorld();
                if (world != null) 
                {
                    world.removeObject(this);
                    removed = true;
                    frog.takeDamage();
                }
            }
        }
    }
}
