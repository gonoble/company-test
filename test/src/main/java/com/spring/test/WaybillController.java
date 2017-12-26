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

import com.spring.domain.Criteria;
import com.spring.domain.PageMaker;
import com.spring.domain.WaybillVO;
import com.spring.service.WaybillService;

@Controller
@RequestMapping("/waybill/*")
public class WaybillController {
	
	private static final Logger logger = LoggerFactory.getLogger(WaybillController.class);
	
	@Inject
	private WaybillService service;
	
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
		return "redirect:/waybill/listPage";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list.............................");
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping (value = "/readPage" , method = RequestMethod.GET)
	public void read(@RequestParam("wb_num")int wb_num, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("read...........................................");
		model.addAttribute(service.read(wb_num));
	}
	
	@RequestMapping (value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("wb_num") int wb_num, Criteria cri, RedirectAttributes rttr) throws Exception{
		logger.info("remove.......................................");
		
		service.remove(wb_num);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/waybill/listPage";
	}
	
	@RequestMapping (value = "/modifyPage" , method = RequestMethod.GET)
	public void modifyGET(@RequestParam("wb_num")int wb_num, @ModelAttribute("cri") Criteria cri,Model model) throws Exception{
		
		logger.info("modify get........................................");
		model.addAttribute(service.read(wb_num));
		
	}
	
	@RequestMapping (value = "/modifyPage" , method = RequestMethod.POST)
	public String modifyPOST(WaybillVO vo, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("modify post......................................");
		
		service.modify(vo);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/waybill/listPage";
	}
	
	@RequestMapping (value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception {
		logger.info("show list Page with Criteria...................");
		
		model.addAttribute(service.listCriteria(cri));
	}
	
	@RequestMapping (value = "/listPage" , method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")Criteria cri, Model model) throws Exception {
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(23);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	
}
