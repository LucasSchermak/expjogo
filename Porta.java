public class Porta extends Saida
{

    private boolean fechada;

    /**
     * Constructor for objects of class Door
     */
    public Porta(String direcao, Room saidaProxima, boolean fechada){
        this.fechada = fechada;
        this.setDirecao(direcao);
        this.setSaidaProxima(saidaProxima);
    }

    public void fechar()
    {
        fechada = true;
        return;
    }

    /**
     * Unlocks this door.
     */
    public void abrir()
    {
        fechada = false;
        return;
    }

    public boolean getFechada()
    {
        return fechada;
    }
}