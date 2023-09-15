package com.shans.kvstores;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class InMemoryKeyValueStore implements KeyValueStore {
    HashMap<String, String> map = new HashMap<>();

    @Override
    public void store(String key, String value) {
        map.put(key, value);
    }
}
