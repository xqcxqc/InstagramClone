package com.example.instagramclone;

import android.util.EventLogTags;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;


//a class that represent the post action which relate to the post we created in dashboard
// represent the Post object

@ParseClassName("Post") //"Post:  match the enetity that we put on the database
public class Post extends ParseObject {

    //define the keys which are the names of the columns
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_USER = "user";
    public static final String KEY_IMAGE = "image" ;

    public String getDescription(){
        //getString is a method defined by parseobject class
        //look inside the post parse object and pulling out
        // the attribute with a name of description
        return getString(KEY_DESCRIPTION);
    }
    public void setDescription(String description){
        //associate the key with the value
        put(KEY_DESCRIPTION, description);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }
    public void setUser(ParseUser user){
        //associate the key with the value
        put(KEY_USER, user);
    }


    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }
    public void setImage(ParseFile parseFile){
        //associate the key with the value
        put(KEY_IMAGE, parseFile);
    }






}
