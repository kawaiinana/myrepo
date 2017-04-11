package com.opm.shop.service.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.opm.shop.entity.CommissionRate;
import com.opm.shop.entity.CommissionRate.RateType;
import com.opm.shop.repo.CommissionRateRepo;
import com.opm.shop.service.CommissionRateLocal;

@Stateless
public class CommissionService implements CommissionRateLocal {

	@Inject
	private CommissionRateRepo repo;

	@Inject
	private EntityManager em;

	@Override
	public void save(CommissionRate comRate) {
		if (comRate.getId() == 0) {
			repo.persit(comRate);
		} else {
			repo.update(comRate);
		}

	}

	@Override
	public CommissionRate findById(int id) {
		return repo.findById(id);
	}
  
	@Override
	public List<CommissionRate> findAll() {
		return repo.findAllUndeleted();
	}

	@Override
	public void delete(CommissionRate c) {
		repo.update(c);
	}

	@Override
	public List<CommissionRate> find(RateType type, Date refDate) {
		StringBuffer sb = new StringBuffer("select c from CommissionRate c where 1 = 1 and c.deleteFlag = false ");
		Map<String, Object> params = new HashMap<>();
		
		if(null != type) {
			sb.append("and c.type = :type ");
			params.put("type", type);
		}
		
		if(null != refDate) {
			sb.append("and c.refDate = :refDate");
			params.put("refDate", refDate);
		}
		
		TypedQuery<CommissionRate> query = em.createQuery(sb.toString(), CommissionRate.class);
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
	
		return query.getResultList();
	}

}
