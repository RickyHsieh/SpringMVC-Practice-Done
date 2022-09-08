package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import demo.model.entity.MvcOrderEntity;
import demo.service.OrderServiceImpl;

@Controller
public class OrderController {
	
	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	@GetMapping("/orders")
	public String orderFindAll(Model model) {
		
		List<MvcOrderEntity> allOrders = orderServiceImpl.getAllOrders();
		
		model.addAttribute("orders", allOrders);
		
		return "order";
		
	}
	
//	@GetMapping("/order/info")
//	public void getOrderInfo(int userId) {
//		System.out.println();
//		System.out.println("getOrderInfo#Start");
//	}
	
	
	
}
