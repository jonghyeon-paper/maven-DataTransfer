package sample;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VersionData {
	private String version;
	private String data;
	
	private ObjectMapper mapper;
	
	public VersionData() {
		mapper = new ObjectMapper();
	}
	
	public String getVersion() {
		return version;
	}
	
	@JsonIgnore
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getData() {
		return data;
	}
	
	@JsonIgnore
	public void setData(Object objectData) throws JsonProcessingException {
		data = mapper.writeValueAsString(objectData);
	}
	
	@JsonIgnore
	public void setData(String stringData) throws JsonProcessingException {
		data = stringData;
	}
	
	@Override
	public String toString() {
		return "VersionData [version=" + version + ", data=" + data + "]";
	}
}