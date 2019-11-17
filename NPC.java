public class NPC
{
    private String nome;
    private String descricao;
    /**
     * Constructor for objects of class NPC
     */
    public NPC(String nome,String descricao)
    {
        this.nome = nome;
        this.descricao = descricao;
    }
    public String getDescricao()
    {
        return descricao;
    }
    public String getNome()
    {
        return nome;
    }
}
