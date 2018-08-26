package org.cn.kkl.rsl.action;

import org.cn.kkl.rsl.biz.IWaybillDetailBiz;
import org.cn.kkl.rsl.entity.WaybillDetail;

public class WaybillDetailAction extends BaseAction<WaybillDetail> {

	private IWaybillDetailBiz waybillDetailBiz;

	public void setWaybillDetailBiz(IWaybillDetailBiz waybillDetailBiz) {
		this.waybillDetailBiz = waybillDetailBiz;
		super.setBaseBiz(this.waybillDetailBiz);
	}
	
}
