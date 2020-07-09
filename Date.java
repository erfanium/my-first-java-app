import java.time.LocalDate;

class Date {
  static LocalDate mockedNow;

  static LocalDate now() {
    if (Date.mockedNow != null) return Date.mockedNow;
    return LocalDate.now();
  }
}