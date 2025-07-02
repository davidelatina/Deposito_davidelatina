public class TooShortStringException extends Exception {

  public TooShortStringException(String message) {
    super(message);
  }

  public TooShortStringException (String message, Throwable cause) {
    super(message, cause);
  }
}
