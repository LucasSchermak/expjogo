
/**
 * classe com saidas não fechadas.
 */
public class Saida
{
    private String direcao;
    private Room saidaProxima;

    /**
     * Constructor for objects of class Saida
     */
    public Saida(){

    }

    public Saida(String direcao, Room saidaProxima)
    {
        this.direcao = direcao;
        this.saidaProxima = saidaProxima;
    }

    public String getDirecao()
    {
        // put your code here
        return direcao;
    }

    public void setDirecao(String direcao)
    {
        this.direcao = direcao;
    }

    public Room getSaidaProxima()
    {
        return saidaProxima;
    }

    public void setSaidaProxima(Room saidaProxima)
    {
        this.saidaProxima = saidaProxima;
    }
}
