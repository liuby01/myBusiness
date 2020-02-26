package com.chinasoft;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinasoft.dao.CatalogueDao;
import com.chinasoft.entity.Catalogue;

/**
 * 目录Dao接口测试
 * 
 * @author 刘炳炎
 */

public class CatalogueDaoTest extends BaseTest {

	@Autowired
	private CatalogueDao catalogueDao;

	// 查询所有目录
	@Test
	public void testSelectAllCatalogue() throws Exception {
		List<Catalogue> catalogues = catalogueDao.selectAllCatalogue();
		for (Catalogue catalogue : catalogues) {
			System.out.println(catalogue);
		}
	}

	// 模糊查询目录
	@Test
	public void testQueryCatalogueByName() throws Exception {
		String caname = "记录";
		List<Catalogue> catalogues = catalogueDao.selectCatalogueByName(caname);
		for (Catalogue catalogue : catalogues) {
			System.out.println(catalogue);
		}
	}

}