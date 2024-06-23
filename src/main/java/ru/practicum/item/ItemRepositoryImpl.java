package ru.practicum.item;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    private final Map<Long, Item> items = new HashMap<>();
    private long itemNextId = 1;

    @Override
    public List<Item> getItems(long userId) {
        return items.values().stream()
                .filter(item -> item.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Item addNewItem(Long userId, Item item) {
        item.setId(generateItemId());
        item.setUserId(userId);
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public void deleteItem(long userId, long itemId) {
        if (items.containsKey(itemId) && items.get(itemId).getUserId().equals(userId)) {
            items.remove(itemId);
        }
    }

    private long generateItemId() {
        return itemNextId++;
    }
}
