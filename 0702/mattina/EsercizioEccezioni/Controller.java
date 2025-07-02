package mattina.EsercizioEccezioni;

class NumeroNegativoException extends Exception {
  public NumeroNegativoException (String message, Throwable cause) {
    super(message, cause);
  }
}

class NumeroZeroException extends Exception {
  public NumeroZeroException (String message, Throwable cause) {
    super(message, cause);
  }
}

class Controller {

  static void checkPositive (int n) throws NumeroNegativoException {
    if (n < 0) {
      throw new NumeroNegativoException("Numero negativo", new Throwable());
    }
  }

  static void checkNotZero(int n) throws NumeroZeroException {
    if (n == 0) {
      throw new NumeroZeroException("Numero zero", new Throwable());
    }
  }
}
