import java.util.*; 


class Program {
  public static String caesarCypherEncryptor(String str, int key) {
		
		HashMap<String, Integer> characterAndPositionMap = new HashMap<String, Integer>(); 
		characterAndPositionMap.put("a", 1);
		characterAndPositionMap.put("b", 2);
		characterAndPositionMap.put("c", 3);
		characterAndPositionMap.put("d", 4);
		characterAndPositionMap.put("e", 5);
		characterAndPositionMap.put("f", 6);
		characterAndPositionMap.put("g", 7);
		characterAndPositionMap.put("h", 8);
		characterAndPositionMap.put("i", 9);
		characterAndPositionMap.put("j", 10);
		characterAndPositionMap.put("k", 11);
		characterAndPositionMap.put("l", 12);
		characterAndPositionMap.put("m", 13);
		characterAndPositionMap.put("n", 14);
		characterAndPositionMap.put("o", 15);
		characterAndPositionMap.put("p", 16);
		characterAndPositionMap.put("q", 17);
		characterAndPositionMap.put("r", 18);
		characterAndPositionMap.put("s", 19);
		characterAndPositionMap.put("t", 20);
		characterAndPositionMap.put("u", 21);
		characterAndPositionMap.put("v", 22);
		characterAndPositionMap.put("w", 23);
		characterAndPositionMap.put("x", 24);
		characterAndPositionMap.put("y", 25);
		characterAndPositionMap.put("z", 26);
		
				HashMap<Integer, String> PositionAndCharacterMap = new HashMap<Integer, String>(); 
		PositionAndCharacterMap.put(1,"a");
		PositionAndCharacterMap.put(2,"b");
		PositionAndCharacterMap.put(3,"c");
		PositionAndCharacterMap.put(4,"d");
		PositionAndCharacterMap.put(5,"e");
		PositionAndCharacterMap.put(6,"f");
		PositionAndCharacterMap.put(7,"g");
		PositionAndCharacterMap.put(8,"h");
		PositionAndCharacterMap.put(9,"i");
		PositionAndCharacterMap.put(10,"j");
		PositionAndCharacterMap.put(11,"k");
		PositionAndCharacterMap.put(12,"l");
		PositionAndCharacterMap.put(13,"m");
		PositionAndCharacterMap.put(14, "n");
		PositionAndCharacterMap.put(15,"o");
		PositionAndCharacterMap.put(16,"p");
		PositionAndCharacterMap.put(17,"q");
		PositionAndCharacterMap.put(18,"r");
		PositionAndCharacterMap.put(19,"s");
		PositionAndCharacterMap.put(20,"t");
		PositionAndCharacterMap.put(21,"u");
		PositionAndCharacterMap.put(22, "v");
		PositionAndCharacterMap.put(23, "w");
		PositionAndCharacterMap.put(24, "x");
		PositionAndCharacterMap.put(25, "y");
		PositionAndCharacterMap.put(26, "z");
		
		
		String returnString = ""; 
		for(int i = 0; i < str.length(); i++)
		{
			int index = characterAndPositionMap.get(Character.toString(str.charAt(i))); 
			int newStartIndex = index + key; 
			if(newStartIndex > 26)
			{
				newStartIndex = newStartIndex % 26; 
			}
			returnString += (PositionAndCharacterMap.get(newStartIndex)); 
		}
		return returnString; 
  }
}

