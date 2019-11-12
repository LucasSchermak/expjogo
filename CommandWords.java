package exp_jogo2_ChildHood;

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "ir", "sair", "socorro", "buceta", "caralho", "foda", "puta", "filho da puta", "corno", "vai se fuder", "toma no cu", "tomar no cu", "vai tomar no cu", "vtnc", "cu", "porra", "desgracado", "viado", "seu lixo"};


    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
