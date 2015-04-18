package com.company.nio2;

/**
 * Created by Pgupta on 1/15/2015.
 */
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class FileWatcher {
    public static void main(String[] args) {
        Path this_dir = Paths.get("F:\\Work\\BeachBody\\Pioneer\\Core\\src\\com.company.nio2\\");
        System.out.println("Now watching the current directory ...");

        try {
            WatchService watcher = this_dir.getFileSystem().newWatchService();
            this_dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
           /* this_dir.register(watcher, StandardWatchEventKinds.ENTRY_DELETE);
            this_dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
*/
            WatchKey watckKey = watcher.take();

            List<WatchEvent<?>> events = watckKey.pollEvents();
            for (WatchEvent event : events) {
                if(event.kind().equals(StandardWatchEventKinds.ENTRY_CREATE))
                System.out.println("Someone just created the file '" + event.context().toString() + "'.");
                if(event.kind().equals(StandardWatchEventKinds.ENTRY_DELETE))
                    System.out.println("Someone just delete the file '" + event.context().toString() + "'.");
                if(event.kind().equals(StandardWatchEventKinds.ENTRY_MODIFY))
                    System.out.println("Someone just modify the file '" + event.context().toString() + "'.");

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}