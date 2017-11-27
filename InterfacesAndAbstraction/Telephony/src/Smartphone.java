public class Smartphone implements Callable, Browsable{

    @Override
    public void call(String number) {
        if (number.matches("\\d+")){
            System.out.println(String.format("Calling... %s", number));
        }
        else{
            System.out.println("Invalid number!");
        }
    }

    @Override
    public void browse(String site) {
        if (site.matches("[^0-9]+")){
            System.out.println(String.format("Browsing: %s!", site));
        }
        else{
            System.out.println("Invalid URL!");
        }
    }
}
