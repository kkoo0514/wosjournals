package com.wosjournals.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.clarivate.wos.journals.client.invoker.ApiClient;
import com.clarivate.wos.journals.client.invoker.ApiException;
import com.clarivate.wos.journals.client.invoker.Configuration;
import com.clarivate.wos.journals.client.model.*;
import com.clarivate.wos.journals.client.CategoriesApi;

@RestController
public class wosRestController {
	
	@RequestMapping("/")
	public String journalsApiController() {
		CategoryList journalsApi = journalsApi();
		System.out.println(journalsApi);
		return "테스트입니다.";
	}

	public CategoryList journalsApi() {
		ApiClient defaultClient = Configuration.getDefaultApiClient();
	    defaultClient.setBasePath("http://wos-journals-snapshot.cortellis.int.clarivate.com");

	    CategoriesApi apiInstance = new CategoriesApi(defaultClient);
	    String q = "q_example"; // String | Free-text search by category name.  Search logic is described in the section [Search](#search).
	    String edition = "edition_example"; // String | Filter by Web of Sceince Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded (ournals across more than 170 disciplines) - SSCI - Social Sciences Citation Index (journals across more than 50 social science disciplines)  Multiple values are allowed, separated by semicolon ( **;** )
	    Integer jcrYear = 56; // Integer | Filter by Category Citation Report year (from 2003).  Only one value is allowed.
	    Integer page = 1; // Integer | Specifying a page to retrieve
	    Integer limit = 10; // Integer | Number of returned results, ranging from 0 to 50
	    CategoryList result = null;
	    try {
	      result = apiInstance.categoriesGet(q, edition, jcrYear, page, limit);
	      System.out.println(result);
	    } catch (ApiException e) {
	      System.err.println("Exception when calling CategoriesApi#categoriesGet");
	      System.err.println("Status code: " + e.getCode());
	      System.err.println("Reason: " + e.getResponseBody());
	      System.err.println("Response headers: " + e.getResponseHeaders());
	      e.printStackTrace();
	    }
	    return result;
	}
	
}