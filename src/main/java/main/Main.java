package main;

import selenium.BaseWebTest;
import selenium.WebEmailTest;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String... args) {
//        BaseWebTest baseWebTest = new BaseWebTest();
//        baseWebTest.loadGooglePage();
        WebEmailTest webEmailTest = new WebEmailTest();
        webEmailTest.loadEmail();
    }

    public static void someMethod() throws FileNotFoundException {
        someMethod("some_string");
    }

    public static void someMethod(String input) {
        someMethod(input, 0);
    }

    public static void someMethod(String input, int amount) {
        someMethod(input, amount, false);
    }

    public static void someMethod(String input, int amount, boolean isTrue) {

    }

    public static class A {
        public void smth() {
            System.out.println("this is A");
        }
    }

    public static class B extends A {

    }

    public static class C extends B {
        @Override
        public void smth() {
            System.out.println("this is C");
        }
    }

    public static class D extends C {

    }
}