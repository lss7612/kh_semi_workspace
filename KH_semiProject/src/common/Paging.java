package common;

public class Paging {

	private int curPage;	//���� ������ ��ȣ
	
	private int totalCount;	//�� �Խñ� ��
	private int listCount;	//�� �������� ��µ� �Խñ� ��
	private int totalPage;	//�� ������ ��
	
	private int pageCount;	//�� ȭ�鿡 ������ ���������̼� ��
	private int startPage;	//ȭ�鿡 ���̴� ���� ������ ��ȣ
	private int endPage;	//ȭ�鿡 ���̴� �� ������ ��ȣ
	
	private int startNo;	//ȭ�鿡 ���̴� �������� ���� �Խñ� ��ȣ
	private int endNo;		//ȭ�鿡 ���̴� �������� �� �Խñ� ��ȣ
	
	//�� �Խñ� ���� �Է��ϴ� ������
	public Paging(int totalCount) {
		this.setTotalCount(totalCount);
		
		this.makePaging();
	}
	
	//�� �Խñ� ��, ���� �������� �Է��ϴ� ������
	public Paging(int totalCount, int curPage) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		
		this.makePaging();
	}

	//�� �Խñ� ��, ���� ������, ������ �Խñ� ���� �Է��ϴ� ������
	public Paging(int totalCount, int curPage, int listCount) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		this.setListCount(listCount);
		
		this.makePaging();
	}
	
	//�� �Խñ� ��, ���� ������, ������ �Խñ� ��, ������ ������ ���� �Է��ϴ� ������
	public Paging(int totalCount, int curPage, int listCount, int pageCount) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		this.setListCount(listCount);
		this.setPageCount(pageCount);
		
		this.makePaging();
	}
	
	//����¡ ���� ���� �޼ҵ�
	private void makePaging() {
		if(totalCount == 0)		return; //�Խñ��� ���� ���
		
		//�⺻�� ����
		if(curPage == 0)	setCurPage(1);	//ù �������� �⺻�� ����
		if(pageCount == 0)	setPageCount(10);	//ȭ�鿡 ������ ������ �� �⺻�� ����
		if(listCount == 0)	setListCount(10);	//ȭ�鿡 ������ �Խñ� �� �⺻�� ����
		
		//�� ������ �� ���
		totalPage = totalCount / listCount; // �� �Խñۼ� / ���������� ��µ� �Խñ� ��
		if( totalCount % listCount > 0 )	totalPage++;

		//���� �������� ����
		//���� ������(curPage)�� �� ������(totalPage)���� Ŭ �� ���������� ���� 
		if(totalPage < curPage)	curPage = totalPage;
		
		//ȭ�鿡 ������ ���������̼� ���۹�ȣ�� ����ȣ
		startPage = ( (curPage-1)/pageCount ) * pageCount + 1; 
		//ȭ�鿡 ���̴½��������� ��ȣ = ((����������-1)/�� ȭ�鿡 ������ ���������̼� ��) * ��ȭ�鿡 ������ ���������̼� 
		endPage = startPage + pageCount - 1;
		
		//�������� ��ȣ ����
		//��������(endPage)�� �� ������(totalPage)���� Ŭ �� �� �������� ����
		if( endPage > totalPage ) endPage = totalPage;

		//ȭ�鿡 ������ �Խñ� ���۹�ȣ�� ����ȣ
		startNo = (curPage-1) * listCount + 1;
		endNo = curPage * listCount;

	}
	
	@Override
	public String toString() {
		return "Paging [curPage=" + curPage + ", totalCount=" + totalCount + ", listCount=" + listCount + ", totalPage="
				+ totalPage + ", pageCount=" + pageCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", startNo=" + startNo + ", endNo=" + endNo + "]";
	}
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	
}
