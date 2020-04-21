package com.nabiki.hope.service.ctrl;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import static java.nio.file.StandardWatchEventKinds.*;

import com.nabiki.hope.common.data2.CommonException;

public abstract class FileWatcher implements Runnable {

	private WatchService watcher;
	private Path watchedPath;
	
	// Watcher's event processing thread
	private Thread eventProc;

	public FileWatcher(Path p) throws CommonException {
		this.watchedPath = p;

		tryCreateFile(this.watchedPath);
		installWatcher();
	}

	@Override
	public void run() {
		processEvents();
	}
	
	private void processEvents() {
		String preContent = "";
		
        for (;;) {

            // Wait for key to be signaled.
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                return;
            }

            for (WatchEvent<?> event: key.pollEvents()) {
                Kind<?> kind = event.kind();

                // Overflow event is issued whatever event it registers.
                // Just skip this event.
                if (kind == OVERFLOW) {
                    continue;
                }

                // Verify that the new file is a text file.
                // Then read content of the file.
                try {
                    if (!Files.probeContentType(this.watchedPath).equals("text/plain")) {
                        continue;
                    }
                    
                    var lines = Files.readAllLines(this.watchedPath);
                    for (var line : lines) {
                    	if (line == null)
                    		continue;
                    	
                    	line = line.trim();
                    	if (line.length() == 0)
                    		continue;
                    	
                    	onTextContentChange(preContent, line);
                    	preContent = line;
                    }
                } catch (IOException | SecurityException x) {
                    continue;
                }
            }

            // Reset the key and this step is critical if you want to receive
            // further watch events. If the key is no longer valid, the directory
            // is inaccessible so exit the loop.
            boolean valid = key.reset();
            if (!valid)
            	break;
        }
    }

	private void tryCreateFile(Path p) throws CommonException {
		if (p == null) {
			throw new CommonException("Watched path is null.");
		}

		try {
			if (!Files.exists(p)) {
				Files.createFile(p);
			}
		} catch (IOException | SecurityException e) {
			throw new CommonException("Can't check file existence or creating file.");
		}
	}

	private void installWatcher() throws CommonException {
        try {
        	this.watcher = FileSystems.getDefault().newWatchService();
			this.watchedPath.register(watcher, ENTRY_CREATE, ENTRY_MODIFY);
			
			this.eventProc = new Thread(this);
			this.eventProc.start();
		} catch (IOException e) {
			throw new CommonException("Fail registering watcher on " + this.watchedPath.toAbsolutePath());
		}
	}
	
	public void stopWatcher() throws CommonException {
		try {
			this.eventProc.interrupt();
			
			// GC
			this.watcher = null;
			this.watchedPath = null;
		} catch (SecurityException  e) {
			throw new CommonException("Can't interrupt watcher event processing thread.");
		}
	}

	public abstract void onTextContentChange(String from, String to);
}
