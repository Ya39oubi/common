package tn.com.abt.smw.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import tn.com.abt.smw.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@PersistenceContext
	private EntityManager entityManager;

	public Integer executeQuery(String sql, List<Object> bindVars) {
		try {
			Query query = entityManager.createNativeQuery(sql);
			for (int i = 0; i < bindVars.size(); i++) {
				query.setParameter(i + 1, bindVars.get(i));
			}
			return query.executeUpdate();

		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Object> findByQuery(String sql) {
		try {
			return entityManager.createNativeQuery(sql).getResultList();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Object> findByQuery(String sql, List<Object> bindVars) {
		try {
			Query query = entityManager.createNativeQuery(sql);
			for (int i = 0; i < bindVars.size(); i++) {
				query.setParameter(i + 1, bindVars.get(i));
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByQuery(Class<?> entityClass, String sql, List<Object> bindVars) {
		try {
			Query query = entityManager.createNativeQuery(sql, entityClass);
			for (int i = 0; i < bindVars.size(); i++) {
				query.setParameter(i + 1, bindVars.get(i));
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public Integer findIntegerByQuery(String sql, List<Object> bindVars) {
		try {
			Query query = entityManager.createNativeQuery(sql);
			for (int i = 0; i < bindVars.size(); i++) {
				query.setParameter(i + 1, bindVars.get(i));
			}
			List<Object> list = query.getResultList();
			if (list == null || list.size() == 0) {
				return null;
			} else {
				if (list.get(0) == null) {
					return null;
				}
			}
			Object object = list.get(0);
			return Integer.parseInt(object.toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public Long findLongByQuery(String sql, List<Object> bindVars) {
		try {
			Query query = entityManager.createNativeQuery(sql);
			for (int i = 0; i < bindVars.size(); i++) {
				query.setParameter(i + 1, bindVars.get(i));
			}
			List<Object> list = query.getResultList();
			if (list == null || list.size() == 0) {
				return null;
			} else {
				if (list.get(0) == null) {
					return null;
				}
			}
			Object object = list.get(0);
			return new Long(object.toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public Double findDoubleByQuery(String sql, List<Object> bindVars) {

		try {
			Query query = entityManager.createNativeQuery(sql);
			for (int i = 0; i < bindVars.size(); i++) {
				query.setParameter(i + 1, bindVars.get(i));
			}
			List<Object> list = query.getResultList();
			if (list == null || list.size() == 0) {
				return null;
			} else {
				if (list.get(0) == null) {
					return null;
				}
			}
			Object object = list.get(0);
			return new Double(object.toString());
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public String findStringByQuery(String sql, List<Object> bindVars) {

		try {
			Query query = entityManager.createNativeQuery(sql);
			for (int i = 0; i < bindVars.size(); i++) {
				query.setParameter(i + 1, bindVars.get(i));
			}
			List<Object> list = query.getResultList();
			if (list == null || list.size() == 0 || list.get(0) == null) {
				return null;
			}

			Object object = list.get(0);
			return object.toString();
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
