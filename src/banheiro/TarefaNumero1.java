package banheiro;

public class TarefaNumero1 implements Runnable {

  private Banheiro banheiro;

  public TarefaNumero1(Banheiro banheiro2) {
    this.banheiro = banheiro2;
  }

  @Override
  public void run() {
    banheiro.fazNumero1();
  }
}
