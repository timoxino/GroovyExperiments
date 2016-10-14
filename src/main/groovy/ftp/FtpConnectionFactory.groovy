package ftp

@Grab("commons-net:commons-net:3.5")
import org.apache.commons.net.ftp.FTPClient
import org.apache.commons.net.ftp.FTP
import groovy.transform.TypeChecked

class FtpConnectionFactory
{
    @TypeChecked
    static FTPClient createConnection()
    {
        def client = new FTPClient()
        client.setDefaultTimeout(30 * 1000);

        client.with {
            connect "url"
            login "user", "password"
            setFileType FTP.BINARY_FILE_TYPE
        }
        client
    }
}
