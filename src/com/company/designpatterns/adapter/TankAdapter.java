package com.company.designpatterns.adapter;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class TankAdapter implements EnemyTank {

    private EnemyRobot enemyRobot;

    TankAdapter(EnemyRobot enemyRobot){
        this.enemyRobot = enemyRobot;
    }
    @Override
    public void fireWeapon() {
        enemyRobot.smashWithHands();
    }

    @Override
    public void moveForward() {
        enemyRobot.walkForward();
    }

    @Override
    public void assignDriver(String driver) {
        enemyRobot.reactToHuman(driver);
    }
}
