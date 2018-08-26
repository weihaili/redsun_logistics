package org.cn.kkl.rsl.dao.impl;

import org.cn.kkl.rsl.dao.IWaybillDetailDao;
import org.cn.kkl.rsl.entity.WaybillDetail;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class WaybillDetailDao extends BaseDao<WaybillDetail> implements IWaybillDetailDao {

	@Override
	public DetachedCriteria getDetachedCriteria(WaybillDetail wd1, WaybillDetail wd2, Object param) {
		DetachedCriteria criteria = DetachedCriteria.forClass(WaybillDetail.class);
		if (wd1!=null) {
			if (null!=wd1.getId()) {
				criteria.add(Restrictions.eq("id", wd1.getId()));
			}
		}
		return criteria;
	}
	
	
}
