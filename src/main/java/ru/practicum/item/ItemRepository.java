package ru.practicum.item;

import java.util.List;

interface ItemRepository {
    
    List<Item> getItems(long userId);

    Item addNewItem(Long userId, Item item);

    void deleteItem(long userId, long itemId);
}