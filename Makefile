# 203405147 203699566
# levisah1 frankya2
bin:
	mkdir bin
compile: bin
	javac -d bin -cp biuoop-1.4.jar src/*.java
jar: compile
	jar cfm ass6game.jar Manifest.txt -C bin . -C resources .
run: jar
	java -jar ass6game.jar
check:
	java -jar checkstyle-5.7-all.jar -c biuoop.xml src/*.java src/*java
