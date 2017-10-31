package com.company.designpatterns.adapter;

import java.util.Random;

/**
 * Created by Pgupta on 9/11/2015.
 */
public class EnemyRobot {
     Random generator = new Random();

    public void smashWithHands(){
        int damage = generator.nextInt(10) + 1;
        System.out.println(" Robot has done " + damage + " damage with his hands." );
    }

    public void walkForward(){
        int moves = generator.nextInt(5) + 1;
        System.out.println(" Robot has moved " + moves + " steps." );
    }

    public void reactToHuman(String driverName){
        System.out.println(" Robot has tramp over " + driverName);
    }

}
