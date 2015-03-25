# SR2Calculator
Software to calculate classifications from module grades under Brunel University London's Senate Regulation 2

Excel Version
-------------

The root directory contains a TestProfile.xls file which contains an example profile which is just about a 1st class award based on the borderline criteria.

To run the code, type

`./gradlew run` on Unix,

or

`./gradle run` on Windows.

You should see something like this:

	GPA (L2, L3, Overall) : (14.25, 12.5, 13.083333)
	E Grade Volume (L2, L3, Overall) : (0, 0, 0)
	% modules at classification (1st, 2:1, 2:2, 3rd) : (0.5833333, 0.77777785, 1.0, 1.0)
	Failure Volume (L2, L3, Overall) : (0, 0, 0)
	First Class Honours
	Mar 20, 2015 4:09:05 PM uk.ac.brunel.sr2calculator.module.StudentProfile calculateClassification
	INFO: Awarding First Class Honours
	
The first line reports the weighted GPA at Level 2, Level 3 and overall taking into account that Level 2 and 3 count for 1/3 and 2/3 of the classification weighting respectively.  The final number is the main thing used to determine classification.  In this case it is 13.08333, below the 14 required for a 1st.

There are certain rules about how much E-grade volume is allowed for different awards.  Effectively your award is capped if you have E-grades.  Again, this is reported at L2,L3 and overall.

The rules for borderlines are more complicated, and consider the % of weighted module grades that are at a particular classification.  In this case, just over 58% are 1st class.  This means that a GPA of 11.5 is required  for a 1st.  Clearly this is met.

Web Based Version
-----------------

The web-based version is a play framework application that lives in the GPACalculator directory.  First, you need to build the underlying calculation engine and publish it to a local maven repository by typing this:

`./gradlew publishToMavenLocal`

This should publish to `~/.m2/repository`.

Then you should `cd` to the GPACalculator directory to run the web-app.  From this directory type:

`./activator run` 

to start the application server locally on port 9000.

For more information about using activator to deploy on a server, please refer to the documentation at the Play Framework website: [https://www.playframework.com/](https://www.playframework.com/).

In essence, you would use a command something like this:

`./activator start -Dhttp.port=80`

Choosing whatever port you wish to host on.