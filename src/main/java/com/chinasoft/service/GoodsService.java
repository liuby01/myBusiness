package com.chinasoft.service;

import java.util.List;

import com.chinasoft.entity.Goods;

/**
 * 商品Service接口
 * 
 * @author 刘炳炎
 */

public interface GoodsService {
	
	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	List<Goods> getAllGoods();

	/**
	 * 模糊查询商品
	 * 
	 * @param goname
	 * @return
	 */
	List<Goods> getSomeGoods(String goname);

	/**
	 * 增加商品
	 * 
	 * 		  goid自增
	 * @param goname
	 * @param caid
	 * @param gonumber
	 * @param price
	 * @param godescribe
	 */

	void addGoods(String goname,int caid,int gonumber,int price,String godescribe);

	/**
	 * 删除商品
	 * 
	 * @param goid
	 */
	void delGoods(int goid);

	/**
	 * 修改目录
	 * 
	 * @param goods
	 */
	void editGoods(Goods goods);

}
