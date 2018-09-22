The purpose of this project is create three specific test cases to the PHP Travels application. 
 
## Languages and Frameworks

This project using the following languages and frameworks:

* Java 8 as the programming language
* TestNG as the UnitTest framework to support the test creation

## Test architecture

We know that any automation project starting with a good test architecture.
This project can be your initial test architecture for a faster start.
You will see the following items in this architecture:

* Use of Page Objects patters
* BaseTest
* TestListner
* Configuration through a properties file

### Configuration through a properties file

The project use the a property file to configure basic mutable items, like:

* base.url: the main app URL

The property file is inside _conf_ folder. This folder has three sub-folders:

* dev:
* test: 
* prod:

You can set different values for the properties keys based on your environment.
When you run a test without inform the parameter `env`, the property file used will be _conf/dev/config.properties_.

To change the environment, just use `-Denv=env_name` where _env_name_ is the name of the folder inside _conf_ folder.

E.g: running all tests using test configuration values

``` bash
mvn test -Denv=test
```