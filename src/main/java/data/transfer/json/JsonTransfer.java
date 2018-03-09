package data.transfer.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.transfer.archetype.ObjectTransfer;
import data.transfer.exception.DataTransferException;
import data.transfer.json.object.JsonInitialData;
import data.transfer.json.object.JsonVersion100;
import data.transfer.json.object.JsonVersion101;
import data.transfer.json.object.JsonVersion110;
import data.transfer.json.object.JsonVersion200;

public class JsonTransfer implements ObjectTransfer {
	
	private String presentVersion;
	
	private ObjectMapper mapper;
	
	public JsonTransfer(String presentVersion) {
		this.presentVersion = presentVersion;
		mapper = new ObjectMapper();
	}
	
	@Override
	public <T> T toInstanceObject(Object data, Class<T> clas) throws DataTransferException {
		JsonInitialData initialData = null;
		try {
			initialData = mapper.readValue((String) data, JsonInitialData.class);
		} catch (IOException e) {
			// JsonDataWrapper를 상속받은 객체정보가 아니다. 때문에 데이터를 JsonDataWrapper에 맞게 변환해주어야 한다.
			initialData = new JsonInitialData();
			initialData.setData((String) data);
		}
		
		JsonDataWrapper presentData = updateData(initialData);
		
		T result = null;
		try {
			result = mapper.readValue(presentData.getData(), clas);
		} catch (IOException e) {
			throw new DataTransferException("데이터 변환에 실패하였습니다.", e);
		}
		
		return result;
	}
	
	private JsonDataWrapper updateData(JsonDataWrapper pastData) throws DataTransferException {
		if (pastData.getVersion() != null && presentVersion.equals(pastData.getVersion())) {
			return pastData;
		}
		
		JsonDataWrapper newVersion = null;
		if (pastData.getVersion() == null || "".equals(pastData.getVersion())) {
			newVersion = new JsonVersion100(pastData);
		} else if ("1.0.0".equals(pastData.getVersion())) {
			newVersion = new JsonVersion101(pastData);
		} else if ("1.0.1".equals(pastData.getVersion())) {
			newVersion = new JsonVersion110(pastData);
		} else if ("1.1.0".equals(pastData.getVersion())) {
			newVersion = new JsonVersion200(pastData);
		} else if ("2.0.0".equals(pastData.getVersion())) {
			return pastData;
		} else {
			throw new DataTransferException("일치하는 버전을 찾을 수 없습니다.");
		}
		newVersion.update();
		return updateData(newVersion);
	}
	
	@Override
	public String toSerializationObject(Object object) throws DataTransferException {
		try {
			JsonInitialData presentData = new JsonInitialData();
			presentData.setVersion(presentVersion);
			presentData.setData(mapper.writeValueAsString(object));
			
			return mapper.writeValueAsString(presentData);
		} catch (JsonProcessingException e) {
			throw new DataTransferException("데이터 변환에 실패하였습니다.", e);
		}
	}
}
