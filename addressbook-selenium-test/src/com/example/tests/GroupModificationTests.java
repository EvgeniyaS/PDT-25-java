package com.example.tests;

import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")	
	public void modifySomeGroupName (GroupData group) {
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
		app.getGroupHelper().modifyGroup(index, group);
		SortedListOf<GroupData> newList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}
}
