
# Library-Project-MPP

Group project for MPP Course of MUM 2018 August Entry

Group #6 - Members
* Dawit Habte Woldergiorgis
* Ganbat Bayar
* Tuy Tam Phan



## Dependencies

You will need to have JavaFX [installed and configured](https://openjfx.io/openjfx-docs/) for your IDE to run this application.

## Run from Source

Right click on the **Library-Project-MPP/Library/src/Main.java** and run as Java Application

## Run from JAR file

Download the [Library.jar](https://github.com/dawithw/Library-Project-MPP/Library.jar) file

Add your JavaFX */lib* folder to the PATH

    export JAVA_FX=/path/to/javafx-sdk-11.0.2/lib/

Go to the folder where you downloaded the Library.jar file

    cd /path/to/..
    
Use the following command to add the JavaFX modules and execute the JAR file

    java --module-path $JAVA_FX --add-modules javafx.controls,javafx.fxml -jar Library.jar

## Application

**Login Credentials**
|Username|Password|Role|
|-|-|-|
| user1 |pass1  |User
|user2|pass2|Librarian
|user3|pass3|Admin


![](https://github.com/dawithw/Library-Project-MPP/blob/master/Library/src/docs/Login.png?raw=true)


See the **[docs](https://github.com/dawithw/Library-Project-MPP/tree/master/Library/src/docs)** folder for more screenshots and UML diagrams
