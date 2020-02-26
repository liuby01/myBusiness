package com.chinasoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.dao.CatalogueDao;
import com.chinasoft.entity.Catalogue;
import com.chinasoft.service.CatalogueService;

/**
 * 目录Service实现
 * 
 * @author 刘炳炎
 */

@Service
public class CatalogueServiceImpl implements CatalogueService {

	@Autowired
	private CatalogueDao cataLogueDao;

	// 查询所有目录
	@Override
	public List<Catalogue> getAllCatalogue() {
		return cataLogueDao.selectAllCatalogue();
	}

	// 模糊查询目录
	@Override
	public List<Catalogue> getSomeCatalogue(String caname) {
		return cataLogueDao.selectCatalogueByName(caname);
	}

	// 增加目录
	@Override
	public void addCatalogue(String caname, String cadescribe) {
		cataLogueDao.insertCatalogue(caname, cadescribe);
	}

	// 删除目录
	@Override
	public void delCatalogue(int caid) {
		cataLogueDao.deleteCatalogue(caid);
	}

	// 修改目录
	@Override
	public void editCatalogue(Catalogue catalogue) {
		cataLogueDao.updateCatalogue(catalogue);
	}

}
