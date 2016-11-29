package com.taiyeoloriade.androidplayground.model;

public class Todo {
 
    int id;
    String note;
    int status;
   long  deadline;
    String created_at;
 
    // constructors
    public Todo() {
    }
 
    public Todo(String note, int status) {
        this.note = note;
        this.status = status;
    }


    public Todo(String note, int status, long deadline) {
        this.note = note;
        this.status = status;
        this.deadline = deadline;
    }

    public Todo(int id, String note, int status) {
        this.id = id;
        this.note = note;
        this.status = status;
    }

    public Todo(int id, String note, int status, long deadline) {
        this.id = id;
        this.note = note;
        this.status = status;
        this.deadline = deadline;
    }
 
    // setters
    public void setId(int id) {
        this.id = id;
    }
 
    public void setNote(String note) {
        this.note = note;
    }
 
    public void setStatus(int status) {
        this.status = status;
    }
     
    public void setCreatedAt(String created_at){
        this.created_at = created_at;
    }

    public void setDeadline(long deadline){
        this.deadline = deadline;
    }
    // getters
    public long getId() {
        return this.id;
    }

    public String getCreatedAt(){
        return this.created_at;
    }

    public long getDeadline(){
        return this.deadline;
    }
    public String getNote() {
        return this.note;
    }
 
    public int getStatus() {
        return this.status;
    }


}