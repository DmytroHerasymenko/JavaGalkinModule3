import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by dima on 14.02.17.
 */
interface MyInterface{
    void g();
}

class A{
    private MyInterface m;
    public void f(){
        m.g();
    }
}
class B implements MyInterface{
    public void g(){
        System.out.println("B");
    }
}
class C implements MyInterface{
    public void g(){
        System.out.println("C");
    }
}
class Factory{
    static Object getInstanceA(String fileName) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        File f = new File(fileName);
        BufferedReader bf = new BufferedReader(new FileReader(f));
        String s = bf.readLine();
        String[] params = s.split(":");
        Class c1 = Class.forName(params[0]);
        Object o1 = c1.newInstance();
        Class c2 = Class.forName(params[2]);
        MyInterface m = (MyInterface)c2.newInstance();
        Field field = c1.getDeclaredField(params[1]);
        field.setAccessible(true);
        field.set(o1,m);
        return o1;
    }
}

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, IOException {
        A pa = (A) Factory.getInstanceA("config.txt");
        pa.f();


    }
}
