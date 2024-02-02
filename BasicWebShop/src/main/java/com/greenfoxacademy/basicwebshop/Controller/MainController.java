package com.greenfoxacademy.basicwebshop.Controller;

import com.greenfoxacademy.basicwebshop.Model.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private List<ShopItem> shopItems = new ArrayList<>();

    public MainController() {
        shopItems.add(new ShopItem("Running shoes","Nike running shoes for every day sport",1000, 5));
        shopItems.add(new ShopItem("Printer","Some HP printer that will pring pages",3000, 2));
        shopItems.add(new ShopItem("Coca Cola","0.5L standard coke",25, 0));
        shopItems.add(new ShopItem("Wokin","Chicken with fried rice and WOKIN sauce",119, 100));
        shopItems.add(new ShopItem("T-Shirt","Blue with corgi on a bike",300, 1));

    }

    @GetMapping("/home")
    public String getHome(Model model){
        model.addAttribute("shopItems", shopItems);
        return "home";
    }

    @GetMapping("/only-available")
    public String getOnlyAvailable(Model model){
        List<ShopItem> availableItems = shopItems.stream()
                .filter(shopItem -> shopItem.getQuantityOfStock() > 0)
                .collect(Collectors.toList());
        model.addAttribute("shopItems", availableItems);
        return "home";
    }

    @GetMapping("/cheapest-first")
    public String getCheapestFirst(Model model){
        List<ShopItem> itemsInPriceOrder = shopItems.stream()
                .sorted(Comparator.comparingDouble(ShopItem::getPrice))
                .collect(Collectors.toList());
        model.addAttribute("shopItems", itemsInPriceOrder);
        return "home";
    }

    @GetMapping("/contains-nike")
    public String getContainsNike(Model model){
        List<ShopItem> nikeItems = shopItems.stream()
                .filter(item -> item.getDescription().toLowerCase().contains("nike"))
                .collect(Collectors.toList());
        model.addAttribute("shopItems", nikeItems);
        return "home";
    }
}