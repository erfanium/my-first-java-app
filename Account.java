import java.time.LocalDateTime;
import java.util.ArrayList;

public class Account {
  static int lastID = 0;
  static ArrayList<Account> accounts = new ArrayList<Account>();
  int id;
  int customerID;
  int balance;
  LocalDateTime createdAt;

  public Account(int cid, int balance) {
    this.createdAt = LocalDateTime.now();
    this.id = lastID;
    this.customerID = cid;
    this.balance = balance;
    Account.lastID++;
    Account.accounts.add(this);
  }

  public static Account findByID(int id) {
    for (Account account : Account.accounts) {
      if (account.id == id) {
        return account;
      }
    }
    return null;
  }

  void increase(int by) {
    this.balance += by;
  }

  void decrease(int by) {
    this.balance -= by;
  }
}
