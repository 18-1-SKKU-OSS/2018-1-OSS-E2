import java.util.LinkedList;
import java.util.List;

public class TwoThreeTree <K extends Comparable<K>, V> {

	//TODO: Rewrite comparator for key, stuff should be sorted by occurrence count with the occurrence number to separate two keys. Word is still the key since count needs to be updated.
	//Also, need to write a iterator to get one element at the time. And for density and other functions it would be neat if we had the num of elements stored in a global var, so we don't need to traverse the tree each time to find it.
	
	private Node root;
	private int nodeCount = 0; //We are only creating new nodes when splitting (with a few exceptions). Just count the splits and we get the size.
	
	public class Node
	{
		protected KeyValuePair keyvalues1;
		protected KeyValuePair keyvalues2;
		protected Node parent, left, middle, right;
		
		public Node(KeyValuePair keyValues1)
		{
			this.keyvalues1 = keyValues1;
		}
		
		public Node(KeyValuePair keyValues1, KeyValuePair keyValues2)
		{
			this.keyvalues1 = keyValues1;
			this.keyvalues2 = keyValues2;
		} 
	}
	public class FourNode extends Node
	{
		protected KeyValuePair keyvalues3;
		protected Node middle2;
		
		public FourNode (KeyValuePair keyValues1, KeyValuePair keyValues2, KeyValuePair keyValues3)
		{
			super(keyValues1, keyValues2);
			this.keyvalues3 = keyValues3;
		}
	}
	
	/**
	 * Retrieves the value of the key stored in the tree. If the key is not in the tree a null value is returned.
	 * @param key The key to find in the tree.
	 * @return The value that's associated with the specified key, returns null if the key is not found.
	 */
	public V get(K key)
	{
		//Search for our key.
		Node searchResult = getNode(key, root, true);
		
		if (searchResult != null)
		{
			//Since it can be either a two or a ThreeNode we need to return the correct value.
			if (searchResult.keyvalues1.key.equals(key))
				return searchResult.keyvalues1.value;
			else
				return searchResult.keyvalues2.value;
		}
		else
			return null;
	}
	
	/**
	 * Inserts the key (with associated value) into the tree.
	 * @param key The key to insert.
	 * @param value The value associated with the key. Can not be null.
	 */
	public void put(K key, V value)
	{
		//Null values are not supported, cause then get will not work properly.
		//Assume we store a null value and then get will return that null value. The calling
		//code will then not know if we have found the value (that is null) or if the search
		//was unsuccessful and that's why we are returning null. 
		if (value == null)
			throw new IllegalArgumentException("Null values not supported!");
		
		//If we don't have a root node we don't have a tree.
		//Create a TwoNode and store our key/value in it, done.
		if (root == null)
		{
			root = new Node(new KeyValuePair(key, value));
			nodeCount = 1; //We need to add 1 to our size variable, we have not done a split, but we have one node now.
			return;
		}
		
		//Find the node we should add the key/value to.
		Node foundNode = getNode(key, root, false);
		
		//If the node is a TwoNode, then it's simple. Convert that TwoNode to a ThreeNode and add.
		//Since we are always adding from the bottom we don't have any children to take into account.
		if (foundNode.keyvalues2 == null)
		{
			if (key.compareTo(foundNode.keyvalues1.key) < 0)		//Key is less than key in node.
			{
				//We need to move stuff if we are inserting to the left.
				foundNode.keyvalues2 = foundNode.keyvalues1;
				foundNode.keyvalues1 = new KeyValuePair(key, value);
			}
			else if (key.equals(foundNode.keyvalues1.key)) 			//Equal to key in node, replace value.
				foundNode.keyvalues1.value = value;
			else if (key.compareTo(foundNode.keyvalues1.key) > 0) 	//Key is greater than key in node.
				foundNode.keyvalues2 = new KeyValuePair(key, value);
			
		}
		else //If the node is a ThreeNode, then it's more complicated. Create a temporary FourNode, split it to a TwoNode and merge that back into the tree.
		{		

			//If we have any key with the key we are trying to add, then just replace those values.  
			if (foundNode.keyvalues1.key.equals(key))
			{
				foundNode.keyvalues1.value = value;
				return;
			}
			if (foundNode.keyvalues2.key.equals(key))
			{
				foundNode.keyvalues2.value = value;
				return;
			}
			
			FourNode tempFourNode = null;
			
			//Key is less than left key, insert new value to the left. 
			if (key.compareTo(foundNode.keyvalues1.key) <= -1)
				tempFourNode = new FourNode(new KeyValuePair(key, value), foundNode.keyvalues1, foundNode.keyvalues2);
			
			//Key is larger then the left key, and smaller then the right key, thus it should go in the middle.
			else if (key.compareTo(foundNode.keyvalues1.key) >= 1 && key.compareTo(foundNode.keyvalues2.key) <= -1)
				tempFourNode = new FourNode(foundNode.keyvalues1, new KeyValuePair(key, value), foundNode.keyvalues2);
			
			//Key is more then the right key, insert new value in the right.
			else if (key.compareTo(foundNode.keyvalues2.key) >= 1)
				tempFourNode = new FourNode(foundNode.keyvalues1, foundNode.keyvalues2, new KeyValuePair(key, value));
			
			//Insert this FourNode into the tree.
			put4NodeInTree(foundNode, tempFourNode);
		}
	}

	/**
	 * Returns the number of nodes in our tree.
	 * @return An integer of how many nodes the entire tree has.
	 */
	public int size()
	{
		return nodeCount;
	}
	
	/**
	 * Returns an iterable collection of all key/values in our tree.
	 * @return A LinkedList with the elements sorted by key order.
	 */
	public Iterable<KeyValuePair> keys()
	{
		//List to store the result in.
		LinkedList<KeyValuePair> results = new LinkedList<KeyValuePair>();
		
		//Traverse the tree in-order and add each keyValue to the LinkedList. 
		traverseTree(root, results);

		return results;
	}
	
	/**
	 * Returns an iterable collection of all key/values in our tree.
	 * @param lo The lowest key value that should occur in our collection.
	 * @param hi The highest key value that should occur in our collection.
	 * @return A LinkedList with the elements sorted by key order within the bounds of lo =< keys =< hi.
	 */
	public Iterable<KeyValuePair> keys(K lo, K hi)
	{
		List<KeyValuePair> treeKeyValues = (LinkedList<KeyValuePair>)keys();
		List<KeyValuePair> result = new LinkedList<KeyValuePair>();
		
		int indexOfLow = indexOfKeyInList(lo, treeKeyValues);
		int indexOfHigh = indexOfKeyInList(hi, treeKeyValues)+1;
		
		if (indexOfLow == -1 || indexOfHigh == -1)
			throw new IllegalArgumentException("Key lo and/or hi not found in the tree.");
		
		result.addAll(treeKeyValues.subList(indexOfLow, indexOfHigh));
		
		return result;
	}
	
	/**
	 * Returns the depth of the entire tree, since it's a balanced tree the depth is the same in the entire tree.
	 * @return The depth as an int. A tree with just one node (root) will have a depth of 0.
	 */
	public int depth()
	{
		//The tree is balanced, so we have the same depth everywhere. 
		int depthCount = 0;
		
		Node curNode = root; 
		
		//Just go left until we have no children any more, count each "level".
		while (curNode != null)
		{
			curNode = curNode.left;
			depthCount++;
		}
		depthCount--; //We counted the "null-level" under the leaf, remove that.
		
		return depthCount;
	}
	
	/**
	 * Returns the maximum number of elements we can add to the tree before our depth changes.
	 * @return Returns the remaining elements we can add before our tree grows in depth.
	 */
	public int howMuchMore()
	{
		//Get the number of different nodes for root. Number of TwoNodes is in index 0, ThreeNodes is index 1.
		int[] totalRes = CountNodeTypes(root);
		
		//Get the depth once.
		int depth = depth();
		double numElementsInFullTree = 0;
		
		//This is how many elements a full tree of our depth have.
		//2 * 3^(depth) + 2 * 3^(depth -1) + 2 *3^(depth -2) + ...
		//Geometric sum.
		for (int n = depth; n >= 0; n--)
			numElementsInFullTree += 2 * Math.pow(3, (depth - n));
		
		//Take the full tree - how much we actually have, and the difference is how many we can add.
		Double result = numElementsInFullTree - (2 * totalRes[1] + totalRes[0]);
		
		return result.intValue();
	}

	/**
	 * Returns the average value of two and threeNodes in our tree.
	 * @return The value as a float.
	 */
	public float density()
	{
		//Get the number of TwoNodes and ThreeeNodes in our tree. TwoNodes is stored at index 0, ThreeNodes at 1.
		int[] totalRes = CountNodeTypes(root);
		
		//Average value of the number of TwoNodes and ThreeNodes. Need to multiply by 2 and 3 because that's their weight.
		return (float) (totalRes[0]*2 + totalRes[1]*3) / (totalRes[0] + totalRes[1]);
	}

	/**
	 * Counts the number of TwoNodes and ThreeNodes in the specified node (included).
	 * @param curNode The node that we wish to count.
	 * @return A int[] with TwoNode count at index 0 and ThreeNode count at index 1.
	 */
	private int[] CountNodeTypes (Node curNode) {
		
		//totalRes: index 0 is TwoNodeCount, index 1 is ThreeNodeCount.
		int[] totalRes = new int[2];
		
		//Current node is a... TwoNode.
		if (curNode.keyvalues2 == null)
			totalRes[0]++;
		else //... ThreeNode.
			totalRes[1]++;
		
		//Count the left children if we have any.
		if (curNode.left != null)
		{
			int[] childRes = CountNodeTypes(curNode.left);
			totalRes[0] += childRes[0];
			totalRes[1] += childRes[1];
		}

		//Count the middle children if we have any.
		if (curNode.middle != null) {
			int[] childRes = CountNodeTypes(curNode.middle);
			totalRes[0] += childRes[0];
			totalRes[1] += childRes[1];
		}

		//Count the right children if we have any.
		if (curNode.right != null) {
			int[] childRes = CountNodeTypes(curNode.right);
			totalRes[0] += childRes[0];
			totalRes[1] += childRes[1];
		}

		return totalRes;
	}
	
	/**
	 * Gets the node with the specified key, or the node where the specified key should be.
	 * @param key The key to search for.
	 * @param startNode String node for our search.
	 * @param returnNullOnMissing If the key is missing in the tree, should return null or the node the key should be stored in.
	 * @return Returns a Node where the specified key is or should be.
	 */
	private Node getNode(K key, Node startNode, boolean returnNullOnMissing)
	{
		//If we should return null on a missing key then the branch we've just gone into will be null if it is where the key should be.
		if (returnNullOnMissing)
		{
			if(startNode == null)
				return null;
		}
		else //If we should find the node the key should be in, we need to check for an empty branch before going down, so we can return before that happens. 
		{
			//Doesn't matter what branch we check for nulls since we have a balanced tree, if any branch is null we have a leaf node.
			if (startNode.left == null)
				return startNode;
		}
		
		//If equal to our first value, this is the same for both TwoNodes and ThreeNodes.
		if (key.equals(startNode.keyvalues1.key))
			return startNode;
		
		//If smaller than the first value search left, this is the same for both TwoNodes and ThreeNodes. 
		if (key.compareTo(startNode.keyvalues1.key) < 0)
			return getNode(key, startNode.left, returnNullOnMissing);
		
		//TwoNode.
		if (startNode.keyvalues2 == null)
		{
			//Must be greater than, search middle cause that's the right child in two nodes.
			return getNode(key, startNode.middle, returnNullOnMissing); //Middle is right child for TwoNodes.
		}
		else //ThreeNode
		{
			//If equal to our second value.
			if (key.equals(startNode.keyvalues2.key))
				return startNode;
			
			//If in the middle, search middle child.
			if (key.compareTo(startNode.keyvalues1.key) > 0 && key.compareTo(startNode.keyvalues2.key) < 0)
				return getNode(key, startNode.middle, returnNullOnMissing);
			else //If greater than our second value, search right.
				return getNode(key, startNode.right, returnNullOnMissing);
		}	
	}
	
	/**
	 * Inserts a FourNode into the tree. If we try to merge with a three node we recursively try to go up the three until we can insert. 
	 * @param currentNode The node the value should be in.
	 * @param tmpFourNode The FourNode we are trying to insert.
	 */
	private void put4NodeInTree(Node currentNode, FourNode tmpFourNode)
	{
		//Split the FourNode into a TwoNode.	
		Node splitResult = Convert4to2(tmpFourNode);
		nodeCount++;
		
		//If we've worked our way up to the root, then we don't need to merge, just set the root to the split result.
		if (currentNode == root)
		{
			root = splitResult;
			nodeCount++;
			//Normally splitting produces two new children, and then merging will reduce that by one.
			//Since we are not merging now we need to count the split above one more time.  
		}
		else
		{
			Node parent = currentNode.parent;
		
			//Merge the splitResult with the parent.
			FourNode mergeResult = MergeNodes (parent, splitResult);
			
			//If the merge result is null the parent was a TwoNode, and we are done. It's inserted.
			//If not, we need to merge the new FourNode we have with the parent and repeat.
			if (mergeResult != null)
				put4NodeInTree(parent, mergeResult);
		}		
	}
	
	/**
	 * Splits a FourNode into a TwoNode.
	 * @param inNode The FourNode to split.
	 * @return Returns the root of the new TwoNode.
	 */
	private Node Convert4to2(FourNode inNode)
	{
		// Convert a FourNode that looks like this:
		//		
		//		(a, b, c)
		//		/  |  |	 \
		//	   /   |  |	  \
		//    1    2  3    4
		//
		//			 (b)
		//			/   \
		//	 	   /     \
		//	 	 (a)     (c)
		//   	/	\	/   \
		//     /	 \ /     \
		//    1      2 3     4
		
		//Create a new local root node, b, from the middle keyValue. 
		Node newRoot = new Node (inNode.keyvalues2);
		
		//New left, a, is the left child. New right, c, is the right child.
		Node newLeft = new Node (inNode.keyvalues1);
		Node newRight = new Node (inNode.keyvalues3);
	
		//Set the new children to the NewRoot.
		newRoot.left = newLeft;
		newRoot.middle = newRight;
		
		//Link these to the root node.
		newLeft.parent = newRoot;
		newRight.parent = newRoot;
		
		//Move branch 1, and relink its parent if we have such a branch.
		newLeft.left = inNode.left;
		
		if (newLeft.left != null)
			newLeft.left.parent = newLeft;
		
		//Move branch 2, and relink its parent if we have such a branch.
		newLeft.middle = inNode.middle;
		
		if (newLeft.middle != null)
			newLeft.middle.parent = newLeft;
			
		//Move branch 3, and relink its parent if we have such a branch.
		newRight.left = inNode.middle2;
		
		if (newRight.left != null)
			newRight.left.parent = newRight;
		
		//Move branch 4, and relink its parent if we have such a branch.
		newRight.middle = inNode.right;
		
		if(newRight.middle != null)
			newRight.middle.parent = newRight;
		
		return newRoot;
	}

	/**
	 * Traverses the tree in-order and adds the KeyValues to a List.
	 * @param curNode The current node we should traverse/add.
	 * @param treeItems List to add KeyValues to.
	 */
	private void traverseTree (Node curNode, List<KeyValuePair> treeItems)
	{
		//If leaf node.
		if (curNode.left == null)
		{
			//Add first value.
			treeItems.add(curNode.keyvalues1);
			
			//If leaf is ThreeNode, then add second value.
			if (curNode.keyvalues2 != null)
				treeItems.add(curNode.keyvalues2);
		}
		else if (curNode.keyvalues2 == null) //If TwoNode.
		{
			traverseTree(curNode.left, treeItems); //Add lesser values first.
			treeItems.add(curNode.keyvalues1); //Then this value.
			traverseTree(curNode.middle, treeItems); //And greater values.
		}
		else //If ThreeNode.
		{
			traverseTree(curNode.left, treeItems); //Lesser values.
			treeItems.add(curNode.keyvalues1); //Low value.
			traverseTree(curNode.middle, treeItems); //Middle values.
			treeItems.add(curNode.keyvalues2); //High value.
			traverseTree(curNode.right, treeItems); //Higher values.
		}
	}
	
	/**
	 * Merges the specified node with the specified tree node.
	 * @param treeNode The node in the tree we are going to merge with.
	 * @param separateNode TwoNode to merge into the tree.
	 * @return If merged with a ThreeNode we get a resultant FourNode as a result that needs to be merged again.
	 */
	private FourNode MergeNodes(Node treeNode, Node separateNode)
	{		
		//The separate node we are sending in is assumed to be a TwoNode.
		
		//Possible merge result.
		FourNode newFourNode = null;
		
		//If the node in the tree we are merging with is a TwoNode.
		if (treeNode.keyvalues2 == null)
		{
			//The thing we are merging is smaller than the treeNode's key.
			if(separateNode.keyvalues1.key.compareTo(treeNode.keyvalues1.key) <= -1)
			{
				//Move the key/values to the right and insert.
				treeNode.keyvalues2 = treeNode.keyvalues1;
				treeNode.keyvalues1 = separateNode.keyvalues1;
				
				//Move the children to the right and insert the separateNode's children into the tree node.
				treeNode.right = treeNode.middle;
				treeNode.middle = separateNode.middle; //Right child in the separateNode.
				treeNode.left = separateNode.left;
			}
			else if (separateNode.keyvalues1.key.compareTo(treeNode.keyvalues1.key) >= 1)
			{
				//Insert key/values.
				treeNode.keyvalues2 = separateNode.keyvalues1;
				
				//Insert the children.
				treeNode.right = separateNode.middle; //Right node in the separateNode.
				treeNode.middle = separateNode.left;
			}
			
			//Don't forget to relink the parent property after we've moved children around.
			separateNode.middle.parent = treeNode;
			separateNode.left.parent = treeNode;						
		}
		else //If the node in the tree we are merging with is a ThreeNode.
		{
			//If the key in the separate node is smaller than the three node's first key.
			if (separateNode.keyvalues1.key.compareTo(treeNode.keyvalues1.key) <= -1)
			{
				newFourNode = new FourNode(separateNode.keyvalues1, treeNode.keyvalues1, treeNode.keyvalues2);
				
				newFourNode.left = separateNode.left;
				newFourNode.middle = separateNode.middle;
				newFourNode.middle2 = treeNode.middle;
				newFourNode.right = treeNode.right;
			}
			else if (separateNode.keyvalues1.key.compareTo(treeNode.keyvalues1.key) > 0 && separateNode.keyvalues1.key.compareTo(treeNode.keyvalues2.key) < 0)
			{
				newFourNode = new FourNode(treeNode.keyvalues1, separateNode.keyvalues1, treeNode.keyvalues2);
				
				newFourNode.left = treeNode.left;
				newFourNode.middle = separateNode.left;
				newFourNode.middle2 = separateNode.middle;
				newFourNode.right = treeNode.right;
			}
			else //If not smaller or in the middle of our values it must be bigger.
			{
				newFourNode = new FourNode(treeNode.keyvalues1, treeNode.keyvalues2, separateNode.keyvalues1);
				
				newFourNode.left = treeNode.left;
				newFourNode.middle = treeNode.middle;
				newFourNode.middle2 = separateNode.left;
				newFourNode.right = separateNode.middle;
			}
			
			//Relink the children to our FourNode.
			newFourNode.left.parent = newFourNode;
			newFourNode.middle.parent = newFourNode;
			newFourNode.middle2.parent = newFourNode;
			newFourNode.right.parent = newFourNode;			
		}
		
		//If no new FourNode then this will be null. 
		return newFourNode;
	}

	/**
	 * Searches a list for the specified key.
	 * @param key The key to search for.
	 * @param listToSearch The list of KeyValues to search for.
	 * @return The index to the first (and only) occurrence of the key in the list.
	 */
	private int indexOfKeyInList(K key, List<KeyValuePair> listToSearch)
	{
		for (int i = 0; i < listToSearch.size(); i++)
		{
			KeyValuePair element = listToSearch.get(i);

			if (element !=null && element.equals(new KeyValuePair (key, null)))
				return i;
		}
		return -1; //Not in the list.
	} 
	
	public class KeyValuePair {

		public K key;
		public V value;
		
		public KeyValuePair(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		public boolean equals(Object o)
		{
			//Assume we are comparing to another KeyValuePair with the same K, V.
			KeyValuePair obj = (KeyValuePair) o;
			
			//KeyValuePairs are equal if keys are equal.
			return this.key.equals(obj.key);
		}
		
	}

	
}
