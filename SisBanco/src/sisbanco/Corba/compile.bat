:: Directorio de java SDK
SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_111"

:: direccion de las fuentes SRC de proyecto netbeans IDL "CorbaCotesInterface"
SET PATH_IDL="C:\Users\Usuari\Documents\NetBeansProjects\CorbaCotesInterface\src"

:: nombre del archivo IDL
SET IDL_NAME=cotes.idl

:: comando para compilar
%JAVA_HOME%\bin\idlj -fall -td %PATH_IDL% %PATH_IDL%\%IDL_NAME%

