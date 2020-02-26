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
import com.chinasoft.entity.Goods;
import com.chinasoft.service.CatalogueService;
import com.chinasoft.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 商品Controller
 * 
 * @author 刘炳炎
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CatalogueService catalogueService;

	// 查询所有目录
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String goodsList(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page) {
		List<Catalogue> caList = catalogueService.getAllCatalogue();
		model.addAttribute("calist", caList);
		PageHelper.startPage(page, 5);
		List<Goods> goList = goodsService.getAllGoods();
		PageInfo<Goods> pageHelper = new PageInfo<Goods>(goList, 5);
		model.addAttribute("golist", goList);
		model.addAttribute("pageInfo", pageHelper);
		return "goods";
	}

	// 模糊查询目录
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	private String searchGoods(Model model, @RequestParam(value = "page", defaultValue = "1") Integer page,
			HttpServletRequest req, HttpServletResponse resp) {
		String goname = req.getParameter("goname");
		req.setAttribute("goname", goname);
		PageHelper.startPage(page, 5);
		List<Goods> goSearchList = goodsService.getSomeGoods(goname);
		PageInfo<Goods> pageHelper = new PageInfo<Goods>(goSearchList, 5);
		model.addAttribute("golist", goSearchList);
		model.addAttribute("pageInfo", pageHelper);
		return "goods";
	}

	// 增加目录
	@RequestMapping(value = "/add")
	public ModelAndView addGoods(String goname,int caid,int gonumber,int price,String godescribe) {
		goodsService.addGoods(goname, caid, gonumber, price, godescribe);
		ModelAndView mav = new ModelAndView("redirect:/goods/list");
		return mav;
	}

	// 删除目录
	@RequestMapping(value = "/del")
	public ModelAndView delGoods(int goid) {
		goodsService.delGoods(goid);
		ModelAndView mav = new ModelAndView("redirect:/goods/list");
		return mav;
	}

	// 修改目录
	@RequestMapping(value = "/edit")
	public ModelAndView editGoods(Goods goods) {
		goodsService.editGoods(goods);
		ModelAndView mav = new ModelAndView("redirect:/goods/list");
		return mav;
	}

}
