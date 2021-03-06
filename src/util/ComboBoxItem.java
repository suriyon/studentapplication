package util;

public class ComboBoxItem {
	private String key;
	private String value;
	public void setKey(String key) {
		this.key = key;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	@Override
	public String toString() {
		return value;
	}
	public ComboBoxItem(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
}
