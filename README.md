
# Library-Project-MPP

Group project for MPP Course of MUM 2018 August Entry

Group #6 - Members
* Dawit Habte Woldergiorgis
* Ganbat Bayar
* Tuy Tam Phan



## Dependencies

You will need to [install and configure JavaFX](https://openjfx.io/openjfx-docs/) on your machine before you can run this application.

## Running Application

If you want to run the application from your IDE, follow the guides in the JavaFX install and configure documentation linked above. 

#### From source code

Clone repository to your local machine

    git clone https://github.com/dawithw/Library-Project-MPP.git

Navigate to the source folder

	cd Library-Project-MPP/Library/src
	
Add environment variable to the *lib* folder of your JavaFX runtime as described [here](https://openjfx.io/openjfx-docs/#install-javafx)

Compile project.

	javac --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml business/*.java dataaccess/*.java Main.java 

Note that *javafx.controls* and *javafx.fxml modules* are required for the application

Now run the application

	java --module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml Main


### Application

**Login Credentials**

|Username|Password|Role|
|-|-|-|
| user1 |pass1  |User
|user2|pass2|Librarian
|user3|pass3|Admin


![](https://github.com/dawithw/Library-Project-MPP/blob/master/Library/src/docs/ui/Login.png?raw=true)


For more UI screenshots, see the **[docs/ui](https://github.com/dawithw/Library-Project-MPP/tree/master/Library/src/docs/ui)** folder

For UML diagrams (class and sequence) see the **[docs/uml](https://github.com/dawithw/Library-Project-MPP/tree/master/Library/src/docs/uml)** folder
