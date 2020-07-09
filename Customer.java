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
