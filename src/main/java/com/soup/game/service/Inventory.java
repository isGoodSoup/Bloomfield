package com.soup.game.service;

import com.soup.game.intf.Item;

import java.util.*;

public class Inventory {
    private final Map<Item, List<Item>> items = new LinkedHashMap<>();

    public void add(Item item) {
        items.computeIfAbsent(item, k -> new ArrayList<>()).add(item);
    }

    public Item get(int i) {
        if(i < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }

        int count = 0;
        for(Map.Entry<Item, List<Item>> entry : items.entrySet()) {
            List<Item> list = entry.getValue();
            if(i < count + list.size()) {
                return list.get(i - count);
            }
            count += list.size();
        }
        throw new IndexOutOfBoundsException("Index out of inventory bounds");
    }

    public void addAll(Collection<Item> newItems) {
        for (Item item : newItems) add(item);
    }

    @SuppressWarnings("UnusedReturnValue")
    public boolean remove(Item item) {
        List<Item> list = items.get(item);
        if(list == null || list.isEmpty()) { return false; }
        list.removeFirst();
        if(list.isEmpty()) { items.remove(item); }
        return true;
    }

    public int getQuantity(Item item) {
        List<Item> list = items.get(item);
        return list == null ? 0 : list.size();
    }

    public Map<Item, Integer> getAll() {
        Map<Item, Integer> result = new LinkedHashMap<>();
        for(Map.Entry<Item, List<Item>> e : items.entrySet()) {
            result.put(e.getKey(), e.getValue().size());
        }
        return result;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        int total = 0;
        for(List<Item> list : items.values()) {
            total += list.size();
        }
        return total;
    }
}