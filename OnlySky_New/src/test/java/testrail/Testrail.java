package testrail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import testrail.*;

public class Testrail {
	  static APIClient client = null;
	    public static String TEST_RUN_ID                = "6";
	    public static String TESTRAIL_USERNAME          = "qa@theonlysky.com";
	    public static String TESTRAIL_PASSWORD          = "789Sherman!";
	    public static String RAILS_ENGINE_URL           = "";
	    public static final int TEST_CASE_PASSED_STATUS = 1;
	    public static final int TEST_CASE_FAILED_STATUS = 5;


	public void runtestcase(String TestRunID ,String testcaseID, int testcasestatus) throws MalformedURLException, IOException, APIException {
		  String testRunId = TestRunID;
    	  String testcaseid=testcaseID;

           try {
        	   
			client = new APIClient("https://theonlysky.testrail.io/");
	
          client.setUser(TESTRAIL_USERNAME);
          client.setPassword(TESTRAIL_PASSWORD);
          Map data = new HashMap();
          data.put("status_id",testcasestatus);
          data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
          client.sendPost("add_result_for_case/"+testRunId+"/"+testcaseid+"",data );
           }
          catch (Exception e) {
  			// TODO Auto-generated catch block
        	  System.out.println("exception on  testrail");
  			e.printStackTrace();
  		}
    	  //updatting the testcase
     }

	}


