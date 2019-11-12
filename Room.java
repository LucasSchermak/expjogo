package exp_jogo2_ChildHood;

import java.util.HashMap;
import java.util.Set;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Object>dObj;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        dObj = new HashMap<String,Object>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructo
     */
    public String getShortDescription()
    {
        return description;
    }
    public String getDescriptionObj () {
    	String olharObj= "Olhar: ";
    	Set <String> obj = dObj.keySet();
    	for(String desc :obj)
    		olharObj += " " + desc;
    	return olharObj;
    }
  
    public String getOlhaDesc(String name)
    {
        String olharObj = "Você olhou " + name + ".\n";
        Object descTemp = dObj.get(name);
        if (descTemp != null) {
            olharObj += "it's " + descTemp.getDescription() + ".";
            return olharObj;
        }
        return "Eu não estou enxergando isso.";
    }
    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "Estou " + description + ".\n" + getExitString();
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
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

