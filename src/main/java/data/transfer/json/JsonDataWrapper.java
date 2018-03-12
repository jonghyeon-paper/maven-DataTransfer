package data.transfer.json;

import data.transfer.archetype.DataWrapper;

/**
 * JSON 타입의 데이터를 감싸는 구조체
 * @author jonghyeon
 *
 */
public abstract class JsonDataWrapper implements DataWrapper {
	
	/**
	 * 버전정보는 3단계로 되어있다.
	 * ex) 2.0.3 (앞쪽부터 첫 번째)
	 * 첫 번째는 객체 또는 객체구조가 변화가 있을 때 변경한다.
	 * 두 번째는 객체의 프로퍼티에 변화가 있을 때 변경된다.
	 * 세 번째는 객체의 데이터에 변화가 있을 때 변경된다. 
	 */
	private String version;
	private String data;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonDataWrapper [version=" + version + ", data=" + data + "]";
	}
}
