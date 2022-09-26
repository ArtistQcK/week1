package com.shpp.p2p.cs.akartel.assignment1;

import com.shpp.karel.KarelTheRobot;

/** find middle point in south line of karel world
 */
public class Assignment1Part3 extends KarelTheRobot {
    /** find middle point in south line of karel world and put beeper
     */
    @Override
    public void run() throws Exception {
        if (frontIsBlocked()) putBeeper();  // 1 slot world check
        else {
            findMid();
            putBeeper();
        }
        say("solo mid");
    }

    /**
     * find center point at this line
     */
    private void findMid() throws Exception {
        if (frontIsClear()) move();
        if (frontIsClear()) move();
        if (frontIsClear()) findMid();
        if (facingEast()) {
            turnLeft();
            turnLeft();
        }
        move();
    }
}

