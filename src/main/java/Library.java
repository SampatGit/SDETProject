import java.util.HashMap;

import utils.DataReader;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Library {
    public static void main(String[] args) throws Exception {
    	DataReader reader = new DataReader();
    	System.out.println(reader.getData("WebUrl"));
    	HashMap<Integer, String> map = new HashMap<>();
    	map.put(1, "Samapt");
    	map.put(2, "Rajesh");
    	System.out.println(map.get(1));
    
    }
}
