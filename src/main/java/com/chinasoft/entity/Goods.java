package com.chinasoft.entity;

/**
 * 商品实体类
 * 
 * @author 刘炳炎
 */

public class Goods {

	private int goid; // 商品ID
	private String goname; // 商品名字
	private int gonumber; // 商品数量
	private String godescribe; // 商品描述
	private String picture; // 商品图片
	private int caid; // 目录ID
	private String caname;
	private int price; // 商品价格

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGoid() {
		return goid;
	}

	public void setGoid(int goid) {
		this.goid = goid;
	}

	public String getGoname() {
		return goname;
	}

	public void setGoname(String goname) {
		this.goname = goname;
	}

	public int getGonumber() {
		return gonumber;
	}

	public void setGonumber(int gonumber) {
		this.gonumber = gonumber;
	}

	public String getGodescribe() {
		return godescribe;
	}

	public void setGodescribe(String godescribe) {
		this.godescribe = godescribe;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Goods(int goid, String goname, int gonumber, String godescribe, String picture, int caid, String caname,
			int price) {
		super();
		this.goid = goid;
		this.goname = goname;
		this.gonumber = gonumber;
		this.godescribe = godescribe;
		this.picture = picture;
		this.caid = caid;
		this.caname = caname;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Goods [goid=" + goid + ", goname=" + goname + ", gonumber=" + gonumber + ", godescribe=" + godescribe
				+ ", picture=" + picture + ", caid=" + caid + ", caname=" + caname + ", price=" + price + "]";
	}

}
