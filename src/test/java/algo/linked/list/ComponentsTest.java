package algo.linked.list;

import static algo.linked.list.ListUtil.createList;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import algo.linked.list.questions.components.Components;

public class ComponentsTest {

	Components service = new Components();
	
	@Test
	public void testNoComponents() {
		assertEquals(service.numComponents(null, null), 0);
	}
	
	@Test
	public void testSingleElement() {
		assertEquals(service.numComponents(createList(1), new int[] {1}), 1);
	}
	
	@Test
	public void testMultipleElementsAllConnected() {
		assertEquals(service.numComponents(createList(1,2,3,4,5), new int[] {1,2,3,4,5}), 1);
	}
	
	@Test
	public void testMultipleElementsAllConnectedButJumbled() {
		assertEquals(service.numComponents(createList(1,2,3,4,5), new int[] {1,3,5,4,2}), 1);
	}
	
	@Test
	public void testMultipleElementsAllDisconnected() {
		assertEquals(service.numComponents(createList(1,2,3,4,5), new int[] {1,3,5}), 3);
	}
	
	@Test
	public void testMultipleElementsSomeConnected() {
		assertEquals(service.numComponents(createList(1,2,3,4,5), new int[] {1,2,5}), 2);
	}
}
