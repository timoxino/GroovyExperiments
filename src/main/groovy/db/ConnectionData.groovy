package db

class ConnectionData
{
    String url
    String driver
    String user
    String password

    ConnectionData(String url, String driver, String user, String password)
    {
        this.url = url
        this.driver = driver
        this.user = user
        this.password = password
    }
}
