import groovy.sql.Sql

@Grab('com.oracle:ojdbc7:12.1.0.2')
@GrabConfig(systemClassLoader=true)

def url = 'jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=127.0.0.1)(PORT=1521))(CONNECT_DATA=(SERVER = DEDICATED)(SERVICE_NAME = S_NAME)))'
def driver = 'oracle.jdbc.OracleDriver'
def user = 'admin'
def password = 'admin'

def sql = Sql.newInstance(url, user, password, driver)

sql.eachRow('SELECT CODE, ADDRESS_LINE1 FROM HCM.ASSET WHERE rownum < 10', { row ->
    print(row.code)
    println(row.address_line1)
})

sql.close();
