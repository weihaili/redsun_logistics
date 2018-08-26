package org.cn.kkl.rsl.entity;

import java.io.Serializable;
import java.util.List;

public class Waybill implements Serializable {

	/**
	 * need version controller and network transmit
	 */
	private static final long serialVersionUID = 2382377804583716064L;
	
	private Long sn;           //'运单号'
	private Long userid;         //'用户ID'
	private String toaddress;      //'收货地址'
	private String addressee;      //'收货人'
	private String tele;   //'收件人电话'
	private String info;   //'运单详情'
	private String state;  //'运单状态'
	private List<WaybillDetail> waybilldetails;
	public List<WaybillDetail> getWaybilldetails() {
		return waybilldetails;
	}
	public void setWaybilldetails(List<WaybillDetail> waybilldetails) {
		this.waybilldetails = waybilldetails;
	}
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getToaddress() {
		return toaddress;
	}
	public void setToaddress(String toaddress) {
		this.toaddress = toaddress;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
