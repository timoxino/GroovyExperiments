package db.finder.attribute

class Reporter
{
    def static report(int quantity, attributesMap)
    {
        def reportFile = new File('report.log')
        def sortedMap = attributesMap.sort { a, b -> b.value.size() <=> a.value.size() }
        for (entry in sortedMap)
        {
            int hotelsNumber = entry.value.size()
            reportFile.append "Attribute $entry.key isn't used in $hotelsNumber hotels\n"
            if(quantity-- == 0) return
        }
    }
}
