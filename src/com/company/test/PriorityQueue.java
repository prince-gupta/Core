package com.company.test;

import java.util.Comparator;
import java.util.Queue;
import java.util.Random;

/**
 * Created by princegupta on 09/11/17.
 */
public class PriorityQueue {


    public static void main(String[] args) {
        Comparator<Customer> customerComparator = (o1, o2) -> o1.getAge() - o2.getAge();
        Queue<Customer> priorityQueue = new java.util.PriorityQueue<>(customerComparator);
        Random random = new Random();
        for(int i = 1 ; i < 50; i++){
               PriorityQueue.Customer customer = new PriorityQueue().new Customer(i,"Customer " + i, new Integer(random.nextInt(100)));
               priorityQueue.add(customer);
        }

        for(Customer customer : priorityQueue)
            System.out.println(customer);
    }

    private class Customer{
        int id;
        String name;
        int age;

        public Customer(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}

