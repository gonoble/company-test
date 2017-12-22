package com.spring.test;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		return "redirect:/waybill/listAll";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list.............................");
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping (value = "/read" , method = RequestMethod.GET)
	public void read(@RequestParam("wb_num")int wb_num, Model model) throws Exception {
		logger.info("read...........................................");
		model.addAttribute(service.read(wb_num));
	}
	
	@RequestMapping (value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("wb_num") int wb_num, RedirectAttributes rttr) throws Exception{
		logger.info("remove.......................................");
		
		service.remove(wb_num);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/waybill/listAll";
	}
	
	@RequestMapping (value = "/modify" , method = RequestMethod.GET)
	public void modifyGET(int wb_num, Model model) throws Exception{
		model.addAttribute(service.read(wb_num));
	}
	
	@RequestMapping (value = "/modify" , method = RequestMethod.POST)
	public String modifyPOST(WaybillVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("modify post......................................");
		
		service.modify(vo);
		rttr.addAttribute("msg", "SUCCESS");
		return "redirect:/waybill/listAll";
	}
}
