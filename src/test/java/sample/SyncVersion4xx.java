package sample;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SyncVersion4xx extends VersionData {

	private String version = "4.0.0";
	
	public SyncVersion4xx(String data) throws IOException {
		super.setVersion(version);
		super.setData(this.update(data));
	}
	
	private String update(String data) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		// convert JSON string to Map
		Map<String, Object> map = mapper.readValue(data, new TypeReference<Map<String, Object>>(){});
		
		List<Map<String, Object>> level3list = (List<Map<String, Object>>) map.get("level3List");
		for (Map<String, Object> item : level3list) {
			item.put("fullname", item.get("name"));
			item.remove("name");
		}
		
		return mapper.writeValueAsString(map);
	}
}
