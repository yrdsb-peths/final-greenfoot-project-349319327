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
    private int frogHp = 10;
    private HealthBar healthBar;

    public Frog() 
    {
         // Adjust position of the health bar
    }
    
    public void addedToWorld(World world) 
    {
        healthBar = new HealthBar(frogHp);
        world.addObject(healthBar, getX(), getY() - 20); // Adjust position of the health bar
    }

    public void act()
    {
        // Add your action code here.
        GreenfootImage frogImage = new GreenfootImage("frog.png");
        int visibleWidth = 70; // Replace 50 with the desired visible width of the frog
        int visibleHeight = 70; // Replace 50 with the desired visible height of the frog
        frogImage.scale(visibleWidth, visibleHeight);
        setImage(frogImage);
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
            getWorld().removeObject(bullet);
            MyWorld world = (MyWorld) getWorld();
            world.hitCounter();
            
            if (frogHp <= 0) 
            {
                frogDeath(); // Call frogDeath() if health is zero or below
            }
            healthBar.updateHealth(frogHp);
        }
    }
    
    public void frogDeath()
    {
        
        MyWorld world = (MyWorld) getWorld();
        if (world != null) 
        {   
            world.gameLose();
            world.removeObject(this);
        }
        
    }
}
