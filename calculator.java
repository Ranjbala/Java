import java.util.Scanner;
public class calculator{
    public static void main(String args[])
    {
        int num1, num2;
        char operator;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the two numbers : ");
        System.out.println("num 1 : ");
        num1 = sc.nextInt();

        System.out.println("num 2: ");
        num2 = sc.nextInt();

        System.out.println("Choose the operator from the list [ +, -, *, /]");
        operator = sc.next().charAt(0);
        
        switch(operator){
            case '+':
                add(num1, num2);
                break;
            case '-':
                subtract(num1, num2);
                break;
            case '*':
                multiply(num1, num2);
                break;
            case '/':
                divide(num1, num2);
                break;
            default:
                System.out.println("Kindly enter a valid operator!");
        }
        sc.close();
    }

    public static void add(int num1, int num2)
    {
        int result = num1 + num2;
        System.out.println("Result of addition of the numbers" + " " + num1 + " and " + num2 + " is " + result);
    }

    public static void subtract(int num1, int num2)
    {
        int result = num1 - num2;
         System.out.println("Result of subtraction of the numbers" + " " + num1 + " and " + num2 + " is " + result);
    }
    public static void multiply(int num1, int num2)
    {
        int result = num1 * num2;
        System.out.println("Result of multiplication of the numbers" + " " + num1 + " and " + num2 + " is " + result);

    }
    public static void divide(int num1, int num2)
    {
        int result = num1 / num2;
        System.out.println("Result of division of the numbers" + " " + num1 + " and " + num2 + " is " + result);
    }
}