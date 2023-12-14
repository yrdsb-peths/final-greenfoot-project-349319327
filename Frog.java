import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frog extends Actor
{
    /**
     * Act - do whatever the Frog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int frogHp = 10;
    String facing = "right";
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("a"))
        {
             move(-3);
             facing = "left";
        }
        else if (Greenfoot.isKeyDown("d"))
        {
             move(3);
             facing = "right";
        }
        shoot();
        takeDamage();
        frogDeath();
    }
    
    
    public void shoot()
    {
        if (Greenfoot.mouseClicked(null)) {
            int mouseX = Greenfoot.getMouseInfo().getX();
            int mouseY = Greenfoot.getMouseInfo().getY();
            
            // Calculate angle towards mouse position
            turnTowards(mouseX, mouseY);
            
            // Create and add a bullet
            getWorld().addObject(new Bullet(), getX(), getY()); 
            
        }
    }
    
    public void takeDamage()
    {
        if(isTouching(BossBulletOne.class))
        {
            frogHp -= 1; 
        }
    }
    
    public void frogDeath()
    {
        if(frogHp <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}
