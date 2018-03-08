package data.transfer.json.object;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.transfer.exception.DataTransferException;
import data.transfer.json.JsonDataWrapper;

public class JsonVersion200 extends JsonDataWrapper {
	
	private String thisVersion = "2.0.0";
	
	public JsonVersion200() {
		super.setVersion(thisVersion);
	}
	
	public JsonVersion200(JsonDataWrapper previousVersion) {
		super.setVersion(previousVersion.getVersion());
		super.setData(previousVersion.getData());
	}
	
	/**
	 * 객체 구조 변경
	 * Object3 대신 Object4를 사용
	 * Object4 기본값 적용
	 */
	@Override
	public void update() throws DataTransferException {
		super.setVersion(thisVersion);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			// convert JSON string to Map
			Map<String, Object> o1Map = mapper.readValue(super.getData(), new TypeReference<Map<String, Object>>(){});
			
			List<Map<String, Object>> o3List = (List<Map<String, Object>>) o1Map.get("object3");
			
			List<Map<String, Object>> o4List = new ArrayList<>();
			for (Map<String, Object> item : o3List) {
				Map<String, Object> newItem =  new HashMap<>();
				String[] nameArray = item.get("fullname").toString().split("-");
				newItem.put("name1", nameArray[0]);
				newItem.put("name2", nameArray.length == 2 ? nameArray[1] : "empty");
				o4List.add(newItem);
			}
			
			o1Map.put("object4", o4List);
			o1Map.remove("object3");
			
			super.setData(mapper.writeValueAsString(o1Map));
		} catch (IOException e) {
			throw new DataTransferException("업데이트중 오류가 발생했습니다.", e);
		}
	}

}
