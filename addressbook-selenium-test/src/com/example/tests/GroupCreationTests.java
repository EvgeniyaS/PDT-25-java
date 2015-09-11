package com.example.tests;

import java.util.Collections;
import java.util.List;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    app.getGroupHelper().createGroup(group);
    List<GroupData> newList = app.getGroupHelper().getGroups();
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }


}
