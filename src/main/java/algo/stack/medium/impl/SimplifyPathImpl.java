package algo.stack.medium.impl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

import algo.stack.medium.SimplifyPath;

public class SimplifyPathImpl implements SimplifyPath {

	private static final String SELF = ".";
	private static final String PARENT = "..";
	private static final String EMPTY = "";

	@Override
	public String simplifyPath(String absolutePath) {
		Deque<String> paths = new ArrayDeque<>();

		for (String pathPart : absolutePath.split("/")) {
			switch (pathPart) {
			case PARENT:
				if (!paths.isEmpty()) {
					paths.removeLast();
				}
				break;
			case EMPTY:
			case SELF:
				// Do nothing
				break;
			default:
				paths.addLast(pathPart);
				break;
			}
		}
		return buildFullPath(paths);
	}

	private String buildFullPath(Deque<String> paths) {
		return paths.stream()
				.collect(Collectors.joining("/","/",""));
	}

}
