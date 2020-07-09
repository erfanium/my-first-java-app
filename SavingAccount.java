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
