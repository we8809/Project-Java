package academy.pocu.comp2500.lab4;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class MemoryCache {
    private static HashMap<String, MemoryCache> instances = new HashMap<String, MemoryCache>();
    private static LinkedHashSet<String> lruInstancesKeys = new LinkedHashSet<String>();
    private static boolean maxInstanceCountSet;
    private static int maxInstanceCount;

    private HashMap<String, String> entry;
    private HashIOCache<String> ioEntryKeys;
    private LinkedHashSet<String> lruEntryKeys;
    private String name;
    private EvictionPolicy evictionPolicy;
    private boolean maxEntryCountSet;
    private int maxEntryCount;

    private MemoryCache(String name) {
        this.name = name;
        this.entry = new HashMap<String, String>();
        this.ioEntryKeys = new HashIOCache<String>();
        this.lruEntryKeys = new LinkedHashSet<String>();
        this.evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    }

    public void addEntry(String key, String value) {
        updateKeyCount(key);

        if (this.entry.containsKey(key)) {
            this.entry.replace(key, value);
            return;
        }

        /* overflow is remove */
        if (this.maxEntryCountSet) {
            if (this.maxEntryCount <= this.entry.size()) {
                evictionFromEntry();
            }
        }

        this.entry.put(key, value);
        this.ioEntryKeys.add(key);
    }

    public String getEntryOrNull(String key) {
        if (this.lruEntryKeys.contains(key)) {
            updateKeyCount(key);
        }

        return this.entry.get(key);
    }

    public void setMaxEntryCount(int maxEntryCount) {
        assert (maxEntryCount != 0) : "maxInstanceCount must be not 0";

        String key;
        int removeCount;
        this.maxEntryCount = maxEntryCount;

        switch (this.evictionPolicy) {
            case FIRST_IN_FIRST_OUT:
                if (this.entry.size() > this.maxEntryCount) {
                    removeCount = this.entry.size() - this.maxEntryCount;

                    for (int i = 0; i < removeCount; i++) {
                        key = this.ioEntryKeys.removeFirst();
                        this.lruEntryKeys.remove(key);
                        this.entry.remove(key);
                    }
                }
                break;
            case LAST_IN_FIRST_OUT:
                if (this.entry.size() > this.maxEntryCount) {
                    removeCount = this.entry.size() - this.maxEntryCount;

                    for (int i = 0; i < removeCount; i++) {
                        key = this.ioEntryKeys.removeLast();
                        this.lruEntryKeys.remove(key);
                        this.entry.remove(key);
                    }
                }
                break;
            case LEAST_RECENTLY_USED:
                Iterator<String> it = this.lruEntryKeys.iterator();

                if (this.entry.size() > this.maxEntryCount) {
                    removeCount = this.entry.size() - this.maxEntryCount;

                    for (int i = 0; i < removeCount; i++) {
                        key = it.next();
                        this.ioEntryKeys.remove(key);
                        this.lruEntryKeys.remove(key);
                        this.entry.remove(key);
                        it = this.lruEntryKeys.iterator();
                    }
                }
                break;
            default:
                break;
        }

        this.maxEntryCountSet = true;
    }

    private void evictionFromEntry() {
        String key;

        switch (this.evictionPolicy) {
            case FIRST_IN_FIRST_OUT:
                key = this.ioEntryKeys.removeFirst();
                this.lruEntryKeys.remove(key);
                this.entry.remove(key);
                break;
            case LAST_IN_FIRST_OUT:
                key = this.ioEntryKeys.removeLast();
                this.lruEntryKeys.remove(key);
                this.entry.remove(key);
                break;
            case LEAST_RECENTLY_USED:
                Iterator<String> it = this.lruEntryKeys.iterator();
                key = it.next();
                this.ioEntryKeys.remove(key);
                this.lruEntryKeys.remove(key);
                this.entry.remove(key);
                break;
            default:
                break;
        }
    }

    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    /* static */
    public static MemoryCache getInstance(String name) {
        MemoryCache findInstance = instances.get(name);
        if (findInstance != null) {
            findInstance.updateCacheCount();
            return findInstance;
        }

        /* overflow is remove */
        if (maxInstanceCountSet) {
            if (maxInstanceCount <= instances.size()) {
                evictionFromInstances();
            }
        }

        MemoryCache newMemCache = new MemoryCache(name);
        newMemCache.updateCacheCount();
        instances.put(name, newMemCache);

        return newMemCache;
    }

    public static void clear() {
        instances.clear();
        lruInstancesKeys.clear();
    }

    public static void setMaxInstanceCount(int maxInstanceCount) {
        assert (maxInstanceCount != 0) : "maxInstanceCount must be not 0";

        MemoryCache.maxInstanceCount = maxInstanceCount;

        String key;
        Iterator<String> it = lruInstancesKeys.iterator();

        if (instances.size() > maxInstanceCount) {
            int removedCount = instances.size() - maxInstanceCount;
            for (int i = 0; i < removedCount; i++) {
                key = it.next();
                lruInstancesKeys.remove(key);
                instances.remove(key);
                it = lruInstancesKeys.iterator();
            }
        }

        MemoryCache.maxInstanceCountSet = true;
    }

    private static void evictionFromInstances() {
        Iterator<String> it = lruInstancesKeys.iterator();
        String key = it.next();
        lruInstancesKeys.remove(key);
        instances.remove(key);
    }

    private void updateCacheCount() {
        boolean ret = lruInstancesKeys.add(this.name);
        if (!ret) {
            lruInstancesKeys.remove(this.name);
            lruInstancesKeys.add(this.name);
        }
    }

    private void updateKeyCount(String key) {
        boolean ret = this.lruEntryKeys.add(key);
        if (!ret) {
            this.lruEntryKeys.remove(key);
            this.lruEntryKeys.add(key);
        }
    }

    /*
    public static void printInstances() {
        Iterator<String> it = instances.keySet().iterator();
        System.out.print("HardDisk Cache List => [");
        for (int i = 0; i < instances.size(); i++) {
            System.out.print(String.format("%s, ", it.next()));
        }
        System.out.println("]");

        System.out.print("LRU List => ");
        System.out.println(lruInstancesKeys);
        System.out.println();
    }

    public void printEntry() {
        Iterator<String> it = this.entry.keySet().iterator();
        System.out.print("Entry => [");
        for (int i = 0; i < this.entry.size(); i++) {
            System.out.print(String.format("%s, ", it.next()));
        }
        System.out.println("]");

        System.out.print("I/O Entry => ");
        System.out.println(this.ioEntryKeys.keySet());

        System.out.print("LRU Entry => ");
        System.out.println(this.lruEntryKeys);
        System.out.println();
    }
    */
}
