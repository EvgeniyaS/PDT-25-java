package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();    
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group 1";
    group.header = "header 1";
    group.footer = "footer 1";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    List<GroupData> newList = app.getGroupHelper().getGroups();
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData("", "", "");
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    List<GroupData> newList = app.getGroupHelper().getGroups();
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
}
