***by KingdomTV***
# KingdomTV
In this repository we will place our web application, where we can control the information about the movies and series we follow.

## Team : 

- Jesús Ávila Martínez

	- E-mail: j.avila@alumnos.urjc.es 
	- Github: [srjesusam](https://github.com/srjesusam )
	
- Miguel Torrijos Guerra:

	- E-mail: m.torrijos@alumnos.urjc.es
	- Github: [migueltg35](https://github.com/migueltg35 )
	
- Sergio Sanchéz Vallés:

	- E-mail: s.sanchezval@alumnos.urjc.es
	- Github: [sergiosv96](https://github.com/sergiosv96 )
	
- Lei Han:

	- E-mail: l.han@alumnos.urjc.es
	- Github: [LeiHan1](https://github.com/LeiHan1 )

## Tools :

- [GitHub Projects](https://github.com/SergioSV96/kingdomTV/projects/1?fullscreen=true)
- [Project](https://github.com/SergioSV96/kingdomTV)

## About the project:

### Topic
	Movies and TV Series tracking Website.
### Database entities

	- User:
	
		- Anonymous.
		- Registered User.
		- Administrator.
		
	- Movie.
	- TV Series.
	- Genres
	- Viewed.
	- Report notifications.
	- Comments.
	
![diagrama%bbdd.png](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/diagrama%20bbdd.png)	
	
### Advanced functionality

	- Uses Database TMDb (The Movie Database).
	- Logging with e-mails.
	
	
### Graphic information
	We are going to use pie charts showing the genre that users like the most.
	
### Other functionality
	
	- Send e-mails.
	- Report spam and report spoiler comments.

### Navigation Diagram
![diagrama.jpg](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/diagrama.JPG)

### Screenshots
Screenshots of the pages

1. Inicio: Main page from the KingdomTV. In which you will be able to see a brief information about the characteristics of the website.

![alt text](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/1.JPG "Index")

2. Peliculas: Page where you can find the movies section, where there are some recommendations and you can also perform an advanced search.

![alt text](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/2.JPG "Peliculas")

3. Series:  Page where you can find the shows section, where there are some recommendations and you can also perform an advanced search.

![alt text](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/3.JPG "Series")

4. Contacto: Here you can get in touch with the website, in case you want us to add a movie or any doubt or suggestion.

![alt text](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/4.JPG "Contacto")

5. Sobre nosotros: Here you will find information about the project and its members.

![alt text](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/9.JPG "Product")

6. Registro: Here you can register on our website, choosing a username and filling in the requested information.

![alt text](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/10.JPG "Registro")

7. Login: Here you can enter your account details and login.

![alt text](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/5.JPG "Login")

8. Movie Info: Here you can see al the info of the movie.

![alt text](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/6.JPG "Movie")

9. Serie Info: Here you can see al the info of the serie.

![alt text](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/7.JPG "Serie")

10. Profile: Here you can see the profile page.

![alt text](https://github.com/SergioSV96/kingdomTV/blob/master/KingdomTV_ScreenShots/8.png "Profile")


### Started Instructions
In order to start the application you will need the MySQL database, for that you have to install MySQLCommunity Server and MySQL Workbench.

Once you have installed and configured it, you will need to access the MySQL command line, called MySQL Command Line, just run the following commands to initialize the database:

mysql> create database kingdomtv; -- Create the new database

mysql> create user' admin' @' localhost' identified by' pass'; -- Creates the user

mysql> grant all on kingdomtv.* to' admin' @' localhost'; -- Gives all the privileges to the new user on the newly created database

From the above we can say that a database called kingdomTV is created and its user root or admin is the user "admin" and its countess is "pass", this can be modified in the application. properties area.

Once we have started the database we can run the program in spring, or the. jar with the tomcat browser.
