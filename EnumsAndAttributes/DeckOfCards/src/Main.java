import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        Deck deck = new Deck();

        Player player1 = new Player(reader.readLine(), new ArrayList<>());
        Player player2 = new Player(reader.readLine(), new ArrayList<>());

        giveCards(reader, deck, player1, 5);
        giveCards(reader, deck, player2, 5);

        if (player1.findStrongesCard().compareTo(player2.findStrongesCard()) >= 0){
            printWinner(player1);
        }
        else{
            printWinner(player2);
        }
    }

    private static void giveCards(BufferedReader reader, Deck deck, Player player, int cardsNumber) throws IOException{
        while(player.handCardsCount() < cardsNumber){
            try {
                String cardName = reader.readLine();
                Card card = deck.takeCard(cardName);
                player.addCard(card);
            }
            catch(IllegalArgumentException | IllegalStateException e){
                System.out.println(e.getMessage());
            }
        }
    }
    private static void printWinner(Player player){
        System.out.println(
                String.format(
                        "%s wins with %s.",
                        player.getName(),
                        player.findStrongesCard().getName()));
    }
}
