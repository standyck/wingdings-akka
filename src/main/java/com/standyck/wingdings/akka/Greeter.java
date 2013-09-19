/*
 * Created by sdyck
 * NEEDS JAVADOCS
 * 
 */
package com.standyck.wingdings.akka;

import akka.actor.UntypedActor;

/**
 *
 * @author sdyck
 */
public class Greeter extends UntypedActor {

	public static enum Msg {
		GREET, DONE;
	}
	
	@Override
	public void onReceive(Object msg) {
		if(msg == Msg.GREET) {
			System.out.println("Hello world");
			getSender().tell(Msg.DONE, getSelf());
		} else unhandled(msg);
	}
	
}
