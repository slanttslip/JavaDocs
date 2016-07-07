package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Table;
import ro.teamnet.zth.appl.domain.Location;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static ro.teamnet.zth.api.em.EntityUtils.GetColumns;
import static ro.teamnet.zth.api.em.EntityUtils.GetTableName;

/**
 * Created by Adrian.Calancea on 7/7/16.
 */
public class QueryBuilder {
    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;


    public String getValueForQuery(Object value) {
        if (value instanceof String)
            return "'" + value + "'";
        else if (value instanceof Date) {
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('" + dateFormat.format((Date) value) + "','mm-dd-YYYY'";
        }
        return value.toString();
    }

    public QueryBuilder addCondition(Condition condition) {

        if (this.conditions == null) {
            this.conditions = new ArrayList<>();
        }
        this.conditions.add(condition);

        return this;
    }

    public QueryBuilder setTableName(Object tableName) {

        this.tableName = tableName;
        return this;
    }

    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns) {

        if (this.queryColumns == null) {
            this.queryColumns = new ArrayList<>();
        }
        this.queryColumns.addAll(queryColumns);
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType) {

        this.queryType = queryType;
        return this;
    }

    private String createSelectQuery() {
        StringBuilder sql = new StringBuilder();

        sql.append("Select ");
        int i = 0;
        for (ColumnInfo a : this.queryColumns) {
            if (i != 0) sql.append(", ");
            i++;
            sql.append(tableName + "." + a.getDbName());
        }
        sql.append(" FROM " + this.tableName);
        i = 0;
        for (Condition a : this.conditions) {
            if (i == 0) sql.append(" where ");
            else sql.append(" and ");

            sql.append(a.getColumnName() + "=" + this.getValueForQuery(a.getValue()));
            i++;
        }
        return sql.toString();
    }

    private String createDeleteQuery() {
        StringBuilder sql = new StringBuilder();

        sql.append("DELETE FROM " + this.tableName);
        int i = 0;
        for (Condition a : this.conditions) {
            if (i == 0) sql.append(" where ");
            else sql.append(" and ");
            sql.append(a.getColumnName() + "=" + this.getValueForQuery(a.getValue()));

            i++;
        }
        return sql.toString();
    }

    private String createUpdateQuery() {
        StringBuilder sql = new StringBuilder();

        sql.append("UPDATE ").append(tableName).append(" SET ");
        int i = 0;
        for (ColumnInfo a : this.queryColumns) {
            if (i != 0) sql.append(", ");
            i++;
            sql.append(tableName + "." + a.getDbName()).append("=").append(a.getValue());
        }
        i = 0;
        for (Condition a : this.conditions) {
            if (i == 0) sql.append(" where ");
            else sql.append(" and ");

            sql.append(a.getColumnName() + "=" + this.getValueForQuery(a.getValue()));

            i++;
        }

        return sql.toString();
    }


    private String createInsertQuery() {
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO ").append(tableName).append(" (");
        int i = 0;
        for (ColumnInfo a : this.queryColumns) {
            if (i != 0) sql.append(", ");
            i++;
            sql.append(a.getDbName());
        }
        i = 0;
        sql.append(") VALUES(");
        for (Condition a : this.conditions) {
            if (i != 0) sql.append(", ");

            sql.append(this.getValueForQuery(a.getValue()));


            i++;
        }
        sql.append(")");
        return sql.toString();
    }


    public String createQuery() {
        if(this.queryType==queryType.UPDATE) return createUpdateQuery();
        if(this.queryType==queryType.SELECT) return createSelectQuery();
        if(this.queryType==queryType.DELETE) return createDeleteQuery();
        if(this.queryType==queryType.INSERT) return createInsertQuery();

    return null;}

    public static void main(String[] args) {
        QueryBuilder qb = new QueryBuilder();

        Condition con = new Condition();
        con.setColumnName("CITY");
        con.setValue("Chisinau");


        ColumnInfo ci = new ColumnInfo();



        qb.addCondition(con);
        qb.addCondition(con);
        qb.setTableName(GetTableName(new Location().getClass()));
        qb.addQueryColumns(GetColumns(new Location().getClass()));
        qb.setQueryType(QueryType.DELETE);


       /* System.out.println(qb.createSelectQuery());
        System.out.println(qb.createDeleteQuery());
        System.out.println(qb.createUpdateQuery());*/
        System.out.println(qb.createQuery());
    }
}
