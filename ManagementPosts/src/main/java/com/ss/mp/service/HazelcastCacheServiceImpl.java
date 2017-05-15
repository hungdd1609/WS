/*package com.ss.mp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.hazelcast.core.HazelcastInstance;
import com.ss.mp.common.constant.Constants;
import com.ss.mp.entity.Account;

public class HazelcastCacheServiceImpl implements CacheService{
	
	@Autowired
    HazelcastInstance hazelcastInstance;
    
    @Autowired
    AccountService userService;
	
	@Override
    public void resetTimeToLive(Integer userId) {
        Map<Integer, Account> users = hazelcastInstance.getMap(Constants.CACHE_TRANSPORTER_ONLINE);
        
        Account user = users.get(userId);
        if (null == user) {
        	user = userService.findOneEager(userId);
        }
        
        users.put(user.getId(), user);
    }

    @Override
    public void put(String name, Object key, Object value, int timeTolive, int timeToIde) {
        Map<Object, Object> cache = hazelcastInstance.getMap(name);
        cache.put(key, value);
    }

    @Override
    public void put(String name, Object key, Object value, boolean eternal) {
        Map<Object, Object> cache = hazelcastInstance.getMap(name);
        cache.put(key, value);
    }

    @Override
    public void remove(String name, Object key) {
        Map<Object, Object> cache = hazelcastInstance.getMap(name);
        cache.remove(key);
    }

}
*/