package com.company.designpatterns.singleton;

/**
 * Created by Pgupta on 4/14/2015.
 */
public class Singleton {

    private String message;
    private static Singleton singletonBean;
    private Singleton(){

    }

    public static synchronized Singleton getInstance(){
        if(singletonBean == null) {
            singletonBean = new Singleton();
            return singletonBean;
        }
        return singletonBean;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void getMessage(){
        System.out.println("SingletonBean");
    }
}