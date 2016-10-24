package db.common

class ConnectionDataProd extends ConnectionData
{
    ConnectionDataProd()
    {
        super('jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = SRV_NM)))', 'oracle.jdbc.OracleDriver', 'user', 'password')
    }
}
