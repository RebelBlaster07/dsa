package asign1;

import java.rmi.*;

public class client {
    public static void main(String args[]) {
        try {
            myRemote obj;

            obj = (myRemote) Naming.lookup("rmi://localhost/Test");

            String str = obj.message();

            System.out.println(str);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
