package oopAssignment4;

public class ConcreteBibItemFactory implements BibItemFactory {
	
	private ItemInputStrategy iiS;
	
	public ConcreteBibItemFactory(ItemInputStrategy iiS) {
		this.iiS = iiS;
	}

	public BibItem createBibItem() {
		BibItem bib = createBibItemUsingStrategy(this.iiS);
		return bib;
	}
	
	private BibItem createBibItemUsingStrategy(ItemInputStrategy iS) {
		return iS.createBibItemFromInput()	;
	}
	

}
