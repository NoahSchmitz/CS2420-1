package assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

/**
 * 
 * @author Maks Cegielski-Johnson
 * @author William Guss
 * 
 * Testing class. Many of these tests can also be done using a DOT file.
 *
 */
public class BSTtester extends TestCase {
	
	BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

	/**
	 * Test for the add method
	 */
	public void testAdd() {
		assertTrue(bst.add(10));
		assertTrue(!bst.add(10));
		assertTrue(bst.contains(10));		
		for(int i = 0; i<= 20; i++){
			if(i%2 == 0)
				bst.add(i);
			else
				bst.add(20-i);
		}
		assertTrue(bst.contains(13));
		assertTrue(!bst.contains(27));
		
	}

	/**
	 * Test for the addAll method
	 */
	public void testAddAll() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<10; i++){
			list.add(i);
		}
		
		bst.addAll(list);
		
		assertEquals(bst.size(), 10);
		for(int i : list)
			assertTrue(bst.contains(i));
	}

	/**
	 * Test for the clear method
	 */
	public void testClear() {
		assertEquals(bst.size(), 0);
		for(int i = 0; i<10; i++){
			bst.add(i);
		}
		assertEquals(bst.size(), 10);
		bst.clear();
		assertEquals(bst.size(), 0);
	}

	/**
	 * Test for the contains method
	 */
	public void testContains() {
		for(int i = 0; i<= 20; i++){
			if(i%2 == 0)
				bst.add(i);
			else
				bst.add(20-i);
		}
		assertTrue(bst.contains(17));
		assertTrue(!bst.contains(39));
		
	}

	/**
	 * Test for the containsAll method.
	 */
	public void testContainsAll() {
		ArrayList<Integer> list = BinarySearchTree.randomList(20);
		
		
		bst.addAll(list);
		
		assertTrue(bst.containsAll(list));
	}

	/**
	 * Test for the isEmpty method
	 */
	public void testIsEmpty() {
		assertTrue(bst.isEmpty());
		bst.add(4);
		assertTrue(!bst.isEmpty());
		bst.clear();
		
		assertEquals(bst.size(), 0);
		for(int i = 0; i<10; i++){
			bst.add(i);
		}
		assertEquals(bst.size(), 10);
		bst.clear();
		assertTrue(bst.isEmpty());
	}

	/**
	 * Test for the remove method.
	 */
	public void testRemove() {
		assertTrue(!bst.remove(99));
		
		bst.add(10);
		bst.add(5);
		bst.add(15);
		bst.add(3);
		bst.add(7);
		bst.add(12);
		bst.add(17);
		
		assertTrue(bst.contains(12));//Testing the first case: Node with no children
		assertEquals(bst.size(), 7);
		
		assertTrue(bst.remove(12));
		assertTrue(!bst.contains(12));
		assertEquals(bst.size(), 6);
		
		bst.add(12);
		
		bst.add(13);//Testing the second case: Node with one child
		assertTrue(bst.contains(12));
		assertTrue(bst.contains(13));
		assertEquals(bst.size(), 8);
		assertTrue(bst.remove(12));
		assertTrue(bst.contains(13));
		assertTrue(!bst.contains(12));
		assertEquals(bst.size(), 7);
		
		
		assertTrue(bst.contains(10)); //Testing the third case: Node with multiple children/grandchildren, in this case the root
		assertTrue(bst.remove(10));
		assertTrue(!bst.contains(10));
		assertTrue(bst.contains(5));//Checking if roots left is still in the list
		assertTrue(bst.contains(15));//Checking if roots right is still in the list
		assertEquals(bst.size(), 6);
	}

	/**
	 * Test for the removeAll method.
	 */
	public void testRemoveAll() {
		bst.add(5);
		bst.add(2);
		bst.add(7);
		bst.add(1);
		bst.add(3);
		bst.add(4);
		bst.add(6);
		bst.add(8);
		bst.add(9);
		bst.add(10);
		
		LinkedList<Integer> even = new LinkedList<Integer>();
		for(int i = 2; i<=10; i+=2)
			even.add(i);
		
		bst.removeAll(even);
		
		for(int i = 1; i<10; i+=2)
			assertTrue(bst.contains(i));
	}

	/**
	 * Test for the size method.
	 */
	public void testSize() {
		assertEquals(bst.size(), 0);
		for(int i = 0; i<10; i++){
			bst.add(i);
		}
		assertEquals(bst.size(), 10);
	}

	/**
	 * Test for the toArrayList method
	 */
	public void testToArrayList() {
		ArrayList<Integer> list = BinarySearchTree.randomList(10);
		for(int i = 0; i<10; i++)
			bst.add(list.get(i));
		
		ArrayList<Integer> BSTList = bst.toArrayList();
		Collections.sort(list);
		for(int i = 0; i<10; i++){
			assertEquals(list.get(i), BSTList.get(i));
		}
		
		
	}

	/**
	 * Test for the first method
	 */
	public void testFirst() {
		bst.add(10);
		bst.add(17);
		bst.add(7);
		bst.add(19);
		bst.add(3);
		
		assertEquals(bst.first(), new Integer(3));
	}

	/**
	 * Test for the last method
	 */
	public void testLast() {
		bst.add(10);
		bst.add(17);
		bst.add(7);
		bst.add(19);
		bst.add(3);
		
		assertEquals(bst.last(), new Integer(19));
	}

	/**
	 * Test for the In-Order Depth First Traversal method.
	 */
	public void testInOrderDFT() {
		bst.add(10);
		bst.add(5);
		bst.add(15);
		bst.add(3);
		bst.add(7);
		bst.add(12);
		bst.add(17);
		
		List<Integer> list = bst.inOrderDFT();
		List<Integer> compare = new ArrayList<Integer>();
		
		compare.add(3);
		compare.add(5);
		compare.add(7);
		compare.add(10);
		compare.add(12);
		compare.add(15);
		compare.add(17);
		
		for(int i = 0; i<7; i++)
			assertEquals(list.get(i), compare.get(i));
	}

	/**
	 * Test for the Pre-Order Depth First Traversal method.
	 */
	public void testPreOrderDFT() {
		bst.add(10);
		bst.add(5);
		bst.add(15);
		bst.add(3);
		bst.add(7);
		bst.add(12);
		bst.add(17);
		
		List<Integer> list = bst.preOrderDFT();
		List<Integer> compare = new ArrayList<Integer>();
		
		compare.add(10);
		compare.add(5);
		compare.add(3);
		compare.add(7);
		compare.add(15);
		compare.add(12);
		compare.add(17);
		
		for(int i = 0; i<7; i++)
			assertEquals(list.get(i), compare.get(i));
	}

	/**
	 * Test for the Post-Order Depth First Traversal method.
	 */
	public void testPostOrderDFT() {
		bst.add(10);
		bst.add(5);
		bst.add(15);
		bst.add(3);
		bst.add(7);
		bst.add(12);
		bst.add(17);
		List<Integer> list = bst.postOrderDFT();
		List<Integer> compare = new ArrayList<Integer>();
		
		compare.add(3);
		compare.add(7);
		compare.add(5);
		compare.add(12);
		compare.add(17);
		compare.add(15);
		compare.add(10);
		
		for(int i = 0; i<7; i++)
			assertEquals(list.get(i), compare.get(i));
	}

	/**
	 * Test for the Level-Order Breadth First Traversal method.
	 */
	public void testLevelOrderBFT() {
		bst.add(10);
		bst.add(5);
		bst.add(15);
		bst.add(3);
		bst.add(7);
		bst.add(12);
		bst.add(17);
		List<Integer> list = bst.levelOrderBFT();
		List<Integer> compare = new ArrayList<Integer>();
		
		compare.add(10);
		compare.add(5);
		compare.add(15);
		compare.add(3);
		compare.add(7);
		compare.add(12);
		compare.add(17);
		
		for(int i = 0; i<7; i++){
			assertEquals(list.get(i), compare.get(i));
			
		}
	}

	
	
	

}
