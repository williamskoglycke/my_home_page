package se.william.mvcexemple.shoppinglist.service;

import org.springframework.data.repository.CrudRepository;
import se.william.mvcexemple.shoppinglist.entity.Item;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    List<Item> findAllByOrderByItemPriceAsc();
    List<Item> findAllByOrderByItemPriceDesc();
    List<Item> findAllByOrderByItemNameAsc();
    List<Item> findAllByOrderByItemNameDesc();
}
