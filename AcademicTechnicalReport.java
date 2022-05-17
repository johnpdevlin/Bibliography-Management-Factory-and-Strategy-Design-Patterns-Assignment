package oopAssignment4;

class AcademicTechnicalReport extends AcademicPublication {

	private String ddmmyy;
	private String institution;
	
	public AcademicTechnicalReport(String title, String author, int year, String institution, String ddmmyy) {
		// TODO Auto-generated constructor stub
		super(author, title, year);
		this.institution = institution;
		this.ddmmyy = ddmmyy;
		this.citeKey = this.getCiteKey();
	}

	@Override
	public String getCiteKey() {
		// TODO Auto-generated method stub
		String citeKey = new String(this.getAuthorLN()+":"+this.getYear()+":"+this.getddmmyy());
		return citeKey;
	}
	
	/**
	 * @param institution the institution to set
	 */
	public void setddmmyy(String ddmmyy) {
		this.ddmmyy = ddmmyy;
	}
	
	/**
	 * @return the ddmmyy
	 */
	public String getddmmyy() {
		return ddmmyy;
	}
	
	/**
	 * @return the institution
	 */
	public String getInstitution() {
		return institution;
	}

	/**
	 * @param institution the institution to set
	 */
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	public String displayHarvard() {
		String harvard = this.getAuthor()+". ("+this.getYear()+"). '"+this.getTitle()+"'. "+this.getInstitution()+".";
		return harvard;
	}

	public String displayBibTex() {
		// TODO Auto-generated method stub
		String bibTex = "@techreport{"+this.getCiteKey()+", author='"+this.getAuthor()+"', title='"+this.getTitle()+"', year='"+this.getYear()+"', institution='"+this.getInstitution()+"'}";
		return bibTex;
	}

}
