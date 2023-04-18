package gui;

import model.Student;
import model.Team;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Martin Pugdal Pedersen
 * @version 1.0
 */
public class MenuApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Team[] teams = new Team[10];

    public static void main(String[] args) {
        int triggerIndex = -1;
        while (triggerIndex != 6) {
            System.out.println("""
                
                MENU
                1: Create a team
                2: Create a student
                3: Show one student's info and results
                4: Show one team's info and results
                5: Show info and results for all teams
                6: Exit program""");
            triggerIndex = scanner.nextInt();

            if (triggerIndex == 1) {
                System.out.print("Team name and room: ");
                String name = scanner.next();
                String room = scanner.next();
                createTeam(name, room);
            }

            else if (triggerIndex == 2) {
                System.out.print("Name of student's team: ");
                String teamName = scanner.next();
                Team team = getTeamByName(teamName);
                if (team == null) {
                    System.out.println("This team doesn't exists!");
                } else {
                    System.out.print("Student's name and activity status (true/false): ");
                    String studentName = scanner.next();
                    boolean studentActive = scanner.nextBoolean();
                    System.out.print("Student's number of grades: ");
                    int amountOfGrades = scanner.nextInt();
                    int[] grades = new int[amountOfGrades];
                    System.out.printf("Student's %s grades: ", amountOfGrades);
                    for (int i = 0; i < amountOfGrades; i++) {
                        grades[i] = scanner.nextInt();
                    }
                    createStudent(team, studentName, studentActive, grades);
                }
            }

            else if (triggerIndex == 3) {
                System.out.print("Student's name: ");
                String studentName = scanner.next();
                Student student = getStudentByName(studentName);
                if (student == null) {
                    System.out.println("This student doesn't exists!");
                } else {
                    System.out.printf("Information about %s%n", student);
                    getStudentInfo(student);
                }
            }

            else if (triggerIndex == 4) {
                System.out.print("Team's name: ");
                String teamName = scanner.next();
                Team team = getTeamByName(teamName);
                if (team == null) {
                    System.out.println("This team doesn't exists!");
                } else {
                    System.out.printf("--> Team info for team with name %s%n", team);
                    System.out.printf("Statistics for team: %s%n", team);
                    for (String studentInfo : team.getStudentsInfo()) {
                        System.out.println(studentInfo);
                    }
                }
            }

            else if (triggerIndex == 5) {
                getAllTeamsInfo();
            }

            else if (triggerIndex == 6) {
                System.out.println("--> Program finished");
            }
        }
    }

    private static void createTeam(String name, String room) {
        boolean found = false;
        int i = 0;
        while (!found) {
            if (i > teams.length) {
                found = !found;
                System.out.println("Sorry, we can't create this team, because we have reached max teams.");
            }
            if (teams[i] == null) {
                teams[i] = new Team(name, room);
                found = !found;
                System.out.printf("--> Team created with name and room set to %s and %s%n", name, room);
            }
            i++;
        }
    }

    private static Team getTeamByName(String name) {
        for (Team team : teams) {
            if (team != null && name.equals(team.getName())) {
                return team;
            }
        }
        return null;
    }

    private static void createStudent(Team team, String name, boolean active, int[] grades) {
        if (team.getStudents().length == team.getRawStudents().length) {
            System.out.println("Sorry, we can't add this student, because we have reached max students in this team.");
        } else {
            team.addStudent(new Student(name, active, grades));
            System.out.printf("--> Student %s(%s) with grades %s created in team %s", name, active ? "active" : "inactive", Arrays.toString(grades), team);
        }
    }

    private static Student getStudentByName(String studentName) {
        for (Team team : teams) {
            for (Student student : team.getStudents()) {
                if (studentName.equals(student.getName())) {
                    return student;
                }
            }
        }
        return null;
    }

    private static void getStudentInfo(Student student) {
        System.out.print("Grades: ");
        for (int grade : student.getGrades()) {
            System.out.print(grade + " ");
        }
        System.out.printf("Highest grade: %s%n", student.getHighestGrade());
        System.out.printf("Average grade: %.2f%n", student.getAverageGrade());
        System.out.print("Answers to the test: ");
        for (char answer : student.getAnswers()) {
            System.out.print(answer + " ");
        }
        System.out.println();
    }

    private static void getAllTeamsInfo() {
        for (Team team : teams) {
            if (team != null) {
                System.out.printf("--> Team info for team with name %s%n", team);
                System.out.printf("Statistics for team: %s%n", team);
                for (String studentInfo : team.getStudentsInfo()) {
                    System.out.println(studentInfo);
                }
            }
        }
    }
}
