import java.util.ArrayList;

public class Customer {
  static ArrayList<Customer> customers = new ArrayList<Customer>();
  static int lastID = 0;
  int id;
  String name;
  ArrayList<Account> accounts = new ArrayList<Account>();
  ArrayList<SavingAccount> savingAccounts = new ArrayList<SavingAccount>();

  static Customer findByID(int id) {
    for (Customer customer : Customer.customers) {
      if (customer.id == id) {
        return customer;
      }
    }
    return null;
  }

  public Customer(String name) {
    this.name = name;
    this.id = Customer.lastID;
    Customer.lastID++;
    Customer.customers.add(this);
  }

  Account createNewAccount(String type, int balance) {
    switch (type) {
      case "Account":
        Account a = new Account(this.id, balance);
        this.accounts.add(a);
        return a;
      case "SavingAccount":
        SavingAccount sa = new SavingAccount(this.id, balance);
        this.accounts.add(sa);
        this.savingAccounts.add(sa);
        return sa;
    }
    return null;
  }

  Account findAccountByID(int id) {
    for (Account account : this.accounts) {
      if (account.id == id) {
        return account;
      }
    }
    return null;
  }

  SavingAccount findSavingAccountByID(int id) {
    for (SavingAccount sAccount : this.savingAccounts) {
      if (sAccount.id == id) {
        return sAccount;
      }
    }
    return null;
  }


  void printAccounts() {
    this.accounts.forEach(a -> System.out.println(a.balance));
  }
}
