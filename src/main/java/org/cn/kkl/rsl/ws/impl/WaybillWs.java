package org.cn.kkl.rsl.ws.impl;

import java.util.List;

import org.cn.kkl.rsl.biz.IWaybillBiz;
import org.cn.kkl.rsl.biz.IWaybillDetailBiz;
import org.cn.kkl.rsl.entity.Waybill;
import org.cn.kkl.rsl.entity.WaybillDetail;
import org.cn.kkl.rsl.ws.IWaybillWs;

public class WaybillWs implements IWaybillWs {
	
	private IWaybillBiz waybillBiz;
	private IWaybillDetailBiz waybillDetailBiz;

	public void setWaybillBiz(IWaybillBiz waybillBiz) {
		this.waybillBiz = waybillBiz;
	}

	public void setWaybillDetailBiz(IWaybillDetailBiz waybillDetailBiz) {
		this.waybillDetailBiz = waybillDetailBiz;
	}

	/**
	 * add weybill
	 * @param userId
	 * @param toAddress
	 * @param addressee
	 * @param telephone
	 * @param info
	 * @return
	 */
	@Override
	public Long addWaybill(Long userId, String toAddress, String addressee, String telephone, String info) {
		Long result =null;
		try {
			Waybill waybill = new Waybill();
			waybill.setAddressee(addressee);
			waybill.setInfo(info);
			waybill.setState("0");
			waybill.setTele(telephone);
			waybill.setToaddress(toAddress);
			waybill.setUserid(userId);
			waybillBiz.add(waybill);
			result = waybill.getSn();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * query waybill detail list by waybill number
	 * @param sn
	 * @return
	 */
	@Override
	public List<WaybillDetail> waybillDetailList(Long sn) {
		WaybillDetail waybillDetail = new WaybillDetail();
		waybillDetail.getWaybill().setSn(sn);
		
		return waybillDetailBiz.getList(waybillDetail, null, null);
	}

}
