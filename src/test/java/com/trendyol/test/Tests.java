package com.trendyol.test;

import org.junit.Assert;
import org.junit.Test;
import com.trendyol.util.ControlPage;

public class Tests {

    private ControlPage controlPage = new ControlPage();

    @Test
    public void isEmptyApiStore(){
        controlPage.apiStart();
    }

    @Test
    public void putAuthorTitleRequiredFields() {
       Assert.assertEquals("Author and Title Required Fields.", "Field '<field_name>' is required.",
               controlPage.authorTitleRequiredFields("",""));
    }

    @Test
    public void putAuthorTitleCannotEmpty() {
        Assert.assertEquals("Author and Title cannot be empty.", "Field '<field_name>' cannot be empty.",
                controlPage.authorTitleRequiredFields("",""));
    }

    @Test
    public void putIdReadOnly() {
        controlPage.createId("4");
    }

    @Test
    public void getBookId() {
        controlPage.getBook("5");
    }

    @Test
    public void putCreateDuplicateBook() {
        Assert.assertEquals("Another book with similar title and author already exists.",
                "Another book with similar title and author already exists.",
                 controlPage.createDuplicateBook("book"));
    }
}