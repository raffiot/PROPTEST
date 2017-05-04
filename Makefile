.SUFFIXES: .java .class
JFLAGS = -cp junit-4.10.jar:hamcrest-core-1.3.jar:src


all:
	javac $(JFLAGS) src/dominio/clases/*.java src/dominio/controladores/drivers/*.java src/dominio/controladores/junit/*.java 

clean:
	rm src/dominio/clases/*.class src/dominio/controladores/drivers/*.class src/dominio/controladores/junit/*.class src/dominio/controladores/*.class
run:
	java $(JFLAGS) dominio.clases.Main
run_AnalisisTest:
	java $(JFLAGS) org.junit.runner.JUnitCore dominio.controladores.junit.AnalisisTest
run_Respuesta_3Test:
	java $(JFLAGS) org.junit.runner.JUnitCore dominio.controladores.junit.Respuesta_3Test
run_Respuesta_4Test:
	java $(JFLAGS) org.junit.runner.JUnitCore dominio.controladores.junit.Respuesta_4Test
run_Respuesta_5Test:
	java $(JFLAGS) org.junit.runner.JUnitCore dominio.controladores.junit.Respuesta_5Test
run_Tipo_1Test:
	java $(JFLAGS) org.junit.runner.JUnitCore dominio.controladores.junit.Tipo_1Test
run_Tipo_2Test:
	java $(JFLAGS) org.junit.runner.JUnitCore dominio.controladores.junit.Tipo_2Test
run_Tipo_3Test:
	java $(JFLAGS) org.junit.runner.JUnitCore dominio.controladores.junit.Tipo_3Test
run_Tipo_4Test:
	java $(JFLAGS) org.junit.runner.JUnitCore dominio.controladores.junit.Tipo_4Test
run_Tipo_5Test:
	java $(JFLAGS) org.junit.runner.JUnitCore dominio.controladores.junit.Tipo_5Test

run_driver_encuesta : 
	java $(JFLAGS) dominio.controladores.drivers.driver_encuesta
	
run_driver_pregunta:
	java $(JFLAGS) dominio.controladores.drivers.driver_pregunta

run_driver_analisis:
	java $(JFLAGS) dominio.controladores.drivers.driver_analisis
