package data.transfer.json.object;

import data.transfer.json.JsonDataWrapper;

public final class JsonVersion100 extends JsonDataWrapper {
	
	private String thisVersion = "1.0.0";
	
	public JsonVersion100() {
		super.setVersion(thisVersion);
	}
	
	public JsonVersion100(JsonDataWrapper previousVersion) {
		super.setVersion(previousVersion.getVersion());
		super.setData(previousVersion.getData());
	}
	
	@Override
	public void update() {
		super.setVersion(thisVersion);
		// TODO something...
	}
}
