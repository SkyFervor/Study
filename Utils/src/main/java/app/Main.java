package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
	public static final String intputPath = "D:\\1.sql";
	public static final String originDB = "[dbo]";

	public static final String outputPath = "D:\\2.sql";
	public static final String newDB = "skyfervorConfig";

	public static final Map<String, Table> tableMap = new HashMap<>();

	static {
		Map<String, String> map = new HashMap<>();
		
		/*
		map.put("CountryCodeID", "CountryCodeId");
		map.put("CountryID", "CountryId");
		map.put("Code", "Code");
		tableMap.put("[CountryCode]", new Table("CountryCode", map, "CountryCodeID"));
		*/

		//tableMap.put("[EnumResource]", "HouseUnitEnum");

		map = new HashMap<>();
		map.put("FeatureTagID", "FeatureTagId");
		//map.put("FeatureTagGroupID", "FeatureTagGroupId");
		//map.put("EnumDataEntityStatus", "EnumDataEntityStatus");
		//map.put("IsActive", "IsActive");
		map.put("KR", "KR");
		map.put("KRComment", "KRComment");
		//map.put("CN", "CN");
		tableMap.put("[FeatureTag]", new Table("FeatureTag", map, "FeatureTagID"));

		map = new HashMap<>();
		map.put("FeatureTagGroupID", "FeatureTagGroupId");
		//map.put("EnumFeatureTagGroupType", "EnumFeatureTagGroupType");
		//map.put("EnumDataEntityStatus", "EnumDataEntityStatus");
		map.put("KR", "KR");
		map.put("KRComment", "KRComment");
		//map.put("CN", "CN");
		tableMap.put("[FeatureTagGroup]", new Table("FeatureTagGroup", map, "FeatureTagGroupID"));

		map = new HashMap<>();
		map.put("GeoPositionID", "GeoPositionId");
		//map.put("EnumDataEntityStatus", "EnumDataEntityStatus");
		//map.put("ParentID", "ParentId");
		//map.put("DestinationRegionID", "DestinationId");
		//map.put("EnumGeoPositionType", "EnumGeoPositionType");
		//map.put("IsActive", "IsActive");
		map.put("KR", "KR");
		//map.put("CN", "CN");
		tableMap.put("[GeoPosition]", new Table("GeoPosition", map, "GeoPositionID"));

		//tableMap.put("[MainBusinessArea]", null);

		map = new HashMap<>();
		map.put("RegionID", "RegionId");
		//map.put("ParentRegionID", "ParentRegionId");
		//map.put("EnumDataEntityStatus", "EnumDataEntityStatus");
		//map.put("EnumRegionLevel", "EnumRegionLevel");
		//map.put("IsActive", "IsActive");
		//map.put("EnumMapType", "EnumMapType");
		//map.put("BusinessAreaID", "BusinessAreaId");
		map.put("KR", "KR");
		//map.put("CN", "CN");
		tableMap.put("[Region]", new Table("Region", map, "RegionID"));

		//tableMap.put("[UnitAmenityCategory]", null);

		map = new HashMap<>();
		map.put("UnitAmenityGoodsID", "UnitAmenityGoodsId");
		//map.put("EnumUnitAmenity", "EnumUnitAmenity");
		//map.put("ExtraCount", "ExtraCount");
		//map.put("EnumDataEntityStatus", "EnumDataEntityStatus");
		//map.put("UnitAmenityCategoryID", "UnitAmenityCategoryId");
		map.put("KR", "KR");
		//map.put("CN", "CN");
		tableMap.put("[UnitAmenityGoods]", new Table("UnitAmenityGoods", map, "UnitAmenityGoodsID"));

		map = new HashMap<>();
		map.put("UnitAmenityGoodsSpecID", "UnitAmenityGoodsSpecId");
		//map.put("UnitAmenityGoodsID", "UnitAmenityGoodsId");
		//map.put("EnumDataEntityStatus", "EnumDataEntityStatus");
		map.put("KR", "KR");
		//map.put("CN", "CN");
		tableMap.put("[UnitAmenityGoodsSpec]", new Table("UnitAmenityGoodsSpec", map, "UnitAmenityGoodsSpecID"));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(intputPath));
		input(br);
		br.close();
	}

	private static void input(BufferedReader br) throws IOException {
		br.read();
		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.isEmpty() || line.startsWith("USE") || line.startsWith("SET") || line.startsWith("GO"))
				continue;

			String s = line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("GO"))
					break;
				s += line;
			}
			String sql = insertToUpdate(s);
			if (sql != null)
				output(sql);
		}
	}

	private static String insertToUpdate(String s) {
		String operator = s.substring(0, s.indexOf(" "));
		String backfard = s.substring(s.indexOf(" ") + 1);

		String[] dbtable = backfard.substring(0, backfard.indexOf(" ")).split("\\.");
		backfard = backfard.substring(backfard.indexOf(" ") + 1);
		String db = dbtable[0];
		if (!originDB.equals(db))
			return null;

		String table = dbtable[1];
		Table newTable = tableMap.get(table);
		if (newTable == null)
			return null;

		List<String> columnList = Collections.emptyList();
		if (backfard.startsWith("(")) {
			columnList = processColumns(backfard.substring(0, backfard.indexOf(")")));
			backfard = backfard.substring(backfard.indexOf(")") + 1);
		}

		String values = backfard.trim().substring(6);
		List<String> valueList = processValue(values);

		return createSQL(newTable, columnList, valueList);
	}

	private static List<String> processColumns(String s) {
		String[] columns = s.substring(1).split(", ");
		List<String> list = new LinkedList<>();
		for (String column : columns) {
			list.add(column.substring(1, column.length() - 1));
		}
		return list;
	}

	private static List<String> processValue(String s) {
		s = s.trim();
		if (s.startsWith("(")) {
			s = s.substring(1);
			s = s.substring(0, s.length() - 1);
		}

		List<String> list = new LinkedList<>();
		while (!s.isEmpty()) {
			s = s.trim();
			if (s.startsWith(","))
				s = s.substring(1);
			s = s.trim();

			if (s.startsWith("'")) {
				list.add(s.substring(0, s.indexOf("'")));
				s = s.substring(1);
				s = s.substring(s.indexOf("'") + 1);
				continue;
			} else if (s.startsWith("CAST(")) {
				s = s.substring(5);
				if (s.startsWith("N'")) {
					s = s.substring(2);
					list.add("'" + s.substring(0, s.indexOf("'") + 1));
					s = s.substring(s.indexOf("'") + 1);
				} else if (s.startsWith("'")) {
					list.add(s.substring(0, s.indexOf("'")));
					s = s.substring(1);
					s = s.substring(s.indexOf("'") + 1);
				}
				s = s.substring(s.indexOf(")") + 1);
				continue;
			} else if (s.startsWith("N'")) {
				s = s.substring(2);
				list.add("'" + s.substring(0, s.indexOf("'") + 1));
				s = s.substring(s.indexOf("'") + 1);
				continue;
			} else if (s.startsWith("NULL")) {
				list.add("NULL");
				s = s.substring(4);
				continue;
			}

			if (s.indexOf(",") == -1) {
				list.add(s.trim());
				continue;
			}
			list.add(s.substring(0, s.indexOf(",")));
			s = s.substring(s.indexOf(",") + 1);
		}
		return list;
	}

	public static String createSQL(Table table, List<String> columnList, List<String> valueList) {
		boolean firstFlag = true;
		boolean resultFlag = false;
		
		StringBuffer s = new StringBuffer("UPDATE " + table.getName() + " SET ");
		Map<String, String> map = table.getMap();
		List<String> keyList = table.getKeyList();
		for (int i = 0; i < columnList.size(); i++) {
			String column = columnList.get(i);
			if (!map.containsKey(column) || keyList.contains(column))
				continue;

			String value = valueList.get(i);
			if (value == null || value.isEmpty() || value.equals("NULL"))
				continue;

			resultFlag = true;
			if (firstFlag) {
				s.append(map.get(column) + "=" + value);
				firstFlag = false;
			} else
				s.append(", " + map.get(column) + "=" + value);
		}

		if (!resultFlag)
			return null;
		
		for (int i = 0; i < keyList.size(); i++) {
			String key = keyList.get(i);
			for (int j = 0; j < columnList.size(); j++) {
				String column = columnList.get(j);
				if (column.equals(key)) {
					if (i == 0)
						s.append(" WHERE " + map.get(column) + "=" + valueList.get(j));
					else
						s.append(" AND " + map.get(column) + "=" + valueList.get(j));
				}
			}
		}
		s.append(";");
		return s.toString();
	}

	public static void output(String s) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath, true));
		bw.write(s);
		bw.newLine();
		bw.close();
	}
}
