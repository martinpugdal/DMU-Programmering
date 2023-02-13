import java.util.Scanner;

public class LoekkerOpgaver {

    public static void main(String[] args) {

//        Kald af metoder der afprøver opgave 1

//        System.out.println(summerEven(100));

//        System.out.println(summerSquare(10));

//        System.out.println(sumOdd(3, 19));

//        allPowers(20);

//        Kald af metoder der afprøver opgave 2
//        System.out.println(sumOddDigits(32677));

//        Kald af metoder der afprøver opgave 3
//        reverse(3456);

//        Scanner sc = new Scanner(System.in);
//        System.out.print("The amount invested: ");
//        double investmentAmount = sc.nextDouble();
//        System.out.print("Annual interest rate: ");
//        double annualInterestRate = sc.nextDouble();
//        double monthlyInterestRate = annualInterestRate / 12 / 100;
//        System.out.print("Years: ");
//        int year = sc.nextInt();
//        int i = 0;
//        System.out.println("Years\tFuture Value");
//        while (i < year) {
//            i++;
//            System.out.printf("%d\t%.2f\n", i, futureInvestmentValue(investmentAmount, monthlyInterestRate, i));
//        }
//        Scanner sc_ = new Scanner(System.in);
//        System.out.print("Sales Amount min: ");
//        int salesMinAmount = sc_.nextInt();
//        System.out.print("Sales Amount max: ");
//        int salesMaxAmount = sc_.nextInt();
        System.out.println("Sales Amount\tCommission");
        int sales = 10000;
        while (sales <= 100000) {
            System.out.println(sales + "\t\t" + computeCommission(sales));
            sales += 5000;
        }
    }

    // Metoden returnerer summen af alle lige tal mellem 2 og n
    public static int summerEven(int n) {
        int i = 0;
        int sum = 0;
        while (i < n) {
            i++;
            if (i%2 == 0)
                sum = sum+i;
        }
        return sum;
    }

    // Metoden returnerer summen af alle kvdrater mellem 1*1 og n*n
    public static int summerSquare(int n) {
        int i = 0;
        int sum = 0;
        while (i < n) {
            i++;
            sum = sum+(i*i);
        }
        return sum;
    }

    // Metoden returnerer summen af alle ulige tal mellem a og b
    public static int sumOdd(int a, int b) {
        int sum = 0;
        while (a <= b) {
            if (a%2 == 1) {
                sum = sum + a;
            }
            a++;
        }
        return sum;
    }

    // Metoden udskriver 2 potenser fra f
    public static void allPowers(int n) {
        int i = 0;
        int sum = 1;
        while (i < n) {
            i++;
            System.out.println(sum);
            sum *= 2;
        }
    }

    public static int sumOddDigits(int number) {
        int sum = 0;
        while (number != 0) {
            int lastDigit = number%10;
            if (lastDigit%2 == 1) {
                sum = sum + lastDigit;
            }
            number = number / 10;
        }
        return sum;
    }

    public static void reverse(int number) {
        StringBuilder result = new StringBuilder();
        while (number != 0) {
            result.append(number % 10);
            number = number/10;
        }
        System.out.println(result);
    }

    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
    }

    public static double computeCommission(double salesAmount) {
        double total = 0, commission = 0;

        if (salesAmount >= 10000.01)
            commission += (total = salesAmount - 10000) * 0.1;

        if (salesAmount >= 5000.01)
            commission += (total -= total - 5000) * 0.08;

        if (salesAmount >= 0.01)
            commission += total * 0.06;

        return commission;
    }
}