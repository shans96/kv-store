package com.shans.kvstores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryKeyValueStoreTest {

    InMemoryKeyValueStore classUnderTest;

    @BeforeEach
    void setup() {
        classUnderTest = new InMemoryKeyValueStore();
    }

    @Test
    void store() {
        classUnderTest.store("foo", "bar");

        Map.Entry<String, String> insertedEntry = classUnderTest.getMap().entrySet().stream().findFirst().get();
        assertEquals(1, classUnderTest.getMap().size());
        assertEquals("foo", insertedEntry.getKey());
        assertEquals("bar", insertedEntry.getValue());
    }
}