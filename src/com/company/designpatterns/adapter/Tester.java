package com.company.designpatterns.adapter;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class Tester {
    public static void main(String[] args) {
        EnemyTank enemyTank = new BasicEnemyTank();

        EnemyRobot enemyRobot = new EnemyRobot();

        EnemyTank adapterTank = new TankAdapter(enemyRobot);

        System.out.println("Enemy Robot");
        enemyRobot.reactToHuman("Marsh");
        enemyRobot.smashWithHands();
        enemyRobot.walkForward();

        System.out.println("Enemy Tank");
        enemyTank.assignDriver("Paul the Tanker");
        enemyTank.fireWeapon();
        enemyTank.moveForward();

        System.out.println("Adapted Robot");
        adapterTank.assignDriver("Paul");
        adapterTank.fireWeapon();
        adapterTank.moveForward();
    }
}
