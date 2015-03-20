package uk.ac.brunel.sr2calculator.module;


public class ModuleResult {
	private Module module;
	private GradePoint gradepoint;
	
	public ModuleResult(Module module, GradePoint gradePoint) {
		this.module = module;
		this.gradepoint = gradePoint;
	}

	public Module getModule() {
		return module;
	}

	public GradePoint getGradepoint() {
		return gradepoint;
	}
}

