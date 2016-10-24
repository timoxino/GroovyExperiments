package db.finder.attribute

import db.common.ConnectionDataInt
import groovy.sql.Sql

class DataReader
{
    def connectionData = new ConnectionDataInt()
    def connection = Sql.newInstance(connectionData.url, connectionData.user, connectionData.password, connectionData.driver)

    def read(resultsMap, offset, maxRows)
    {
        connection.eachRow('SELECT aa.ATTRIBUTE_NUMBER, a.CODE FROM ASSET_ATTRIBUTE aa JOIN HCM.ASSET a ON a.ASSET_ID = aa.ASSET_ID WHERE aa.ASSET_ATTRIBUTE_ID IN (SELECT DISTINCT ASSET_ATTRIBUTE_ID FROM HCM.PROPERTY p WHERE p.STRING_VALUE IS NULL AND p.INTEGER_VALUE IS NULL AND p.LONG_VALUE IS NULL AND p.BOOLEAN_VALUE IS NULL AND p.DOUBLE_VALUE IS NULL AND p.FLOAT_VALUE IS NULL AND p.DATE_VALUE IS NULL AND p.FILE_PATH IS NULL AND p.FILENAME IS NULL)', offset, maxRows) {
            record ->
                if (resultsMap[record.ATTRIBUTE_NUMBER] == null) resultsMap[record.ATTRIBUTE_NUMBER] = new HashSet()
                resultsMap[record.ATTRIBUTE_NUMBER].add(record.CODE)
        }
    }

    def close()
    {
        connection.close()
    }
}
