package tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC002_GetIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Get an existing Incident (REST)";
		testDescription = "Get an existing Incident (REST)";
		nodes = "Incident";
		authors = "Sarath";
		category = "REST";
		dataFileName = "TC001";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData")
	public void getIncident(File file) {		
				
		Response response = get("table/incident");

		verifyContentType(response, "application/Json");
		
		verifyResponseCode(response, 200);
		
	}


}





