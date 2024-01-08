import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Titlescreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Titlescreen extends World
{
    Label titleLabel = new Label("Boss Fight", 60);
    /**
     * Constructor for objects of class Titlescreen.
     * 
     */
    public Titlescreen()
    {    
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("OIP.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        addObject(titleLabel, getWidth()/2, 200);
        prepare();
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    private void prepare()
    {
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,300,300);
        label.setLocation(300,300);
        Label label2 = new Label("Use a, d, w, s to move", 40);
        addObject(label2,300,300);
        label2.setLocation(300,250);
        Label label3 = new Label("Press mouse2 to shoot", 40);
        addObject(label3,296,278);
        label3.setLocation(300,350);
    }
}
