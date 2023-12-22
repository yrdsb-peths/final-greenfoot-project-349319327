import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends World
{

    /**
     * Constructor for objects of class World2.
     * 
     */
    public World2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        GreenfootImage bg = new GreenfootImage("OIP.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }
}
