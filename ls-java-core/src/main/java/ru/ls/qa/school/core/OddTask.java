package ru.ls.qa.school.core;

public class OddTask {

    public static void main(String[] args){
        int num1 = 2;
        int num2 = 3;
        printResult(num1);
        printResult(num2);
    }

    public static void printResult(int num) {
        System.out.println("Число: " + num + " - " + (isOdd(num) ? "не четное" : "четное"));
    }

    public static boolean isOdd(int number){
        if(number % 2 == 0){
            return false;
        }
        return true;
    }
}
