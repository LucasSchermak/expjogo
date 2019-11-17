/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{

    private String itemNome;
    private String descricao;

    /**
     * Constructor for objects of class Item
     */
    public Item(String itemNome, String descricao)
    {
        this.itemNome  = itemNome;
        this.descricao = descricao;
    }
    //volta o nome do item
    public String getItemNome(){
        return itemNome;
    }
    //volta a descrição do item
    public String getDescricao(){
        return descricao;
    }
}
