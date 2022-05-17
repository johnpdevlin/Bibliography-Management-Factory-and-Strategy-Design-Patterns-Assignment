package oopAssignment4;


abstract interface GUIItemInputStrategy extends ItemInputStrategy {

	@Override
	public abstract BibItem createBibItemFromInput();
	
	
}
