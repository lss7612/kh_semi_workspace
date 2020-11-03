package dto;

public class ParamData {

	private int datano; //PK
	private String title;
	private String data1;
	public int getDatano() {
		return datano;
	}
	public void setDatano(int datano) {
		this.datano = datano;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	@Override
	public String toString() {
		return "ParamData [datano=" + datano + ", title=" + title + ", data1=" + data1 + "]";
	}
	
	
	
}
