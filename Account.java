import java.time.LocalDate;

public class Account {
  static int lastID = 0;
  int id;
  int customerID;
  int balance;
  LocalDate createdAt;

  public Account(int cid, int balance) {
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
