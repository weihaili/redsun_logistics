package org.cn.kkl.rsl.ws;

import java.util.List;

import javax.jws.WebService;

import org.cn.kkl.rsl.entity.WaybillDetail;

@WebService
public interface IWaybillWs {
	
	
	/**
	 * query waybill detail list by waybill number
	 * @param sn
	 * @return
	 */
	List<WaybillDetail> waybillDetailList(Long sn);
	
	/**
	 * add weybill
	 * @param userId
	 * @param toAddress
	 * @param addressee
	 * @param telephone
	 * @param info
	 * @return
	 */
	Long addWaybill(Long userId,String toAddress,String addressee,String telephone,String info);
}
