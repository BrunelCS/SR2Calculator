package uk.ac.brunel.sr2calculator.module;


public class ModuleResult {
	private Module module;
	private GradePoint gradepoint;
	
	public ModuleResult(Module module, GradePoint gradePoint) {
		this.module = module;
		this.gradepoint = gradePoint;
	}
	
	/**
	 * Convenience constructor taking strings
	 * @param module
	 * @param grade
	 */
	public ModuleResult(String module, String grade) {
		new ModuleResult(ModuleFactory.getInstance().getModule(module), new GradePoint(grade));
	}

	public Module getModule() {
		return module;
	}

	public GradePoint getGradepoint() {
		return gradepoint;
	}
}

