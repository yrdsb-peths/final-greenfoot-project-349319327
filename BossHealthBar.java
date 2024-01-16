import greenfoot.*;

public class BossHealthBar extends Actor {
    private int maxHealth;
    private int currentHealth;

    public BossHealthBar(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        updateImage();
    }

    public void act() {
        // Health bar doesn't need to perform any additional actions
    }

    public void updateHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage healthBar = new GreenfootImage(maxHealth + 2, 20);
        healthBar.setColor(Color.RED);
        healthBar.fillRect(1, 1, maxHealth, 18);

        int greenWidth = (int) ((double) currentHealth / maxHealth * (maxHealth));
        healthBar.setColor(Color.GREEN);
        healthBar.fillRect(1, 1, greenWidth, 18);

        setImage(healthBar);
    }
}

