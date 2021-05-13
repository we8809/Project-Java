package academy.pocu.comp2500.lab4.app;

import academy.pocu.comp2500.lab4.EvictionPolicy;
import academy.pocu.comp2500.lab4.MemoryCache;

public class Program {

    public static void main(String[] args) {
        {
            MemoryCache memCacheA = MemoryCache.getInstance("A");
            MemoryCache memCacheB = MemoryCache.getInstance("B");
            MemoryCache memCacheC = MemoryCache.getInstance("C");
            MemoryCache.getInstance("A");
            MemoryCache.setMaxInstanceCount(2);
            MemoryCache memCacheD = MemoryCache.getInstance("D");

            MemoryCache.printInstances();
        }
    }
}

