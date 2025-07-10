// Sottosistema
class LuceCamera {
  void accendi() {
    System.out.println("Accesa luce in camera.");
  }
}

class LuceCucina {
  void accendi() {
    System.out.println("Accesa luce in cucina.");
  }
}

// Facade
class GestioneLuciFacade {
  private LuceCamera a = new LuceCamera();
  private LuceCucina b = new LuceCucina();

  public void accendiTutte() {
    a.accendi();
    b.accendi();
  }
}

