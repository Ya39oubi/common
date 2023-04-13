package tn.com.abt.smw.service;

import java.util.List;

public interface CommonService {

	public Integer executeQuery(String sql, List<Object> bindVars);

	public List<Object> findByQuery(String sql);

	public List<Object> findByQuery(String sql, List<Object> bindVars);

	@SuppressWarnings("rawtypes")
	public List findByQuery(Class<?> entityClass, String sql, List<Object> bindVars);

	public Integer findIntegerByQuery(String sql, List<Object> bindVars);

	public Long findLongByQuery(String sql, List<Object> bindVars);

	public Double findDoubleByQuery(String sql, List<Object> bindVars);

	public String findStringByQuery(String sql, List<Object> bindVars);

}
