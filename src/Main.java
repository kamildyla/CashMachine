/** CASH MACHINE created by Kamil Dyla 09.06.2019
 *  The correct code in logIn() is: "xyz"
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main (String[] args)
    {
        int cash = 14_560;

        logIn();

        do {
            switch (menu()) {
                case 1: {
                    accountBalance(cash);
                }
                break;

                case 2: {
                    cash = cashWithdrawal(cash);
                }
                break;

                case 3: {
                    cash = cashPayment(cash);
                }
                break;

                case 4: {
                    System.out.println("---------- EXIT ----------");
                    System.out.println("----- Take your card -----");
                    System.exit(0);
                } break;

            }
        } while (1==1);
    }






    static void logIn()
    {
        String valid = "xyz";
        System.out.println("---------- CASH MACHINE ----------");
        System.out.println("--------- Insert the card --------");

        Scanner sc = new Scanner(System.in);

        String card;
        do {
            System.out.print("Code: ");
            card = sc.next();
            if ( ! (card.equals("xyz") || card.equals("XYZ")) ){
                System.out.println(">>>> Bad code. Try once again <<<<");
            }
        } while ( ! (card.equals("xyz") || card.equals("XYZ")) );

        System.out.println("---------- correct code ---------- \n");
    }

    static int menu()
    {
        int num = 0;

        do {
            System.out.println("- account balacne     ( 1 )");
            System.out.println("- cash withdrawal     ( 2 )");
            System.out.println("- cash payment        ( 3 )");
            System.out.println("- exit                ( 4 )");
            System.out.print("   Your choice:   ");

            Scanner sc = new Scanner(System.in);
            try {
                num = sc.nextInt();
                if ((num<1) || (num>4)){
                    System.out.println("<<<<<<< BAD CODE >>>>>>>");
                    System.out.println("<<<< Try once again >>>>");
                }
            } catch (InputMismatchException e) {
                System.out.println("<<<<<<< BAD CODE >>>>>>>");
                System.out.println("<<<< Try once again >>>>");
            }
            System.out.println(" ");

        } while ( ! (num >=1 && num <= 4) );

        return num;
    }

    static void accountBalance(int cash)
    {
        System.out.println("----- Account balacne -----");
        System.out.println("Your money: " + cash + " USD \n");
    }

    static int cashWithdrawal(int cash)
    {
        int money = 0;

        do {
            System.out.println("----- Cash withdrawal -----");
            money = (enterAmount());

        } while (money%10 != 0);

        if (money > cash){
            System.out.println(">> Insufficient money << \n");
            return cash;
        }
        else {
            cash = (cash - money);
            if (money != 0) {
                System.out.println("------> Cash paid <------ \n");
            }
        }
        return (cash);
    }

    static int cashPayment(int cash)
    {
        int money = 0;

        do {
            System.out.println("------ Cash payment ------ \n");
            money = (enterAmount());

        } while (money%10 != 0);

        cash = (cash + money);
        if (money !=0) {
            System.out.println("-----> Cash accepted <----- \n");
        }

        return (cash);
    }

    static int enterAmount()
    {
        int money = 0;
        System.out.println("To back enter '0'");
        System.out.print("Enter the amount (divisible by 10): ");
        Scanner sc = new Scanner(System.in);

        try {
            money = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("<<<  Try once again  >>> \n");
        }

        if (money%10 != 0){
            System.out.println("<<<  Incorrect amount  >>> \n" );
        }

        return money;
    }
}