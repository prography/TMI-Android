package com.example.administrator.tmi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrator.tmi.data.Board;
import com.example.administrator.tmi.data.ItemData;
import com.example.administrator.tmi.data.Member;

import java.util.ArrayList;
import java.util.List;

import static android.provider.Contacts.SettingsColumns.KEY;
import static com.example.administrator.tmi.activity.LoginActivity.emailSave;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DATA";
    private static final String TABLE_MEMBER = "Members";
    private static final String TABLE_BOARD = "Boards";
    private static final String KEY_ID = "id";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_PASSWORD = "password";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_MEMBER = "CREATE TABLE IF NOT EXISTS " + TABLE_MEMBER + "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                KEY_EMAIL + " TEXT NOT NULL," +
                KEY_PASSWORD + " TEXT NOT NULL" + ");";
        db.execSQL(CREATE_TABLE_MEMBER);

        String CREATE_TABLE_BOARDS = "CREATE TABLE IF NOT EXISTS " + TABLE_BOARD + "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                KEY_USER_ID + " INTEGER NOT NULL," +
                KEY_TITLE + " TEXT NOT NULL," +
                KEY_CONTENT + " TEXT NOT NULL" + ");";
        db.execSQL(CREATE_TABLE_BOARDS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String DROP_TABLE_MEMBER =
//                "DROP TABLE IF EXISTS "+TABLE_MEMBER;
//        db.execSQL(DROP_TABLE_MEMBER);
//        onCreate(db);
//
//        String DROP_TABLE_BOARD =
//                "DROP TABLE IF EXISTS "+TABLE_BOARD;
//        db.execSQL(DROP_TABLE_BOARD);
//        onCreate(db);
    }


    public void createMember(Member member){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, member.getEmail());
        values.put(KEY_PASSWORD, member.getPassword());

        db.insert(TABLE_MEMBER, null, values);
        db.close();
    }

    public void createBoard(Board board){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_ID, board.getUser_id());
        values.put(KEY_TITLE, board.getTitle());
        values.put(KEY_CONTENT, board.getContent());

        db.insert(TABLE_BOARD, null, values);
        db.close();
    }

    public List<Board> getBoards(){
        List<Board> boardList = new ArrayList<>();

        String SELECT_ALL = "SELECT * FROM " + TABLE_BOARD + " ORDER BY id DESC";

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL, null);

        if (cursor.moveToFirst()) {
            do{
                int userId = cursor.getInt(1);

                Board board = new Board();
                board.setId(Integer.parseInt(cursor.getString(0)));
                board.setUser_id(userId);
                board.setTitle(cursor.getString(2));
                board.setContent(cursor.getString(3));

                Member member = new Member();
                Cursor memberCursor = db.rawQuery("SELECT * FROM Members WHERE id = " + userId, null);

                memberCursor.moveToFirst();
                member.setId(memberCursor.getInt(0));
                member.setEmail(memberCursor.getString(1));

                board.setMember(member);


                boardList.add(board);
            }while(cursor.moveToNext());
        }

        return boardList;
    }

    public List<Board> searchBoards(String string){
        List<Board> boardList = new ArrayList<>();

        String SELECT_ALL = "SELECT * FROM " + TABLE_BOARD +" WHERE title LIKE '%"+string+"%'" + " ORDER BY id DESC";

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL, null);

        if (cursor.moveToFirst()) {
            do{
                int userId = cursor.getInt(1);

                Board board = new Board();
                board.setId(Integer.parseInt(cursor.getString(0)));
                board.setUser_id(userId);
                board.setTitle(cursor.getString(2));
                board.setContent(cursor.getString(3));

                Member member = new Member();
                Cursor memberCursor = db.rawQuery("SELECT * FROM Members WHERE id = " + userId, null);

                memberCursor.moveToFirst();
                member.setId(memberCursor.getInt(0));
                member.setEmail(memberCursor.getString(1));

                board.setMember(member);


                boardList.add(board);
            }while(cursor.moveToNext());
        }

        return boardList;
    }

    public List<Board> myBoards(){
        List<Board> boardList = new ArrayList<>();

        SQLiteDatabase db= this.getReadableDatabase();
        Member member2 = new Member();
        Cursor memberCursor2 = db.rawQuery("SELECT * FROM Members WHERE email = '" + emailSave +"'", null);

        memberCursor2.moveToFirst();
        int tempId = memberCursor2.getInt(0);


        String SELECT_ALL = "SELECT * FROM Boards WHERE user_id = "+tempId  + " ORDER BY id DESC";

        Cursor cursor = db.rawQuery(SELECT_ALL, null);

        if (cursor.moveToFirst()) {
            do{
                int userId = cursor.getInt(1);

                Board board = new Board();
                board.setId(Integer.parseInt(cursor.getString(0)));
                board.setUser_id(userId);
                board.setTitle(cursor.getString(2));
                board.setContent(cursor.getString(3));

                Member member = new Member();
                Cursor memberCursor = db.rawQuery("SELECT * FROM Members WHERE id = " + userId, null);

                memberCursor.moveToFirst();
                member.setId(memberCursor.getInt(0));
                member.setEmail(memberCursor.getString(1));

                board.setMember(member);


                boardList.add(board);
            }while(cursor.moveToNext());
        }

        return boardList;
    }
}
