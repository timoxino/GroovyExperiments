package ftp

import groovy.transform.TypeChecked

while (true)
{
    FtpUploader.upload(generateFileName(), prepareFileStream())
    Thread.sleep(120_000)
}

private def generateFileName()
{
    'TEST_FILE_' + new Date()
}

@TypeChecked
private def InputStream prepareFileStream()
{
    new FileInputStream('file.bin')
}
