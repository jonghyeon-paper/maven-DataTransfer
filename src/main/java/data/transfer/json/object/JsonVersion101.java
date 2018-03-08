package data.transfer.json.object;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.transfer.exception.DataTransferException;
import data.transfer.json.JsonDataWrapper;

public final class JsonVersion101 extends JsonDataWrapper {
	
	private String thisVersion = "1.0.1";
	
	public JsonVersion101() {
		super.setVersion(thisVersion);
	}
	
	public JsonVersion101(JsonDataWrapper previousVersion) {
		super.setVersion(previousVersion.getVersion());
		super.setData(previousVersion.getData());
	}
	
	/**
	 * 데이터 업데이트
	 * name 프로퍼티의 '레벨' 값을 > 'Level' 로 변경
	 */
	@Override
	public void update() throws DataTransferException {
		super.setVersion(thisVersion);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			// convert JSON string to Map
			Map<String, Object> o1Map = mapper.readValue(super.getData(), new TypeReference<Map<String, Object>>(){});
			o1Map.put("name", o1Map.get("name").toString().replaceAll("레벨", "Level"));
			
			Map<String, Object> o2Map = (Map<String, Object>) o1Map.get("object2");
			o2Map.put("name", o2Map.get("name").toString().replaceAll("레벨", "Level"));
			
			List<Map<String, Object>> o3List = (List<Map<String, Object>>) o1Map.get("object3");
			for (Map<String, Object> item : o3List) {
				item.put("name", item.get("name").toString().replaceAll("레벨", "Level"));
			}
			
			super.setData(mapper.writeValueAsString(o1Map));
		} catch (IOException e) {
			throw new DataTransferException("업데이트중 오류가 발생했습니다.", e);
		}
	}
}