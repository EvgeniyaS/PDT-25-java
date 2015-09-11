package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")	
	public void modifySomeGroupName (GroupData group) {
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
		app.getGroupHelper().modifyGroup(index, group);
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    oldList.remove(index);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
}
