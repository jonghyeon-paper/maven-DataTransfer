package data.transfer.archetype;

import data.transfer.exception.DataTransferException;

/**
 * 데이터를 감싸는 구조체
 * @author jonghyeon
 *
 */
public interface DataWrapper {
	
	/**
	 * 현재버전의 구조에 맞게 버전 및 데이터를 업데이트
	 * @throws DataTransferException 
	 */
	void update() throws DataTransferException;
}
