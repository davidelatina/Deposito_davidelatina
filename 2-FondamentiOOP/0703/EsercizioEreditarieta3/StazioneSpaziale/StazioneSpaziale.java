package EsercizioEreditarieta3.StazioneSpaziale;

import java.util.ArrayList;

public class StazioneSpaziale {
  private int userTotal = 0;
  private Astronauta activeUser;

  private ArrayList<Astronauta> personale;

  // Liste ordinate insieme: esperimento [1] ha valutazione valutazioni [1], eccetera
  private ArrayList<String> esperimenti;
  private ArrayList<Integer> valutazioni;

  public StazioneSpaziale() {
    this.personale = new ArrayList<>();
    this.esperimenti = new ArrayList<>();
    this.valutazioni = new ArrayList<>();
  }

  // Assumi nuovo personale.
  public void hire(boolean ispettore, String nome, String email) {

    // Assegna al lavoro appropriato, genera nuovo oggetto e inserisci in arraylist
    if (ispettore) {
      Ispettore nuovoUtente = new Ispettore(nome, email);
      personale.add(nuovoUtente);
    } else {
      Scienziato nuovoUtente = new Scienziato(nome, email);
      personale.add(nuovoUtente);
    }

    // Aggiungi al totale utenti
    userTotal++;

    // Imposta primo utente come attivo
    if (userTotal == 1) {
      activeUser = personale.getFirst();
    }
  }

  // Ottieni rango utente
  public String getUserRank() {
    return this.activeUser.toString();
  }

  // Ottieni mansione utente
  public String getUserJob() {
    return this.activeUser.getJob();
  }

  // Ottieni messaggio di accesso
  public String getUserGreeting() {
    return "Ciao, "
        + this.activeUser.toString()
        + " "
        + this.activeUser.getNome()
        + " - Credito: "
        + activeUser.getCreditoOssigeno();
  }

  // Aggiungi crediti ossigeno (solo con login)
  private void addOxygen() {
    float oxy = activeUser.getCreditoOssigeno();
    oxy += 10.0f + (float) Math.random() * 90;
    activeUser.setCreditoOssigeno(oxy);
  }

  // Effettua login
  public boolean login(String nome, String email) {

    // SOLO PER PRIMO LOGIN aggiungi automaticamente il primo accesso al personale
    if (personale.size() == 0) {
      personale.add(new Scienziato(nome, email));
      return true;
    }

    // Altrimenti, controlla se i dati sono corretti
    for (Astronauta a : personale) {
      if (a.getNome().equalsIgnoreCase(nome) && a.getEmail().equalsIgnoreCase(email)) {
        this.activeUser = a;
        addOxygen();
        return true;
      }
    }
    return false;
  }

  // Stampa informazioni utente
  public void printInfo() {
    Astronauta utente = activeUser;
    System.out.println(utente + " " + utente.getNome() + " " + utente.getEmail());
  }

  // Numero di esperimenti
  int getNumberOfExperiments() {
    return esperimenti.size();
  }

  // Numero di valutazioni
  int getNumberOfEvaluations() {
    if (valutazioni.size() == 0) {
      return 0;
    }

    int ret = 0;

    for (int i : valutazioni) {
      if (i > 0) {
        ret++;
      }
    }

    return ret;
  }

  // Ottieni informazioni su un singolo esperimento.
  public String getExperimentInfo(int i) {
    // --- Verifica input
    if (i < 1 || esperimenti.size() < i) {
      return "Indice invalido. Sono attualmente presenti solo "
          + esperimenti.size()
          + " esperimenti.\n";
    }

    // --- Corpo funzione
    return esperimenti.get(i - 1);
  }

  // Funzione in overload.
  // Effettua lavoro consono alla posizione. promuovi dopo 3 azioni.

  // Aggiungi esperimento (Scienziato)
  public boolean work(String s) {
    // --- Verifica input
    if (!(activeUser instanceof Scienziato)) {
      System.out.println("Utente non autorizzato.");
      return false;
    }

    // Esperimento invalido
    if (s.trim().isBlank()) {
      System.out.println("Nome esperimento invalido.");
      return false;
    }

    // --- Corpo funzione

    // Valido
    esperimenti.add(s);
    // Zero è segnaposto per esperimenti ancora non valutati
    valutazioni.add(0);
    System.out.println("Esperimento \"" + s + "\" aggiunto.");

    // Aggiungi esperienza
    addExperience();

    return true;
  }

  // Valuta esperimento (Ispettore)
  public boolean work(int esperimento, int voto) {

    // --- Verifica input
    if (!(activeUser instanceof Ispettore)) {
      System.out.println("Utente non autorizzato.");
      return false;
    }
    if (voto < 1 || 5 < voto) {
      System.out.println("Voto invalido. Inserire un numero da 1 a 5.");
      return false;
    }
    if (esperimento < 1 || esperimenti.size() < esperimento) {
      System.out.println(
          "Esperimento inesistente. Inserire un numero compreso tra 1 e " + esperimenti.size());
      return false;
    }

    // --- Corpo funzione
    esperimento--;
    valutazioni.set(esperimento, voto);

    // Aggiungi esperienza
    addExperience();

    return true;
  }

  // Stampa (ruoli avanzati)
  public boolean work() {

    // Effettua lavoro consono alla posizione
    if (activeUser instanceof IspettoreCapo) {
      printAll();
    } else if (activeUser instanceof ScienziatoEsperto) {
      printAllExperiments();
    } else {
      System.out.println("Utente non autorizzato.");
      return false;
    }

    // Aggiungi esperienza
    addExperience();

    return true;
  }

  // Incrementa esperienza (solo con work())
  private void addExperience() {
    int esperienza = activeUser.getEsperienza();
    esperienza++;
    activeUser.setEsperienza(esperienza);
    if (activeUser.getEsperienza() == 3) {
      promuovi();
    }
  }

  private void promuovi() {

    // Scienziato -> Scienziato esperto
    if (activeUser instanceof Scienziato) {
      for (int i = 0; i < personale.size(); i++) {
        if (personale.get(i) == activeUser) {
          ScienziatoEsperto newAccount =
              new ScienziatoEsperto(
                  activeUser.getNome(), activeUser.getEmail(), activeUser.getCreditoOssigeno());
          personale.set(i, newAccount);
          activeUser = personale.get(i);
        }
      }

      // Ispettore -> Ispettore capo
    } else if (activeUser instanceof Ispettore) {
      for (int i = 0; i < personale.size(); i++) {
        if (personale.get(i) == activeUser) {
          IspettoreCapo newAccount =
              new IspettoreCapo(
                  activeUser.getNome(), activeUser.getEmail(), activeUser.getCreditoOssigeno());
          personale.set(i, newAccount);
          activeUser = personale.get(i);
        }
      }
    } else {
      // Non dovrebbe essere accessibile
      System.out.println("Non dovrebbe essere accessibile");
    }
  }

  private void printAllExperiments() {
    for (String string : esperimenti) {
      System.out.println(string);
    }
  }

  private void printAll() {

    for (int i = 0; i < esperimenti.size(); i++) {
      System.out.print("val: ");
      if (valutazioni.get(i) == 0) {
        System.out.print("-");
      } else {
        System.out.print(valutazioni.get(i));
      }
      System.out.println(" | esp: ");

      System.out.println(esperimenti.get(i));
    }
  }
}

class ScienziatoEsperto extends Scienziato {
  // Ruolo
  private static final String job = "Supervisione esperimenti";

  String getJob() {
    return job;
  }

  // Costruttore
  ScienziatoEsperto(String nome, String email, float creditoOssigeno) {
    super(nome, email);
    this.setCreditoOssigeno(creditoOssigeno);
  }

  @Override
  public String toString() {
    return "Scienziato Esperto";
  }
}

class IspettoreCapo extends Ispettore {
  // Ruolo
  private static final String job = "Supervisione valutazioni";

  String getJob() {
    return job;
  }

  // Costruttore
  IspettoreCapo(String nome, String email, float creditoOssigeno) {
    super(nome, email);
    this.setCreditoOssigeno(creditoOssigeno);
  }

  @Override
  public String toString() {
    return "Ispettore Capo";
  }
}

class Scienziato extends Astronauta {
  // Ruolo
  private static final String job = "Aggiungi esperimento";

  String getJob() {
    return job;
  }

  // Costruttore
  Scienziato(String nome, String email) {
    super(nome, email);
  }

  @Override
  public String toString() {
    return "Scienziato";
  }
}

class Ispettore extends Astronauta {
  // Ruolo
  private static final String job = "Valuta esperimenti";

  String getJob() {
    return job;
  }

  // Costruttore
  Ispettore(String nome, String email) {
    super(nome, email);
  }

  @Override
  public String toString() {
    return "Ispettore";
  }
}

abstract class Astronauta {
  // Ruolo
  private static final String job = "Non morire";

  String getJob() {
    return job;
  }

  // Nome
  private String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  // Email
  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // Esperienza
  private int esperienza = 0;

  public int getEsperienza() {
    return esperienza;
  }

  public void setEsperienza(int esperienza) {
    this.esperienza = esperienza;
  }

  // Credito ossigeno
  private float creditoOssigeno = 0.0f;

  public float getCreditoOssigeno() {
    return creditoOssigeno;
  }

  public void setCreditoOssigeno(float creditoOssigeno) {
    this.creditoOssigeno = creditoOssigeno;
  }

  // Costruttore
  Astronauta(String nome, String email) {

    this.nome = nome;
    this.email = email;
    this.esperienza = 0;

    this.creditoOssigeno += 10.0f + (float) Math.random() * 90;
  }

  @Override
  public String toString() {
    return "Astronauta";
  }
}
