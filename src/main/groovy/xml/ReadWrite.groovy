package xml

def parsedFile = new XmlSlurper().parse(new File('content.xml'))

def categories = parsedFile.depthFirst().findAll {it.name() == 'category'}
def result = new HashSet<>(categories.collect { "PREFIX $it" })

def outputFile = new File('output.data')
result.each {outputFile.append("$it\n")}
