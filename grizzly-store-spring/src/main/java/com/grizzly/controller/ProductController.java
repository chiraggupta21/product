package com.grizzly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grizzly.entity.Product;
import com.grizzly.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
			
	@GetMapping("/listall")
	public String listProduct(Model model)
	{
		List<Product> listProduct=productService.listProduct();
		model.addAttribute("products", listProduct);
		return "productlist";
	}
	
	@RequestMapping("/showform")
	public String showFormForAdd(Model model)
	{
		Product p=new Product();
		model.addAttribute("product",p);
		return "addproduct";
	}
	
	@RequestMapping("/saveproduct")
	public String addAProduct(@ModelAttribute("product")Product p)
	{
		productService.addProduct(p);
		return "redirect:/products/listall";
	}
	
	@RequestMapping("/delete")
	public String deleteProduct(@ModelAttribute("productId") int id)
	{
		productService.deleteProduct(id);
		return "redirect:/products/listall";
	}
	
	@RequestMapping("/update")
	public String updateBook(@ModelAttribute("productId") int id, Model model)
	{
		Product p=productService.getProduct(id);
		model.addAttribute("product",p);
		return "addproduct";
	}
	
	 @RequestMapping("/logout")  
	    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	        if (auth != null){      
	           new SecurityContextLogoutHandler().logout(request, response, auth);  
	        }  
	         return "redirect:/login";  
	     }  
}
