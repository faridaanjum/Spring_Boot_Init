package com.onlinetutorialspoint.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlinetutorialspoint.docs.Item;

public interface ItemRepository extends MongoRepository<Item,Long> {
List<Item> findByCategory(String Category);
Item findByItemId(long itemId);
}
