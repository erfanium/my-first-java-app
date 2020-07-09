import java.time.LocalDateTime;
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
      System.out.println("-> MENU: What Do U want from me?");
      System.out.println("  1. Create an account for new customer");
      System.out.println("  2. Create an account for old customer");
      System.out.println("  3. Show account balance");
      System.out.println("  4. Show saving account profit");
      System.out.println("  5. Send money to another account");
      System.out.println("  0. Exit app");

      int n = App.scanner.nextInt();
      if (n == 1) App.createAccountForNewCustomer();
      else if (n == 2) App.createAccountForOldCustomer();
      else if (n == 3) App.showAccountBalance();
      else if (n == 4) App.showSavingAccountProfit();
      else if (n == 5) App.sendMoney();
      else if (n == 0) {
        exit = true;
        System.out.println("Bye!");
      }
    }
  }

  private static void createAccountForNewCustomer() {
    System.out.println("-> What type of account do U want?");
    System.out.println("  1. Transaction account");
    System.out.println("  2. Saving account");
    System.out.println("  0. Go to menu");
    int n = App.scanner.nextInt();
    String accountType = "";
    if (n == 1) accountType = "Account";
    else if (n == 2) accountType = "SavingAccount";
    else if (n == 0) return;

    System.out.println("-> Enter customer name: ");
    String name = App.scanner.next();
    Customer c = new Customer(name);

    System.out.println("-> Enter initialize balance: ");
    int balance = App.scanner.nextInt();

    Account a = c.createNewAccount(accountType, balance);
    System.out.println("Done! CustomerID: " + c.id + " AccountID: " + a.id);
  }

  private static void createAccountForOldCustomer() {
    System.out.println("-> Enter CustomerID: ");
    int customerID = App.scanner.nextInt();
    Customer c = Customer.findByID(customerID);
    if (c == null)  {
      System.out.println("CustomerID not found!");
      return;
    }

    System.out.println("Customer name is: " + c.name);

    System.out.println("-> What type of account do U want?");
    System.out.println("  1. Transaction account");
    System.out.println("  2. Saving account");
    int n = App.scanner.nextInt();
    String accountType = "";
    if (n == 1) accountType = "Account";
    else if (n == 2) accountType = "SavingAccount";

    System.out.println("-> Enter initialize balance: ");
    int balance = App.scanner.nextInt();

    Account a = c.createNewAccount(accountType, balance);
    System.out.println("Done! CustomerID: " + c.id + " AccountID: " + a.id);
  }

  private static void showAccountBalance() {
    System.out.println("-> Enter CustomerID: ");
    int customerID = App.scanner.nextInt();
    Customer c = Customer.findByID(customerID);
    if (c == null)  {
      System.out.println("CustomerID not found!");
      return;
    }

    System.out.println("Customer name is: " + c.name);

    System.out.println("-> Enter AccountID: ");
    int accountID = App.scanner.nextInt();
    Account a = c.findAccountByID(accountID);
    if (a == null)  {
      System.out.println("AccountID not found!");
      return;
    }

    System.out.println("  | Balance is: " + a.balance);
    System.out.println("  | Account created at: " + a.createdAt);

  }

  private static void showSavingAccountProfit() {
    System.out.println("-> Enter CustomerID: ");
    int customerID = App.scanner.nextInt();
    Customer c = Customer.findByID(customerID);
    if (c == null)  {
      System.out.println("CustomerID not found!");
      return;
    }

    System.out.println("Customer name is: " + c.name);

    System.out.println("-> Enter AccountID: ");
    int accountID = App.scanner.nextInt();
    SavingAccount a = c.findSavingAccountByID(accountID);
    if (a == null)  {
      System.out.println("AccountID not found!");
      return;
    }

    System.out.println("  | Current profit is: " + a.calculateProfit());

  }

  private static void sendMoney() {
    System.out.println("-> Enter your CustomerID: ");
    int customerID = App.scanner.nextInt();
    Customer c = Customer.findByID(customerID);
    if (c == null)  {
      System.out.println("CustomerID not found!");
      return;
    }

    System.out.println("Customer name is: " + c.name);

    System.out.println("-> Enter your AccountID: ");
    int userAId = App.scanner.nextInt();
    Account userA = c.findAccountByID(userAId);
    if (userA == null)  {
      System.out.println("your account ID not found!");
      return;
    }

    System.out.println("-> Enter your partner AccountID: ");
    int partnerAId = App.scanner.nextInt();
    Account partnerA = Account.findByID(partnerAId);
    if (partnerA == null)  {
      System.out.println("Partner account ID not found!");
      return;
    }

    System.out.println("-> Enter the amount:");
    int amount = App.scanner.nextInt();
    userA.decrease(amount);
    partnerA.increase(amount);

    System.out.println("Done!");
  }
}
