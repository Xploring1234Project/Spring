package com.training.springrestapi.service;

import com.training.springrestapi.dao.ItemRepository;
import com.training.springrestapi.dto.ItemDTO;
import com.training.springrestapi.entity.Item;
import com.training.springrestapi.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ItemService {
    @Autowired
    private ItemRepository itemRepo;
    @Autowired
    private ModelMapper modelMapper;


    public ItemDTO addItem(ItemDTO itemDto) {
       // return itemRepo.save(item);
        Item item = modelMapper.map(itemDto, Item.class);
        Item savedItem = itemRepo.save(item);
        return modelMapper.map(savedItem, ItemDTO.class);
    }

    public List<ItemDTO> fetchItems() {
        //return itemRepo.findAll();
        List<Item> items = itemRepo.findAll();
        List<ItemDTO> itemList=new ArrayList<>();
       /* for(Item obj:items)
        {
            ItemDTO itemDto=new ItemDTO();
            itemDto=modelMapper.map(obj, ItemDTO.class);
            itemList.add(itemDto);
        }*/
        return items.stream()
                .map(item -> modelMapper.map(item, ItemDTO.class))
                .collect(Collectors.toList());
    }

   /* public Item fetchItem(int id) {
        Optional<Item> item=itemRepo.findById(id);
        return item.get();
    }
*/
    public ItemDTO fetchItem(int id) {
        return itemRepo.findById(id).map(item->modelMapper.map(item, ItemDTO.class)).
                orElseThrow(()->new ResourceNotFoundException
                        ("Invalid Item id "+ id + " not found"));
    }
    public Item updateItem(Item item,int id) {
        Item obj=itemRepo.findById(id).get();
        obj.setItemName(item.getItemName());
        obj.setPrice(item.getPrice());
        return itemRepo.save(obj);
    }
}
