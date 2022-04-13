package com.example.contactappsql.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.contactappsql.data.local.utils.DBConstants

class DatabaseHelper(ctx: Context) : SQLiteOpenHelper(ctx, DBConstants.DB_NAME, null, 1) {


    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(DBConstants.CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS " + DBConstants.TABLE_NAME);
        onCreate(p0);
    }
}