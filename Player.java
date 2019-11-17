import java.util.HashMap;
import java.util.Set;

public class Player {   
    private HashMap<String, Item> inventario;

    public Player(){
        inventario = new HashMap<String, Item>();
    }
    //adiciona o inventario em uma string e retorna ela.
    public String getInventario(){
        String returnInventario = "Inventario: ";
        Set<String> keys = inventario.keySet();
        for(String item : keys){
            returnInventario += " " + item;
        }
        return returnInventario;
    }
    //adiciona item diretamente no inventario
    public void addInventario(Item item){
        inventario.put(item.getItemNome(),item);
    }
    //adiciona o item e a descrição no inventario.
    public void addInventarioD(String itemNome, String descricao){
        Set<String> keys = inventario.keySet();
        for(String item : keys){
            if (item.equals(itemNome))
            {
                System.out.println("Eu já temos isso!");
                return;
            }
        }
        Item novoItem = new Item (descricao, itemNome);
        inventario.put(itemNome, novoItem);

    }
    // verifica se o player já tem uma chave no inventario.
    public boolean verificaChave(){
        Set<String> keys = inventario.keySet();
        for(String item : keys){
            if(item.equals("chave"))
                return true;
        }
        return false;
    }
    // tira o item do inventario
    public Item dropItem(String itemNome){
        Set<String>keys = inventario.keySet();
        for(String item : keys){
            if (item.equals(itemNome))
            {
                Item inv = inventario.get(itemNome);
                inventario.remove(itemNome);
                return inv;
            }
        }
        System.out.println("Eu não tenho isso!");
        return null;
    }
}
