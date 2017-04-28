package com.N.entity;

public class Pageroll {
	private int currpage=1;
	private int pagesize=5;
	private int pagecnt;
	private int tatalcnt;
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currage) {
		this.currpage = currage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagecnt() {
		if (tatalcnt % pagesize == 0)
			pagecnt = tatalcnt/pagesize;
		else
			pagecnt = tatalcnt/pagesize+1;
		return pagecnt;
	}
	public void setPagecnt(int pagecnt) {
		this.pagecnt = pagecnt;
	}
	public int getTatalcnt() {
		return tatalcnt;
	}
	public void setTatalcnt(int tatalcnt) {
		this.tatalcnt = tatalcnt;
	}
	
}
