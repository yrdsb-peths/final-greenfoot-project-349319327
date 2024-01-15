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
        
        int visibleWidth = 600; // Replace 50 with the desired visible width of the frog
        int visibleHeight = 50; // Replace 50 with the desired visible height of the frog
        
        beam.scale(visibleWidth, visibleHeight);
        setRotation(getRotation() + 180);
        setImage(beam);
    }
    public void act()
    {
        // Add your action code here.
        setRotation(getRotation() + 180);
    }
    
    
    
    
}
