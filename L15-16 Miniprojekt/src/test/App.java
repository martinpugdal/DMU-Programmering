package test;

import models.Student;
import models.Team;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        Team team1 = new Team("23V", "23.3");
        Team team2 = new Team("23U", "23.2");

        Student student1 = new Student("Martin", true, new int[]{3,4,5});
        Student student2 = new Student("Thor", false, new int[]{12,4,7});
        Student student3 = new Student("Anders", true, new int[]{5,4,9});
        Student student4 = new Student("Mark", false, new int[]{1,5,5});
        Student student5 = new Student("Sebastian", true, new int[]{2,5,2});
        Student student6 = new Student("Oliver", false, new int[]{12,8,7});


        // team 1
        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);
        // team 2
        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);


        team1.removeStudent("Thor");
        team2.removeStudent("Mark");


        System.out.printf("holdnavn: %s, rum: %s, antal students: %d%n", team1.getName(), team1.getRoom(), team1.getStudentsAmount());
        System.out.printf("holdnavn: %s, rum: %s, antal students: %d%n", team2.getName(), team2.getRoom(), team2.getStudentsAmount());


        System.out.println();


        System.out.printf("%s's karaktere:%n", student3);
        for (int grade : student3.getGrades()) {
            System.out.println(" - "+grade);
        }


        System.out.println();


        System.out.printf("Karaktergennemsnit for %s: %.2f%n", student3, student3.getAverageGrade());
        System.out.printf("Højeste karakter opnået for %s: %s%n", student3, student3.getHighestGrade());


        System.out.println();


        System.out.printf("%s's karaktergennemsnit:%n", team1);
        System.out.println(team1.getAverageOfAllStudentsGrades());
        System.out.printf("%s's karaktergennemsnit:%n", team2);
        System.out.println(team2.getAverageOfAllStudentsGrades());


        System.out.println();


        int team1MinAverage = 3;
        int team2MinAverage = 2;
        System.out.printf("Students fra %s med minAverage på %s:%n", team1, team2MinAverage);
        for (Student student : team1.highScoreStudents(team1MinAverage)) {
            System.out.println(" - "+student);
        }
        System.out.printf("Students fra %s med minAverage på %s:%n", team1, team2MinAverage);
        for (Student student : team2.highScoreStudents(team2MinAverage)) {
            System.out.println(" - "+student);
        }


        System.out.println();


        for (int i = 1; i <= 10; i++) {
            student1.registerAnswerOnMultipleChoice(i, student1.randomAnswer());
            student3.registerAnswerOnMultipleChoice(i, student3.randomAnswer());

            student5.registerAnswerOnMultipleChoice(i, student5.randomAnswer());
            student6.registerAnswerOnMultipleChoice(i, student6.randomAnswer());
        }

        getTeamAnswers(team1); //Fyldte for meget, så lavede en ny metode til det her.
        System.out.println();
        getTeamAnswers(team2);


        System.out.println();


        System.out.printf("fra %s:%n", team1);
        for (String studentInfo : team1.getStudentsInfo()) {
            System.out.println(studentInfo);
        }
        System.out.println();
        System.out.printf("fra %s:%n", team2);
        for (String studentInfo : team2.getStudentsInfo()) {
            System.out.println(studentInfo);
        }


        System.out.println();


        System.out.println(team1+" har svaret følgende totalt:");
        for (int i = 0; i < team1.getCorrectAnswers().length; i++) {
            System.out.printf("%s: %s%n", team1.getCorrectAnswers()[i], team1.getCorrectAnswersOverall()[i]);
        }
        System.out.println();
        System.out.println(team2+" har svaret følgende totalt:");
        for (int i = 0; i < team2.getCorrectAnswers().length; i++) {
            System.out.printf("%s: %s%n", team2.getCorrectAnswers()[i], team2.getCorrectAnswersOverall()[i]);
        }
    }

    private static void getTeamAnswers(Team team) {
        System.out.println("Se studentendes fra "+ team + "'s svar til testen & hvor mange rigtige svar de har fået:");
        for (Student student : team.getStudents()) {
            System.out.printf("%s har svaret: ", student);
            for (char answer : student.getAnswers()) {
                System.out.print(answer + " ");
            }
            System.out.println();
            System.out.printf("Fik %s rigtige svar.%n", student.correctAnswers(team.getCorrectAnswers()));
        }
    }
}
