package com.company;

public class Game {
    final String name;
    final Ganre ganre;
    final String type;

    private Game(String name, Ganre ganre, String type) {
        this.name = name;
        this.ganre = ganre;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Ganre getGanre() {
        return ganre;
    }

    public String getType() {
        return type;
    }

    public static class GameDisk{
        final String description;
        final Game data;

        private GameDisk(String name, Ganre ganre, String description){
            data = new Game(name, ganre, "Physical");
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public Game getData() {
            return data;
        }
    }

    public static class VirtualGame{
        int rating;
        final Game data;

        private VirtualGame(String name, Ganre ganre){
            data = new Game(name, ganre, "Physical");
        }

        public Game getData() {
            return data;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }

    public static GameDisk getDisk(String name, Ganre ganre, String description){
        return new GameDisk(name, ganre, description);
    }

    public static VirtualGame getVirtualDisk(String name, Ganre ganre){
        return new VirtualGame(name, ganre);
    }
}
