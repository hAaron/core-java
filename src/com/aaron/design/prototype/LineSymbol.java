package com.aaron.design.prototype;
/*
 *  A concrete prototype to draw a line
 */
public class LineSymbol extends Graphic {
    public LineSymbol() {
    }
    @Override
    public void DoSomething() {
        System.out.println("I am used to draw a line !");
    }
}