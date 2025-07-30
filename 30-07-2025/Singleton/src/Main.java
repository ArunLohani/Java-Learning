
class Singleton {

    private static Singleton instance = null;
    private Singleton() {

    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    protected void demoMethod( ) {
        System.out.println("demoMethod for singleton");
    }
}
public class Main {

    public static void main(String[] args) {
        Singleton tmp = Singleton.getInstance( );
        Singleton tmp2 = Singleton.getInstance(); //returns the same instance as tmp
        tmp.demoMethod( );
        tmp2.demoMethod();
        System.out.println(tmp == tmp2);
    }
}