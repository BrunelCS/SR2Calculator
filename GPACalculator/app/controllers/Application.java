package controllers;

import models.Grade;
import models.Student;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import uk.ac.brunel.sr2calculator.awards.Award;
import uk.ac.brunel.sr2calculator.awards.AwardFactory;
import views.formdata.StudentFormData;
import views.html.Index;

/**
 * The controller for the single page of this application.
 */
public class Application extends Controller {

	/**
	 * Returns the page where the form is filled by the Student whose id is passed, or an empty form
	 * if the id is 0.
	 * @param id The id of the Student whose data is to be shown.  0 if an empty form is to be shown.
	 * @return The page containing the form and data.
	 */
	public static Result getIndex(long id) {
		StudentFormData studentData = (id == 0) ? new StudentFormData() : models.Student.makeStudentFormData(id);
		Form<StudentFormData> formData = Form.form(StudentFormData.class).fill(studentData);

		return ok(Index.render(
				formData,
				Grade.makeGPAMap1(studentData),
				Grade.makeGPAMap2(studentData),
				Grade.makeGPAMap3(studentData),
				Grade.makeGPAMap4(studentData),
				Grade.makeGPAMap5(studentData),
				Grade.makeGPAMap6(studentData),
				Grade.makeGPAMap7(studentData),
				Grade.makeGPAMap8(studentData),
				Grade.makeGPAMap9(studentData),
				Grade.makeGPAMap10(studentData),
				Grade.makeGPAMap11(studentData)
				));
	}

	/**
	 * Process a form submission.
	 * First we bind the HTTP POST data to an instance of StudentFormData.
	 * The binding process will invoke the StudentFormData.validate() method.
	 * If errors are found, re-render the page, displaying the error data. 
	 * If errors not found, render the page with the good data. 
	 * @return The index page with the results of validation. 
	 */
	public static Result postIndex() {

		// Get the submitted form data from the request object, and run validation.
		Form<StudentFormData> formData = Form.form(StudentFormData.class).bindFromRequest();
		StudentFormData sfd = new StudentFormData();
		
		sfd.CS2001Grade = formData.data().get("CS2001Grade");
		sfd.CS2002Grade = formData.data().get("CS2002Grade");
		sfd.CS2003Grade = formData.data().get("CS2003Grade");
		sfd.CS2004Grade = formData.data().get("CS2004Grade");
		sfd.CS2005Grade = formData.data().get("CS2005Grade");

		sfd.CS2555Grade = formData.data().get("CS2555Grade");

		sfd.CS3072Grade = formData.data().get("CS3072Grade");
		sfd.CS3001Grade = formData.data().get("CS3001Grade");
		sfd.CS3100Grade = formData.data().get("CS3100Grade");
		sfd.CS3002Grade = formData.data().get("CS3002Grade");
		sfd.CS3003Grade = formData.data().get("CS3003Grade");
		
		
		
		if (sfd.CS2001Grade == "" || sfd.CS2002Grade == "" || sfd.CS2003Grade == "" || sfd.CS2004Grade == "" || sfd.CS2005Grade == "" || 
		sfd.CS3072Grade == "" || sfd.CS3001Grade == "" || sfd.CS3100Grade == "" || sfd.CS3002Grade == "" || sfd.CS3003Grade == "" ) {
		            
			flash("error", "All field, must be filled in ('Placement' is the only optional field).");
			return badRequest(Index.render(
			        formData,
					Grade.makeGPAMap1(sfd),
					Grade.makeGPAMap2(sfd),
					Grade.makeGPAMap3(sfd),
					Grade.makeGPAMap4(sfd),
					Grade.makeGPAMap5(sfd),
					Grade.makeGPAMap6(sfd),
					Grade.makeGPAMap7(sfd),
					Grade.makeGPAMap8(sfd),
					Grade.makeGPAMap9(sfd),
					Grade.makeGPAMap10(sfd),
					Grade.makeGPAMap11(sfd)
					));
		}
		else {
			//Convert the formData into a Student model instance.
			sfd.createStudentProfile();

			flash("success", "Student classification calculated");
			flash("l2", sfd.level2GPA);
			flash("l3", sfd.level3GPA);
			flash("overall", sfd.overallGPA);
			flash("classification", sfd.classification);       
			flash("volume1", sfd.gradeVolume1);
			flash("volume2", sfd.gradeVolume2);
			flash("volume3", sfd.gradeVolume3);
			flash("volume4", sfd.gradeVolume4);


			return ok(Index.render(
					formData,
					Grade.makeGPAMap1(sfd),
					Grade.makeGPAMap2(sfd),
					Grade.makeGPAMap3(sfd),
					Grade.makeGPAMap4(sfd),
					Grade.makeGPAMap5(sfd),
					Grade.makeGPAMap6(sfd),
					Grade.makeGPAMap7(sfd),
					Grade.makeGPAMap8(sfd),
					Grade.makeGPAMap9(sfd),
					Grade.makeGPAMap10(sfd),
					Grade.makeGPAMap11(sfd)
					));
		}
	}
}


