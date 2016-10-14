package ftp

@Grab("commons-net:commons-net:3.5")
import org.apache.commons.net.ftp.FTPReply

class FtpUploader
{
    def static upload(String fileName, InputStream inputStream)
    {
        def connection = null
        try
        {
            connection = FtpConnectionFactory.createConnection()
            connection.storeFile(fileName, inputStream);

            Logger.trace(connection.getReplyString())
            if (!FTPReply.isPositiveCompletion(connection.getReplyCode()))
            {
                def replyString = connection.getReplyString()
                Logger.all("Negative reply code: $replyString")
            }
            connection.logout()
        } catch (IOException e)
        {
            def exception = e.toString()
            Logger.error("Uploading failed: $exception");
        } catch (Exception e)
        {
            def exception = e.toString()
            Logger.error("Unknown exception: $exception");
        }
        finally
        {
            if (connection != null && connection.isConnected())
            {
                try
                {
                    connection.disconnect();
                } catch (IOException e)
                {
                    def exception = e.toString()
                    Logger.error("Disconnecting failed: $exception");
                }
            }
        }
    }
}