import greenfoot.*;

public class BossHealthBar extends Actor 
{
    private int maxHealth;
    private int currentHealth;

    public BossHealthBar(int maxHealth) 
    {   
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        updateImage();
    }

    public void act() 
    {
        // Health bar doesn't need to perform any additional actions
    }

    public void updateHealth(int currentHealth) 
    {
        this.currentHealth = currentHealth;
        updateImage();
        //updates health bar base on current value
    }

    private void updateImage() 
    {   
        //draw red rectangle to represent max health
        GreenfootImage healthBar = new GreenfootImage(maxHealth + 2, 20);
        healthBar.setColor(Color.RED);
        healthBar.fillRect(1, 1, maxHealth, 18);
        //draw green rectangle to represent current health
        int greenWidth = (int) ((double) currentHealth / maxHealth * (maxHealth));
        healthBar.setColor(Color.GREEN);
        healthBar.fillRect(1, 1, greenWidth, 18);

        setImage(healthBar);
    }
}

