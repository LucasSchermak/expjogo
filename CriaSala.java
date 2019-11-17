/**
 * Write a description of class CriaSala here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CriaSala
{
    private Player player;
    private Room currentRoom;
    public CriaSala()
    {
        player = new Player();
        currentRoom = new Room("No meu Quarto","...");
    }

    public void createRooms()
    {
        //Casa
        Room minhaCasa,quarto,sala,cozinha,banheiro,garagem,quartoPais,escadas,jardim,sacada,c1,c2;
        //Rua
        Room rua;

        //criar as salas
        minhaCasa = new Room("na minha casa","ela é a mais bonita do condominio");
        quarto = new Room("no meu quarto", "aqui ficam meus brinquedos e minha cama. Meu irmão mais velho, Jonas, também dorme aqui, mas ele é chato");
        sala = new Room("na nossa sala", "a tv está ligada no One Piece, a guitarra do meu irmão está jogada no chão, como sempre...\nA porta para a rua fica aqui");
        cozinha = new Room("na nossa cozinha", "tem muitas coisas que eu não posso mexer aqui. Engraçado, está tudo arrumado, achei que encontraria a mamãe aqui cozinhando. \nA porta para o jardim fica aqui");
        banheiro = new Room("no meu banheiro", "minha escova de dentes está ficando velha. Eu não estou com vontade de fazer pipi agora");
        garagem = new Room("na nossa garagem", "nosso carro azul está aqui, ele está sujo. Tem também as ferramentas do papai. \nO portão da garagem é automática");
        quartoPais = new Room("no quarto do papai e da mamãe", "a cama deles é enorme, a porta da sacada está aberta");
        escadas = new Room("nas escadas de casa", "mamãe diz que aqui é perigoso");
        jardim = new Room("no jardim de casa", "as flores da mamãe estão crescendo muito bem");
        sacada = new Room("na sacada", "aqui é muito alto! Se o papai me ver aqui ele me mata!");
        c1 = new Room("no corredor de cima", "este corredor leva até o meu quarto e do meu irmão, o banheiro, o quarto dos meus pais e as escadas");
        c2 = new Room("no corredor de baixo", "este corredor leva até as escadas, a cozinha, a sala e a garagem");

        rua = new Room("consegui sair de casa", "há várias outras casas no nosso condomínio, não há muitos carros na rua");
        
        // initialise room exits
        minhaCasa.setExit("porta", rua);
        
        quarto.setExit("corredor", c1);
        banheiro.setExit("corredor", c1);
        quartoPais.setExit("corredor", c1);
        quartoPais.setExit("sacada", sacada);
        c1.setExit("quarto", quarto);
        c1.setExit("banheiro", banheiro);
        c1.setPorta("quarto dos pais", quartoPais, true);
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
        sala.setPorta("porta", rua, true);
        garagem.setExit("porta", c2);
        garagem.setPorta("portao", rua, true);
        
        
        setCurrentRoom(quarto);
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Room novaSala)
    {
        currentRoom = novaSala;
    }
}