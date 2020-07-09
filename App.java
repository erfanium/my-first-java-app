import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
  static Scanner scanner;
  public static void main(String args[]) {
    App.scanner = new Scanner(System.in);
    App.menu();
  }


  private static void menu() {
    boolean exit = false;
    while (!exit) {
      System.out.println("-> What Do U want to me?");
      System.out.println("  1. Create an account for new customer");
      System.out.println("  0. Exit app");

      int n = App.scanner.nextInt();
      switch (n) {
        case 1: {
          App.createAccountForNewCustomer();
          break;
        }
        case 0: {
          exit = true;
          System.out.println("Bye!");
          break;
        }
      }
    }
  }

  private static void createAccountForNewCustomer() {
    System.out.println("-> What type of account do U want?");
    System.out.println("  1. Transaction account");
    System.out.println("  2. Saving account");
    System.out.println("  0. Exit");


    int n = App.scanner.nextInt();
    switch (n) {
      case 1: {
        App.createAccountForNewCustomer();
        break;
      }
      case 0: {
        break;
      }
    }

  }
}
