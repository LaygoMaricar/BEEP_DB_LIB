package com.afpayments.beejees.fe.database.sqlite.queries;

/**
 * Created by peter.linchangco on 12/07/2018.
 */

public class SQLQueryHelper {

    public static String selectWhere(String tableName, String columnName, String operand , String criteria){
        return "SELECT * from " + tableName + " where " + columnName + " " + operand + " '" + criteria + "' ";
    }

    public static String selectWhere(String tableName, String columnName, String operand , Long criteria){
        return "SELECT * from " + tableName + " where " + columnName + " " + operand + " " + criteria + " ";
    }

    public static String selectWhere(String tableName, String columnName, String operand , int criteria){
        return "SELECT * from " + tableName + " where " + columnName + " " + operand + " " + criteria + " ";
    }

    public static String selectWhereLimit(String tableName, String columnName, String operand , String criteria, Long limit){
        return "SELECT * from " + tableName + " where " + columnName + " " + operand + " '" + criteria + "' Limit " + limit;
    }
    
    public static String selectWhereLikeLimit(String tableName, String columnName, String criteria, Long limit){
        return "SELECT * from " + tableName + " where UPPER(" + columnName + ") like  UPPER('%" + criteria + "%') Limit " + limit;
    }

    public static String selectWhereLimit(String tableName, String columnName, String operand , Long criteria , Long limit){
        return "SELECT * from " + tableName + " where " + columnName + " " + operand + " " + criteria + " Limit " + limit;
    }

    public static String selectLimit(String tableName, Long limit){
        return "SELECT * from " + tableName + " Limit " + limit;
    }

    public static String selectAll(String tableName){
        return "SELECT * from " + tableName;
    }

    public static String whereClause(String columnName, String operand, String criteria){
        return columnName + " " + operand + " '" + criteria + "' ";
    }

    public static String whereClause(String columnName, String operand, Long criteria){
        return columnName + " " + operand + " " + criteria + " ";
    }

    public static String updateWhere(String tableName, String setColumn, String setValue, String whereColumn, String operand, String criteria){
        return "UPDATE " + tableName + " SET " + setColumn + " = '" + setValue + "' " + " where " + whereColumn + " " + operand + " '" + criteria + "' ";
    }

}
