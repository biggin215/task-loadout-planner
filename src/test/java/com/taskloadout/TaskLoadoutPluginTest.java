package com.taskloadout;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

/**
 * Launches a RuneLite dev client with this plugin loaded. Run with: ./gradlew run
 */
public class TaskLoadoutPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(TaskLoadoutPlugin.class);
		RuneLite.main(args);
	}
}
