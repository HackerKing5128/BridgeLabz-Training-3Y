import java.util.*;

// Interface for downloadable games
interface IDownloadable {
    void download();
    void playDemo();
}

// Base Game class
abstract class Game implements IDownloadable {
    protected String title;
    protected String genre;
    protected double price;
    protected double rating; // 0 - 5

    public Game(String title, String genre, double price, double rating) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
    }

    public void applyDiscount(double percent) {
        price = price - (price * percent / 100);
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " (" + genre + ") - Rs." + String.format("%.2f", price) + " | Rating: " + rating;
    }
}

// ArcadeGame subclass
class ArcadeGame extends Game {
    public ArcadeGame(String title, double price, double rating) {
        super(title, "Arcade", price, rating);
    }

    @Override
    public void download() {
        System.out.println("Downloading arcade game: " + title);
    }

    @Override
    public void playDemo() {
        System.out.println("Playing short demo of arcade game: " + title);
    }
}

// StrategyGame subclass
class StrategyGame extends Game {
    public StrategyGame(String title, double price, double rating) {
        super(title, "Strategy", price, rating);
    }

    @Override
    public void download() {
        System.out.println("Downloading strategy game: " + title);
    }

    @Override
    public void playDemo() {
        System.out.println("Playing strategy demo with AI opponent: " + title);
    }
}

// User class
class User {
    private String name;
    private List<Game> ownedGames;

    public User(String name) {
        this.name = name;
        this.ownedGames = new ArrayList<>();
    }

    public void purchaseGame(Game game) {
        ownedGames.add(game);
        System.out.println(name + " purchased: " + game.getTitle());
    }

    public void showOwnedGames() {
        System.out.println(name + "'s Games:");
        for (Game g : ownedGames) {
            System.out.println("- " + g);
        }
    }
}

// Demo
public class GameBox {
    public static void main(String[] args) {
        Game pacman = new ArcadeGame("Pac-Man", 500.0, 4.5);
        Game chessMaster = new StrategyGame("Chess Master", 170.0, 4.8);

        // Apply discount
        pacman.applyDiscount(20); // 20% off
        chessMaster.applyDiscount(10); // 10% off

        pacman.download();
        pacman.playDemo();
        System.out.println();

        chessMaster.download();
        chessMaster.playDemo();
        System.out.println();

        // User purchases games
        User user1 = new User("Charlie");
        user1.purchaseGame(pacman);
        user1.purchaseGame(chessMaster);
        System.out.println();

        user1.showOwnedGames();
    }
}
