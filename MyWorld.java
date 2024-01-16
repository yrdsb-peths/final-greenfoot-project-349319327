import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Jacob Lee) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int hit = 0;
    Label hitLabel;
    Label hitCounterLabel;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        GreenfootImage bg = new GreenfootImage("OIP.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        createFrog();
        addBossOne();
        hitLabel = new Label("", 30); 
        addObject(hitLabel, 100, 50); 
        hitCounterLabel = new Label("Got Hit: ", 30);  
        addObject(hitCounterLabel, 50, 50);
        
    }
    
    private void prepare()
    {
        createFrog();
        addBossOne();
        hitLabel = new Label("", 30); 
        addObject(hitLabel, 100, 50); 
        hitCounterLabel = new Label("Got Hit: ", 30);  
        addObject(hitCounterLabel, 50, 50);
    }
    
    public void gameWin()
    {
        Label gameOverLabel = new Label("You Win", 100);
        addObject(gameOverLabel, 300, 200);
    
        if (hit == 0) 
        {
            Label congratsLabel = new Label("Congratulations! You didn't get hit!", 70);
            addObject(congratsLabel, 300, 300);
        } 
        else 
        {
            Label gotHit = new Label("You got hit " + hit + " times!", 70);
            addObject(gotHit, 300, 300);
            Label tryZero = new Label("Try hitless next time!", 50);
            addObject(tryZero, 300, 350);
        }
    }
    
    public void createFrog()
    {
        Frog playFrog = new Frog();
        addObject(playFrog, 200, 350);
    }
    
    public void bossAtkOne()
    {
        BossBulletOne atkOne = new BossBulletOne();
    }
    
    public void addBossOne()
    {
        BossOne snake = new BossOne();
        addObject(snake, 500, 200);
    }
    
    public void gameLose()
    {
        Label gameOverLabel = new Label("You Lose", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    public void hitCounter()
    {
        hit++;
        if(hitLabel != null)
        {
            hitLabel.setValue(hit);
        }
    }
    
}
