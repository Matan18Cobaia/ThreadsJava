package banheiro;

public class Banheiro {

  boolean ehSujo = true;

  public void fazNumero1() {
    String convidado = Thread.currentThread().getName();
    System.out.println(convidado + " Batendo na porta");

    synchronized (this) {
      System.out.println(convidado + " Entrando no banheiro");
      while (ehSujo) {
        System.out.println(convidado + " eca, o banheiro est� sujo");
        try {
          this.wait();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }

      System.out.println(convidado + " Fazendo coisa rapida");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(convidado + " Dando descarga");
      System.out.println(convidado + " lavando M�o");
      ehSujo = true;
      System.out.println(convidado + " saindo do banheiro");
    }
  }

  public void fazNumero2() {
    String convidado = Thread.currentThread().getName();
    System.out.println(convidado + " Batendo na porta");
    synchronized (this) {
      System.out.println(convidado + " Entrando no banheiro");
      while (ehSujo) {
        System.out.println(convidado + " eca, o banheiro est� sujo");
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println(convidado + " Fazendo coisa demorada");
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(convidado + " Dando descarga");
      System.out.println(convidado + " lavando M�o");
      ehSujo = true;
      System.out.println(convidado + " saindo do banheiro");
    }
  }

  public void limpa() {
    String faxineira = Thread.currentThread().getName();
    System.out.println(faxineira + " Batendo na porta");
    synchronized (this) {
      System.out.println(faxineira + " entrando no banheiro");
      System.out.println(faxineira + " fazendo a limpeza");
      try {
        Thread.sleep(12000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      this.notifyAll();
      ehSujo = false;
      System.out.println((faxineira + " saindo do banheiro"));
    }
  }
}
