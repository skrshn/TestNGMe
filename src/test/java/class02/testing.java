package class02;

import org.testng.annotations.*;

public class testing {

    @BeforeSuite
    public void beforesuit(){
        System.out.println("i am before suit");
    }

    @AfterSuite
    public void aftersuit(){
        System.out.println("i am after suit");
    }
    @BeforeTest
    public void beforetest(){

        System.out.println("i am before test :)");
    }
    @AfterTest
    public void atertest(){

        System.out.println("i am after test :)");
    }
    @BeforeClass
    public void beforeclass(){
    System.out.println("I am before class method");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("I am after class method");
    }

    @BeforeMethod
    public void before(){
        System.out.println("this is my before method");
    }
    @AfterMethod
    public void after(){
        System.out.println("this is my after method");
    }
   @Test
    public void Test(){
    System.out.println("drive me crazy , drive me mad");
        }
    @Test
    public void Test2(){
        System.out.println("drive me to sanity , drive me to hell");
    }
}


