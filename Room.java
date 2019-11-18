import java.util.HashMap;
import java.util.Set;

public class Room 
{
    private String description;
    private String name;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Item> itens;
    private NPC npc;
    private HashMap<String, Porta> portas;
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
        npc = new NPC("Mãe","...");
        portas = new HashMap<String, Porta>();
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
        return "Estou " + name + description + ".\n" + getExitString() +".\n" + getPortaString() + ".\n";//+ getItemString() + ".\n" + getNPCString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Saidas:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direcao
     * "direcao". If there is no room in that direcao, return null.
     * @param direcao The exit's direcao.
     * @return The room in the given direcao.
     */
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
}

