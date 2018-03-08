package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import sample.data.Level1;
import sample.data.Level2;
import sample.data.Level3;

public class Sample1 {
	
	public static final String PRESENT_VERSION = "4.0.0";
	public static final String PAST_4_X_X_VERSION = "4.X.X";
	public static final String PAST_3_X_X_VERSION = "3.X.X";
	public static final String PAST_3_3_X_VERSION = "3.3.X";
	public static final String PAST_2_X_X_VERSION = "2.X.X";
	public static final String PAST_1_X_X_VERSION = "1.X.X";
	
	private static Level1 getSampleData() {
		List<Level3> l3List = new ArrayList<>();
		l3List.add(new Level3(3f, "레벨3"));
		l3List.add(new Level3(4f, "레벨3-1"));
		
		Level1 l1 = new Level1("L1", "레벨1");
		l1.setLevel2(new Level2(2, "레벨2"));
		l1.setLevel3List(l3List);
		return l1;
	}
	
	private static VersionData updateData(VersionData readData) throws IOException {
		if (PRESENT_VERSION.equals(readData.getVersion())) {
			return readData;
		}
		
		if (PAST_1_X_X_VERSION.equals(readData.getVersion())) {
			return Sample1.updateData(new SyncVersion2xx(readData.getData()));
		} else if (PAST_2_X_X_VERSION.equals(readData.getVersion())) {
			return Sample1.updateData(new SyncVersion3xx(readData.getData()));
		} else if (PAST_3_3_X_VERSION.equals(readData.getVersion())) {
			return Sample1.updateData(new SyncVersion4xx(readData.getData()));
		} else if (PAST_3_X_X_VERSION.equals(readData.getVersion())) {
			return Sample1.updateData(new SyncVersion33x(readData.getData()));
		}
		
		throw new RuntimeException("No matching version information found.");
	}
	
	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		VersionData vd = new VersionData();
		vd.setVersion("3.3.X");
		vd.setData("{\"id\":\"L1\",\"name\":\"레벨1\",\"level2\":{\"id\":2,\"name\":\"레벨2\"},\"level3List\":[{\"id\":3.0,\"name\":\"레벨3\"},{\"id\":4.0,\"name\":\"레벨3-1\"}]}");
		
		// this is error. mismatch property name
//		Level1 l1pre = mapper.readValue(vd.getData(), Level1.class);
//		System.out.println(l1pre.toString());
//		System.out.println(mapper.writeValueAsString(l1pre));
		
		VersionData finalData = Sample1.updateData(vd);
		System.out.println(finalData.toString());
		
		Level1 l1after = mapper.readValue(finalData.getData(), Level1.class);
		System.out.println(l1after.toString());
	}
}