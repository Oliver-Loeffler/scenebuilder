# Scene Builder LE 20 (Leading Edge - March 2023)

This version of Scene Builder is a fork of the most recent version of Gluons Scene Builder for OpenJFX.
The difference to Gluon Scene Builder is, that this version has basically includes many of the open PRs and features. Hence curious users can use Scene Builder LE to explore and play with early and yet unofficial features.

Often it is hard to judge how a feature feels and how it works. This for shall allow exploration of new functionality. This also means, that some features may also get remove if it turns out that they do not work in the intended way or in cases these features receive negative feedback.

This fork of Scene Builder can be installed and executed in parallel to an existing version of the mainline Scene Builder provided by Gluon.

## March 2023 highlights:
* Scene Builder now runs with Java 20
* OpenJFX 20 is used instead of its early access version

## February 2023 highlights:

* Scene Builder can now create controller skeletons for JRuby by @byteit101
* Scene Builder also can create controller skeletons for Scala by @rladstaetter
* added Chinese translation provided by @bbbboom
* This fork is now consistently called Scene Builder LE and its configuration and settings are independent from Gluon released Scene Builder versions.
* During work on getting Scene Builder LE available in the Microsoft App Store, the tracking functionality has been removed, user registration is no longer working.

## October 2022 highlights:

* Binding expression support (no resolution / string only) by @treilhes
* Library refresh by @luca-domenichini
* Backward navigation when walking through scene graph nodes. One goes back (upwards) in the graph by pressing `ESC`. by @luca-domenichini
* It is now possible to edit `Insets` of custom controls if those are exposed as Property
* Nice menu for update check by @gargoyle
* JavaFX / JFX-Central linked in help
* Scene Builder now can read FXMLs with unresolved imports it preserves these imports when requested
* Scene Builder notifies the user which FXML imports cannot be resolved
* Application data, preferences and library are now specific to Scene Builder version. This also means, that e.g. Scene Builder 18 and Scene Builder 19 Leading Edge can run at the same time on the same machine.
* The welcome page supports now loading of FXML files via drag & drop.
* Zoom in/out for the workspace is now working properly, in previous versions the keyboard controls were not working. Zoom works now with `CMD`+`+` or `CMD`+`-` on Mac and with `CTRL`+`+` or `CTRL`+`-` on Win/Linux. Also `SHIFT`+`CMD` and `SHIFT`+`CTRL` together with the arrow keys allows to zoom in/out.
* It is now possible to copy FXML controller skeleton code from the correspoding preview window into the clipboard. For older versions this did not work properly.
* With some FXML files, the keyboard accelerator `CTRL`+`P` for showing the preview window was not working.
* There are no FX8 qualifiers anymore.

Some open PRs are missing but those will follow soon.

## What is Scene Builder ##

Gluon [Scene Builder](http://gluonhq.com/products/scene-builder/) is a drag and drop UI designer tool allowing rapid desktop and mobile app development.
Scene Builder separates design from logic, allowing team members to quickly and easily focus on their specific aspect of application development.

Scene Builder works with the JavaFX ecosystem – official controls, community projects, and Gluon offerings including
[Gluon Mobile](http://gluonhq.com/products/mobile),
[Gluon Desktop](http://gluonhq.com/products/desktop), and
[Gluon CloudLink](http://gluonhq.com/products/cloudlink).

Scene Builder is open source, and it is freely licensed under the BSD license.
[Gluon](http://gluonhq.com) can provide [custom consultancy](http://gluonhq.com/services/consulting/), [training](http://gluonhq.com/services/training/), and open source [commercial support](http://gluonhq.com/services/commercial-support/).

## Getting started ##

The best way to get started with Gluon Scene Builder is by downloading and installing on your developer machine the latest 
[Scene Builder release](http://gluonhq.com/products/scene-builder/#download).

See the [documentation](http://docs.gluonhq.com/scenebuilder/) about the new features recently included.

For community support, go to [StackOverflow](https://stackoverflow.com/questions/tagged/scenebuilder).

## Issues and Contributions ##

Issues can be reported to the [Issue tracker](https://github.com/gluonhq/scenebuilder/issues/)

Contributions can be submitted via [Pull requests](https://github.com/gluonhq/scenebuilder/pulls/), 
providing you have signed the [Gluon Individual Contributor License Agreement (CLA)](https://cla.gluonhq.com). Please check the [contribution guide](CONTRIBUTING.md) for more details.

## Building Scene Builder LE ##

### Requisites ###

Gluon Scene Builder is frequently released, and this is only required in case you want to fork and build your local version of Scene Builder.

These are the requisites:

* A recent version of [JDK 17 or later](https://www.oracle.com/technetwork/java/javase/downloads/index.html) for building 'master' branch

### How to build Scene Builder ###

Scene Builder makes use of the Maven Wrapper to build and run the project. So there is no need to install Maven on the developers machine. To utilize Maven Wrapper, instead of calling `mvn`, one can run `./mvnw` on Linux or macOS or `mvnw` on Windows instead.

To build the Scene Builder services, on the project's root, run:

`mvn clean package`

Alternatively, utilizing the Maven Wrapper, one can run:

`./mvnw clean package`

It will create a partial shadow cross-platform jar under `app/target/lib/scenebuilder-$version.jar`, that doesn't include the JavaFX dependencies.

### How to run Scene Builder ###

Before starting the app, all dependencies must be installed locally.
This is achieved by:

`mvn install`

Then Scene Builder can be started with Maven:

`mvn javafx:run -f app`

Alternatively, you can run the partial shadow jar, providing you have downloaded the JavaFX SDK from [here](https://gluonhq.com/products/javafx/):

```
java 
--module-path /path/to/javafx-sdk-$javafxVersion/lib \
--add-modules javafx.web,javafx.fxml,javafx.swing,javafx.media \
--add-opens=javafx.fxml/javafx.fxml=ALL-UNNAMED \
-cp app/target/lib/scenebuilder-$version.jar \
com.oracle.javafx.scenebuilder.app.SceneBuilderApp
```

## Scene Builder Kit ##

To build and install the Scene Builder Kit in your local repository, run:

`mvn clean install -f kit`

The custom controls of the Scene Builder kit can be used in your project.
You can add it as a regular dependency to the build of your app:

```
<dependency>
  <groupId>com.gluonhq.scenebuilder</groupId>
  <artifactId>kit</artifactId>
  <version>$version</version>
</dependency>
```

## Code Style

To ensure that new code formatting matches the requirements for Pull Requests,
the Maven Checkstyle plugin can be used to create a report listing possibly coding 
style violations.

Contributors can check for code-style violations in their code by running the Checkstyle Maven goal. The checkstyle configuration is currently in a very early stage and only checks for empty blocks, extra white space, padding and empty lines.

To run the plugin:

```
mvn checkstyle:checkstyle
```

There will be a report for each sub-project, one for `app` and one for `kit`.

* Kit: `kit/target/site/checkstyle.html`
* App: `app/target/site/checkstyle.html`

This project makes use of [EditorConfig](https://editorconfig.org/) which is [directly supported](https://editorconfig.org/#pre-installed) by IntelliJ IDEA. There are plugins for NetBeans, Eclipse and Visual Studio and [more](https://editorconfig.org/#download). EditorConfig ensures via configuration in `.editorconfig` file, that the proper indentation is used.

EditorConfig can automatically correct possible formatting violations when executed as a Maven plug-in: `mvn editorconfig:format`.

