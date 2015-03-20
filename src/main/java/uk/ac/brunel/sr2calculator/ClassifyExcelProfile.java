package uk.ac.brunel.sr2calculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import uk.ac.brunel.sr2calculator.awards.Award;
import uk.ac.brunel.sr2calculator.awards.AwardFactory;
import uk.ac.brunel.sr2calculator.module.GradePoint;
import uk.ac.brunel.sr2calculator.module.ModuleFactory;
import uk.ac.brunel.sr2calculator.module.ModuleResult;
import uk.ac.brunel.sr2calculator.module.StudentProfile;

public class ClassifyExcelProfile {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Workbook workbook = new HSSFWorkbook(new FileInputStream(new File("/Users/simonkent/Desktop/TestProfile.xls")));

		Sheet sheet = workbook.getSheetAt(0);
		
		StudentProfile profile = new StudentProfile();
		
	    for (Row row : sheet) {
	    	String moduleCode = row.getCell(2).getStringCellValue();
	    	String moduleGrade = row.getCell(6).getStringCellValue();
			profile.addResult(new ModuleResult(ModuleFactory.getInstance().getModule(moduleCode), new GradePoint(moduleGrade)));
	    }
	   
	    
	    System.out.println("GPA (L2, L3, Overall) : (" + 
	    		profile.calculateLevelWeightedGPA(2) + ", " + 
	    		profile.calculateLevelWeightedGPA(3) + ", " + 
	    		profile.calculateLevelSR2WeightedGPA() + ")");
	    
	    System.out.println("E Grade Volume (L2, L3, Overall) : (" + 
	    		profile.calculateVolumeForGradePointsAtLevels(new GradePoint[] {new GradePoint("E-"), new GradePoint("E"), new GradePoint("E+")}, new int[] {2}) + ", " + 
	    		profile.calculateVolumeForGradePointsAtLevels(new GradePoint[] {new GradePoint("E-"), new GradePoint("E"), new GradePoint("E+")}, new int[] {3}) + ", " + 
	    		profile.calculateVolumeForGradePointsAtLevels(new GradePoint[] {new GradePoint("E-"), new GradePoint("E"), new GradePoint("E+")}, new int[] {2,3}) + ")");
	    
	    System.out.println("% modules at classification (1st, 2:1, 2:2, 3rd) : (" +
	    		profile.calculateOverallVolumeForClassification(AwardFactory.getInstance().getFirstClass()) + ", " +
	    		profile.calculateOverallVolumeForClassification(AwardFactory.getInstance().getUpperSecondClass()) + ", " +
	    		profile.calculateOverallVolumeForClassification(AwardFactory.getInstance().getLowerSecondClass()) + ", " +
	    		profile.calculateOverallVolumeForClassification(AwardFactory.getInstance().getThirdClass()) + ")");
	    		
	    System.out.println("Failure Volume (L2, L3, Overall) : (" + 
	    		profile.calculateVolumeForGradePointsAtLevels(new GradePoint[] {new GradePoint("F")}, new int[] {2}) + ", " + 
	    		profile.calculateVolumeForGradePointsAtLevels(new GradePoint[] {new GradePoint("F")}, new int[] {3}) + ", " + 
	    		profile.calculateVolumeForGradePointsAtLevels(new GradePoint[] {new GradePoint("F")}, new int[] {2,3}) + ")");
	    
	    Award award = profile.calculateClassification(true);
	    
	    System.out.println(award.getName());
	}

}
