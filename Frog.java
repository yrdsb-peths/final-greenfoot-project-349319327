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
    
    
    public void act()
    {
        // Add your action code here.
        handleMovement();
        shoot();
        takeDamage();
        
    }
    
    
    public void handleMovement() 
    {
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
            moveUp();
        } 
        else if (Greenfoot.isKeyDown("s")) 
        {
            setLocation(getX(), getY() + 5);
        }
    }
    public void moveUp() 
    {
        setLocation(getX(), getY()-5);
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
        BossBulletOne bullet = (BossBulletOne) getOneIntersectingObject(BossBulletOne.class);
        if (bullet != null) 
        {
            frogHp -= 1;
            getWorld().removeObject(bullet); // Remove the bullet hitting the frog
            if (frogHp <= 0) 
            {
                frogDeath(); // Call frogDeath() if health is zero or below
            }
        }
    }
    
    public void frogDeath()
    {
        
        MyWorld world = (MyWorld) getWorld();
        if (world != null) 
        {   
            
            world.removeObject(this);
        }
        
    }
}
