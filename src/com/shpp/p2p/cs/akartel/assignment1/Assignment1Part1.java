package com.shpp.p2p.cs.akartel.assignment1;
import com.shpp.karel.KarelTheRobot;

/**
 * find newspaper , get it and come back to previous position
 */
public class Assignment1Part1 extends KarelTheRobot{
    /**
     * find newspaper , get it and come back to previous position
     */
    @Override
    public void run() throws Exception {
        moveToNewspaper();
        pickBeeper();
        comeBackHome();
    }

    /**
     * move until start position     */
    private void comeBackHome() throws Exception {
        turnLeft();
        turnLeft();
        moveToWall();
        turRight();
        move();
        turRight();
    }

    /**
     * move until facing wall
     */
    public void moveToWall() throws Exception {
        while (!frontIsBlocked()) move();
    }

    /**
     * karel moves to newspaper
     */
    private void moveToNewspaper() throws Exception{
        turRight();
        move();
        turnLeft();
        moveToBeeber();
    }

    /**
     * move until beeper present
     */
    private void moveToBeeber() throws Exception{
        while (noBeepersPresent()){
            move();
        }
    }

    /**
     * Turn karel to the right
     */
    public void turRight() throws Exception{
        turnLeft();
        turnLeft();
        turnLeft();
    }
}