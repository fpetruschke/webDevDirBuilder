# WDDB - webDevDirBuilder

## About
'WDDB' is a little Java-Project for automatically creating a directory structure on Linux computers.  
The only thing you have to do is writing down a project name and choosing the location where to create the directory.  

## Requirements
- Only works on Linux.
- You need to have Java 1.7 installed.  
- import Project into your workspace to run it or use the executeable .jar

## Default structure
The structure is set inside the "config.properties".    
By default 'WDDB' creates following dir structure:    

```

[d] Projectname/    
[d] |  app/    
[d] |  |  config/    
[d] |  |  log/    
[d] |  |  MVC/    
[d] |  |  |  Controller/   
[d] |  |  |  Model/    
[d] |  |  |  View/   
[d] |  web/   
[d] |  |  css/   
[d] |  |  img/   
[d] |  |  js/   
[f] |  |  index.php  
[f] |  |  index.html  
[d] |  tests/  

```

## Getting started

* Run the project (either .jar or within your Java-IDE)
* Give the project a name
* Click on the folder-icon to choose the directory where to create the project
* Done. Now you just have to import the Project as "Existing Project" into your favourite IDE
