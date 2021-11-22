package com.company;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to Hagman");
        File dictionary  = new File("/Users/manuelmendez/IdeaProjects/hangman/src/dictionary.txt");

        Scanner scanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        ArrayList words = new ArrayList();
        while(scanner.hasNextLine()){
            words.add(scanner.nextLine());
        }

        String hidden_text = (String) words.get((int)(Math.random() * words.size()));
        char[] textArray = hidden_text.toCharArray();
        char[] myAnswers = new char[textArray.length];

        for (int i = 0; i < textArray.length; i++){
            myAnswers[i] = '?';
        }

        boolean finished = false;
        int lives = 6;

        while (!finished) {
            System.out.println("***********************");
            for (char myAnswer : myAnswers) {
                System.out.print(" _");
            }
            System.out.print("\nDigit a letter: ");
            String letter = input.next();
//            checks for valid input
            while (letter.length() != 1 || Character.isDigit((letter.charAt(0)))) {
                System.out.println("Error input - Try Again");
                System.out.print("\nDigit a letter: ");
                letter = input.next();
            }

//            checks if letter is in the word
            boolean found = false;
            for (int i = 0; i< textArray.length; i++){
                if(letter.charAt(0) == textArray[i]){
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }

            if(!found){
                lives--;
                System.out.println("Wrong letter");
            }

            boolean done = true;
            for (int i =0; i < myAnswers.length; i++){
                if(myAnswers[i] == '?'){
                    System.out.print(" _");
                    done = false;
                }else{
                    System.out.print("" + myAnswers[i]);
                }
            }

            System.out.println("\n" + "Lives left: " + lives);
            drawHangman(lives);
//            check if the game ends
            if(done){
                System.out.println("Congrats You Found The Word");
                finished = true;
            }

            if(lives <= 0){
                System.out.println("You are dead! Study your English");
                finished = true;
            }

        }

        System.out.println("The hidden word was '" +hidden_text + "'");
    }


    public static void drawHangman(int l) {
        if(l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else{
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}
