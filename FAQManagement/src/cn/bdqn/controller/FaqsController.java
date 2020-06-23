package cn.bdqn.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Faqs;
import cn.bdqn.service.FaqsService;
import cn.bdqn.tools.PageSupport;

@Controller
public class FaqsController {
	@Resource
	FaqsService faqsService;
	
	@RequestMapping("/faqsList")
	public String getFaqsByPage(Model model,String pageIndex,String queryTitle) {
		//页面容量
		int pageSize = 3;
		//当前页码
		Integer currentPageNo = 1;
		
		if(pageIndex != null){
			try{
				currentPageNo = Integer.valueOf(pageIndex);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		//查询总条数
		Map<String,Object> countMap = new HashMap<String,Object>();
		countMap.put("title", queryTitle);
		int totalCount = faqsService.count(countMap);
		//总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		//控制首页和尾页
		if(currentPageNo < 1){
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount){
			currentPageNo = totalPageCount;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("title", queryTitle);
		map.put("pageIndex", currentPageNo-1);
		map.put("pageSize", pageSize);
		List<Faqs> faqsList = faqsService.getFaqsByPage(map);
		model.addAttribute("faqsList", faqsList);
		model.addAttribute("pages", pages);
		model.addAttribute("queryTitle", queryTitle);
		return "faqsList";
	}
	
	@RequestMapping("/faqsAdd")
	public String faqsAdd() {
		return "faqsAdd";
	}
	
	@RequestMapping(value="/getClasses.json",method=RequestMethod.GET)
	@ResponseBody
	public String getClasses(){
		List<Classes> list = faqsService.getClasses();
		String json = JSON.toJSONString(list);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping("/faqsSave")
	public String faqsSave(String classid,String title,String content,Model model) {
		Faqs faqs = new Faqs();
		faqs.setClassid(Integer.parseInt(classid));
		faqs.setTitle(title);
		faqs.setContent(content);
		faqs.setCreatedate(new Date());
		int i = faqsService.save(faqs);
		if (i > 0) {
			return "redirect:/faqsList";
		} else {
			model.addAttribute("error", "添加失败");
			return "faqsAdd";
		}
	}
	
	@RequestMapping("/faqsView")
	public String faqsView(String id,Model model) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		List<Faqs> list= faqsService.getFaqsById(map);
		model.addAttribute("faq", list.get(0));
		return "faqsView";
	}
}
