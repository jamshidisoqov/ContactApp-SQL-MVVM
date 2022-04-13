package com.example.contactappsql.data.local

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.util.Log.d
import android.widget.Toast
import com.example.contactappsql.data.local.models.Contact
import com.example.contactappsql.data.local.utils.DBConstants
import java.util.*
import kotlin.collections.ArrayList

class DatabaseQueryImpl(private var ctx: Context, helper: DatabaseHelper) : DatabaseQuery {

    private var sqLiteDatabase: SQLiteDatabase = helper.writableDatabase

    override fun insertContact(contact: Contact) {
        val cv = ContentValues()
        cv.put(DBConstants.COLUMN_USERNAME, contact.name)
        cv.put(DBConstants.COLUMN_PHONE_NUMBER, contact.number)

        try {
          sqLiteDatabase.insertOrThrow(DBConstants.TABLE_NAME, null, cv)
        } catch (e: SQLiteException) {
            Toast.makeText(ctx, "${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("Range")
    override fun getAllContact(): List<Contact> {

        val cursor = sqLiteDatabase.rawQuery(DBConstants.SELECT_QUERY, null)
        try {
            if (cursor != null) {
                val list = ArrayList<Contact>()
                while (cursor.moveToNext()) {
                    val id = cursor.getInt(cursor.getColumnIndex(DBConstants.COLUMN_USER_ID))
                    val name = cursor.getString(cursor.getColumnIndex(DBConstants.COLUMN_USERNAME))
                    val number =
                        cursor.getString(cursor.getColumnIndex(DBConstants.COLUMN_PHONE_NUMBER))
                    list.add(Contact(id, name, number))
                }
                return list
            }
        } catch (e: Exception) {
            d("Exception", "getAllContact:${e.message} ")
            Toast.makeText(ctx, "Operation Failed", Toast.LENGTH_SHORT).show()
        } finally {
            cursor.close()
        }

        return Collections.emptyList()

    }

    override fun searchContact(): List<Contact> {
        return emptyList()
    }

    override fun deleteContact(pos: Int) {
        sqLiteDatabase.delete(
            DBConstants.TABLE_NAME,
            DBConstants.COLUMN_USER_ID + " = ? " + pos,
            null
        )
    }

}