package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.*;
import sk.tuke.kpi.oop.game.scenarios.Junkyard;

public class Main {
    public static void main(String[] args){
        // nastavenie okna hry: nazov okna a jeho rozmery
        WindowSetup windowSetup = new WindowSetup("Project Ellen", 800, 600);

        // vytvorenie instancie hernej aplikacie
        // pouzijeme implementaciu rozhrania `Game` triedou `GameApplication`
        Game game = new GameApplication(windowSetup);

        // vytvorenie sceny pre hru
        // pouzijeme implementaciu rozhrania `Scene` triedou `World`
//        Scene scene = new World("mission-impossible", "maps/mission-impossible.tmx", new MissionImpossible.Factory());
//        Scene scene = new World("escape-room", "maps/escape-room.tmx", new EscapeRoom.Factory());
        Scene scene = new World("junkyard", "maps/junkyard.tmx", new Junkyard.Factory());
        // pridanie sceny do hry
        game.addScene(scene);


//        MissionImpossible missionImpossible = new MissionImpossible();
//        scene.addListener(missionImpossible);
//
        Junkyard junkyard = new Junkyard();
        scene.addListener(junkyard);

//        Player player = new Player();
//        scene.addActor(player, 0, 0);
        // spustenie hry
        game.start();

        game.getInput().onKeyPressed(Input.Key.ESCAPE, game::stop);
    }
}
