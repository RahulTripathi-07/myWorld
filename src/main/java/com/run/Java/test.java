package com.run.Java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.codehaus.plexus.util.FileUtils;

public class test {

	public static List<String> zipSlipNoncompliant(ZipFile zipFile) throws IOException {
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		List<String> filesContent = new ArrayList<>();

		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			File file = new File(entry.getName());
			String content = FileUtils.fileRead(file); // Noncompliant
			filesContent.add(content);
		}

		return filesContent;
	}

}
