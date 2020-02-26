package com.chinasoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasoft.entity.Goods;

/**
 * 商品Dao接口
 *
 * @author 刘炳炎
 */

public interface GoodsDao {
	
	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	List<Goods> selectAllGoods();

	/**
	 * 根据名字查询商品
	 * 
	 * @param goname
	 * @return
	 */
	List<Goods> selectGoodsByName(String goname);

	/**
	 * 增加商品
	 * 
	 * 		  goid自增
	 * @param goname
	 * @param caid
	 * @param godnumber
	 * @param price
	 * @param godescribe
	 */
	
	void insertGoods(@Param("goname") String goname,@Param("caid") int caid,@Param("gonumber") int gonumber,@Param("price") int price,@Param("godescribe") String godescribe);

	/**
	 * 删除商品
	 * 
	 * @param goid
	 */
	void deleteGoods(int goid);

	/**
	 * 修改商品
	 * 
	 * @param goods
	 */
	void updateGoods(Goods goods);

}
