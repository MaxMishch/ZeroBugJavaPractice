package Dmitrii.GroupTasks.Quiz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class JavaQuiz implements Quiz {

    ArrayList<String> questions = new ArrayList<>();
    ArrayList<Integer> answers = new ArrayList<>();

    static Integer correctAnswer;
    int countOfQuestion = 1;
    int indexOfQuestion;


    public static void scanner() {
        correctAnswer = null;
        while (correctAnswer == null) {
            try {
                Scanner scan = new Scanner(System.in);
                correctAnswer = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("TYPE ONLY DIGITS HERE");
                correctAnswer = null;
            }
        }
    }
    @Override
    public void setQuestions() {
        questions.add("2+2=?");
        questions.add("3*3=?");
        questions.add("2*2=?");
        questions.add("11+4=?");
        questions.add("11*11=?");
        questions.add("5-5=?");
        questions.add("10-5=?");
        questions.add("1+2=?");
        questions.add("5*4=?");
        questions.add("22-11=?");
    }
    @Override
    public int answer(int index){
        answers.add(4);
        answers.add(9);
        answers.add(4);
        answers.add(15);
        answers.add(121);
        answers.add(0);
        answers.add(5);
        answers.add(3);
        answers.add(20);
        answers.add(11);
        return answers.get(index);
    }

    @Override
    public int getRandomNumber() {
       return ThreadLocalRandom.current().nextInt(questions.size());
    }


    @Override
    public void generateQuestions() {
        System.out.println(countOfQuestion + ")question:");
        String question = questions.get(getRandomNumber());
        indexOfQuestion = questions.indexOf(question);
        System.out.println(question);
        questions.remove(question);

        countOfQuestion++;
    }

    @Override
    public void answeredCorrect(){
        correctAnswer++;
    }

    @Override
    public void calculateScore(){
        double percentageOfAnswer = (correctAnswer / NUMBER_OF_ASKED_QUESTIONS) * 100.0;
        System.out.println(percentageOfAnswer);

        if(Math.round(percentageOfAnswer)>=80){
            System.out.println("Great job! You scored "+ correctAnswer +" out of "+NUMBER_OF_ASKED_QUESTIONS+" and you complete "+Math.round(percentageOfAnswer)+"% of quiz with positive answers!");
        } else  if (Math.round(percentageOfAnswer)>=50){
            System.out.println("Good job but can be improved! You scored "+ correctAnswer +" out of "+NUMBER_OF_ASKED_QUESTIONS+" and you complete "+Math.round(percentageOfAnswer)+"% of quiz with positive answers!");
        } else{
            System.out.println("Try to practice more and try again! You scored "+ correctAnswer +" out of "+NUMBER_OF_ASKED_QUESTIONS+" and you complete "+Math.round(percentageOfAnswer)+"% of quiz with positive answers!");
        }

    }

    @Override
    public void start(){
        setQuestions();
        System.out.println("*****************************************************" +
                         "\n*              Welcome to our Quiz!                 *" +
                         "\n* Thank you for your choice! Quiz begin! Good luck! *" +
                         "\n*****************************************************");

        int i = 0;
        do {
            generateQuestions();
            System.out.println("Print your answer by using numbers");

            scanner(); //Add function that handles incorrect input typing

            if(answer(indexOfQuestion)== correctAnswer){
                System.out.println("************************************" +
                                 "\n* Congratulations! Correct answer! *" +
                                 "\n************************************");
                answeredCorrect();
            } else{
                System.out.println("*************************" +
                                 "\n* Sorry! Wrong answer!  *" +
                                 "\n* Correct answer was: " + answer(indexOfQuestion) + " *" +
                                 "\n*************************");
            }
            answers.remove(indexOfQuestion);
            i++;
        }  while( i< NUMBER_OF_ASKED_QUESTIONS);
        calculateScore();
    }
}
