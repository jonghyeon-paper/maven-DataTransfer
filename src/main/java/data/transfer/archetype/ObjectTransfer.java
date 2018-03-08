package data.transfer.archetype;

import data.transfer.exception.DataTransferException;

public interface ObjectTransfer {
	
	/**
	 * 데이터를 객체정보를 기준으로 인스턴스화 한다
	 * @param data
	 * @param cls
	 * @return
	 * @throws DataTransferException
	 */
	<T> T toInstanceObject(Object data, Class<T> cls) throws DataTransferException;
	
	/**
	 * 객체를 직렬화한다
	 * @param object
	 * @return
	 * @throws DataTransferException
	 */
	Object toSerializationObject(Object object) throws DataTransferException;
}
