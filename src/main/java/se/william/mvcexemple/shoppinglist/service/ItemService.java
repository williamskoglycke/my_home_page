package se.william.mvcexemple.shoppinglist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.william.mvcexemple.shoppinglist.entity.Item;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemService() {
    }

    public List<Item> getAllItems(){
        List<Item> items = (List<Item>) this.itemRepository.findAll();
        return items;
    }

    public Item getItem(int id){
        Item item = this.itemRepository.findById(id).get();
        return item;
    }

    public void addItem(Item item){
        this.itemRepository.save(item);
    }

    public void deleteItem(Integer id){
        this.itemRepository.deleteById(id);
    }

    public void deleteItem(Item item){
        this.itemRepository.delete(item);
    }

    public void updateItem(Item item){
        this.itemRepository.save(item);
    }

    public List<Item> getAllItemsPriceAsc() {
        List <Item> items = this.itemRepository.findAllByOrderByItemPriceAsc();
        return items;
    }
    public List<Item> getAllItemsPriceDesc() {
        List <Item> items = this.itemRepository.findAllByOrderByItemPriceDesc();
        return items;
    }

    public List<Item> getAllItemsNameAsc(){
        List<Item> items = this.itemRepository.findAllByOrderByItemNameAsc();
        return items;
    }

    public List<Item> getAllItemsNameDesc(){
        List<Item> items = this.itemRepository.findAllByOrderByItemNameDesc();
        return items;
    }
}
