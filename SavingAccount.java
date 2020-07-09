import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class SavingAccount extends Account {
  public int profitPercentage = 20;
  public LocalDateTime lastPercentageCalculationDate;

  public SavingAccount(int cid, int balance) {
    super(cid, balance);
    this.lastPercentageCalculationDate = LocalDateTime.now();
  }

  public int calculateProfit() {
    int m = (int)ChronoUnit.SECONDS.between(
      this.lastPercentageCalculationDate,
      LocalDateTime.now()
    );
    this.lastPercentageCalculationDate = LocalDateTime.now();
    this.balance = this.balance + m * this.profitPercentage;
    return this.balance;
  }
}
