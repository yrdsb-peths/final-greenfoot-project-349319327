import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Adds the boss, boss shoots green fireballs, when below 60 hp, shoots fireballs faster
 * 
 * @author (Jacob Lee) 
 * @version (a version number or a date)
 */
public class BossOne extends Actor 
{
    GreenfootImage[] idle = new GreenfootImage[2];
    private int shootingDelay = 70;
    private int laserDelay = 300;
    private int laserLife = 2;
    private int shootingTimer = 0;
    private int attackState = 0;
    Laser beam = new Laser();
    int bossHp = 130;
    String facing = "left";
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer laserTimer = new SimpleTimer();
    private BossHealthBar healthBar;

    public BossOne() {
    for (int i = 0; i < idle.length; i++) {
        idle[i] = new GreenfootImage("images/bossOne_sprite/bossOne" + i + ".png");
        if (i < 2) {
            int newWidth = idle[i].getWidth() * 3;
            int newHeight = idle[i].getHeight() * 2;
            idle[i].scale(newWidth, newHeight);
        }
    }
    animationTimer.mark();
    setImage(idle[0]);
    }

    int imageIndex = 0;
    
    public void animateBoss() 
    {
        if (animationTimer.millisElapsed() < 220) 
        {
            return;
        }
        animationTimer.mark();
        if (facing.equals("left")) 
        {
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1) % idle.length;
        }
    }




    public void act() 
    {
        hit();
        die();
        bulletSpeed();
        healthBar.updateHealth(bossHp);
        animateBoss();
        
    }

    public void addedToWorld(World world) 
    {
        healthBar = new BossHealthBar(bossHp);
        world.addObject(healthBar, world.getWidth() / 2, world.getHeight() - 10);
    }

    public void bulletSpeed() 
    {   
        /* adjust the firerate of the boss*/
        if (bossHp >= 70) 
        {
            if (shootingTimer <= 0) 
            {
                
                atkOne();
                shootingTimer = shootingDelay;
            } 
            else 
            {
                shootingTimer--;
            }
        } 
        else 
        {
            if (shootingTimer <= 0) 
            {
                atkOne();
                shootingTimer = 60;
            } 
            else 
            {
                shootingTimer--;
            }
            laserSpeed();
        }
    }

    public void hit() 
    {
        if (isTouching(Bullet.class)) 
        {
            removeTouching(Bullet.class);
            bossHp -= 2;
        }
    }

    public void die() 
    {
        if (bossHp <= 0) 
        {
            MyWorld world = (MyWorld) getWorld();
            if (world != null) 
            {
                world.gameWin();
                world.removeObject(this);
            }
        }
    }

    public void atkOne() 
    {
        List<Frog> frogs = getWorld().getObjects(Frog.class);
        if (getWorld().getObjects(Frog.class).size() > 0) 
        {
            Frog croc = frogs.get(0);
            BossBulletOne bullet = new BossBulletOne();
            getWorld().addObject(bullet, getX(), getY());
            bullet.turnTowards(croc.getX(), croc.getY());
        }
    }

    public void laserSpeed() 
    {
        if (shootingTimer <= 0) 
        {
            laser();
            shootingTimer = laserDelay;
        } 
        else 
        {
            shootingTimer--;
            if (laserTimer.millisElapsed() >= laserLife * 2000) 
            {
                MyWorld world = (MyWorld) getWorld();
                world.removeObject(beam);
                laserTimer.mark(); // Remove the laser after 2 seconds
            }
        }
    }

    public void laser() 
    {
        List<Frog> frogs = getWorld().getObjects(Frog.class);
        if (getWorld().getObjects(Frog.class).size() > 0) 
        {
            Frog croc = frogs.get(0);
            int laserWidth = 100;
            int laserHeight = 200;
            getWorld().addObject(beam, laserWidth, laserHeight);
            beam.turnTowards(100, 200);
        }
    }
}
