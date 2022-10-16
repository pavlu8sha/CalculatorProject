import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Calculator calc = new Calculator();
        System.out.println(calc.calculate(scn.nextLine()));
    }
}