# Card tracking for Trello

It shows the card tracking details for a given trello kanban board.
Shows the time taken for a card to move from In-progress to Done.

##Pre-requisites and Technologies used

####Ubuntu 

    As this application is build on a ubuntu system. Preferably Ubuntu 14.04
    
####Git

    To clone the project on your system
    
    $ sudo apt-get update
    $ sudo apt-get install git

####Java 

    Preferably JAVA 8

    **Java 8**

    Install oracle java 8 as given [here](http://askubuntu.com/questions/56104/how-can-i-install-sun-oracles-proprietary-java-jdk-6-7-8-or-jre).     
    Also make sure the JAVA_HOME environment variable is set (preferably in the shell's startup script).

    or

    You may also use following commands for java Installation:

      $ sudo apt-get install python-software-properties
      $ sudo add-apt-repository ppa:webupd8team/java
      $ sudo apt-get update
      $ sudo apt-get install oracle-java8-installer

    Set Java Home in source file

####Grails

     Preferably 3.0.15
    
    **Setting up Grails 3.0.15 on Ubuntu**

    Install _sdk_ tool, for more information [click here](http://sdkman.io/). 

      $ sudo apt-get install unzip
      $ curl -s http://get.sdkman.io | bash
      $ source "$HOME/.sdkman/bin/sdkman-init.sh"

    Grails installation using SDK Tool
   
      $ sdk install grails 3.0.15  
  
    Verify current grails version, in effect, is 3.0.15 . The _sdk_ tool can maintain multiple versions of a software, so make sure of the grails version with  
  
      $ sdk current    
        Using:    
        grails: 3.0.15    

###Cloning the project

    Clone the project from Git repo try URL 
    
    $ git clone git@github.com:vibhor-webonise/trello.git
    
###Running the project

    Go to project directory and try below commands
    
    $ grails clean
    $ grails compile
    $ grails run-app
    
    you will see the output as
    | Running application...
    Grails application running at http://localhost:8080 in environment: development
    
    Try this url in your browser
    You will see a button on the page saying "Show Card Tracking"
    By clicking the button you will be able to see all the cards 
    on the kanban board with their respective progress.
