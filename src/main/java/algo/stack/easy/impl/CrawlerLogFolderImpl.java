package algo.stack.easy.impl;

import algo.stack.easy.CrawlerLogFolder;

public class CrawlerLogFolderImpl implements CrawlerLogFolder {

	@Override
	public int minOperations(String[] logs) {
		int count = 0;
		for (String log : logs) {
			switch (log) {
			case "../":
				count = Math.max(count - 1, 0);
				break;
			case "./":
				// Do nothing
				break;
			default:
				count++;
				break;
			}
		}
		return count;
	}

}
