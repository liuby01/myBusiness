package com.chinasoft.entity;

/**
 * 目录实体类
 * 
 * @author 刘炳炎
 */

public class Catalogue {

	private int caid; // 目录ID
	private String caname; // 目录名字
	private String cadescribe; // 目录描述
	private int gotype; // 商品种数

	public Catalogue() {
		super();
	}

	public int getCaid() {
		return caid;
	}

	public void setCaid(int caid) {
		this.caid = caid;
	}

	public String getCaname() {
		return caname;
	}

	public void setCaname(String caname) {
		this.caname = caname;
	}

	public String getCadescribe() {
		return cadescribe;
	}

	public void setCadescribe(String cadescribe) {
		this.cadescribe = cadescribe;
	}

	public int getGotype() {
		return gotype;
	}

	public void setGotype(int gotype) {
		this.gotype = gotype;
	}

	public Catalogue(int caid, String caname, String cadescribe, int gotype) {
		super();
		this.caid = caid;
		this.caname = caname;
		this.cadescribe = cadescribe;
		this.gotype = gotype;
	}

	@Override
	public String toString() {
		return "Catalogue [caid=" + caid + ", caname=" + caname + ", cadescribe=" + cadescribe + ", gotype=" + gotype
				+ "]";
	}

}
