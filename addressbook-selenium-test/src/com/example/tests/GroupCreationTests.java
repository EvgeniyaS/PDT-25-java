package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    app.getGroupHelper().createGroup(group);
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    assertThat(newList, equalTo(oldList.withAdded(group)));
  }
}
