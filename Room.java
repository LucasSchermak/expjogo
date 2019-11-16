import java.util.HashMap;
import java.util.Set;

public class Room 
{
    private String description;
    private String name;
    private HashMap<String, Room> exits;        // stores exits of this room.
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
    }
    
    public static void createRooms()
    {
        //Casa
        Room quarto,sala,cozinha,banheiro,garagem,quartoPais,escadas,quartoIrmao,jardim,sacada;
        //Primeiro andar lojas
        Room loja1,loja2,loja3,loja4,loja5,loja6,
        loja7,loja8,loja9,loja10,loja11,loja12,
        loja13,loja14,loja15,loja16,loja17,loja18,
        loja19, loja20,loja21;
        //Primeiro andar Quiosques
        Room q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;
        //Primeiro andar seguranca, enfermaria e banheiros
        Room enfermaria,seguranca, banheiro1, 
        banheiro2, banheiro3,elevador;

        //criar as salas
        quarto = new Room("no meu quarto");
        sala = new Room("na nossa sala");
        cozinha = new Room("na nossa cozinha");
        banheiro = new Room("no meu banheiro");
        garagem = new Room("na nossa garagem");
        quartoPais = new Room("no quarto do papai e da mamãe");
        escadas = new Room("nas escadas de casa, mamãe diz que aqui é perigoso");
        quartoIrmao = new Room("no quarto do Jonas, o meu irmão");
        jardim = new Room("no jardim de casa");
        sacada = new Room("na sacada, se o papai me ver aqui ele me mata!");
        c11 = new Room("Você está");
        c12 = new Room("Você está");
        c13 = new Room("Você está");
        c14 = new Room("Você está");
        c15 = new Room("Você está");
        c16 = new Room("Você está");
        c17 = new Room("Você está");
        
        loja1 = new Room("Você está na PetLand comprando brinquedos para o seu pet");
        loja2 = new Room("Você está na Imaginarium");
        loja3 = new Room("Você está no banco");
        loja4 = new Room("Você está na PBKids");
        loja5 = new Room("Você está no Boticário");
        loja6 = new Room("Você está na Toni Toys");
        loja7 = new Room("Você está no Kids Park");
        loja8 = new Room("Você está na Livraria");
        loja9 = new Room("Você está no Magic Game");
        loja10 = new Room("Você está no Cinema");
        loja11 = new Room("Você está na Adidas");
        loja12 = new Room("Você está na MAC Cosméticos");
        loja13 = new Room("Você está nas Lojas Americanas");
        loja14 = new Room("Você está na Granado");
        loja15 = new Room("Você está na Game Hero");
        loja16 = new Room("Você está na C&A");
        loja17 = new Room("Você está na Centauro");
        loja18 = new Room("Você está na Polishop");
        loja19 = new Room("Você está na Bumerang Brinquedos");
        loja20 = new Room("Você está na Tok&Stok");
        loja21 = new Room("Você está na Hot Zone");
        
        q1 = new Room("Você está na Bubble Kill");
        q2 = new Room("Você está na loja de doces");
        q3 = new Room("Você está na Maybelline");
        q4 = new Room("Você está na Piticas");
        q5 = new Room("Você está na Casa da Bruxa");
        q6 = new Room("Você está na Chilli Beans");
        q7 = new Room("Você está na Zee Dog");
        q8 = new Room("Você está na Aco Design");
        q9 = new Room("Você está na Goodies Confeitaria");
        q10 = new Room("Você está na Cacau Show");
        
        banheiro1 = new Room("");
        banheiro2 = new Room("");
        banheiro3 = new Room("");
        elevador = new Room("");
        enfermaria = new Room("");
        seguranca = new Room("");
        //colocar as saidas da sala
        c1.setExit("KidsPark", loja7);
        c1.setExit("Livraria,", loja8);
        c1.setExit("MagicGames", loja9);
        c1.setExit("Banheiro", banheiro2);
        c1.setExit("CorredorOeste", c2);
        c1.setExit("CorredorSul", c4);
        c1.setExit("Piticas",q4);
        c1.setExit("BubbleKill",q1);
        
        c2.setExit("Cinema", loja10);
        c2.setExit("Adidas", loja11);
        c2.setExit("CorredorLeste", c1);
        c2.setExit("CorredorSul", c5);
        c2.setExit("CorredorOeste", c3);
        
        c3.setExit("Mac", loja12);
        c3.setExit("LojasAmericanas",loja13);
        c3.setExit("Granado", loja14);
        c3.setExit("Hotzone",loja21);
        c3.setExit("CorredorSul",c6);
        c3.setExit("CorredorLeste",c2);
        c3.setExit("CasaDaBruxa", q5);
        c3.setExit("ChilliBeans", q6);
        
        c4.setExit("ToniToys", loja6);
        c4.setExit("Boticario",loja5);
        c4.setExit("CorredorNorte",c1);
        c4.setExit("CorredorSul",c7);
        c4.setExit("Piticas",q4);
        c4.setExit("ClubeDoce",q2);
        
        c5.setExit("CorredorNorte",c2);
        c5.setExit("CorredorSul", c9);
        c5.setExit("BubbleKill",q1);
        c5.setExit("Maybelline",q3);
        c5.setExit("CasaDaBruxa",q5);
        c5.setExit("Elevador",elevador);
        
        c6.setExit("Game hero", loja15);
        c6.setExit("c&a", loja16);
        c6.setExit("corredor ao norte", c3);
        c6.setExit("corredor ao sul", c11);
        c6.setExit("chilli beans",q6);
        
        c7.setExit("pbkids", loja4);
        c7.setExit("banco", loja3);
        c7.setExit("corredor ao norte",c4);
        c7.setExit("corredor ao oeste", c8);
        c7.setExit("corredor ao sul", c12);
        
        c8.setExit("corredor ao leste",c7);
        c8.setExit("corredor ao oeste", c9);
        c8.setExit("b&c balas", q2);
        c8.setExit("maybelline",q3);
        c8.setExit("zee dog",q7);
        c8.setExit("aco design",q8);
        
        c9.setExit("corredor ao norte",c5);
        c9.setExit("corredor ao oeste",c10);
        c9.setExit("corredor ao sul",c13);
        c9.setExit("corredor ao leste", c8);
        currentRoom = homeP;
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
             /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "Estou " + name + description + ".\n" + getExitString();
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
    public String getName(){
        return name;
    }
}

