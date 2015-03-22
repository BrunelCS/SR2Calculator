package uk.ac.brunel.sr2calculator.module;

public class Module {
	private String moduleCode;
	private int credits;
	private int level;
	
	/* package */ Module(String moduleCode, int level, int credits) {
		super();
		this.setModuleCode(moduleCode);
		this.setCredits(credits);
		this.setLevel(level);
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public int getCredits() {
		return credits;
	}

	public int getLevel() {
		return level;
	}
	
	private void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	
	private void setCredits(int credits) {
		this.credits = credits;
	}
	
	private void setLevel(int level) {
		if (level<1 || level >3) {
			throw new IllegalArgumentException("Level must be between 1 and 3");
		}
		this.level=level;
	}
}
