package com.test;

import org.nutz.ioc.loader.annotation.IocBean;

import com.jarvis.cache.annotation.Cache;

@IocBean
public class AutoLoadCacheService {

	@Cache(autoload = true, expire = 120, key = "'test_'+#hash(#args[0])")
	public AutoLoadCache getData(AutoLoadCache data) {
		System.out.println("aa >" + data.getName());
		return data;
	}
}
