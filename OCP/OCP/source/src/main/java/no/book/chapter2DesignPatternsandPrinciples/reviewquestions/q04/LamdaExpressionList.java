package no.book.chapter2DesignPatternsandPrinciples.reviewquestions.q04;

import jdk.management.resource.ResourceId;

import java.util.function.Consumer;

public class LamdaExpressionList {

    public static void main(String ... args) {

        a();
        b();
        c();
        d();
        e();
        f();
        g();
    }

    private static void g() {
        //(Animal z, m) -> a
    }


    private static void f() {
        //() ->
        Runnable runnable = () -> {
        };
    }

    private static void e() {
        //Wolf w -> 39
    }

    private static void d() {
        Consumer<Camel> camelConsumer =
                (Camel c) -> { return; };
    }

    private static void c() {
        //(Coyote y) -> return 0;
    }

    private static void b() {
        //x,y -> x+y

    }


    private static void a() {
        ResourceId resourceId =
                () -> "";
    }

}

/*
Which of the following are valid lambda expressions? (Choose all that apply.)

A. () -> ""
    B. x,y -> x+y
    C. (Coyote y) -> return 0;
D. (Camel c) -> {return;}
    E. Wolf w -> 39
    F. () ->
    G. (Animal z, m) -> a

ANSWER

 */