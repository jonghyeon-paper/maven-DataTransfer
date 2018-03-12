package data.transfer.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

public class SampleData {
	
	public static String getVersionNoneJsonDataString() throws JsonProcessingException {
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
		
		File inFile = new File("D:\\ex-data\\project-zero\\maven-DataTransfer\\src\\test\\java\\data\\transfer\\json\\sample\\version-none");
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
	
	public static String getVersion100JsonDataString() throws JsonProcessingException {
		File inFile = new File("D:\\ex-data\\project-zero\\maven-DataTransfer\\src\\test\\java\\data\\transfer\\json\\sample\\version-100");
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
	
	public static String getVersion101JsonDataString() throws JsonProcessingException {
		File inFile = new File("D:\\ex-data\\project-zero\\maven-DataTransfer\\src\\test\\java\\data\\transfer\\json\\sample\\version-101");
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
	
	public static String getVersion110JsonDataString() throws JsonProcessingException {
		File inFile = new File("D:\\ex-data\\project-zero\\maven-DataTransfer\\src\\test\\java\\data\\transfer\\json\\sample\\version-110");
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
	
	public static String getVersion200JsonDataString() throws JsonProcessingException {
		File inFile = new File("D:\\ex-data\\project-zero\\maven-DataTransfer\\src\\test\\java\\data\\transfer\\json\\sample\\version-200");
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
