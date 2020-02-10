.DEFAULT_GOAL := default
default:
	xsltproc \
		-o ../java/com/epam/courses/java/fundamentals/integration/RestTests.java \
		./swagger2RestAssured.xslt \
		./swagger_mailOut.xml

extract-mimes:
	xsltproc \
		-o ./mimes.xml \
		./extractMime.xslt \
		../../../../web/src/main/conf/web.xml
