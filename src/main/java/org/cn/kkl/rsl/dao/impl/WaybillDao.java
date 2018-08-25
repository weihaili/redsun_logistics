package org.cn.kkl.rsl.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.cn.kkl.rsl.dao.IWaybillDao;
import org.cn.kkl.rsl.entity.Waybill;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class WaybillDao extends BaseDao<Waybill> implements IWaybillDao {

	@Override
	public DetachedCriteria getDetachedCriteria(Waybill waybill1, Waybill waybill2, Object param) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Waybill.class);
		if (waybill1!=null) {
			if (null!=waybill1.getSn()) {
				criteria.add(Restrictions.eq("sn", waybill1.getSn()));
			}
			if (null!=waybill1.getUserid()) {
				criteria.add(Restrictions.eq("userid", waybill1.getUserid()));
			}
			if (StringUtils.isNotBlank(waybill1.getToaddress())) {
				criteria.add(Restrictions.like("toaddress", waybill1.getToaddress(), MatchMode.ANYWHERE));
			}
			if (StringUtils.isNotBlank(waybill1.getAddressee())) {
				criteria.add(Restrictions.like("addressee", waybill1.getAddressee(), MatchMode.ANYWHERE));
			}
			if (StringUtils.isNotBlank(waybill1.getTele())) {
				criteria.add(Restrictions.like("tele", waybill1.getTele(), MatchMode.ANYWHERE));
			}
			if (StringUtils.isNotBlank(waybill1.getInfo())) {
				criteria.add(Restrictions.like("info", waybill1.getInfo(), MatchMode.ANYWHERE));
			}
			if (StringUtils.isNotBlank(waybill1.getState())) {
				criteria.add(Restrictions.eq("state", waybill1.getState()));
			}
		}
		if (waybill2!=null) {
			
		}
		return criteria;
	}

	
}
