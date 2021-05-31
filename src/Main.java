import UI.LoginStart;
import UI.Register;
import mysqld.Mysqld;

public class Main {
    public static Register register;
    public static void main(String[] args) {
        Mysqld mysqld = new Mysqld("root","taosiyu20010620");
        // LoginStart loginStart = new LoginStart();
        register = new Register();
        // System.out.println("Hello world!");
    }
}
