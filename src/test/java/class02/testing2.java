package class02;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testing2 {
    @BeforeSuite
    public  void beforesuit(){
        System.out.println("i am another before suit method");
    }
    @BeforeTest
    public  void beforetest2(){
        System.out.println("i am before test in another class");
    }
    @Test
    public void Testb(){
        System.out.println("drive me 888888 , drive me888888");
    }
    @Test
    public void Testa(){
        System.out.println("drive me to 999999 , drive me to 999999");
    }
}
