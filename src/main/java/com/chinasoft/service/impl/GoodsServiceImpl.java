package com.chinasoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.dao.GoodsDao;
import com.chinasoft.entity.Goods;
import com.chinasoft.service.GoodsService;

/**
 * 商品Service实现
 * 
 * @author 刘炳炎
 */

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;

	// 查询所有商品
	@Override
	public List<Goods> getAllGoods() {
		return goodsDao.selectAllGoods();
	}

	// 模糊查询商品
	@Override
	public List<Goods> getSomeGoods(String goname) {
		return goodsDao.selectGoodsByName(goname);
	}

	// 增加商品
	@Override
	public void addGoods(String goname,int caid,int gonumber,int price,String godescribe) {
		goodsDao.insertGoods(goname, caid, gonumber, price, godescribe);
	}

	// 删除商品
	@Override
	public void delGoods(int goid) {
		goodsDao.deleteGoods(goid);
	}

	// 修改商品
	@Override
	public void editGoods(Goods goods) {
		goodsDao.updateGoods(goods);
	}

}
