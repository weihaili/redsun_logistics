package org.cn.kkl.rsl.biz.impl;

import org.cn.kkl.rsl.biz.IWaybillBiz;
import org.cn.kkl.rsl.dao.IWaybillDao;
import org.cn.kkl.rsl.entity.Waybill;

public class WaybillBiz extends BaseBiz<Waybill> implements IWaybillBiz {

	private IWaybillDao waybillDao;

	public void setWaybillDao(IWaybillDao waybillDao) {
		this.waybillDao = waybillDao;
		super.setBaseDao(this.waybillDao);
	}
	
	
	
}
