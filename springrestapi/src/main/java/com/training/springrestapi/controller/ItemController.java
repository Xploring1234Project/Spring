package com.training.springrestapi.controller;

import com.training.springrestapi.dto.ItemDTO;
import com.training.springrestapi.entity.Item;
import com.training.springrestapi.exception.ResourceNotFoundException;
import com.training.springrestapi.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ItemController {
   @Autowired
    private  ItemService itemService;

    //http:localhost:8080/saveitem
    @PostMapping("/saveitem")
    public ResponseEntity<ItemDTO> addItem(@Valid @RequestBody ItemDTO itemDto)
    {
        ItemDTO savedItem = itemService.addItem(itemDto);

        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        //return itemService.addItem(item);
    }

    //http://localhost:8080/fetchitems
    @GetMapping("/fetchitems")
    public ResponseEntity<List<ItemDTO>> fetchItems()
    {
        List<ItemDTO> items = itemService.fetchItems();

        return new ResponseEntity<>(items, HttpStatus.OK);
        //return itemService.fetchItems();
    }

    //http://localhost:8080/1
    @GetMapping("/{id}")
    public ItemDTO fetchItem(@PathVariable int id)
    {
        return itemService.fetchItem(id);
//ItemDTO item = itemService.fetchItem(id);
 //       return ResponseEntity.ok(item);

    }

    @PutMapping("/{id}")
    public Item updateItem(@RequestBody Item item,@PathVariable int id)
    {
        return itemService.updateItem(item,id);
    }

    /*@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}*/


}

/*@RequestBody
@RequestParam
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
@PatchMapping
@PathVariable

 */

