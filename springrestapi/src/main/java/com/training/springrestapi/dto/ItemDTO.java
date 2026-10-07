package com.training.springrestapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
public class ItemDTO {
    @NotNull(message = "Id cannot be null")
	private int itemId;
    @NotBlank(message = "Name cannot be empty")
	private String itemName;
    @Min(value = 1, message = "Price must be greater than 0")
	private double price;

public ItemDTO()
{}

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
