package models;

public class Team {

    private final String name;
    private final String room;
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

    public String getRoom() {
        return room;
    }

    public Student[] getStudents() {
        Student[] students = new Student[this.studentsAmount];
        int n = 0;
        while (this.students[n] != null) {
            students[n] = this.students[n];
            n++;
        }
        return students;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] == null) {
                this.students[i] = student;
                this.studentsAmount += 1;
                return;
            }
        }
    }

    public void removeStudent(String name) {
        int foundIndex = -1;
        int i = -1;
        while (foundIndex == -1) {
            i++;
            if (name.equals(this.students[i].getName())) {
                this.studentsAmount -= 1;
                foundIndex = i;
            }
        }
        for (int j = foundIndex; j < this.studentsAmount; j++) {
            this.students[j] = this.students[j+1];
            this.students[j+1] = null;
        }
    }

    public int getStudentsAmount() {
        return this.studentsAmount;
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
        Student[] activeStudents = new Student[this.studentsAmount];
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
        String[] studentsInfo = new String[this.studentsAmount];
        for (int i = 0; i < this.studentsAmount; i++) {
            studentsInfo[i] = String.format("%4s %8s %4s", this.students[i], String.format("%.2f", this.students[i].getAverageGrade()), this.students[i].correctAnswers(this.correctAnswers));
        }
        return studentsInfo;
    }

    public int[] getCorrectAnswersOverall() {
        int[] correctResultOverall = new int[10];
        for (Student student : getStudents()) {
            for (int i = 0; i < correctAnswers.length; i++) {
                if (correctAnswers[i] == student.getAnswers()[i]) {
                    correctResultOverall[i]++;
                }
            }
        }
        return correctResultOverall;
    }

    public String toString() {
        return this.name;
    }
}
