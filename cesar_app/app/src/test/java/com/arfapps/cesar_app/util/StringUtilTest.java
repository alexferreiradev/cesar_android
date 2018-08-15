package com.arfapps.cesar_app.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

	@Test
	public void stringsHasTypoChanged() {
		// @formatter:off
		String[][] dataList = {
				{"pale", 		"ple", 		"true"},
				{"pales", 		"pale", 	"true"},
				{"pale", 		"bale", 	"true"},
				{"pale", 		"bake", 	"false"},
				{"pal", 		"bake", 	"false"},
				{"pal", 		"bals", 	"false"},
				{"pal", 		"palms", 	"false"},
		};

		for(String[] stringData: dataList){
			boolean hasTyped = StringUtil.stringsHasTypoChanged(stringData[0].toCharArray(), stringData[1].toCharArray());

			Assert.assertEquals(stringData[2], String.valueOf(hasTyped));
		}
	}

	@Test
	public void stringsHasPermuted() {
		// @formatter:off
		String[][] dataList = {
				{"you", 			"yuo", 						"true"},
				{"probably", 		"porbalby", 				"true"},
				{"despite", 		"desptie", 					"true"},
				{"moon", 			"nmoo", 					"false"},
				{"misspellings",	"mpeissngslli", 			"false"},
		};

		for(String[] stringData: dataList){
			boolean hasPermuted = StringUtil.stringsHasPermuted(stringData[0].toCharArray(), stringData[1].toCharArray());

			Assert.assertEquals(stringData[2], String.valueOf(hasPermuted));
		}
	}

	@Test
	public void replaceVectorWith() {
		// @formatter:off
		String[][] dataList = {
				{"User is not allowed      ", "User&32is&32not&32allowed"},
				{"User is not all owed        ", "User&32is&32not&32all&32owed"},
				{"User is not all ow ed          ", "User&32is&32not&32all&32ow&32ed"},
		};

		for(String[] stringData: dataList){
			String replaced = StringUtil.replaceVectorWith(stringData[0].toCharArray(), "&32", ' ');

			Assert.assertEquals(stringData[1], replaced);
		}
	}

	@Test
	public void replaceVectorWithLessMemory() {
		// @formatter:off
		String[][] dataList = {
				{"User is not allowed      ", "User&32is&32not&32allowed"},
				{"User is not all owed        ", "User&32is&32not&32all&32owed"},
				{"User is not all ow ed          ", "User&32is&32not&32all&32ow&32ed"},
		};

		for(String[] stringData: dataList){
			String replaced = StringUtil.replaceVectorLessMemoryWith(stringData[0].toCharArray(), "&32", ' ');

			Assert.assertEquals(stringData[1], replaced);
		}
	}
}