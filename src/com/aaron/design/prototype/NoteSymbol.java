package com.aaron.design.prototype;

/**
 * 
 * @author Aaron
 * @date 2017年6月6日
 * @version 1.0
 * @package_name com.aaron.design.prototype
 */
public class NoteSymbol extends Graphic {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoteSymbol() {
    }
	@Override
    public void DoSomething() {
        System.out.println("I am used to draw a note !");
    }
}