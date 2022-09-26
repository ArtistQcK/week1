package com.shpp.p2p.cs.akartel.assignment1;

/**
 * build checkerboard in karel worlds
 */
public class Assignment1Part4 extends Assignment1Part2 {
    /**
     * build checkerboard in karel worlds
     */
    @Override
    public void run() throws Exception {

        passLine();

        if (noBeepersPresent()) buildStandardCheckBoard();
        else buildOddSlotsCheckBoard();

        checkForVerticalCheckboard();

    }

    /**
     * method check and build checkerboard vertically (1 X number) world
     */
    private void checkForVerticalCheckboard() throws Exception {
        if (facingWest() && rightIsClear()) {
            turRight();
            move();
            passLine();
        }
    }

    /**
     * build checkerboard with odd number of slots
     */
    private void buildOddSlotsCheckBoard() throws Exception {
        moveToNextLine();
        while (frontIsClear()) {
            if (facingWest()) {
                move();
                passLine();
                moveToNextLine();
            } else {
                passLine();
                moveToNextLine();
            }
        }
    }

    /**
     * build checkerboard with even number of slots
     */
    private void buildStandardCheckBoard() throws Exception {
        moveToNextLine();
        while (frontIsClear()) {
            passLine();
            moveToNextLine();
        }
    }

    /**
     * moving to the next line
     */
    private void moveToNextLine() throws Exception {
        if (facingEast() && leftIsClear()) {
            turnLeft();
            move();
            turnLeft();
        } else if (facingWest() && rightIsClear()) {
            turRight();
            move();
            turRight();
        }
    }

    /**
     * passing line & putting beepers every second position
     */
    private void passLine() throws Exception {
        putBeeper();
        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
    }
}
