import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean removed = false;
    public Laser()
    {
        GreenfootImage beam = new GreenfootImage("laser.png");
        int visibleWidth = 1200; // Replace 50 with the desired visible width of the frog
        int visibleHeight = 300; // Replace 50 with the desired visible height of the frog
        
        beam.scale(visibleWidth, visibleHeight);
        
        setImage(beam);
    }
    public void act()
    {
        // Add your action code here.
        
    }
    
     private void setHitbox() 
     {
        int width = getImage().getWidth();
        int height = getImage().getHeight();
        GreenfootImage hitboxImage = new GreenfootImage(width, height);
        setImage(hitboxImage);
    }
    
    
}
