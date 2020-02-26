package com.chinasoft.service;

import java.util.List;

import com.chinasoft.entity.Catalogue;

/**
 * 目录Service接口
 * 
 * @author 刘炳炎
 */

public interface CatalogueService {

	/**
	 * 查询所有目录
	 * 
	 * @return
	 */
	List<Catalogue> getAllCatalogue();

	/**
	 * 模糊查询目录
	 * 
	 * @param caname
	 * @return
	 */
	List<Catalogue> getSomeCatalogue(String caname);

	/**
	 * 增加目录
	 * 
	 * 		  caid自增
	 * @param caname     
	 * @param cadescribe 
	 */

	void addCatalogue(String caname, String cadescribe);

	/**
	 * 删除目录
	 * 
	 * @param caid
	 */
	void delCatalogue(int caid);

	/**
	 * 修改目录
	 * 
	 * @param catalogue
	 */
	void editCatalogue(Catalogue catalogue);

}
