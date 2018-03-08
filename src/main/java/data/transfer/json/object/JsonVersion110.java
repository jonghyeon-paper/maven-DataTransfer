package data.transfer.json.object;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.transfer.exception.DataTransferException;
import data.transfer.json.JsonDataWrapper;

public final class JsonVersion110 extends JsonDataWrapper {
	
	private String thisVersion = "1.1.0";
	
	public JsonVersion110() {
		super.setVersion(thisVersion);
	}
	
	public JsonVersion110(JsonDataWrapper previousVersion) {
		super.setVersion(previousVersion.getVersion());
		super.setData(previousVersion.getData());
	}
	
	/**
	 * 프로퍼티 변경
	 * object3 의 name 프로퍼티를 fullname으로 변경
	 */
	@Override
	public void update() throws DataTransferException {
		super.setVersion(thisVersion);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			// convert JSON string to Map
			Map<String, Object> o1Map = mapper.readValue(super.getData(), new TypeReference<Map<String, Object>>(){});
			
			List<Map<String, Object>> o3List = (List<Map<String, Object>>) o1Map.get("object3");
			for (Map<String, Object> item : o3List) {
				item.put("fullname", item.get("name"));
				item.remove("name");
			}
			
			super.setData(mapper.writeValueAsString(o1Map));
		} catch (IOException e) {
			throw new DataTransferException("업데이트중 오류가 발생했습니다.", e);
		}
	}
}
