package com.chinasoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasoft.entity.Catalogue;

/**
 * 目录Dao接口
 *
 * @author 刘炳炎
 */

public interface CatalogueDao {

	/**
	 * 查询所有目录
	 * 
	 * @return
	 */
	List<Catalogue> selectAllCatalogue();

	/**
	 * 根据名字查询目录
	 * 
	 * @param caname
	 * @return
	 */
	List<Catalogue> selectCatalogueByName(String caname);

	/**
	 * 增加目录
	 * 
	 *        caid自增
	 * @param caname     
	 * @param cadescribe 
	 */
	void insertCatalogue(@Param("caname") String caname, @Param("cadescribe") String cadescribe);

	/**
	 * 删除目录
	 * 
	 * @param caid
	 */
	void deleteCatalogue(int caid);

	/**
	 * 修改目录
	 * 
	 * @param catalogue
	 */
	void updateCatalogue(Catalogue catalogue);

}
