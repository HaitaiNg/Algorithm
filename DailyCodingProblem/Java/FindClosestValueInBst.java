// Average Run Time O(log(n)) || O(1) space
// Worst case Run Time O(n) || O(1) space
class Program {
    public static int findClosestValueInBst(BST tree, int target) {
	return findClosestValueInBstHelper(tree, target, 1000000000); 
    }
    
    public static int findClosestValueInBstHelper(BST tree, int target, int closest)
    {
	BST currentNode = tree; 
	while(currentNode != null)
	    {
		if ((Math.abs(target - closest)) > (Math.abs(target - currentNode.value)))
		    {
			closest = currentNode.value;
		    }
		if (target < currentNode.value)
		    {
			currentNode = currentNode.left;
		    }
		else if (target > currentNode.value)
		    {
			currentNode = currentNode.right; 
		    }
		else
		    {
			break; 
		    }
	    }
	return closest; 
    }
    
    static class BST {
	public int value;
	public BST left;
	public BST right;

	public BST(int value) {
	    this.value = value;
	}
    }
}

/////// Test cases 

// Add, edit, or remove tests in this file.
// Treat it as your playground!

class ProgramTest {
    public TestBST test;

    public ProgramTest() {
	this.test = new TestBST(100);
	this.test.insert(5).insert(15).insert(5).insert(2).insert(1).insert(22).insert(1)
	    .insert(1).insert(3).insert(1).insert(1).insert(502).insert(55000).insert(204)
	    .insert(205).insert(207).insert(206).insert(208).insert(203).insert(-51)
	    .insert(-403).insert(1001).insert(57).insert(60).insert(4500);
    }

  @Test
      public void TestCase1() {
      Utils.assertTrue(Program.findClosestValueInBst(this.test, 100) == 100);
  }

  @Test
      public void TestCase2() {
      Utils.assertTrue(Program.findClosestValueInBst(this.test, 208) == 208);
  }

  @Test
      public void TestCase3() {
      Utils.assertTrue(Program.findClosestValueInBst(this.test, 4500) == 4500);
  }

  @Test
      public void TestCase4() {
      Utils.assertTrue(Program.findClosestValueInBst(this.test, 4501) == 4500);
  }

  @Test
      public void TestCase5() {
      Utils.assertTrue(Program.findClosestValueInBst(this.test, -70) == -51);
  }

  @Test
      public void TestCase6() {
      Utils.assertTrue(Program.findClosestValueInBst(this.test, 2000) == 1001);
  }

  @Test
      public void TestCase7() {
      Utils.assertTrue(Program.findClosestValueInBst(this.test, 6) == 5);
  }

  @Test
      public void TestCase8() {
      Utils.assertTrue(Program.findClosestValueInBst(this.test, 30000) == 55000);
  }

  @Test
      public void TestCase9() {
      Utils.assertTrue(Program.findClosestValueInBst(this.test, -1) == 1);
  }

  @Test
      public void TestCase10() {
      Utils.assertTrue(Program.findClosestValueInBst(this.test, 29751) == 55000);
  }

  @Test
      public void TestCase11() {
      Utils.assertTrue(Program.findClosestValueInBst(this.test, 29749) == 4500);
  }

    class TestBST extends Program.BST {
	public TestBST(int value) {
	    super(value);
	}

	public TestBST insert(int value) {
	    Program.BST current = null;
	    if (value < this.value) {
		if (this.left == null) {
		    Program.BST newBST = new Program.BST(value);
		    this.left = newBST;
		    return this;
		} else {
		    current = this.left;
		}
	    } else {
		if (right == null) {
		    Program.BST newBST = new Program.BST(value);
		    this.right = newBST;
		    return this;
		} else {
		    current = this.right;
		}
	    }
	    while (true) {
		if (value < current.value) {
		    if (current.left == null) {
			Program.BST newBST = new Program.BST(value);
			current.left = newBST;
			return this;
		    } else {
			current = current.left;
		    }
		} else {
		    if (current.right == null) {
			Program.BST newBST = new Program.BST(value);
			current.right = newBST;
			return this;
		    } else {
			current = current.right;
		    }
		}
	    }
	}
    }
}

