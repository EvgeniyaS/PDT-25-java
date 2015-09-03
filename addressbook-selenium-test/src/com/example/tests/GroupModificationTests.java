package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	
	@Test
	
	public void modifySomeGroupName () {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
		app.getGroupHelper().initGroupModification(0);
		GroupData group = new GroupData();
		group.name = "new name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    oldList.remove(0);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	@Test
	
	public void modifySomeGroupHeader () {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
		app.getGroupHelper().initGroupModification(0);
		GroupData group = new GroupData();
		group.header = "new header";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    assertEquals(newList, oldList);
	}

	@Test
	
	public void modifySomeGroupFooter () {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
		app.getGroupHelper().initGroupModification(0);
		GroupData group = new GroupData();
		group.footer = "new footer";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    assertEquals(newList, oldList);
	}
	
	@Test
	
	public void modifySomeGroupAllFields () {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
		app.getGroupHelper().initGroupModification(0);
		GroupData group = new GroupData();
		group.name = "new name2";
		group.header = "new header2";
		group.footer = "new footer2";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    oldList.remove(0);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
