import java.util.Scanner;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Scanner leitor;    
    
     // Create the game and initialise its internal map.

    public Game() 
    {
        createRooms();
        parser = new Parser();
        leitor = new Scanner(System.in);
    }


     //* Create all the rooms 
    private void createRooms()
    {
        Room homeP, hPsala, hPcozinha, hPquarto, hPbanheiro, rua;
      
        // create the rooms
        homeP = new Room("na minha casa");
        hPsala = new Room("na sala de casa");
        hPcozinha = new Room("na cozinha da minha mãe");
        hPquarto = new Room("no meu quarto");
        hPbanheiro = new Room("no banheiro de casa");
        rua = new Room("na rua de casa");
        // initialise room exits
        homeP.setExit("leste", hPsala);
        homeP.setExit("sul", hPcozinha);
        homeP.setExit("oeste", hPquarto);
        homeP.setExit("norte",rua);

        hPsala.setExit("oeste", hPcozinha);
        hPsala.setExit("oeste", hPquarto);

        hPcozinha.setExit("leste", hPsala);
        hPcozinha.setExit("oeste", hPquarto);
        
        hPquarto.setExit("norte", hPsala);
        hPquarto.setExit("leste", hPcozinha);

        hPbanheiro.setExit("oeste", hPsala);
        
        rua.setExit("sul", homeP);
        currentRoom = homeP;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        printIntro();
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Obrigado por jogar! Tchau!");
        
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("   oooooo.   oooo         o8o  oooo        .o8  ooooo   ooooo                           .o8  ");
        System.out.println(" d8P'  `Y8b  `888         `'   `888        888  `888'   `888'                           888  ");
        System.out.println("888           888 .oo.   oooo   888   .oooo888   888     888   .ooooo.   .ooooo.   .oooo888  "); 
        System.out.println("888           888PYY88b  `888   888  d88' `888   888ooooo888  d88' `88b d88' `88b d88' `888  "); 
        System.out.println("888           888   888   888   888  888   888   888     888  888   888 888   888 888   888  "); 
        System.out.println("`88b    ooo   888   888   888   888  888   888   888     888  888   888 888   888 888   888  "); 
        System.out.println(" `Y8bood8P'  o888o o888o o888o o888o `Y8bod88P  o888o   o888o `Y8bod8P' `Y8bod8P' `Y8bod88P  \n\n\n");
        System.out.println("Um jogo produzido por Allyson Luan Dunke e Lucas Schermak.");
        System.out.println("Escreva 'socorro' se precisar de ajuda ;) /n");
        System.out.println("Aperte qualquer tecla para continuar...");
        String qualquerTecla = leitor.nextLine().trim();
    }
    
    private void printIntro()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA !!!");
        System.out.println(". . .");
        System.out.println("O quê??");
        System.out.println(". . .");
        System.out.println("Ufa, foi só um pesadelo!");
        System.out.println("Acabei de sonhar que minha mãe havia sumido!");
        System.out.println("Não imagino eu, um garoto de 7 anos, conseguir viver sem a mamãe...");
        System.out.println("Falando nisso, melhor eu ir falar com ela.");
        System.out.println("Me bateu uma fome!");
        System.out.println();
        //System.out.println(currentRoom.getLongDescription());
    }
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Quê? Não entendi ...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("socorro")) {
            printHelp();
        }
        else if (commandWord.equals("ir")) {
            goRoom(command);
        }
        else if (commandWord.equals("sair")) {
            wantToQuit = quit(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("Meu nome é Bartolomeu, tenho 7 anos.");
        System.out.println("Me chamam de Bart :)");
        System.out.println();
        System.out.println("Caso voce esteja confuso,");
        System.out.println("Você pode escrever:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Ir para onde?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Não tem caminho por aqui!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Por Favor Não!!!1");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
