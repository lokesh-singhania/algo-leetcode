package algo.stack.medium.impl.rdl;

import java.util.stream.IntStream;

public class ViaStreams extends RemoveDuplicateLettersImpl{

	@Override
	protected String buildString(boolean[] presentCharacters) {
		return IntStream.range(0, 26)
				.filter(i->presentCharacters[i])
				.mapToObj(this::toChar)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
	}

}
