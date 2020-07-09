import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
  static Scanner scanner;
  static Account a;
  public static void main(String args[]) {
    App.scanner = new Scanner(System.in);
    App.menu();
  }

  private static void menu() {
    System.out.println("-> What Do U want to me?");
    System.out.println("  1. Create an account for new customer");
    int n = App.scanner.nextInt();
    switch (n) {
      case 1: {
        App.createAccountForNewCustomer();
        break;
      }
    }
  }

  private static void createAccountForNewCustomer() {
    System.out.println("-> What type of account do U want?");
    System.out.println("  1. Transaction account");
    System.out.println("  2. Saving account");

    int n = App.scanner.nextInt();
    switch (n) {
      case 1: {
        App.createAccountForNewCustomer();
        break;
      }
    }

  }
}
