package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    public Item saveDetails(Item item){
        return itemRepo.save(item);
    }
    public Item getItemByID(int ID){
        return itemRepo.findById(ID).orElse(null);
    }
    public Item updateDetail(Item item){
        Item updatedItem = itemRepo.findById(item.getId()).orElse(null);
        if(updatedItem != null){
            updatedItem.setName(item.getName());
            updatedItem.setId(item.getId());
            updatedItem.setPrice(item.getPrice());
            updatedItem.setDescription(item.getDescription());
            updatedItem.setStock(item.getStock());
            itemRepo.save(updatedItem);
            return updatedItem;
        }
        return null;
    }
    public List<Item> getItems(){
        return itemRepo.findAll();
    }
    public void addImageToItem(Item item, MultipartFile file) throws IOException {
        item.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        itemRepo.save(item);
    }
    public List<List<Item>> listSplit(List<Item> itemList) {
        List<Item> notNullItems = new ArrayList<>();
        for (Item item : itemList) {
            if (item != null) {
                notNullItems.add(item);
            }
        }

        List<List<Item>> RowOf5 = new ArrayList<>();
        for (int i = 0; i < notNullItems.size(); i += 2) {
            int end = Math.min(i + 2, notNullItems.size());
            RowOf5.add(new ArrayList<>(notNullItems.subList(i, end)));
        }
        return RowOf5;
    }

}
