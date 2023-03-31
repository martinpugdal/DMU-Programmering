package model;

/**
 * @author Martin Pugdal Pedersen
 * @version 1.0
 */
public class Team {

    private String name;
    private String room;
    private final Student[] students;
    private int studentsAmount;
    private final char[] correctAnswers;

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
        this.students = new Student[35];
        this.studentsAmount = 0;

        this.correctAnswers =  new char[]{
            'D',
            'A',
            'C',
            'C',
            'D',
            'B',
            'A',
            'B',
            'D',
            'A'
        };
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Student[] getRawStudents() {
        return this.students;
    }

    public Student[] getStudents() {
        Student[] students = new Student[getStudentsAmount()];
        int n = 0;
        while (getRawStudents()[n] != null) {
            students[n] = getRawStudents()[n];
            n++;
        }
        return students;
    }

    public int getStudentsAmount() {
        return this.studentsAmount;
    }

    public void setStudentsAmount(int studentsAmount) {
        this.studentsAmount = studentsAmount;
    }


    public void addStudent(Student student) {
        if(getStudentsAmount() < getRawStudents().length) {
            getRawStudents()[studentsAmount] = student;
            setStudentsAmount(getStudentsAmount()+1);
        }
        else{
            System.out.println("Sorry, we can't add this student, because we have reached max students in this team.");
        }
    }

    public void removeStudent(String name) {
        int foundIndex = -1;
        int i = -1;
        while (foundIndex == -1) {
            i++;
            if (name.equals(getRawStudents()[i].getName())) {
                setStudentsAmount(getStudentsAmount()-1);
                foundIndex = i;
            }
        }
        for (int j = foundIndex; j < getStudentsAmount(); j++) {
            getRawStudents()[j] = getRawStudents()[j+1];
            getRawStudents()[j+1] = null;
        }
    }

    public double getAverageOfAllStudentsGrades() {
        int gradeSum = 0;
        int gradeTotal = 0;
        for (Student student : getStudents()) {
            for (int grade : student.getGrades()) {
                gradeSum += grade;
            }
            gradeTotal += student.getGrades().length;
        }
        return (double) gradeSum/gradeTotal;
    }

    public Student[] highScoreStudents(double minAverage) {
        int i = 0;
        Student[] activeStudents = new Student[getStudentsAmount()];
        for (Student student : getStudents()) {
            if (student.isActive()) {
                if (student.getAverageGrade() >= minAverage) {
                    activeStudents[i] = student;
                    i++;
                }
            }
        }
        Student[] highScoreStudents = new Student[i];
        int j = 0;
        for (Student student : activeStudents) {
            if (student != null) {
                highScoreStudents[j] = student;
                j++;
            }
        }
        return highScoreStudents;
    }

    public char[] getCorrectAnswers() {
        return correctAnswers;
    }

    public String[] getStudentsInfo() {
        String[] studentsInfo = new String[getStudentsAmount()];
        for (int i = 0; i < getStudentsAmount(); i++) {
            studentsInfo[i] = String.format("%4s %8s %4s", getRawStudents()[i], String.format("%.2f", getRawStudents()[i].getAverageGrade()), getRawStudents()[i].correctAnswers(this.correctAnswers));
        }
        return studentsInfo;
    }

    public int[] getCorrectAnswersOverall() {
        int[] correctResultOverall = new int[10];
        for (Student student : getStudents()) {
            for (int i = 0; i < getCorrectAnswers().length; i++) {
                if (getCorrectAnswers()[i] == student.getAnswers()[i]) {
                    correctResultOverall[i]++;
                }
            }
        }
        return correctResultOverall;
    }

    public String toString() {
        return getName();
    }
}
