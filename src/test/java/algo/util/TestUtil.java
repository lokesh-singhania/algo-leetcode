package algo.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class TestUtil {

	// TODO Add logger and error handling
	public static <TestClass, Interface> Object[] createFactory(Class<TestClass> testClass,
			Class<Interface> interfaceClass,
			Class<? extends Interface>... implClasses) {
		return Arrays.stream(implClasses)
				.map(TestUtil::newInstance)
				.map(i -> newInstance(testClass, interfaceClass, i))
				.toArray();
	}

	private static <TC, I> TC newInstance(Class<TC> testClass, Class<I> interfaceClass, I i) {
		try {
			return testClass.getConstructor(interfaceClass).newInstance(i);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static <I> I newInstance(Class<? extends I> c) {
		try {
			return c.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
			return null;
		}
	}
	
	

}
