package com.company.designpatterns.adapter;

import java.util.Random;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class BasicEnemyTank implements EnemyTank {

    Random generator = new Random();
    @Override
    public void fireWeapon() {
        int damage = generator.nextInt(10) + 1;
        System.out.println("Basic Tank does " + damage + " damage");
    }

    @Override
    public void moveForward() {
        int moves = generator.nextInt(5) + 1;
        System.out.println("Basic Tank moves " + moves + " spaces");
    }

    @Override
    public void assignDriver(String driver) {
        System.out.println(driver + " is Driving the tank. ");
    }
}
