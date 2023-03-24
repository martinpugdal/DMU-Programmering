package model;

import java.util.Random;

/**
 * @author Martin Pugdal Pedersen
 * @version 1.0
 */
public class Student {

    private String name;
    private boolean active;
    private int[] grades;
    private char[] answers;

    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
        this.answers = new char[10];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public char[] getAnswers() {
        return answers;
    }

    public void setAnswers(char[] answers) {
        this.answers = answers;
    }


    public int getHighestGrade() {
        int highestGrade = -1;
        for (int grade : getGrades()) {
            if (highestGrade < grade) {
                highestGrade = grade;
            }
        }
        return highestGrade;
    }

    public double getAverageGrade() {
        int sumGrade = 0;
        for (int grade : getGrades()) {
                sumGrade += grade;
        }
        return (double) sumGrade/getGrades().length;
    }

    public void registerAnswerOnMultipleChoice(int questionNumber, char answer) {
        getAnswers()[questionNumber-1] = answer;
    }

    public char randomAnswer() {
        Random random = new Random();
        int answerIndex = random.nextInt(4);
        return (new char[]{'A', 'B', 'C', 'D'})[answerIndex];
    }

    public int correctAnswers(char[] correct) {
        int correctAnswers = 0;
        for (int i = 0; i < correct.length; i++) {
            if (getAnswers()[i] == correct[i]) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    public String toString() {
        return getName();
    }
}
