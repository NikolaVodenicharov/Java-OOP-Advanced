import sun.reflect.Reflection;

public class Main {
    public static void main(String[] args) {
        Class aClass = Reflection.class;
        System.out.println(aClass);
        System.out.println(aClass.getSuperclass());
        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }
}
