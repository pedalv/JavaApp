package no.listeners;

import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.event.internal.DefaultLoadEventListener;
import org.hibernate.event.spi.EventSource;
import org.hibernate.event.spi.LoadEvent;

public class LoadEventListener extends DefaultLoadEventListener {

	@Override
	protected Object loadFromSessionCache(LoadEvent arg0, EntityKey arg1, LoadType arg2) throws HibernateException {
		// TODO Auto-generated method stub
		return super.loadFromSessionCache(arg0, arg1, arg2);
	}

	@Override
	public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {
		
		System.out.println("Entity loaded:");
		System.out.println(event.getEntityId());
		
	}

	@Override
	protected void upgradeLock(Object arg0, EntityEntry arg1, LockOptions arg2, EventSource arg3) {
		// TODO Auto-generated method stub
		super.upgradeLock(arg0, arg1, arg2, arg3);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
}
