package com.chinasoft;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinasoft.entity.Catalogue;
import com.chinasoft.service.CatalogueService;

/**
 * 目录Service测试
 * 	
 * @author 刘炳炎
 */

public class CatalogueServiceImplTest extends BaseTest {
	
	@Autowired
	CatalogueService catalogueService;

	// 模糊查询测试
	@Test
	public void testGetSomeCatalogue() throws Exception {
		String caname = "说";
		List<Catalogue> catalogues = catalogueService.getSomeCatalogue(caname);
		for (Catalogue catalogue : catalogues) {
			System.out.println(catalogue);
		}
	}
	
	// 修改测试
	@Test
	public void testEditCatalougue() throws Exception {
		Catalogue catalogue = new Catalogue();
		catalogue.setCaid(3);
		catalogue.setCaname("刘");
		catalogue.setCadescribe("");
		catalogueService.editCatalogue(catalogue);
	}

}
