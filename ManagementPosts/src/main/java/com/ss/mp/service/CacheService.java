package com.ss.mp.service;

public interface CacheService {
	
	void put(String name, Object key, Object value, int timeTolive, int timeToIde);
    
    void put(String name, Object key, Object value, boolean eternal);
	
    void remove(String name, Object key);
    
    void resetTimeToLive(Integer userId);

}
