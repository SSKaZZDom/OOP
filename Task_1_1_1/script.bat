javadoc -d .\make\ -sourcepath .\src\main\java -subpackages ru.nsu.vlomakin

javac -d .\make\bin\ -sourcepath .\src\main\java .\src\main\java\ru\nsu\vlomakin\Heapsort.java

mkdir .\make\jar
jar cf .\make\jar\Heapsort.jar -C .\make\bin .