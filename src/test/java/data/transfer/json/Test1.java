package data.transfer.json;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import data.transfer.exception.DataTransferException;
import data.transfer.json.sample.Object1;

public class Test1 extends SampleData {
	
	/*
	 * 버전 정보가 없는 데이터 읽기
	 */
	@Test
	public void T1() throws JsonProcessingException, DataTransferException {
		//JsonTransfer jt = new JsonTransfer("1.0.0");
		//JsonTransfer jt = new JsonTransfer("1.0.1");
		//JsonTransfer jt = new JsonTransfer("1.1.0");
		JsonTransfer jt = new JsonTransfer("2.0.0");
		Object1 result = jt.toInstanceObject(super.getVersionNoneJsonDataString(), Object1.class);
		System.out.println(result.toString());
		System.out.println(jt.toSerializationObject(result));
	}
	
	@Test
	public void T2() throws JsonProcessingException, DataTransferException {
		//JsonTransfer jt = new JsonTransfer("1.0.0");
		//JsonTransfer jt = new JsonTransfer("1.0.1");
		//JsonTransfer jt = new JsonTransfer("1.1.0");
		JsonTransfer jt = new JsonTransfer("2.0.0");
		Object1 result = jt.toInstanceObject(super.getVersion100JsonDataString(), Object1.class);
		System.out.println(result.toString());
		System.out.println(jt.toSerializationObject(result));
	}
	
	@Test
	public void T3() throws JsonProcessingException, DataTransferException {
		//JsonTransfer jt = new JsonTransfer("1.0.0");
		//JsonTransfer jt = new JsonTransfer("1.0.1");
		//JsonTransfer jt = new JsonTransfer("1.1.0");
		JsonTransfer jt = new JsonTransfer("2.0.0");
		Object1 result = jt.toInstanceObject(super.getVersion101JsonDataString(), Object1.class);
		System.out.println(result.toString());
		System.out.println(jt.toSerializationObject(result));
	}
	
	@Test
	public void T4() throws JsonProcessingException, DataTransferException {
		//JsonTransfer jt = new JsonTransfer("1.0.0");
		//JsonTransfer jt = new JsonTransfer("1.0.1");
		//JsonTransfer jt = new JsonTransfer("1.1.0");
		JsonTransfer jt = new JsonTransfer("2.0.0");
		Object1 result = jt.toInstanceObject(super.getVersion110JsonDataString(), Object1.class);
		System.out.println(result.toString());
		System.out.println(jt.toSerializationObject(result));
	}
	
	@Test
	public void T5() throws JsonProcessingException, DataTransferException {
		//JsonTransfer jt = new JsonTransfer("1.0.0");
		//JsonTransfer jt = new JsonTransfer("1.0.1");
		//JsonTransfer jt = new JsonTransfer("1.1.0");
		JsonTransfer jt = new JsonTransfer("2.0.0");
		Object1 result = jt.toInstanceObject(super.getVersion200JsonDataString(), Object1.class);
		System.out.println(result.toString());
		System.out.println(jt.toSerializationObject(result));
	}
}
