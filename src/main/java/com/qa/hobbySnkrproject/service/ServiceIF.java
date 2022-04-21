package com.qa.hobbySnkrproject.service;

import java.util.List;

public interface ServiceIF<T> {
	
	T createSneaker(T t);
	
	List<T>getAllSnkrs();
	
	T getSnkr(Integer id);
	
	T replaceSnkr(Integer id,T t);
	
	void removeSnkr(Integer id);
	
}
