package com.ear.core.model;

public class FileModel {

	private String extension;
	private String nameFile;
	private String encodeB64;
	private String path;
	private Long size;
	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	/**
	 * @return the nameFile
	 */
	public String getNameFile() {
		return nameFile;
	}
	/**
	 * @param nameFile the nameFile to set
	 */
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	/**
	 * @return the encodeB64
	 */
	public String getEncodeB64() {
		return encodeB64;
	}
	/**
	 * @param encodeB64 the encodeB64 to set
	 */
	public void setEncodeB64(String encodeB64) {
		this.encodeB64 = encodeB64;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}	
	
}
