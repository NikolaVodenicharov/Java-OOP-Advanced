import models.IdentifiableCounter;

public class Main {
    public static void main(String[] args) {

//        HeatProcessor heatProcessor = new HeatProcessor();
//        HeatProcessor heatProcessor2 = new HeatProcessor();
//        System.out.println(heatProcessor.getId());
//        System.out.println(heatProcessor2.getId());
        for (int i = 0; i < 10; i++) {
            System.out.println(IdentifiableCounter.getCount());

        }

        System.out.println("hi");
    }
}
