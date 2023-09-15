package com.shans;

import com.shans.kvstores.InMemoryKeyValueStore;
import com.shans.kvstores.KeyValueStore;

import java.util.List;

public class Main {
    private static final List<String> SUPPORTED_COMMANDS = List.of("get", "set", "rm");

    private static final KeyValueStore keyValueStore = new InMemoryKeyValueStore(); // TODO: make this configurable via command line?

    public static void main(String[] args) {
        String command = args[0]; // TODO: remove the risk of an IndexOutOfBoundsException

        if (!SUPPORTED_COMMANDS.contains(command)) {
            System.err.println("Unsupported command received, possible commands: \"get <key>\", \"set <key> <value>\", \"rm <key>\"");
            System.exit(1);
        }

        if ("set".equals(command)) {
            String key = args[1];
            String value = args[2];

            if (key != null && value != null) {
                System.out.println("Storing key: " + key + " and value: " + value);
                keyValueStore.store(key, value);
            } else {
                System.err.println("A key and a value are required for the \"set\" command");
                System.exit(2);
            }
        }
    }
}