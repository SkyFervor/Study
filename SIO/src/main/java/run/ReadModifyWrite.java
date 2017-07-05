package run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadModifyWrite {
	public static void main(String[] args) throws IOException {
		String inputPath = "D:\\1.sql";
		String outputPath = "D:\\2.sql";

		String prefix = "INSERT INTO Region (RegionID, ParentRegionID, EnumDataEntityStatus, CreateTime, LastUpdateTime, LastSyncTime,EnumRegionLevel, IsActive, Longitude, Latitude, EnumMapType, Pinyin, ShortPinyin, CN, EN, BusinessAreaID, JP, KR, IsOversea) VALUES ('";
		String suffix = "', 1);";

		String line = null;
		try (BufferedReader br = new BufferedReader(new FileReader(inputPath)); BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));) {
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty())
					bw.write(prefix + line + suffix + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
