package javaCore;

/**
 * @Author: long
 * @Date: 2020/8/23 19:16
 * @Title
 * @Description:
 */
public class DynamicProxy {

    public static void main(String[] args) {

    }

    public void superTest(){
        System.out.println("super");
    }


    class Test{
        public void ChildTest(){
            superTest();
        }
    }
}
