package ru.ls.qa.school.core;

public class OddTask {

    public static void main(String[] args){
        isOdd(2);
        isOdd(3);
    }

    static void isOdd(int number){
        if(number % 2 == 0){
            System.out.println("Четное число: "+ number +" "+ false);
        }
        else System.out.println("Нечетное число: "+ number +" "+ true);
    }
}
