package org.cn.kkl.rsl.entity;

import java.io.Serializable;

public class WaybillDetail implements Serializable {

	/**
	 * need network transmit and version control
	 */
	private static final long serialVersionUID = -3002275776260997096L;
	
	private Long   id;        // 'ID'
	private Waybill   waybill;        // 运单'
	private String exedate; // '执行日期'
	private String exetime; // '执行时间'
	private String info;    //  '执行信息'
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Waybill getWaybill() {
		return waybill;
	}
	public void setWaybill(Waybill waybill) {
		this.waybill = waybill;
	}
	public String getExedate() {
		return exedate;
	}
	public void setExedate(String exedate) {
		this.exedate = exedate;
	}
	public String getExetime() {
		return exetime;
	}
	public void setExetime(String exetime) {
		this.exetime = exetime;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
