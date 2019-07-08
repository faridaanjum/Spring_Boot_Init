package com.onlinetutorialspoint.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinetutorialspoint.docs.Item;
import com.onlinetutorialspoint.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	ItemService itemService;	
	
	@RequestMapping("/getAllItems")
	@ResponseBody
	public List<Item> getItems(){
		return itemService.getAllItems();
	}
	
	@RequestMapping("/getItemById")
	@ResponseBody
	public Item getItemById(@RequestParam("item") long item) {
		return itemService.getItemByItemId(item);
	}
	
	@RequestMapping("/getItem")
	@ResponseBody
	public List<Item> getItem(@RequestParam("category") String category){
		return itemService.getItemByCategory(category);
	}
	
	@PostMapping("/addItem")
	@ResponseBody
	public String addItem(@RequestParam("itemId") long itemId,@RequestParam("serialNumber") String serialNumber,
            @RequestParam("name") String name,
            @RequestParam("category") String category) {
		if(itemService.addItem(itemId, serialNumber, name, category) != null) {
			return "Item Added Successfully";
		}
		else {
			 return "Something went wrong !";
		}
		
	}
	
	@RequestMapping("/deleteItem")
	@ResponseBody
	public String deleteItem(@RequestParam("itemId") int itemId) {
		if(itemService.deleteItem(itemId) == 1) {
			 return "Item Deleted Successfully";
		}
		else {
			 return "Something went wrong !";
		}
	}
	
	
	

}
