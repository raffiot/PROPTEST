.SUFFIXES: .java .class

all:
	javac -cp /usr/share/java/junit.jar src/dominio/clases/*.java src/dominio/controladores/drivers/*.java src/dominio/controladores/junit/*.java src/dominio/controladores/*.java

clean:
	rm src/dominio/clases/*.class src/dominio/controladores/drivers/*.class src/dominio/controladores/junit/*.class src/dominio/controladores/*.class
run:
	java -cp src dominio.clases.Main
