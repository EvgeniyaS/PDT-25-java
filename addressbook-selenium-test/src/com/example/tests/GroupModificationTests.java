package com.example.tests;

import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")	
	public void modifySomeGroupName (GroupData group) {
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
		app.getGroupHelper().modifyGroup(index, group);
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}
}
