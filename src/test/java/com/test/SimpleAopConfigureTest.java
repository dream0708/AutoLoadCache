package com.test;

import org.nutz.dao.Dao;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.json.Json;

public class SimpleAopConfigureTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Ioc ioc = new NutIoc(new ComboIocLoader("*json", "/ioc", "*anno", "com.test", "*com.jarvis.cache.aop.nutz.AutoLoadCacheIocLoader"));
		Dao dao = ioc.get(Dao.class);
		dao.create(AutoLoadCache.class, false);
		AutoLoadCacheService autoLoadCacheService = ioc.get(AutoLoadCacheService.class);
		AutoLoadCache data = new AutoLoadCache();
		data.setId(1);
		data.setAge(20);
		data.setName("test1");
		AutoLoadCache res1 = autoLoadCacheService.getData(data);
		data.setAge(30);
		System.out.println(Json.toJson(res1));
		data.setName("test2");
		AutoLoadCache res2 = autoLoadCacheService.getData(data);
		System.out.println(Json.toJson(res2));
		ioc.depose();
	}
}
