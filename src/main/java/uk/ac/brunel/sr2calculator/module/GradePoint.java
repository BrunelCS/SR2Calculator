package uk.ac.brunel.sr2calculator.module;

import java.util.HashMap;
import java.util.Map;

public class GradePoint {
	int gradePoint;
	
	private static Map<GradePoint, String> GRADEMAPPINGS = new HashMap<GradePoint, String>();
	
	public GradePoint(int gradePoint) {
		super();
		if (gradePoint < 0 || gradePoint > 17) {
			throw new IllegalArgumentException("Grade Point must be between 0 and 17");
		}
		this.gradePoint = gradePoint;
	}
	
	public GradePoint(String grade) {
		initGradeMapping();
		if (!GRADEMAPPINGS.containsValue(grade)) {
			throw new IllegalArgumentException("Invalid Grade Provided");
		} else {
			for (GradePoint gp : GRADEMAPPINGS.keySet()) {
				if (gp.toGrade().equals(grade)) {
					this.gradePoint=gp.gradePoint;
				}
			}
		} 
	}
	
	private void initGradeMapping() {
		if(GRADEMAPPINGS.isEmpty()) {
			GRADEMAPPINGS.put(new GradePoint(1), "F");
			GRADEMAPPINGS.put(new GradePoint(2), "E-");
			GRADEMAPPINGS.put(new GradePoint(3), "E");
			GRADEMAPPINGS.put(new GradePoint(4), "E+");
			GRADEMAPPINGS.put(new GradePoint(5), "D-");
			GRADEMAPPINGS.put(new GradePoint(6), "D");
			GRADEMAPPINGS.put(new GradePoint(7), "D+");
			GRADEMAPPINGS.put(new GradePoint(8), "C-");
			GRADEMAPPINGS.put(new GradePoint(9), "C");
			GRADEMAPPINGS.put(new GradePoint(10), "C+");
			GRADEMAPPINGS.put(new GradePoint(11), "B-");
			GRADEMAPPINGS.put(new GradePoint(12), "B");
			GRADEMAPPINGS.put(new GradePoint(13), "B+");
			GRADEMAPPINGS.put(new GradePoint(14), "A-");
			GRADEMAPPINGS.put(new GradePoint(15), "A");
			GRADEMAPPINGS.put(new GradePoint(16), "A+");
			GRADEMAPPINGS.put(new GradePoint(17), "A*");
		}
	}

	public String toGrade() {
		initGradeMapping();
		return GRADEMAPPINGS.get(this);
	}

	public int toInt() {
		return gradePoint;
	}

	public boolean greaterThan(GradePoint that) {
		return this.gradePoint > that.gradePoint;
	}
	
	public boolean greaterThanOrEqual(GradePoint that) {
		return this.gradePoint >= that.gradePoint;
	}
	
	public boolean lessThan(GradePoint that) {
		return this.gradePoint < that.gradePoint;
	}
	
	public boolean lessThanOrEqual(GradePoint that) {
		return this.gradePoint < that.gradePoint;
	}
	
	public boolean equals(Object that) {
		if (this==that) {
			return true;
		}
		GradePoint other = (GradePoint)that;
		if (this.gradePoint==other.gradePoint) {
			return true;
		} else {
			return false;
		}
	}
}
