package com.spring.test;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.PageMaker;
import com.spring.domain.SearchCriteria;
import com.spring.domain.WaybillVO;
import com.spring.service.WaybillService;

@Controller
@RequestMapping("/search/*")
public class SearchWaybillController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchWaybillController.class);
	
	@Inject
	private WaybillService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model)throws Exception{
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listSearchCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("wb_num") int wb_num, @ModelAttribute("cri")SearchCriteria cri, Model model)throws Exception{
		model.addAttribute(service.read(wb_num));
	}
	
	@RequestMapping (value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("wb_num")int wb_num, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		
		service.remove(wb_num);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/search/list";
	}
	
	@RequestMapping (value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(int wb_num, @ModelAttribute("cri")SearchCriteria cri, Model model) throws Exception{
		model.addAttribute(service.read(wb_num));
	}
	
	@RequestMapping (value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(WaybillVO vo, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		
		service.modify(vo);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/search/list";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(WaybillVO vo, Model model) throws Exception {
		logger.info("register get.............................");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(WaybillVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("register post.............................");
		logger.info(vo.toString());
		
		service.regist(vo);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/search/list";
	}
}
