1-)

In order to execute the application just use

"mvn resources:resources liquibase:update" command

 it will create all necessary tables without doing anything.

 2-) After that execute the main application

 3-) I changed the port to 8080 by using port(8080) in the application. Therefore

Please use such kind of link :

http://localhost:8080/moneyTransfer/3032556/3032896/20/TL

3032556 = Account Number that money is transfered from

3032896 = Account Number That Money is Transfered To

20 = Amount that will be transfered

TL = Account Currency Type, Such like Turkish Lira Account , Euro Account