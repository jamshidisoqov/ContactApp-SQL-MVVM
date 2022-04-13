package com.example.contactappsql.data.local.utils

object DBConstants {

    const val DB_NAME = "contact"
    const val TABLE_NAME = "mycontact"
    const val COLUMN_USER_ID = "_id"
    const val COLUMN_USERNAME = "username"
    const val COLUMN_PHONE_NUMBER = "number"
    const val CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
            COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_USERNAME + " TEXT NOT NULL, " +
            COLUMN_PHONE_NUMBER + " TEXT NOT NULL)"
    const val SELECT_QUERY="SELECT*FROM "+ TABLE_NAME
}