import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();

		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "3");
		map.put("d", "4");
		
		System.out.println(JSONObject.fromObject(map).toString());
		
		
	}

}
