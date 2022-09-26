package com.shpp.p2p.cs.akartel.assignment1;

/**
 * build stone columns
 */
public class Assignment1Part2 extends Assignment1Part1 {
    /**
     * build stone columns
     */
    @Override
    public void run() throws Exception {

        checkColumn();

        while (frontIsClear()) {
            repairColumn();
            moveToNextColumn();
        }

       checkColumn();
    }

    /**
     * check first and last column and repair if necessary
     */
    private void checkColumn()  throws Exception{
        if (frontIsBlocked() && leftIsClear()) repairColumn();
    }

    /**
     * repair column with beepers
     */
    private void repairColumn() throws Exception {
        if (leftIsBlocked() && noBeepersPresent()) putBeeper();
        else {
            turnLeft();
            moveUntilWallPutBeepers();
            if (rightIsClear()) {    //check right to revert or finish level
                turnLeft();
                turnLeft();
                moveToWall();
                turnLeft();
            }
        }
    }

    /**
     * moving to the next column
     */
    private void moveToNextColumn() throws Exception {
        if (frontIsClear()) {
            move();
            move();
            move();
        }
        if (frontIsClear()) {
            move();
        }
    }

    /**
     * moving until wall & putting beepers if necessary
     */
    private void moveUntilWallPutBeepers() throws Exception {
        while (frontIsClear()) {
            if (noBeepersPresent()) putBeeper();
            move();
            if (noBeepersPresent()) putBeeper();
        }
    }
}