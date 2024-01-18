import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int maxHp;
    private int currentHp;
    
    public void act()
    {
        handleMovement();
    }

    public HealthBar(int maxHp) 
    {
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        updateImage();
    }

    public void updateHealth(int newHp) 
    {
        currentHp = newHp;
        updateImage();
        //update the healthbar
    }

    private void updateImage() 
    {   
        // add gray rectangle to represent max health
        GreenfootImage healthBar = new GreenfootImage(maxHp + 2, 10);
        healthBar.setColor(Color.GRAY);
        healthBar.fill();
        healthBar.setColor(Color.GREEN);
        int healthWidth = (int) Math.ceil((currentHp / (double) maxHp) * (maxHp));
        healthBar.fillRect(1, 1, healthWidth, 8);
        setImage(healthBar);
    }
    
    public void handleMovement() 
    {   
        //makes the healthbar follow the croc/frog at all times
        if (Greenfoot.isKeyDown("a")) 
        {
            move(-3);
        } 
        
        else if (Greenfoot.isKeyDown("d")) 
        {
            move(3);
        } 
        else if (Greenfoot.isKeyDown("w")) 
        {
            setLocation(getX(), getY() -5);
        } 
        else if (Greenfoot.isKeyDown("s")) 
        {
            setLocation(getX(), getY() + 5);
        }
    }
}
