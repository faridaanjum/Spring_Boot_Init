package com.onlinetutorialspoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.docs.Item;
import com.onlinetutorialspoint.repository.ItemRepository;

@Service
public class ItemService {
@Autowired
ItemRepository itemRepo;
public List<Item> getAllItems(){
	return itemRepo.findAll();
}

public List<Item> getItemByCategory(String category){
	List<Item> item = itemRepo.findByCategory(category);
	return item;
}

public Item getItemByItemId(long itemId){
	Item item = itemRepo.findByItemId(itemId);
	return item;
}
public Item addItem(long id, String serialNumber, String name, String category ) {
	Item item = new Item();
	item.setItemId(id);
	item.setSerialNumber(serialNumber);
	item.setName(name);
	item.setCategory(category);
	return itemRepo.save(item);
	
}
public int deleteItem(long itemId) {
	Item item = itemRepo.findByItemId(itemId);
	if(item != null) {
		itemRepo.delete(item);
		return 1;
	}
	return -1;
}

}
