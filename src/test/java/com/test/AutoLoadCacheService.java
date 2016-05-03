package com.test;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.service.IdEntityService;

import com.jarvis.cache.annotation.Cache;

@IocBean(args = { "dao" })
public class AutoLoadCacheService extends IdEntityService<AutoLoadCache> {

	public AutoLoadCacheService() {
	}

	public AutoLoadCacheService(Dao dao) {
		super(dao);
	}

	public void add(AutoLoadCache data) {
		dao().insert(data);
	}

	@Cache(autoload = true, expire = 120, key = "'test_'+#hash(#args[0])")
	public AutoLoadCache getData(AutoLoadCache data) {
		System.out.println("aa >"+data.getName());
		return dao().fetch(getEntityClass(), data.getId());
	}
}
