package 异常多线程07LambdaCase2;

public class Main110703 {

    public static void main(String[] args) {

        //第一种 单独创建Calculator接口实现类 重写其中的calc()方法
        CalculatorImpl calculator = new CalculatorImpl();

        invokeCalc(120,130,calculator);
        System.out.println("________________");


        //第二种 匿名内部类+匿名对象的方式
        invokeCalc(120, 130, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });

        System.out.println("________________");

        //第三种 使用Lambda表达式
        invokeCalc(120,130,(int a,int b)-> a+b
        );
    }

    private static void invokeCalc(int a, int b, Calculator calculator) {

        int result = calculator.calc(a, b);
        System.out.println("结果是：" + result);
    }
}
