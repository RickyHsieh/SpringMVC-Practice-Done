package demo.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import demo.model.ajaxResult.AjaxResult;
import demo.model.dto.IndexDto;
import demo.model.dto.IndexPageDto;
import demo.model.entity.WebBroadCastEntity;
import demo.service.WebBroadCastServiceImpl;

@Controller
public class IndexController {

	@Autowired
	WebBroadCastServiceImpl webBroadCastServiceImpl;

	// 三種連jsp方式
	@GetMapping("/index")
	public ModelAndView index(@RequestParam(name = "page", defaultValue = "1") Integer currentPage) {

		System.out.println("index#start");
		System.out.println("page:" + currentPage);
		ModelAndView mv = new ModelAndView();
		mv.addObject("currentPage", webBroadCastServiceImpl.paging(currentPage));
		return mv;
	}

	@GetMapping("/paging")
	public @ResponseBody Object paging(HttpServletRequest request, int draw, int start, int length, @RequestParam("search[value]") String search) {
		Enumeration<String> parameterNames = request.getParameterNames();
		
//		System.out.println("查詢自" + search);
//		while (parameterNames.hasMoreElements()) {
//			String names = parameterNames.nextElement();
//			String key= request.getParameter(names);
//			System.out.println(names + key);
//		}

		Page page = webBroadCastServiceImpl.datatablePaging(start / length, length, search);

		IndexPageDto indexPage = new IndexPageDto();
		indexPage.setDraw(draw);
		indexPage.setRecordsFiltered(page.getTotalElements());
		indexPage.setRecordsTotal(page.getTotalElements());
		indexPage.setData(page.getContent());

		return indexPage;
	}

//	@PostMapping("/indexSave")
//	public String save(String title,String content,@RequestParam("newsImage")MultipartFile file) {
//		
//		new MvcNews
//		
//	}
	
	@GetMapping("/delete")
	public @ResponseBody String delete(@RequestParam("id")Integer id) {
		System.out.println("刪除#Start");
		 webBroadCastServiceImpl.delete(id);
		 System.out.println("成功刪除");
		 return "succeed";
	}
	
	@PostMapping("/edit/save")
	public @ResponseBody Object edit(@RequestBody IndexDto.WebBoardCastDto dto) { //回傳object
		System.out.println("編輯#Start");
		System.out.println("編輯id :" + dto.getId());
		System.out.println("編輯title : " + dto.getTitle());
		System.out.println("編輯content : " + dto.getContent());
		
		WebBroadCastEntity webBroadCastEntity = new WebBroadCastEntity();
		webBroadCastEntity.setId(dto.getId());
		webBroadCastEntity.setTitle(dto.getTitle());
		webBroadCastEntity.setContent(dto.getContent());
		webBroadCastServiceImpl.saveEdit(webBroadCastEntity);
		System.out.println("編輯成功");
		
		AjaxResult result = new AjaxResult();
		try {
				result.setCode("0000");
				result.setDesc("編輯成功");
		} catch (Exception e) {
				result.setCode("9999");
				result.setDesc(e.getMessage());
		}
	
		
		 return result;
	}
	
	
	@GetMapping("/edit")
	public ModelAndView edit(int id) { //回傳object
		
		System.out.println("編輯#Start");
		System.out.println("編輯id :" + id);
		
		ModelAndView mv = new ModelAndView();
		AjaxResult result = new AjaxResult();
		try {
			WebBroadCastEntity data = webBroadCastServiceImpl.findById(id);
			mv.addObject("id", data.getId());
			mv.addObject("title", data.getTitle());
			mv.addObject("beginTime", data.getFmtBeginTime());
			mv.addObject("content", data.getContent());
			mv.addObject("edit");
			
		} catch (Exception e) {
			result.setCode("9999");
			result.setDesc(e.getMessage());
			mv.addObject(result);
		}
		return  mv;
	
	}
	
	

	
}
