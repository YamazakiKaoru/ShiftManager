package com.example.Schedulle.auth.account;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import lombok.Data;

@Data
public class ImageFile {

	private String fileName;

	/**
	 *  BASE64でエンコードしたファイルデータを文字列で返す
	 * @return
	 */
	public String encodeString() {
		File imageFile = new File(fileName);
		StringBuffer base64String = new StringBuffer();

		try {
			String contextType = Files.probeContentType(imageFile.toPath());
			byte[] fileData = Files.readAllBytes(imageFile.toPath());

			base64String.append("data:");
			base64String.append(contextType);
			base64String.append(";base64,");
			base64String.append(Base64.getEncoder().encodeToString(fileData));
		} catch (IOException e) {
			return "";
		}
		return base64String.toString();
	}


}