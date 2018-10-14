package se.william.mvcexemple.shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.william.mvcexemple.shoppinglist.entity.Item;
import se.william.mvcexemple.shoppinglist.service.ItemService;

import java.util.List;

@RestController
public class RestApiController {

    @Autowired
    private ItemService itemService;

    @RequestMapping({"/items"})
    public List<Item> getItems(){
        return this.itemService.getAllItems();
    }

    @PostMapping({"/items"})
    public void addItem(@RequestBody Item item){
        this.itemService.addItem(item);
    }

    @RequestMapping({"/items/{id}"})
    public Item getItem(@PathVariable Integer id){
        return this.itemService.getItem(id);
    }


    @DeleteMapping({"/items/{id}"})
    public void deleteItem(@PathVariable Integer id){
        this.itemService.deleteItem(id);
    }

    @PutMapping({"/items/{id}"})
    public void updateItem(@RequestBody Item item){
        this.itemService.updateItem(item);
    }

}
