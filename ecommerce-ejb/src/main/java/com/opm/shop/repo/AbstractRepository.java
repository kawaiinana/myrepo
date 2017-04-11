package com.opm.shop.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public abstract class AbstractRepository<T> {

	@PersistenceContext
	private EntityManager em;
	private Class<T> type;

	public static final String SELECT = "select t from %s t ";
	
	public AbstractRepository(Class<T> type) {
		super();
		this.type = type;
	}

	public void persit(T t) {
		em.persist(t);
	}

	public void update(T t) {
		em.merge(t);
	}

	public T findById(Object id) {
		return em.find(type, id);
	}

	public List<T> find(String where, Map<String, Object> params) {

		StringBuffer sb = new StringBuffer(String.format(SELECT, type.getSimpleName()));

		if (where != null && params != null) {
			sb.append("where ").append(where);
		}

		TypedQuery<T> q = em.createQuery(sb.toString(), type);

		if (null != params) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}

		return q.getResultList();
	}

	public List<T> find(String where, Map<String, Object> params, int start, int limit) {

		StringBuffer sb = new StringBuffer(String.format(SELECT, type.getSimpleName()));

		if (where != null && params != null) {
			sb.append("where ").append(where);
		}

		TypedQuery<T> q = em.createQuery(sb.toString(), type);

		if (null != params) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}

		if (start > 0) {
			q.setFirstResult(start);
		}

		if (limit > 0) {
			q.setMaxResults(limit);
		}
		return q.getResultList();
	}

	public long findCount(String where, Map<String, Object> params) {

		StringBuffer sb = new StringBuffer("select COUNT(t) from %s t");

		if (where != null && params != null) {
			sb.append("where ").append(where);
		}

		TypedQuery<T> q = em.createQuery(sb.toString(), type);

		if (null != params) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return 0;
	}

	public List<T> findBy(T role, String keyword) {
		StringBuffer sb = new StringBuffer(String.format(SELECT, type.getSimpleName()));
		Map<String, Object> params = new HashMap<>();

		if (null != role) {
			sb.append("and t.role = :role ");
			params.put("role", role);
		}

		if (null != keyword && !keyword.isEmpty()) {
			sb.append("and t.keyword like :keyword");
			params.put("keyword", keyword.concat("%"));
		}

		TypedQuery<T> query = em.createQuery(sb.toString(), type);
		for (String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}

		return query.getResultList();
	}
	
	public List<T> findAllUndeleted() {
		StringBuffer sb = new StringBuffer(String.format(SELECT, type.getSimpleName()));

		sb.append("where t.deleteFlag = false ");

		TypedQuery<T> query = em.createQuery(sb.toString(), type);


		return query.getResultList();
	}
	
}