package data.transfer.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import data.transfer.exception.DataTransferException;
import data.transfer.json.sample.Object1;

public class Test1 {
	
	/*
	 * 버전 프로퍼티가 없는 데이터 읽기
	 */
	@Test
	public void T1() throws JsonProcessingException, DataTransferException {
		//JsonTransfer jt = new JsonTransfer("");
		//JsonTransfer jt = new JsonTransfer("1.0.0");
		//JsonTransfer jt = new JsonTransfer("1.0.1");
		//JsonTransfer jt = new JsonTransfer("1.1.0");
		JsonTransfer jt = new JsonTransfer("2.0.0");
		Object1 result = jt.toInstanceObject(getSampleJsonDataString(), Object1.class);
		System.out.println(result.toString());
	}
	
	/*
	 * 버전 프로퍼티가 있는 데이터 읽기
	 */
	@Test
	public void T2() throws JsonProcessingException, DataTransferException {
		//JsonTransfer jt = new JsonTransfer("1.0.0");
		//JsonTransfer jt = new JsonTransfer("1.0.1");
		//JsonTransfer jt = new JsonTransfer("1.1.0");
		JsonTransfer jt = new JsonTransfer("2.0.0");
		Object1 result = jt.toInstanceObject(getSampleJsonFullDataString(), Object1.class);
		System.out.println(result.toString());
	}
	
	public static String getSampleJsonDataString() throws JsonProcessingException {
//		List<Object3> o3List = new ArrayList<>();
//		o3List.add(new Object3(3f, "레벨3"));
//		o3List.add(new Object3(4f, "레벨3-1"));
//		
//		Object1 o1 = new Object1("L1", "레벨1");
//		o1.setObject2(new Object2(2, "레벨2"));
//		o1.setObject3(o3List);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		return mapper.writeValueAsString(o1);
		
		File inFile = new File("D:\\ex-data\\project-zero\\maven-DataTransfer\\src\\test\\java\\data\\transfer\\json\\sample\\data");
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(inFile));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) try {br.close(); } catch (IOException e) {}
		}
		return sb.toString();
	}
	
	public static String getSampleJsonFullDataString() throws JsonProcessingException {
		File inFile = new File("D:\\ex-data\\project-zero\\maven-DataTransfer\\src\\test\\java\\data\\transfer\\json\\sample\\fulldata");
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(inFile));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) try {br.close(); } catch (IOException e) {}
		}
		return sb.toString();
	}
}
