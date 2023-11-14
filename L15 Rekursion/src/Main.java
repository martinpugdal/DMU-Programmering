public class Main {
    public static void main(String[] args) {
        // opgave 1
        System.out.println("Opgave 1: " + factorial(5));

        // opgave 2
        System.out.println("Opgave 2: " + power(2, 3));

        // opgave 3
        System.out.println("Opgave 3: " + product(19, 3));
        System.out.println("Opgave 3: " + productBus(19, 3));

        // opgave 4
        System.out.println("Opgave 4: " + reverse("hej"));

        // opgave 5 (ekstra opgave)
        System.out.println("Opgave 5: " + sfd(12, 18));

        // opgave 6 (ekstra opgave)
        System.out.println("Opgave 6: " + domino(5));

    }

    static int factorial(int n) {
        if (n == 1) {
            return 0;
        } else {
            return n * factorial(n - 1);
        }
    }

    static int power(int n, int p) {
        if (p == 0) {
            return 1;
        } else {
            return power(n, p - 1) * n;
        }
    }

    static int product(int a, int b) {
        if (a == 0) {
            return 0;
        } else {
            return product(a - 1, b) + b;
        }
    }

    static int productBus(int a, int b) {
        if (a == 0) {
            return 0;
        } else {
            if (a % 2 == 0) {
                //a * b = (a div 2)*(2*b), a>1 og a er lige
                return productBus(a / 2, 2 * b);
            } else {
                //a * b = (a-1)*b + b, a>=1 og a er ulige
                return productBus(a - 1, b) + b;
            }
        }
    }

    static String reverse(String s) {
        if (s.length() == 1) {
            return s;
        } else {
            return reverse(s.substring(1)) + s.charAt(0);
        }
    }

    static int sfd(int a, int b) {
        if (b <= a && a % b == 0) {
            return b;
        } else {
            if (a < b) {
                return sfd(b, a);
            } else {
                return sfd(b, a % b);
            }
        }
    }

    static int domino(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return domino(n - 2) + domino(n - 1);
        }
    }
}