package se.william.mvcexemple.shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.william.mvcexemple.shoppinglist.entity.Item;
import se.william.mvcexemple.shoppinglist.service.ItemService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ShoppingListController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/additem")
    public String itemForm(Model model){
        model.addAttribute("item", new Item());
        return "shoppinglist/additem";
    }

    @PostMapping("/additem")
    public String addItem(@Valid @ModelAttribute Item item, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "shoppinglist/additem";
        }
        this.itemService.addItem(item);
        return "redirect:/listitems";
    }

    @GetMapping("/listitems")
    public String getAllItems(Model model){
        List<Item> allItems = this.itemService.getAllItems();
        model.addAttribute("allItems",allItems);
        return "shoppinglist/list-items";
    }


    @GetMapping("/orderedlist")
    public String getAllItemsInOrder(@RequestParam String sort, Model model){

        List<Item> allItems;
        boolean isPriceSorted = false;
        boolean isNameSorted = false;

        switch (sort){
            case "priceAsc":
                allItems = this.itemService.getAllItemsPriceAsc();
                isPriceSorted = true;
                break;
            case "priceDesc":
                allItems = this.itemService.getAllItemsPriceDesc();
                break;
            case "nameAsc":
                allItems = this.itemService.getAllItemsNameAsc();
                isNameSorted = true;
                break;
            case "nameDesc":
                allItems = this.itemService.getAllItemsNameDesc();
                break;
            default:
                allItems = this.itemService.getAllItems();
                break;
        }
        model.addAttribute("allItems",allItems);
        model.addAttribute("priceSorted", isPriceSorted);
        model.addAttribute("nameSorted", isNameSorted);
        return "shoppinglist/list-items";
    }


    @GetMapping("/deleteitem")
    public String deleteItem(@RequestParam("itemId") int theId) {

        this.itemService.deleteItem(theId);

        return "redirect:/listitems";
    }

    @GetMapping("/updateitem")
    public String updateItem(@RequestParam("itemId") int theId, Model theModel) {

        Item item = this.itemService.getItem(theId);

        theModel.addAttribute("item", item);

        return "shoppinglist/additem";

    }



}
