package ro.teamnet.zth.api.em;

import java.util.Objects;

/**
 * Created by Adrian.Calancea on 7/7/16.
 */
public class ColumnInfo {

    private String columnName;
    private Class columnType;
    private String dbName;
    private Boolean isId;
    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Boolean isId() {
        return isId;
    }

    public void setId(boolean id) {
        isId = id;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public Class getColumnType() {
        return columnType;
    }

    public void setColumnType(Class columnType) {
        this.columnType = columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

;

}
