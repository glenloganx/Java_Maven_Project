1. Create new Maven project
2. Add dependency to Maven: TestNG (search on Maven Repo new version) ApacheHTTPClient, Jackson
3. Create the model classes for serialization and deserialization of API calls - json to pojo tool
4. Create corresponding step classes to implement PostMan task from above.
   - Creating a new board (POST)
   - Getting board by ID (GET)
   - Updating board (PUT)
   - Remove board (DELETE)
5. Each test should contain Assertion (you should check not only response code)
6. Add REST Assured library to your Maven
7. Create test class with the same verifications using REST Assured library
8. Add Retrofit and OKHTTP libraries
9. Create test class with the same verifications using Retrofit and OKHTTPClient libraries

