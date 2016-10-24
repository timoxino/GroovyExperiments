package db.finder.attribute

class Runner
{
    def static run(Setting setting, File executionFile, attributesMap)
    {
        def reader = new DataReader()
        def threshold = setting.offset + setting.amount
        while (setting.offset < threshold)
        {
            def start = System.currentTimeMillis();
            executionFile.append "Processing from '$setting.offset'"

            reader.read(attributesMap, setting.offset, setting.step)
            setting.offset += setting.step

            def time = (System.currentTimeMillis() - start) / 1000;
            executionFile.append "to '$setting.offset' took $time seconds\n"
        }
        reader.close()
    }
}
