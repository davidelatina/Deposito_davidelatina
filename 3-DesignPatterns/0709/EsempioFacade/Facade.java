// Sottosistema
class SubsystemA {
  void operationA() {
    System.out.println("Operazione A del sottosistema A");
  }
}

class SubsystemB {
  void operationB() {
    System.out.println("Operazione B del sottosistema B");
  }
}

// Facade
class Facade {
  private SubsystemA a = new SubsystemA();
  private SubsystemB b = new SubsystemB();

  public void operazioneUnificata() {
    a.operationA();
    b.operationB();
  }
}

