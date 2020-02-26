package com.chinasoft.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasoft.entity.Catalogue;
import com.chinasoft.service.CatalogueService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 目录Controller
 * 
 * @author 刘炳炎
 */

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {

	@Autowired
	private CatalogueService catalogueService;

	// 查询所有目录
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String catalogueList(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page) {
		PageHelper.startPage(page, 5);
		List<Catalogue> caList = catalogueService.getAllCatalogue();
		PageInfo<Catalogue> pageHelper = new PageInfo<Catalogue>(caList, 5);
		model.addAttribute("calist", caList);
		model.addAttribute("pageInfo", pageHelper);
		return "catalogue";
	}

	// 模糊查询目录
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	private String searchCatalogue(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page,
			HttpServletRequest req, HttpServletResponse resp) {
		String caname = req.getParameter("caname");
		req.setAttribute("caname", caname);
		PageHelper.startPage(page, 5);
		List<Catalogue> caSearchList = catalogueService.getSomeCatalogue(caname);
		PageInfo<Catalogue> pageHelper = new PageInfo<Catalogue>(caSearchList, 5);
		model.addAttribute("calist", caSearchList);
		model.addAttribute("pageInfo", pageHelper);
		return "catalogue";
	}

	// 增加目录
	@RequestMapping(value = "/add")
	public ModelAndView addCatalogue(String caname, String cadescribe) {
		catalogueService.addCatalogue(caname, cadescribe);
		ModelAndView mav = new ModelAndView("redirect:/catalogue/list");
		return mav;
	}

	// 删除目录
	@RequestMapping(value = "/del")
	public ModelAndView delCatalogue(int caid) {
		catalogueService.delCatalogue(caid);
		ModelAndView mav = new ModelAndView("redirect:/catalogue/list");
		return mav;
	}

	// 修改目录
	@RequestMapping(value = "/edit")
	public ModelAndView updCatalogue(Catalogue catalogue) {
		catalogueService.editCatalogue(catalogue);
		ModelAndView mav = new ModelAndView("redirect:/catalogue/list");
		return mav;
	}

}
