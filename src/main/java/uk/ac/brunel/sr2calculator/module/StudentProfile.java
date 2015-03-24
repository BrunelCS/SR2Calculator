package uk.ac.brunel.sr2calculator.module;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import uk.ac.brunel.sr2calculator.awards.Award;
import uk.ac.brunel.sr2calculator.awards.AwardFactory;

public class StudentProfile {
	
	//private static Map<Classification, Map<Double, Double>> classificationLookup;
	
	private List<ModuleResult> results;
	
	public StudentProfile() {
		results = new ArrayList<ModuleResult>();
	}
	
	public StudentProfile addResult(ModuleResult result) {
		results.add(result);
		return this;
	}
	
	public double calculateLevelWeightedGPA(int level) {
		float gradePointSum = 0.0f;
		int creditVolume = 0;
		for (ModuleResult result : results) {
			if (result.getModule().getLevel()==level) {
				gradePointSum+=result.getGradepoint().toInt()*result.getModule().getCredits();
				creditVolume+=result.getModule().getCredits();
			}
		}
		if (creditVolume==0) {
			return 0.0f;
		} else {
			return gradePointSum / creditVolume;
		}
	}
	
	public double calculateLevelSR2WeightedGPA() {
		return (calculateLevelWeightedGPA(2) + 2 * calculateLevelWeightedGPA(3))/3;
	}
	
	public float calculateVolumeForLevelAndClassification(int level, Award classification) {
		int inClassCreditVolume = 0;
		int totalCreditVolume = 0;
		for (ModuleResult result : results) {
			if (result.getModule().getLevel()==level) {
				if (result.getGradepoint().greaterThanOrEqual(classification.getMinimumGradePoint())) {
					inClassCreditVolume+=result.getModule().getCredits();
				}
				totalCreditVolume+=result.getModule().getCredits();
			}
		}
		if (totalCreditVolume==0) {
			return 0.0f;
		} else {
			return (float)inClassCreditVolume / (float)totalCreditVolume;
		}
	}
	
	public double calculateOverallProportionForClassification(Award classification) {
		return (calculateVolumeForLevelAndClassification(2, classification)+
				2*calculateVolumeForLevelAndClassification(3, classification)) / 3;
	}
	
	public Award calculateClassification(boolean verbose) {
		for(Award cl : AwardFactory.getInstance().getAwards()) {
			if (cl.canBeAwardedForProfile(this)) {
				Logger.getLogger(this.getClass().getName()).info("Awarding " + cl.getName());
				return cl;
			}
		}
		Logger.getLogger(this.getClass().getName()).info("No Award Found");
		return AwardFactory.getInstance().getNone();
	}

	public int calculateVolumeForGradePointsAtLevels(GradePoint[] gradePoints, int[] levels) {
		int creditVolume = 0;
		for (ModuleResult result : results) {
		for (GradePoint gp : gradePoints) {
			for (int level : levels) {
				if (result.getModule().getLevel()==level) {
					if (result.getGradepoint().equals(gp)) {
						creditVolume+=result.getModule().getCredits();
					}
				}
			}
		}
		}
		return creditVolume;
	}
}
