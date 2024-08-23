package com.wosjournals.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.wos.journals.client.invoker.ApiClient;
import com.clarivate.wos.journals.client.invoker.ApiException;
import com.clarivate.wos.journals.client.invoker.Configuration;
import com.clarivate.wos.journals.client.model.*;
import com.clarivate.wos.journals.client.CategoriesApi;
import com.clarivate.wos.journals.client.JournalsApi;

@RestController
public class wosRestController {
	
	@RequestMapping("/")
	public String journalsApiController() {
		
//		CategoryList testApi = testApi();
		JournalList journalsApi = journalsApi();
		
		return journalsApi==null?"====":journalsApi.toString();
	}

	public CategoryList testApi() {
		ApiClient defaultClient = Configuration.getDefaultApiClient();
	    defaultClient.setBasePath("http://wos-journals-snapshot.cortellis.int.clarivate.com");
	    defaultClient.setConnectTimeout(99999999);
//	    defaultClient.setApiKey("58d7013f6d03df70fccea67ac300cb552a9fdd56");

	    CategoriesApi apiInstance = new CategoriesApi(defaultClient);
	    String q = "q_example"; // String | Free-text search by category name.  Search logic is described in the section [Search](#search).
	    String edition = "edition_example"; // String | Filter by Web of Sceince Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded (ournals across more than 170 disciplines) - SSCI - Social Sciences Citation Index (journals across more than 50 social science disciplines)  Multiple values are allowed, separated by semicolon ( **;** )
	    Integer jcrYear = 2023; // Integer | Filter by Category Citation Report year (from 2003).  Only one value is allowed.
	    Integer page = 1; // Integer | Specifying a page to retrieve
	    Integer limit = 10; // Integer | Number of returned results, ranging from 0 to 50
	    CategoryList result = null;
	    try {
	      result = apiInstance.categoriesGet(q, edition, jcrYear, page, limit);
	    } catch (ApiException e) {
	      System.err.println("Exception when calling CategoriesApi#categoriesGet");
	      System.err.println("Status code: " + e.getCode());
	      System.err.println("Reason: " + e.getResponseBody());
	      System.err.println("Response headers: " + e.getResponseHeaders());
	      e.printStackTrace();
	      
	    }
	    return result;
	}
	
	public JournalList journalsApi() {
	    ApiClient defaultClient = Configuration.getDefaultApiClient();
	    defaultClient.setBasePath("http://wos-journals-snapshot.cortellis.int.clarivate.com");
	    defaultClient.setConnectTimeout(99999999);
	    defaultClient.getAuthentication("");
//	    defaultClient.setApiKeyPrefix("https://api.clarivate.com/apis/wos-journals/v1");
//	    defaultClient.setApiKey("58d7013f6d03df70fccea67ac300cb552a9fdd56");

	    JournalsApi apiInstance = new JournalsApi(defaultClient);
	    String q = "0945-053X"; // String | Free-text search by journal name (e.g. *Nature Genetics*), JCR abbreviation (e.g. *NAT GENET*), publisher (e.g. *PUBLIC LIBRARY SCIENCE*) or [ISSN / eISSN code](https://www.issn.org/understanding-the-issn/what-is-an-issn/) (e.g. *1061-4036*)  The search logic is described in the section [Search](#search).
	    String edition = "SCIE"; // String | Filter by Web of Science Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded - SSCI - Social Sciences Citation Index - AHCI - Arts & Humanities Citation Index - ESCI - Emerging Sources Citation Index  Multiple values are allowed, separated by a semicolon ( **;** )
	    String categoryCode = "IP"; // String | Filter journals by category identifiers.  Each journal in JCR is assigned to at least one of the subject categories, indicating a general area of science or the social sciences. Journals may be included in more than one subject category.  Multiple values are allowed, separated by a semicolon ( **;** )
	    Integer jcrYear = 2019; // Integer | Filter by Journal Citation Report year (from 1997).  **NOTE:** The filter **jcrYear** is mandatory while using **jif**, **jifPercentile**, **jifQuartile**, and **jci** filters  Only one value is allowed.
	    String jif = "gte:5.0"; // String | Filter by [Journal Impact Factor](http://jcr.help.clarivate.com/Content/jcr3-glossary.htm) (JIF).  **NOTE:** The filter **jcrYear** is mandatory while using **jif** filter  Filter logic is described in the section [Filter by range](#range)
	    String jifPercentile = "gte:70.0 AND lte:90.0"; // String | Filter by [Journal Impact Factor Percentile](http://jcr.help.clarivate.com/Content/glossary-journal-impact-factor-percentile.htm), ranging from 0 to 100  **NOTE:** The filter **jcrYear** is mandatory while using **jifPercentile** filter  Filter logic is described in the section [Filter by range](#range)
	    String jifQuartile = "Q1"; // String | Filter by JIF quartile rank for a category, from highest to lowest based on their JIF value: <br />Q1 is represented by the top 25% of journals in the category; <br />Q2 is occupied by journals in the 25 to 50% group; <br />Q3 is occupied by journals in the 50 to 75% group; <br />Q4 is occupied by journals in the 75 to 100% group.  **NOTE:** The filter **jcrYear** is mandatory while using **jifQuartile** filter  Multiple values are allowed, separated by a semicolon ( **;** )
	    String jci = "jci_example"; // String | Filter by [Journal Citation Indicator](http://jcr.help.clarivate.com/Content/jcr3-glossary.htm) (JCI).  **NOTE:** The filter **jcrYear** is mandatory while using **jci** filter  Filter logic is described in the section [Filter by range](#range)
	    String jciQuartile = "Q1"; // String | Filter by JCI quartile rank for a category, from highest to lowest based on their JCI value: Q1 is represented by the top 25% of journals in the category; Q2 is occupied by journals in the 25 to 50% group; Q3 is occupied by journals in the 50 to 75% group; Q4 is occupied by journals in the 75 to 100% group.  **NOTE:** The filter **jcrYear** is mandatory while using **jciQuartile** filter  Multiple values are allowed, separated by a semicolon ( **;** )
	    String jciPercentile = "gte:70.0 AND lte:90.0"; // String | Filter by Journal Citation Indicator (JCI) percentile, ranging from 0 to 100  **NOTE:** The filter **jcrYear** is mandatory while using **jciPercentile** filter  Filter logic is described in the section [Filter by range](#range)
	    Integer page = 1; // Integer | Specifying a page to retrieve
	    Integer limit = 10; // Integer | Number of returned results, ranging from 0 to 50
	    JournalList result = null;
	    try {
	      result = apiInstance.journalsGet(q, edition, categoryCode, jcrYear, jif, jifPercentile, jifQuartile, jci, jciQuartile, jciPercentile, page, limit);
	      System.out.println(result);
	    } catch (ApiException e) {
	      System.err.println("Exception when calling JournalsApi#journalsGet");
	      System.err.println("Status code: " + e.getCode());
	      System.err.println("Reason: " + e.getResponseBody());
	      System.err.println("Response headers: " + e.getResponseHeaders());
	      e.printStackTrace();
	    }
	    return result;
	  }
	
}