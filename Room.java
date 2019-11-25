import java.util.HashMap;
import java.util.Set;

public class Room {
    private String description;
    private String name;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Porta> portas;
    private HashMap<String, Item> itens;
    private HashMap<String, NPC> npcs;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String name,String description) 
    {
        this.description = description;
        this.name = name;
        exits = new HashMap<String, Room>();
        itens = new HashMap<String, Item>();
        portas = new HashMap<String, Porta>();
        npcs = new HashMap<String, NPC>();
    }

    /**
     * Define an exit from this room.
     * @param direcao The direcao of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direcao, Room neighbor) 
    {
        exits.put(direcao, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructo
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "Estou " + name + ", " + description + ".\n" + getExitString() +".\n" + getPortaString() + ".\n" + getItemString() +".\n" + getNPCString();
    }
    private String getItemString() {
        String returnString = "Itens:";
        Set<String> keys = itens.keySet();
        for(String item : keys) {
            returnString += " " + item;
            returnString += " " + itens.get(item).getDescricao();
        }
        return returnString;
    }
    private String getExitString()
    {
        String returnString = "Saidas:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    public Room getExit(String direcao) 
    {
        return exits.get(direcao);
    }

    public String getName(){
        return name;
    }

    public void setPorta(String direcao, Room saidaProxima, boolean fechada)
    {
        Porta p = new Porta(direcao, saidaProxima, fechada);
        portas.put(direcao, p);
    }

    public Room getPorta(String direcao){
        Porta p = portas.get(direcao) ;
        if(p != null)
        {
            return p.getSaidaProxima();
        }
        return null;
    }
    public Porta getPortaAtual(String direcao) {
        return portas.get(direcao);
    }
    public void setItem(String name, String descricao) {
        Set<String>keys = itens.keySet();
        for(String item : keys)
            if(item.equals(name))
                return;
        Item novoItem = new Item(name, descricao);
        itens.put(name, novoItem);
    }
    public Item deletaItem(String name){
        Set<String>keys = itens.keySet();
        for(String item: keys) {
            if (item.equals(name)) {
                Item i = itens.get(name);
                itens.remove(name);
                return i;
            }
        }
        System.out.println("Não tem isso aqui.");
        return null;
    }

    public String getPortaString(){
        String returnString = "Portas:";
        Set<String> keys = portas.keySet();
        for(String porta : keys) {
            returnString += " " + porta;
        }
        return returnString;
    }
    
    public boolean getFechada(String direcao){
        return portas.get(direcao).getFechada();
    }
    private String getNPCString()
    {
        String returnString = "NPCS:";
        Set<String> keys = npcs.keySet();
        for(String npc : keys)
            returnString += " " + npc;
        return returnString;
    }
    public void addNPC(String name)
    {
    
        Set<String> keys = npcs.keySet();
        for(String npc : keys)
            if (npc.equals(name))
                return;
    
        NPC newNPC = new NPC(name);
        npcs.put(name, newNPC);
        
    }
    public NPC getNPC()
    {
        return npcs.entrySet().iterator().next().getValue();
    }    
}

