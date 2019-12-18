package cn.rainfly.controller;


import cn.rainfly.service.WebOfficeService;
import cn.rainfly.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class WebOfficeController {


	@Autowired
	WebOfficeService webOfficeService;

	@RequestMapping("listCategory")
	public ModelAndView listCategory(Page page){
		return null;
	}

}
