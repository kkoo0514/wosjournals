/*
 * Web of Science™ Journals API
 * This API provides journal-level metadata and metrics for all journals in the Journal Citation Reports™ covered in the Web of Science Core Collection, including the Journal Impact Factor™ and other new metrics. Integrate journal data into your internal systems or retrieve journal indicators for bibliometrics studies.  ## Resources This API follows the REST approach to disclose resources in URL format. Only the GET method is currently available to perform requests over HTTP.  The API is available on the [Clarivate Developer Portal](https://developer.clarivate.com/apis/wos-journal). The access requires registration on the Portal and approval from the Clarivate Sales/Product teams to entitle to the API.  ## Credentials All requests require authentication with an API Key authentication flow. For more details, check the [Guide](https://developer.clarivate.com/help/api-access#key_access).  ## API Client Libraries The current languages/frameworks are supported: [Python](https://github.com/clarivate/wosjournals-python-client) | [Java](https://github.com/clarivate/wosjournals-java-client) | [Javascript](https://github.com/clarivate/wosjournals-javascript-client)  ## Content You can learn more about content at [Journal Citation Reports™ Product page](https://clarivate.com/webofsciencegroup/solutions/journal-citation-reports/), or in the [documentation](http://jcr.help.clarivate.com/Content/home.htm).  ## <a name=\"search\"></a> Search (query parameter `q=`) This API supports free-text search for a journal name, abbreviation, ISSN code, publisher, and Web of Science™ category name (only `/categories` endpoint). You need to provide a complete and valid ISSN code pattern; otherwise, the API will not look up for ISSN codes.  ### Boolean operators | Operator    | Description  | Example| |-----|-----|------------------| | + / \" \" | Search by two or more terms in the same field. Blank space is the same as an AND operator. The search retrieves all the records that contain the terms, e.g., | `/journals?q=matrix biology`<br> `/journals?q=nature+group` | | OR | Search by at least one term in the field. The search retrieves all the records that contain one of the terms, e.g., | `/journals?q=gas OR oil` | | NOT / - | Search by excluding specific terms. The search retrieves all the records that match the query specifics, e.g., | `/journals?q=genetics -nature` |  ### Special symbols The wildcards ( __*__ ) are allowed in the search that starts with the search query&#58; `/journals?q=nano*` will search indications that start from __nano__&#58; for example, _Nanotechnology_ or _nanotubes_.  Please note&#58; the free text search query (with the parameter `q=`) should contain at least three symbols.  ## Filtering The API supports several filters for Journals and Web of Science™ Categories, narrowing down the initial list of entities or search results.  There are two types of filters:  - Filter by one or multiple **values**: *edition*, *categoryCode*, *jcrYear*, *jifQuartile* - Filter by **range**: *jif*, *jifPercentile*, *jci*,   ### Filter by values The filter name goes before the equals sign, followed by one or multiple filter values, separated by a semicolon, like `categoryCode=RZ;RU`. You can combine various filters with or without the search. Filters are separated by an ampersand (**&amp;**): `q=nature&categoryCode=RU;KM&jcrYear=2018`  Please note&#58; filter by *jcrYear* allows only one year value as an input  ### <a name='range'></a> Filter by range The API supports range filtering for Journal Impact Factor (*jif*) or Journal Impact Factor Percentile (*jifPercentile*) with the following operators:  - ***eq*** (equal): if a Journal Impact Factor (Percentile) is equal to a specific number.<br /> For example: for `jif=eq:5.032` the result will include journals with Journal Impact Factor = 5.032.<br /> Not combinable with any other operator - ***gt*** (greater than): if a Journal Impact Factor (Percentile) is greater than a specific number.<br /> For example: for `jif=gt:5` the result will include journals with Journal Impact Factor = 5.001 and higher.<br /> Combinable with *lt* and *lte* operators - ***gte*** (greater than equal): if a Journal Impact Factor (Percentile) is greater than or equal to a specific number.<br /> For example: for `jif=gte:5` the result will include journals with Journal Impact Factor = 5.000 and higher.<br /> Combinable with *lt* and *lte* operators - ***lt*** (less than): if a Journal Impact Factor (Percentile) is less than a specific number.<br /> For example: for `jif=lt:5` the result will include journals with Journal Impact Factor = 4.999 and less.<br /> Combinable with *gt* and *gte* operators - ***lte*** (less than equal): if a Journal Impact Factor (Percentile) is less than a specific number.<br /> For example: for `jif=lte:5` the result will include journals with Journal Impact Factor = 5.000 and less.<br /> Combinable with *gt* and *gte* operators  Use `AND` to combine two operators, e.g.,`jifPercentile=gte:50 AND lte:80` responses with all journals in a percentile range from 50% to 80% (both included).  ## Pagination To ensure fast response time, each search or multiple entity calls (such as `/journals` or `/categories/ID/cited/year/YYYY`) retrieve only a certain number of hits/records.  There are two optional request parameters to browse along with the result&#58; _limit_ and _page_.  - limit&#58; Number of returned results, ranging from 0 to 50 (default **10**) - page&#58; Specifying a page to retrieve (default **1**)  Moreover, this information is shown in the response body, in the tag **metadata**&#58;  ```json \"metadata\": {   \"total\": 91,   \"page\": 1,   \"limit\": 10 } ``` ## Errors The WoS Journals API uses conventional HTTP success or failure status codes. For errors, some extra information is included to indicate what went wrong in the JSON response. The list of HTTP codes is listed below.  | Code  | Title  | Description | |---|---|---| | 400  | Bad request  | Request syntax error | | 401  | Unauthorized  | The API key is invalid or missed | | 404  | Not found  | The resource is not found | | 405 | Method not allowed | Method other than GET is not allowed | | 50X  | Server errors  | Technical error with servers| Each error response (except `401 Unauthorized` error) contains the code of the error, the title of the error and detailed description of the error: a misprint in an endpoint, wrong URL parameter, etc. The example of the error message is shown below:  ```json \"error\": {   \"status\": 404,   \"title\": \"Resource couldn't be found\",   \"details\": \"There is no information in WoS Journals API about the identifier ABC_DEF for the Journals content area. Sorry :(\" } ``` For the `401 Unauthorized` error the response body is a little bit different: ```json {   \"error_description\": \"The access token is missing\",   \"error\": \"invalid_request\" } ```
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.clarivate.wos.journals.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Number of journals in the category according to the number of times per year published
 */
@ApiModel(description = "Number of journals in the category according to the number of times per year published")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-04-08T14:37:40.089+02:00[Europe/Paris]")
public class Frequency {
  public static final String SERIALIZED_NAME_ANNUAL = "annual";
  @SerializedName(SERIALIZED_NAME_ANNUAL)
  private Integer annual;

  public static final String SERIALIZED_NAME_HEMIANNUAL = "hemiannual";
  @SerializedName(SERIALIZED_NAME_HEMIANNUAL)
  private Integer hemiannual;

  public static final String SERIALIZED_NAME_TRIANNUAL = "triannual";
  @SerializedName(SERIALIZED_NAME_TRIANNUAL)
  private Integer triannual;

  public static final String SERIALIZED_NAME_SEMIANNUAL = "semiannual";
  @SerializedName(SERIALIZED_NAME_SEMIANNUAL)
  private Integer semiannual;

  public static final String SERIALIZED_NAME_QUARTERLY = "quarterly";
  @SerializedName(SERIALIZED_NAME_QUARTERLY)
  private Integer quarterly;

  public static final String SERIALIZED_NAME_BIMONTHLY = "bimonthly";
  @SerializedName(SERIALIZED_NAME_BIMONTHLY)
  private Integer bimonthly;

  public static final String SERIALIZED_NAME_MONTHLY = "monthly";
  @SerializedName(SERIALIZED_NAME_MONTHLY)
  private Integer monthly;

  public static final String SERIALIZED_NAME_BIWEEKLY = "biweekly";
  @SerializedName(SERIALIZED_NAME_BIWEEKLY)
  private Integer biweekly;

  public static final String SERIALIZED_NAME_WEEKLY = "weekly";
  @SerializedName(SERIALIZED_NAME_WEEKLY)
  private Integer weekly;

  public static final String SERIALIZED_NAME_DAILY = "daily";
  @SerializedName(SERIALIZED_NAME_DAILY)
  private Integer daily;

  public static final String SERIALIZED_NAME_IRREGULAR = "irregular";
  @SerializedName(SERIALIZED_NAME_IRREGULAR)
  private Integer irregular;

  public Frequency() { 
  }

  public Frequency annual(Integer annual) {
    
    this.annual = annual;
    return this;
  }

   /**
   * Get annual
   * @return annual
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getAnnual() {
    return annual;
  }


  public void setAnnual(Integer annual) {
    this.annual = annual;
  }


  public Frequency hemiannual(Integer hemiannual) {
    
    this.hemiannual = hemiannual;
    return this;
  }

   /**
   * Get hemiannual
   * @return hemiannual
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getHemiannual() {
    return hemiannual;
  }


  public void setHemiannual(Integer hemiannual) {
    this.hemiannual = hemiannual;
  }


  public Frequency triannual(Integer triannual) {
    
    this.triannual = triannual;
    return this;
  }

   /**
   * Get triannual
   * @return triannual
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTriannual() {
    return triannual;
  }


  public void setTriannual(Integer triannual) {
    this.triannual = triannual;
  }


  public Frequency semiannual(Integer semiannual) {
    
    this.semiannual = semiannual;
    return this;
  }

   /**
   * Get semiannual
   * @return semiannual
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getSemiannual() {
    return semiannual;
  }


  public void setSemiannual(Integer semiannual) {
    this.semiannual = semiannual;
  }


  public Frequency quarterly(Integer quarterly) {
    
    this.quarterly = quarterly;
    return this;
  }

   /**
   * Get quarterly
   * @return quarterly
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getQuarterly() {
    return quarterly;
  }


  public void setQuarterly(Integer quarterly) {
    this.quarterly = quarterly;
  }


  public Frequency bimonthly(Integer bimonthly) {
    
    this.bimonthly = bimonthly;
    return this;
  }

   /**
   * Get bimonthly
   * @return bimonthly
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getBimonthly() {
    return bimonthly;
  }


  public void setBimonthly(Integer bimonthly) {
    this.bimonthly = bimonthly;
  }


  public Frequency monthly(Integer monthly) {
    
    this.monthly = monthly;
    return this;
  }

   /**
   * Get monthly
   * @return monthly
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getMonthly() {
    return monthly;
  }


  public void setMonthly(Integer monthly) {
    this.monthly = monthly;
  }


  public Frequency biweekly(Integer biweekly) {
    
    this.biweekly = biweekly;
    return this;
  }

   /**
   * Get biweekly
   * @return biweekly
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getBiweekly() {
    return biweekly;
  }


  public void setBiweekly(Integer biweekly) {
    this.biweekly = biweekly;
  }


  public Frequency weekly(Integer weekly) {
    
    this.weekly = weekly;
    return this;
  }

   /**
   * Get weekly
   * @return weekly
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getWeekly() {
    return weekly;
  }


  public void setWeekly(Integer weekly) {
    this.weekly = weekly;
  }


  public Frequency daily(Integer daily) {
    
    this.daily = daily;
    return this;
  }

   /**
   * Get daily
   * @return daily
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getDaily() {
    return daily;
  }


  public void setDaily(Integer daily) {
    this.daily = daily;
  }


  public Frequency irregular(Integer irregular) {
    
    this.irregular = irregular;
    return this;
  }

   /**
   * Get irregular
   * @return irregular
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getIrregular() {
    return irregular;
  }


  public void setIrregular(Integer irregular) {
    this.irregular = irregular;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Frequency frequency = (Frequency) o;
    return Objects.equals(this.annual, frequency.annual) &&
        Objects.equals(this.hemiannual, frequency.hemiannual) &&
        Objects.equals(this.triannual, frequency.triannual) &&
        Objects.equals(this.semiannual, frequency.semiannual) &&
        Objects.equals(this.quarterly, frequency.quarterly) &&
        Objects.equals(this.bimonthly, frequency.bimonthly) &&
        Objects.equals(this.monthly, frequency.monthly) &&
        Objects.equals(this.biweekly, frequency.biweekly) &&
        Objects.equals(this.weekly, frequency.weekly) &&
        Objects.equals(this.daily, frequency.daily) &&
        Objects.equals(this.irregular, frequency.irregular);
  }

  @Override
  public int hashCode() {
    return Objects.hash(annual, hemiannual, triannual, semiannual, quarterly, bimonthly, monthly, biweekly, weekly, daily, irregular);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Frequency {\n");
    sb.append("    annual: ").append(toIndentedString(annual)).append("\n");
    sb.append("    hemiannual: ").append(toIndentedString(hemiannual)).append("\n");
    sb.append("    triannual: ").append(toIndentedString(triannual)).append("\n");
    sb.append("    semiannual: ").append(toIndentedString(semiannual)).append("\n");
    sb.append("    quarterly: ").append(toIndentedString(quarterly)).append("\n");
    sb.append("    bimonthly: ").append(toIndentedString(bimonthly)).append("\n");
    sb.append("    monthly: ").append(toIndentedString(monthly)).append("\n");
    sb.append("    biweekly: ").append(toIndentedString(biweekly)).append("\n");
    sb.append("    weekly: ").append(toIndentedString(weekly)).append("\n");
    sb.append("    daily: ").append(toIndentedString(daily)).append("\n");
    sb.append("    irregular: ").append(toIndentedString(irregular)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

