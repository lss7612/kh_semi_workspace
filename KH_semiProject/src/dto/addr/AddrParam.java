package dto.addr;

public class AddrParam {

	private String arrayCondition = "userid";
	private String search = null;
	private String searchCondition = "All";
	private boolean isASC = true;
	
	
	@Override
	public String toString() {
		return "AddrParam [arrayCondition=" + arrayCondition + ", search=" + search + ", searchCondition="
				+ searchCondition + ", isASC=" + isASC + "]";
	}
	public String getArrayCondition() {
		return arrayCondition;
	}
	public void setArrayCondition(String arrayCondition) {
		this.arrayCondition = arrayCondition;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public boolean isASC() {
		return isASC;
	}
	public void setASC(boolean isASC) {
		this.isASC = isASC;
	}
	
	
	
	
	
	
}
