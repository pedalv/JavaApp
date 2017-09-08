package no.simpleprogram;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class EhCacheConfig {
	
	private static Cache<Long, String> mycache;
	
	private EhCacheConfig(){
       //Private Constructor
    }
	 
	public synchronized static Cache<Long, String> getMyCacheInstance() {
       if (mycache == null) {
    	   CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder() 
   			    .withCache("preConfigured", CacheConfigurationBuilder
   			    		.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)))
   			    .build(); 
   			cacheManager.init(); 

   			Cache<Long, String> preConfigured =
   			    cacheManager.getCache("preConfigured", Long.class, String.class); 

   			mycache = cacheManager.createCache("myCache", 
   			    CacheConfigurationBuilder
   			    	.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)));
   			
          System.out.println("ehcache created!");
       } 
       
       return mycache;
   }
}
