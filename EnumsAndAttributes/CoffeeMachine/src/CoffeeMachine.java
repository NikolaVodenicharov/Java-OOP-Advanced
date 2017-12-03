import java.util.List;

public class CoffeeMachine {
    private int insertedMoney;
    private List<Coffee> coffeeSold;

    public CoffeeMachine(int insertedMoney, List<Coffee> coffeeSold) {
        this.insertedMoney = insertedMoney;
        this.coffeeSold = coffeeSold;
    }

    public void buyCoffee(String size, String type){
        Dosage dosage = Enum.valueOf(Dosage.class, size.toUpperCase());
        if (this.insertedMoney >= dosage.getPrice()){
            this.insertedMoney = 0;

            CoffeeType coffeeType = Enum.valueOf(CoffeeType.class, type.toUpperCase());
            Coffee coffee = new Coffee(coffeeType, dosage);

            this.coffeeSold.add(coffee);
        }
    }
    public void insertCoin(String inputCoin){
        Coin coin = Enum.valueOf(Coin.class, inputCoin.toUpperCase());
        this.insertedMoney += coin.getValue();
    }
    public Iterable<Coffee> getCoffeesSold(){
        return this.coffeeSold;
    }

}
