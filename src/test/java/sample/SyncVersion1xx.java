package sample;

import com.fasterxml.jackson.core.JsonProcessingException;

public class SyncVersion1xx extends VersionData {
	
	private String version = "1.X.X";
	
	public SyncVersion1xx(String data) throws JsonProcessingException {
		super.setVersion(version);
		super.setData(this.update(data));
	}
	
	private String update(String data) {
		// TODO process to next version data
		return data;
	}
}
