package com.company;

public class PlayRoom {
    public static void main(String[] args) {
        Game.GameDisk[] gameDisks = {Game.getDisk("Doom Eternal", Ganre.ACTION, "brains and blood"),
                Game.getDisk("Forza Horizon", Ganre.RACE, "Many Cars"),
                Game.getDisk("Fifa 2022", Ganre.SPORT, "Football in your heart"),
                Game.getDisk("Battlefield 2042", Ganre.ACTION, "Shooter and explosions")};


        Game.VirtualGame[] virtualGames = {Game.getVirtualDisk("Halfly alex", Ganre.ACTION),
                Game.getVirtualDisk("Carrier Command 2", Ganre.ACTION),
                Game.getVirtualDisk("Beat Saber", Ganre.SPORT),
                Game.getVirtualDisk("Skyrim", Ganre.ACTION)};

    }

    GameConsole ployka = new GameConsole("Sony", "XWG789VtIEP");
    

}
