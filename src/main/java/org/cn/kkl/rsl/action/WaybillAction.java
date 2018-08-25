package org.cn.kkl.rsl.action;

import org.cn.kkl.rsl.biz.IWaybillBiz;
import org.cn.kkl.rsl.entity.Waybill;

public class WaybillAction extends BaseAction<Waybill> {

	private IWaybillBiz waybillBiz;

	public void setWaybillBiz(IWaybillBiz waybillBiz) {
		this.waybillBiz = waybillBiz;
		super.setBaseBiz(this.waybillBiz);
	}
	
	
}
