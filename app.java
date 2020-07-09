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
    System.out.println("What Do U want to me?");
    System.out.println("  1. Create a customer");

  }
}

class Date {
  static LocalDate mockedNow;

  static LocalDate now() {
    if (Date.mockedNow != null) return Date.mockedNow;
    return LocalDate.now();
  }
}

public class Customer {
  static int lastID = 0;
  int id;
  String name;
  ArrayList<Account> accounts = new ArrayList<Account>();
  ArrayList<SavingAccount> savingAccounts = new ArrayList<SavingAccount>();

  public Customer() {
    this.name = "erfan";
  }

  void createNewAccounts(String type, int balance) {
    switch (type) {
      case "Account":
        Account a = new Account(this.id, balance);
        this.accounts.add(a);
        break;
      case "SavingAccount":
        SavingAccount sa = new SavingAccount(this.id, balance);
        this.savingAccounts.add(sa);
        break;
    }
  }

  void printAccounts() {
    this.accounts.forEach(a -> System.out.println(a.balance));
  }
}

class Account {
  static int lastID = 0;
  int id;
  int customerID;
  int balance;
  LocalDate createdAt;

  Account(int cid, int balance) {
    this.createdAt = Date.now();
    this.id = lastID;
    this.customerID = cid;
    this.balance = balance;
    Account.lastID++;
  }

  void increase(int by) {
    this.balance += by;
  }

  void decrease(int by) {
    this.balance -= by;
  }
}

class SavingAccount extends Account {
  int profitPercentage = 0;
  LocalDate lastPercentageCalculationDate;

  SavingAccount(int cid, int balance) {
    super(cid, balance);
  }

  void calculateProfit() {
    long m = ChronoUnit.MONTHS.between(
      this.lastPercentageCalculationDate,
      Date.now()
    );
    this.balance += m * this.profitPercentage;
  }
}
