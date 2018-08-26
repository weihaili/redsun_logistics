package org.cn.kkl.rsl.biz.impl;

import org.cn.kkl.rsl.biz.IWaybillDetailBiz;
import org.cn.kkl.rsl.dao.IWaybillDetailDao;
import org.cn.kkl.rsl.entity.WaybillDetail;

public class WaybillDetailBiz extends BaseBiz<WaybillDetail> implements IWaybillDetailBiz {

	private IWaybillDetailDao waybillDetailDao;

	public void setWaybillDetailDao(IWaybillDetailDao waybillDetailDao) {
		this.waybillDetailDao = waybillDetailDao;
		super.setBaseDao(this.waybillDetailDao);
	}
}
