
import java.util.Scanner;
import java.util.Set;

public class Game 
{
    private Parser parser;
    private Scanner leitor;    
    private Player player;
    // Create the game and initialise its internal map.

    public Game() 
    {
        player= new Player();
        parser = new Parser();
        leitor = new Scanner(System.in);
        createRooms();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        printIntro();
        tocarMusica("Music/zuul.wav");
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Obrigado por jogar! Tchau!");

    }

    private void createRooms()
    {
        //Casa
        Room minhaCasa,quarto,sala,cozinha,banheiro,garagem,quartoPais,escadas,jardim,sacada,c1,c2;
        //Rua
        Room rua1, rua2, rua3;
        //Mundo magico
        Room portal, inicio;
        Room pessoasestranhas1, pessoasestranhas2, pessoasestranhas3;
        Room ficoupequeno1, ficoupequeno2, ficoupequeno3; 
        Room altura1, altura2, altura3; 
        Room cachorro1, cachorro2, cachorro3; 
        Room fantasmas1, fantasmas2, fantasmas3; 
        Room trovao1, trovao2, trovao3; 
        Room escuro1, escuro2, escuro3;
        Room insetos1, insetos2, insetos3;
        Room ladrao1, ladrao2, ladrao3;
        Room dentista1, dentista2, dentista3;
        Room minecraft1, minecraft2, minecraft3;

        //criar as salas
        // CASA
        minhaCasa = new Room("na minha casa","ela é a mais bonita do condominio");
        quarto = new Room("no meu quarto", "aqui ficam meus brinquedos e minha cama. \nMeu irmão mais velho, Jonas, também dorme aqui, mas ele é chato. Sorte que ele está dormindo agora");
        sala = new Room("na nossa sala", "a tv está ligada no One Piece, a guitarra do meu irmão está jogada no chão, como sempre...\nA porta para a rua fica aqui");
        cozinha = new Room("na nossa cozinha", "tem muitas coisas que eu não posso mexer aqui. \nEngraçado, está tudo arrumado, achei que encontraria a mamãe aqui cozinhando. \nA porta para o jardim fica aqui");
        banheiro = new Room("no meu banheiro", "minha escova de dentes está ficando velha. Eu não estou com vontade de fazer pipi agora");
        garagem = new Room("na nossa garagem", "nosso carro azul está aqui, ele está sujo. Tem também as ferramentas do papai. \nO portão da garagem é automática");
        quartoPais = new Room("no quarto do papai e da mamãe", "a cama deles é enorme, a porta da sacada está aberta");
        escadas = new Room("nas escadas de casa", "mamãe diz que aqui é perigoso");
        jardim = new Room("no jardim de casa", "as flores da mamãe estão crescendo muito bem");
        sacada = new Room("na sacada", "aqui é muito alto! Se o papai me ver aqui ele me mata!");
        c1 = new Room("no corredor de cima", "este corredor leva até o meu quarto e do meu irmão, o banheiro, o quarto dos meus pais e as escadas");
        c2 = new Room("no corredor de baixo", "este corredor leva até as escadas, a cozinha, a sala e a garagem");

        rua1 = new Room("saindo de casa", "há várias outras casas no nosso condomínio, não há muitos carros na rua.\nAlgo está brilhando na esquina");
        rua2 = new Room("no meio da rua", "a luz brilhante está cada vez mais perto");
        rua3 = new Room("na esquina", "a luz na verdade é um portal, talvez eu devesse chegar mais perto..");

        // PORTAL
        portal = new Room("em frente a algo que se parece com um portal", "ele é de cor roxa e tem formas bizarras");

        // MUNDO MAGICO
        inicio = new Room("em uma espécie de mundo mágico","há alguns caminhos que eu posso seguir");
        pessoasestranhas1 = new Room("um lugar que eu não conheço", "algumas pessoas que eu nunca vi estão me encarando. Talvez elas saibam onde mamãe está");
        pessoasestranhas2 = new Room("um lugar que eu não conheço", "estou começando a ficar com medo. As pessoas não me respondem");
        pessoasestranhas3 = new Room("um lugar que eu definitivamente não conheço", "estou me sentindo muito mal, as pessoas começaram a rir de mim");
        
        ficoupequeno1 = new Room("em uma cozinha", "parece a da minha casa, mas as coisas estão muito grandes");
        ficoupequeno2 = new Room("um lugar onde tudo está gigante", "acabei de tropeçar no garfo que eu mais gosto, parece que estou em cima da mesa de casa");
        ficoupequeno3 = new Room("em cima da mesa de casa", "o Jonas está beeeem grande. Parece que ele me viu.\n Ah não, ele deve estar achando que eu sou uma formiga! Melhor eu correr de volta");
        
        altura1 = new Room("subindo um morro", "quero ver até aonde eu consigo subir");
        altura2 = new Room("chegando em um precipício", "acho que não é uma boa idéia continuar");
        altura3 = new Room("à beira de um precipício", "se eu der mais um passo eu vou cair!");
        
        cachorro1 = new Room("em frente a um cachorrinho bonitinho", "ele é grande e peludo");
        cachorro2 = new Room("em frente a um cachorro que me mostra os dentes", "ele está chegando perto de mim");
        cachorro3 = new Room("sendo perseguido por um cachorro feio", "ele é rápido, estou cansado, não vou conseguir fugir..");
        
        fantasmas1 = new Room("em lugar cheio de pequenos muros de concreto e gavetas", "olhando bem, tem um lençol mais a frente");
        fantasmas2 = new Room("de frente a um lençol voador", "ele está fazendo careta! Ah não, ele está me fazendo seguí-lo");
        fantasmas3 = new Room("seguindo meu amigo lençol", "quero levar ele para casa");
        
        trovao1 = new Room("brincando no parquinho da frente de casa", "escutei um barulhão!");
        trovao2 = new Room("na gangorra", "parece que está começando a chover");
        trovao3 = new Room("no escorregador", "posso tentar me esconder nos túneis");
        
        escuro1 = new Room("no escuro", "não faço idéia da onde estou");
        escuro2 = new Room("no escuro", "chutei alguma coisa, meu pé tá dodói");
        escuro3 = new Room("no escuro", "será que eu fiquei cego? Estou muito triste");
        
        insetos1 = new Room("no jardim de casa", "estou entediado. As flores da mamãe são tão lindas");
        insetos2 = new Room("perto das flores da mamãe", "olhando bem de perto, tem alguns bichinhos destruindo as plantinhas. Eu deveria tentar tirá-los");
        insetos3 = new Room("em cima das flores da mamãe", "ela vai me matar por ter pisado nelas");
        
        ladrao1 = new Room("na sala de casa", "estou jogando Minecraft.\nHum? Que barulho foi esse?");
        ladrao2 = new Room("na sala de casa", "tem alguns homens me olhando na janela!");
        ladrao3 = new Room("atrás da tv", "tomara que eles não me vejam");
        
        dentista1 = new Room("sentado na cadeira da doutora Karen", "ela é a dentista que cuida da minha boca. Ela é muito legal.\nNão vejo ela por perto.");
        dentista2 = new Room("na sala da doutora Karen", "parece que estou trancado aqui... Que estranho");
        dentista3 = new Room("esperando a doutora", "a porta acabou de abrir.\nNão é a doutora! É UM MONSTRO HORRÍVEL! SOCORROOO!!!");
        
        minecraft1 = new Room("em um lugar onde tudo é quadrado","me deu uma vontade de socar uma árvore");
        minecraft2 = new Room("socando uma árvore","eu quebrei ela na porrada, mas a gravidade não derrubou ela.\nEla está flutuando agora, incrível!");
        minecraft3 = new Room("ficando com fome","já está anoitecendo. Melhor fugir antes que monstros apareçam");
        // SAIDAS //////////////////////////////////////////////////////////////////////////////////////
        // SAIDAS //////////////////////////////////////////////////////////////////////////////////////
        // SAIDAS //////////////////////////////////////////////////////////////////////////////////////
        // SAIDAS //////////////////////////////////////////////////////////////////////////////////////
        // SAIDAS //////////////////////////////////////////////////////////////////////////////////////
        // SAIDAS //////////////////////////////////////////////////////////////////////////////////////
        // SAIDAS //////////////////////////////////////////////////////////////////////////////////////
        // SAIDAS //////////////////////////////////////////////////////////////////////////////////////
        // SAIDAS //////////////////////////////////////////////////////////////////////////////////////
        minhaCasa.setExit("porta", rua1);

        quarto.setExit("corredor", c1);
        banheiro.setExit("corredor", c1);
        quartoPais.setExit("corredor", c1);
        quartoPais.setExit("sacada", sacada);
        sacada.setExit("voltar", quartoPais);
        c1.setExit("meuquarto", quarto);
        c1.setExit("banheiro", banheiro);
        c1.setPorta("quartodospais", quartoPais, false);
        c1.setExit("escadas", escadas);
        escadas.setExit("subir", c1);
        escadas.setExit("descer", c2); 
        c2.setExit("escadas", escadas);
        c2.setExit("cozinha", cozinha);
        c2.setExit("sala", sala);
        c2.setExit("garagem", garagem);
        cozinha.setExit("corredor", c2);
        cozinha.setExit("jardim", jardim);
        sala.setExit("corredor", c2);
        sala.setPorta("porta", sala, false);
        garagem.setExit("porta", c2);
        garagem.setPorta("portao", rua1, false);
        
        rua1.setExit("andando", rua2);
        rua2.setExit("voltar", rua1);
        rua2.setExit("andando", rua3);
        rua3.setExit("voltar", rua2);
        rua3.setExit("olhar", portal);
        portal.setExit("atravessar", inicio);
        portal.setExit("voltar", rua3);
        
        inicio.setExit("vizinhanca", pessoasestranhas1);
        inicio.setExit("cozinha", ficoupequeno1);
        inicio.setExit("aventura", altura1);
        inicio.setExit("cachorro", cachorro1);
        inicio.setExit("brincar", fantasmas1);
        inicio.setExit("parquinho", trovao1);
        inicio.setExit("esconder", escuro1);
        inicio.setExit("jardim", insetos1);
        inicio.setExit("sala", ladrao1);
        inicio.setExit("dentista", dentista1);
        
        pessoasestranhas1.setExit("conversar", pessoasestranhas2);
        pessoasestranhas2.setExit("embora", pessoasestranhas3);
        pessoasestranhas3.setExit("portal", inicio);
        
        ficoupequeno1.setExit("explorar", ficoupequeno2);
        ficoupequeno2.setExit("andando", ficoupequeno3);
        ficoupequeno3.setExit("portal", inicio);
        
        altura1.setExit("explorar", altura2);
        altura2.setExit("perto", altura3);
        altura3.setExit("portal", inicio);
        
        cachorro1.setExit("acariciar", cachorro2);
        cachorro2.setExit("fugir", cachorro3);
        cachorro3.setExit("portal", inicio);
        
        fantasmas1.setExit("investigar", fantasmas2);
        fantasmas2.setExit("seguir", fantasmas3);
        fantasmas3.setExit("portal", inicio);
        
        trovao1.setExit("gangorra", trovao2);
        trovao2.setExit("escorregador", trovao3);
        trovao3.setExit("portal", inicio);
        
        escuro1.setExit("andando", escuro2);
        escuro2.setExit("voltar", escuro3);
        escuro3.setExit("portal", inicio);
        
        insetos1.setExit("perto", insetos2);
        insetos2.setExit("tirar", insetos3);
        insetos3.setExit("portal", inicio);
        
        dentista1.setExit("levantar", dentista2);
        dentista2.setExit("esperar", dentista3);
        dentista3.setExit("portal", inicio);
        
        minecraft1.setExit("socar", minecraft2);
        minecraft2.setExit("explorar", minecraft3);
        minecraft3.setExit("portal", inicio);
        
        sala.setItem("chave","chave do quarto da mamãe");
        sala.setItem("controle","controle que abre a porta da garagem");
        
        quarto.addNPC("Jonas");
        
        cachorro1.addNPC("Cachorro");
        cachorro2.addNPC("Cachorro");
        cachorro3.addNPC("Cachorro");
        
        dentista1.addNPC("Karen");
        dentista2.addNPC("Karen");
        dentista3.addNPC("Karen");
        
        player.setCurrentRoom(quarto);
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("  .oooooo.   oooo         o8o  oooo        .o8  ooooo   ooooo                           .o8  ");
        System.out.println(".d8P'  `Y8b  `888         `''  `888        888  `888'   `888'                           888  ");
        System.out.println("888           888 .oo.   oooo   888   .oooo888   888     888   .ooooo.   .ooooo.   .oooo888  "); 
        System.out.println("888           888PYY88b  `888   888  d88' `888   888ooooo888  d88' `88b d88' `88b d88' `888  "); 
        System.out.println("888           888   888   888   888  888   888   888     888  888   888 888   888 888   888  "); 
        System.out.println("`88b    ooo   888   888   888   888  888   888   888     888  888   888 888   888 888   888  "); 
        System.out.println(" `Y8bood8P'  o888o o888o o888o o888o `Y8bod88P  o888o   o888o `Y8bod8P' `Y8bod8P' `Y8bod88P  \n\n\n");
        System.out.println("Um jogo produzido por Allyson Luan Dunke e Lucas Schermak.");
        System.out.println("Escreva 'socorro' se precisar de ajuda ;)");
        System.out.println("Aperte enter para continuar...");
        leitor.nextLine().trim();
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
        System.out.println(player.getCurrentRoom().getLongDescription());
        System.out.println(player.getInventario());
    }

    private void tocarMusica(String musica)
    {
        new Som().tocarSom(musica);
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
            System.out.println("Que? Não entendi ...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("socorro")) {
            printHelp();
        }
        else if (commandWord.equals("ir")) {
            goRoom(command);
        }
        else if (commandWord.equals("abrir")) {
            portaDestrancada(command);
        }
        else if (commandWord.equals("pegar")) {
            pegarItem(command);
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

        String direcao = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.getCurrentRoom().getExit(direcao);

        Room nextPorta = player.getCurrentRoom().getPorta(direcao);
        if (nextPorta != null){
            if(player.getCurrentRoom().getFechada(direcao) == false)
            {
                System.out.println("A porta está fechada!");
                return;
            }
            else
            {
                player.setCurrentRoom(nextPorta);
                System.out.println(player.getCurrentRoom().getLongDescription());
                System.out.println(player.getInventario());
                return;
            }
        }
        if (nextRoom == null) {
            System.out.println("Não tem caminho por aqui!");
        }
        else {
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().getLongDescription());
            System.out.println(player.getInventario());
        }
    }

    private void pegarItem(Command Command) {
        if (!Command.hasSecondWord()) {
            System.out.println("Pegar o que?");
            return;
        }   
        String itemDesejado = Command.getSecondWord();
        Item i = player.getCurrentRoom().deletaItem(itemDesejado);
        if (i != null)
        {     
            if(i.getItemNome().equals("chave")){
                player.chave = true;
            }
            else if(i.getItemNome().equals("controle")){
                player.controle = true;
            }
            player.addInventarioD(i.getItemNome(), i.getDescricao());

            //  atualiza inv.
            System.out.println(player.getCurrentRoom().getLongDescription());
            System.out.println(player.getInventario());
        }
    }

    // remove o item da sala

    private void portaDestrancada(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Abrir o que?");
            return;
        }
        String portaDesejada = command.getSecondWord();

        
        if(player.verificaChave()) {
           player.getCurrentRoom().getPortaAtual(portaDesejada).abrir();
           player.dropItem("chave");
           player.chave = false;

        }
        else if(player.verificaControle()) {
           player.getCurrentRoom().getPortaAtual(portaDesejada).abrir();
           player.dropItem("controle");
           player.controle = false;

        }
        else
        {
            System.out.println("Você não tem a chave!");
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

//public static void main(String []args) {
 //       new Game().play();
  //  }
}
