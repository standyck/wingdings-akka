/*
 * Created by sdyck
 * NEEDS JAVADOCS
 * 
 */
package com.standyck.wingdings.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 *
 * @author sdyck
 */
public class HelloWorld extends UntypedActor {

	@Override
	public void preStart() {
		final ActorRef greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
		greeter.tell(Greeter.Msg.GREET, getSelf());
	}
	
	@Override
	public void onReceive(Object msg) throws Exception {
		if(msg == Greeter.Msg.DONE) {
			getContext().stop(getSelf());
		} else unhandled(msg);
	}
	
}
