
javadoc -d .\make\ -sourcepath .\src\main\java -subpackages org.example

javac -d .\make\bin\ -sourcepath .\src\main\java .\src\main\java\org\example\Stack.java

mkdir .\make\jar
jar cf .\make\jar\Stack.jar -C .\make\bin .

java -classpath .\make\jar\Stack.jar org.example.Stack