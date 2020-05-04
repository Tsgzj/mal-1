dist: mal

target/%.class:
	clj -e "(compile 'mal.$*)"

target/%.jar: target/%.class
	clj -A:uberdeps --main-class mal.$* --target $@

mal.jar:
	clj -A:uberdeps --main-class mal.$* --target target/$@

mal:
	java -jar mal.jar

clean:
	rm -rf target/ mal.jar mal
