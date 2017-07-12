package no.integrators;

import org.hibernate.boot.Metadata;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import no.listeners.LoadEventListener;

public class DefaultIntegrator implements Integrator {

	@Override
	public void disintegrate(SessionFactoryImplementor arg0, 
			SessionFactoryServiceRegistry arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void integrate(Metadata arg0, 
			SessionFactoryImplementor arg1, 
			SessionFactoryServiceRegistry arg2) {

		EventListenerRegistry r = arg2.getService(EventListenerRegistry.class);
		r.prependListeners(EventType.LOAD, new LoadEventListener());	
	}
	
	/*
	NOTE: 
		List of all event available in -> EventType.POST_COMMIT_INSERT ...
	*/
}
