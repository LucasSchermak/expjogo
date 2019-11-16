
/**
 * classe com saidas não fechadas.
 */
public class Saida
{
    private String direcao;
    private Room proximaSaida;

    /**
     * Constructor for objects of class Saida
     */
    public Saida(String direcao, Room proximaSaida)
    {
        this.direcao = direcao;
        this.proximaSaida = proximaSaida;
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
    public Room getProximaSaida()
    {
        return proximaSaida;
    }
    public void setProximaSaida(Room proximaSaida)
    {
        this.proximaSaida = proximaSaida;
    }
}
