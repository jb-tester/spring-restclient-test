# Spring RestClient


See [blog post](https://spring.io/blog/2023/07/13/new-in-spring-6-1-restclient/)
The corresponding feature [request](https://github.com/spring-projects/spring-framework/issues/29552)
Umbrella issue in YT: [IDEA-325726](https://youtrack.jetbrains.com/issue/IDEA-325726/Spring-6.1-new-RestClient-API)

Found issues:
* urls from local variables are not resolved: [IDEA-331276](https://youtrack.jetbrains.com/issue/IDEA-331276/Spring-RestClient-the-URLs-provided-as-local-variables-are-not-recognized)
   * see SecondRestClientService.java
* baseUrls from DefaultUriBuilderFactory constructors are not recognized [IDEA-331353](https://youtrack.jetbrains.com/issue/IDEA-331353/Spring-RestClient-baseURL-passed-via-DefaultUriBuilderFactory-constructor-is-not-recognized)
   * see ThirdRestClientService.java
* restClient + @HttpExchange interface: [IDEA-331364](https://youtrack.jetbrains.com/issue/IDEA-331364/Spring-RestClient-endpoints-from-client-registered-as-HttpExchange-interface-backend-should-be-shown-in-the-same-way-as-other)
   * see FourthRestClientConfig