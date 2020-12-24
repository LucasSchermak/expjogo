public class Porta extends Saida
{

    private boolean fechada;

    public Porta(String direcao, Room saidaProxima, boolean fechada){
        this.fechada = fechada;
        this.setDirecao(direcao);
        this.setSaidaProxima(saidaProxima);
    }

    public void abrir()
    {
        fechada = false;
        System.out.println("Porta aberta.");
        return;
    }

    public boolean getFechada()
    {
        return fechada;
    }
}