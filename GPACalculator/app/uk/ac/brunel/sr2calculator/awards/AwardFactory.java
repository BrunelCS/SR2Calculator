package uk.ac.brunel.sr2calculator.awards;

import java.util.ArrayList;
import java.util.List;

public class AwardFactory {
	private static AwardFactory instance;
	private final Award FIRST = new FirstClassHonours();
	private final Award UPPER_SECOND = new UpperSecondClassHonours();
	private final Award LOWER_SECOND = new LowerSecondClassHonours();
	private final Award THIRD = new ThirdClassHonours();
	private final Award NONE = new NoAward();

	private final List<Award> classifications = new ArrayList<Award>();

	
	private AwardFactory() {
		classifications.add(FIRST);
		classifications.add(UPPER_SECOND);
		classifications.add(LOWER_SECOND);
		classifications.add(THIRD);
		classifications.add(NONE);
	}
	
	public static AwardFactory getInstance() {
		if (instance==null) {
			instance = new AwardFactory();
		}
		return instance;
	}
	
	public Award getFirstClass() {
		return FIRST;
	}
	
	public Award getUpperSecondClass() {
		return UPPER_SECOND;
	}
	
	public Award getLowerSecondClass() {
		return LOWER_SECOND;
	}
	
	public Award getThirdClass() {
		return THIRD;
	}
	
	public Award getNone() {
		return NONE;
	}
	
	public List<Award> getAwards() {
		return classifications;
	}
}
