package com.todos.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import com.todos.pages.TodosPage;
import com.todos.utils.Setup;

public class AddTodoTest extends Setup {

	public AddTodoTest() throws IOException {
		super();
	}

	TodosPage todoPage;

	@Test
	public void iCanAddTodo() throws IOException {
		todoPage = new TodosPage();
		boolean elementText = todoPage.isElementDisplayed(TodosPage.inputText);
		Assert.assertTrue(elementText);
		todoPage.submitTodo(prop.getProperty("todo1"));
		String element = todoPage.checkElementContains(TodosPage.elementTodo);
		Assert.assertTrue(element.contains(prop.getProperty("todo1")));
		boolean check = todoPage.isCheckBoxSelected(TodosPage.checkBox);
		Assert.assertFalse(check);
	}
}
